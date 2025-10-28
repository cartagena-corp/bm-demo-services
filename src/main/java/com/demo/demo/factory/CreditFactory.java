package com.demo.demo.factory;

import com.demo.demo.service.dto.Credit;
import com.nsbt.demo.model.PosPeNaRta.Productos.Rotativos.Rotativo;
import com.nsbt.demo.model.PosPeNaRta.Productos.Creditos.Credito;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;

import java.math.BigDecimal;
import java.util.List;

@Mapper
public interface CreditFactory {
	
	@Mapping(target = "token", expression = "java(com.demo.demo.util.TokenizationUtil.generateLoanToken(credito.getNumProTot()))")
	@Mapping(target = "tipoProducto", source = "tipPro")
	@Mapping(target = "numeroProductoTotal", source = "numProTot")
	@Mapping(target = "numeroProducto", source = "numPro")
	@Mapping(target = "descripcionProducto", source = "desPro")
	@Mapping(target = "nombreProductoCliente", source = "aliPro")
	@Mapping(target = "valorCuota", source = "pagCuo")
	@Mapping(target = "pagoTotal", source = "pagTot")
	@Mapping(target = "valorProximCuota", source = "valProxCuo")
	@Mapping(target = "fechaProximaCuota", source = "fecProxCuo")
	@Mapping(target = "interesMora", source = "intMor")
	@Mapping(target = "diasMora", source = "diasMor")
	@Mapping(target = "fechaCorte", source = "fecCort")
	@Mapping(target = "saldoVencido", source = "saldoVen")
	@Mapping(target = "saldoPagar", source = "salPag")
	@Mapping(target = "fechaLimitePago", source = "fecMaxPag")
	@Mapping(target = "estadoBanTotal", source = "estCod")
	@Mapping(target = "tipoOperacion", source = "estOpe")
	@Mapping(target = "descripcionEstadoProducto", source = "estDes")
	Credit from(Credito credito);
	
	List<Credit> from (List<Credito> creditos);
	
	@Mapping(target = "token", expression = "java(com.demo.demo.util.TokenizationUtil.generateRotaryToken(rotativo.getNumProTot()))")
	@Mapping(target = "tipoProducto", source = "tipPro")
	@Mapping(target = "numeroProductoTotal", source = "numProTot")
	@Mapping(target = "numeroProducto", source = "numPro")
	@Mapping(target = "descripcionProducto", source = "desPro")
	@Mapping(target = "nombreProductoCliente", source = "aliPro")
	@Mapping(target = "fechaCorte", source = "fecCortCr")
	@Mapping(target = "fechaProximaCuota", source = "proxCuoCr")
	@Mapping(target = "estadoBanTotal", source = "estCod")
	@Mapping(target = "tipoOperacion", source = "estOpe")
	@Mapping(target = "descripcionEstadoProducto", source = "estDes")
	@Mapping(target = "origenAlianza", expression = "java(com.demo.demo.factory.CreditFactory.getOrigenAlianza())")
	@Mapping(target = "cupoGlobal", expression = "java(com.demo.demo.factory.CreditFactory.getCupoGlobal(rotativo))")
	@Mapping(target = "cupoDisponible", source = "saldoCr")
	@Mapping(target = "cupoUtilizado", source = "utilizaCr")
	@Mapping(target = "fechaPago", source = "proxCuoCr")
	@Mapping(target = "valorPago", source = "valProxCuoCr")
	Credit fromRotativo(Rotativo rotativo);
	
	List<Credit> fromRotativo (List<Rotativo> rotativos);
	
	static boolean getOrigenAlianza() {
		return true;
	}

	static String getCupoGlobal(Rotativo rotativo) {
		BigDecimal saldoCr = BigDecimal.ZERO;
		BigDecimal utilizaCr = BigDecimal.ZERO;
		
		if(rotativo!= null && rotativo.getSaldoCr()!=null) {
			saldoCr = new BigDecimal(rotativo.getSaldoCr());
		}
		if(rotativo!= null && rotativo.getUtilizaCr()!=null) {
			utilizaCr = new BigDecimal(rotativo.getUtilizaCr());
		}
		return saldoCr.add(utilizaCr).toString();
	}
}
