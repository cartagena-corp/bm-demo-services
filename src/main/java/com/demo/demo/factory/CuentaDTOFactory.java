package com.demo.demo.factory;

import com.demo.demo.model.Cuenta;
import com.demo.demo.service.dto.Account;
import com.demo.demo.util.ConstantsUtil;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;

import java.math.BigDecimal;
import java.text.NumberFormat;
import java.util.Currency;
import java.util.List;
import java.util.Locale;

@Mapper
public interface CuentaDTOFactory {
	
	@Mapping(target = "numeroProducto", expression = "java(com.demo.demo.factory.CuentaDTOFactory.getNumeroProductoCorto(account))")
	@Mapping(source = "tipoProducto", target = "tipoProducto")
	@Mapping(source = "token", target = "id")
	@Mapping(source = "numeroProductoTotal", target = "numeroProductoCompleto")
	@Mapping(source = "descripcionProducto", target = "tipoCuenta")
	@Mapping(target = "saldoDisponible", expression = "java(com.demo.demo.factory.CuentaDTOFactory.getCurrencyAvailable(account))")
	@Mapping(target = "saldoTotal", expression = "java(com.demo.demo.factory.CuentaDTOFactory.getCurrencyTotal(account))")
	@Mapping(target = "origenPago", expression = "java(com.demo.demo.factory.CuentaDTOFactory.allowUseToPayment(account))")
	@Mapping(target = "tipoOperacionCuenta", source= "tipoOperacionCuenta")
	@Mapping(target = "estadoCuenta", source= "estadoBanTotal")
	@Mapping(target = "aplicaInteres", source= "aplicaInteres")
	@Mapping(target = "rentabilidad", source= "rentabilidad")
	Cuenta from(Account account);

	List<Cuenta> from(List<Account> account);

	static String getCurrencyTotal(Account account) {
		return new StringBuilder().append(formatter(new BigDecimal(account.getSaldoTotal()).movePointLeft(2))).toString();
	}
	
	static String getCurrencyAvailable(Account account) {
		if("Soñando juntos".equalsIgnoreCase(account.getDescripcionProducto()) 
				|| "viviendamia".equalsIgnoreCase(account.getDescripcionProducto())){
			return null;
		}
		return new StringBuilder().append(formatter(new BigDecimal(account.getDisponible()).movePointLeft(2))).toString();
	}
	
	static String getNumeroProductoCorto(Account account) {
		return account.getNumeroProducto().substring(account.getNumeroProducto().length() - 6);
	}
	
	static String formatter(BigDecimal value) {
		NumberFormat nf = NumberFormat.getCurrencyInstance(new Locale("es", "CO"));
		nf.setCurrency(Currency.getInstance("COP"));
		return nf.format(value);
	}
	
	static boolean allowUseToPayment( Account account) {
		return ConstantsUtil.ESTADO_OPERACION_S.equals(account.getTipoOperacion()) ||
				ConstantsUtil.ESTADO_OPERACION_D.equals(account.getTipoOperacion()) ||
				ConstantsUtil.ESTADO_OPERACION_R.equals(account.getTipoOperacion());
	}
	
}
