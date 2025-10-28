package com.demo.demo.factory;

import com.demo.demo.service.dto.Account;
import com.nsbt.demo.model.PosPeNaRta.Productos.Cuentas.Cuenta;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;

import java.util.List;

@Mapper
public interface AccountFactory {

	@Mapping(target = "token", expression = "java(com.demo.demo.util.TokenizationUtil.generateAccountToken(accountResponse.getNumProTot()))")
	@Mapping(target = "tipoProducto", source = "tipPro")
	@Mapping(target = "numeroProductoTotal", source = "numProTot")
	@Mapping(target = "numeroProducto", source = "numPro")
	@Mapping(target = "descripcionProducto", source = "desPro")
	@Mapping(target = "nombreProductoCliente", source = "aliPro")
	@Mapping(target = "disponible", source = "valDis")
	@Mapping(target = "canje", source = "valCan")
	@Mapping(target = "saldoTotal", source = "salTot")
	@Mapping(target = "estadoBanTotal", source = "estCod")
	@Mapping(target = "tipoOperacion", source = "estOpe")
	@Mapping(target = "descripcionEstadoProducto", source = "estDes")
	@Mapping(target = "tipoOperacionCuenta", source = "tipOpe")
	@Mapping(target = "aplicaInteres", source = "intCaus")
	@Mapping(target = "rentabilidad", source = "intRent")
	Account from(Cuenta accountResponse);

	List<Account> from(List<Cuenta> cuentas);

}
