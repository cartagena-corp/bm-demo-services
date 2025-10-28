package com.demo.demo.service.impl;

import com.demo.demo.factory.AccountOverviewFactory;
import com.demo.demo.service.AccountOverviewService;
import com.demo.demo.service.dto.AccountOverview;
import com.demo.demo.util.ParameterUtil;
import com.nsbt.demo.exception.ConsultarProductosActivosWSException;
import com.nsbt.demo.exception.NSBTTimeOutException;
import com.nsbt.demo.factory.JaxbProcessorFactory;
import com.nsbt.demo.model.PosPeNa;
import com.nsbt.demo.model.PosPeNaRta;
import com.nsbt.demo.util.Parameter;
import com.nsbt.demo.ws.ConsultarProductosActivosWS;
import org.springframework.http.HttpStatusCode;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;
import java.time.ZoneId;

import org.mapstruct.factory.Mappers;
import org.springframework.web.server.ResponseStatusException;

@Service
public class AccountOverviewServiceImpl implements AccountOverviewService {

    private final JaxbProcessorFactory mapper;
    private final ConsultarProductosActivosWS webService;

    public AccountOverviewServiceImpl(JaxbProcessorFactory mapper, ConsultarProductosActivosWS webService) {
        this.mapper = mapper;
        this.webService = webService;
    }

    @Override
    public AccountOverview getAccountOverview(String address, String documentType, String documentNumber) {
        LocalDateTime today = LocalDateTime.now(ZoneId.of("America/Bogota"));
        String numTx = ParameterUtil.getDRqCl(documentType, documentNumber, today);
        Parameter parameter = getParamPosPeNa(numTx, today, address, documentType,documentNumber);

        try {
            PosPeNaRta response = validateRta(webService.getProductosActivos(parameter));
            AccountOverview accountOverview = Mappers.getMapper(AccountOverviewFactory.class).from(response.getProductos());
            return accountOverview;
        } catch (NSBTTimeOutException e) {
            throw new ResponseStatusException(HttpStatusCode.valueOf(500), "NSBTTimeOutException");
        }
    }

    private PosPeNaRta validateRta(PosPeNaRta rta) {
        if (!"0".equals(rta.getCODRTA())) {
            throw new ConsultarProductosActivosWSException("Error al validar la respuesta");
        }
        return rta;
    }

    private Parameter getParamPosPeNa(String numTx, LocalDateTime today, String address,
                                      String documentType, String documentNumber) {
        String xml = getXMLPosPeNa(numTx, today, address, documentType, documentNumber);
        return Parameter.builder().time(today).nroReq(numTx).ip(address).canal((short) 92)
                .operacion((short) 503).variante((short) 10).drqus("ServiAdmin")
                .ecantlin((short) 1).setEdatosItem(0, "PosPeNa").setEtdatsItem(0, "L")
                .setEvallsItem(0, xml).build();
    }

    private String getXMLPosPeNa(String numTx, LocalDateTime today, String address,
                                 String documentType, String documentNumber) {
        try {
            PosPeNa posPeNa = new PosPeNa();
            posPeNa.setIDETRX(numTx);
            posPeNa.setFECHOR(ParameterUtil.getFechaHora(today));
            posPeNa.setCODADQ("59");
            posPeNa.setCODEST("999999999");
            posPeNa.setCODTER("999");
            posPeNa.setTipIdNat(documentType);
            posPeNa.setNumIdNat(documentNumber);
            posPeNa.setTipBca("F");
            posPeNa.setDirIpC(address);
            return mapper.objectToXml(posPeNa);
        }
        catch (Exception e) {
            throw new ConsultarProductosActivosWSException(e);
        }
    }
}
