package com.demo.demo.factory;

import com.demo.demo.model.CDT;
import com.demo.demo.service.dto.Cdt;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;

import java.math.BigDecimal;
import java.text.NumberFormat;
import java.util.Currency;
import java.util.List;
import java.util.Locale;

@Mapper
public interface CdtDTOFactory {
	
	@Mapping(target = "numeroProducto", expression = "java(com.demo.demo.factory.CdtDTOFactory.getNumeroProductoCorto(cdt))")
	@Mapping(source = "token", target = "id") 
	@Mapping(target = "totalPago", expression = "java(com.demo.demo.factory.CdtDTOFactory.getTotalPaid(cdt))")
	@Mapping(source = "descripcionProducto", target = "tipoCdt")
	@Mapping(source = "proximoVecimiento", target = "plazo")
	@Mapping(source = "fechaVencimiento", target = "fechaVencimento")
	@Mapping(target = "monto", expression = "java(com.demo.demo.factory.CdtDTOFactory.montoFormatted(cdt))")
	@Mapping(source = "tasaPactada", target = "tasaNominal")
	CDT from (Cdt cdt);

	List<CDT> from (List<Cdt> cdt);
	
	static String getTotalPaid(Cdt cdt) {
		return new StringBuilder().append(new BigDecimal(cdt.getValorApertura()).movePointLeft(2)).toString();
	}
	
	static String getNumeroProductoCorto(Cdt cdt) {
		return cdt.getNumeroProducto().substring(cdt.getNumeroProducto().length() - 6);
	}
	
	static String montoFormatted(Cdt cdt) {
		BigDecimal valueConverted = new  BigDecimal(cdt.getValorApertura()).movePointLeft(2);
		NumberFormat nf = NumberFormat.getCurrencyInstance(new Locale("es", "CO"));
		nf.setCurrency(Currency.getInstance("COP"));
		return nf.format(valueConverted);
	}
}
