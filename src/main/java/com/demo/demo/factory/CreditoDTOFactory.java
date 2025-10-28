package com.demo.demo.factory;

import com.demo.demo.model.Credito;
import com.demo.demo.service.dto.Credit;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;

import java.math.BigDecimal;
import java.text.NumberFormat;
import java.util.Currency;
import java.util.List;
import java.util.Locale;

@Mapper
public interface CreditoDTOFactory {

	@Mapping(target = "numeroProducto", expression = "java(com.demo.demo.factory.CreditoDTOFactory.getNumeroProductoCorto(credit))")
	@Mapping(source = "token", target = "id")
	@Mapping(source = "nombreProductoCliente", target = "tipoCredito")
	@Mapping(target = "pagoMinimo", expression = "java(com.demo.demo.factory.CreditoDTOFactory.getPagoMinimoFormatted(credit))")
	@Mapping(source = "fechaLimitePago", target = "fechaPagoMinimo")
	@Mapping(target = "totalPago", expression = "java(com.demo.demo.factory.CreditoDTOFactory.getTotalPaid(credit))")
	@Mapping(source = "descripcionProducto", target = "linea")
	@Mapping(source = "origenAlianza", target = "origenAlianza")
	@Mapping(target = "cupoGobal", expression = "java(com.demo.demo.factory.CreditoDTOFactory.getCupoGlobalFormatted(credit))")
	@Mapping(target = "cupoDisponible", expression = "java(com.demo.demo.factory.CreditoDTOFactory.getCupoDisponibleFormatted(credit))")
	@Mapping(target = "cupoUtilizado", expression = "java(com.demo.demo.factory.CreditoDTOFactory.getCupoUtilizadoFormatted(credit))")
	@Mapping(target = "fechaPago", source = "fechaPago")
	@Mapping(target = "valorPago", expression = "java(com.demo.demo.factory.CreditoDTOFactory.getValorPagoFormatted(credit))")
	Credito from(Credit credit);

	List<Credito> from(List<Credit> credits);

	static String getTotalPaid(Credit credit) {
		if(credit != null && credit.getPagoTotal() != null) {
			return new StringBuilder().append(formatter(new BigDecimal(credit.getPagoTotal()).movePointLeft(2))).toString();
		}else {
			return null;
		}
	}

	static String getPagoMinimoFormatted(Credit credit) {
		if(credit != null && credit.getValorCuota() != null) {
			return new StringBuilder().append(formatter(new BigDecimal(credit.getValorCuota()).movePointLeft(2))).toString();
		}else {
			return null;
		}
	}

	static String getCupoGlobalFormatted(Credit credit) {
		if(credit != null && credit.getCupoGlobal() != null) {
			return new StringBuilder().append(formatter(new BigDecimal(credit.getCupoGlobal()).movePointLeft(2))).toString();
		}else {
			return null;
		}
	}

	static String getCupoDisponibleFormatted(Credit credit) {
		if(credit != null && credit.getCupoDisponible() != null) {
			return new StringBuilder().append(formatter(new BigDecimal(credit.getCupoDisponible()).movePointLeft(2))).toString();
		}else {
			return null;
		}
	}
	
	static String getCupoUtilizadoFormatted(Credit credit) {
		if(credit != null && credit.getCupoUtilizado() != null) {
			return new StringBuilder().append(formatter(new BigDecimal(credit.getCupoUtilizado()).movePointLeft(2))).toString();
		}else {
			return null;
		}
	}

	static String getValorPagoFormatted(Credit credit) {
		if(credit != null && credit.getValorPago() != null) {
			return new StringBuilder().append(formatter(new BigDecimal(credit.getValorPago()).movePointLeft(2))).toString();
		}else {
			return null;
		}
	}
	
	static String getNumeroProductoCorto(Credit credit) {
		if(credit != null && credit.getNumeroProducto() != null) {
			return credit.getNumeroProducto().substring(credit.getNumeroProducto().length() - 6);
		}else {
			return null;
		}
	}
	
	static String formatter(BigDecimal value) {
		NumberFormat nf = NumberFormat.getCurrencyInstance(new Locale("es", "CO"));
		nf.setCurrency(Currency.getInstance("COP"));
		return nf.format(value);
	}
	
}
