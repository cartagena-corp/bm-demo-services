package com.demo.demo.factory;

import com.demo.demo.service.dto.AccountOverview;
import com.demo.demo.service.dto.Credit;
import com.nsbt.demo.model.PosPeNaRta.Productos;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.factory.Mappers;

import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.List;

@Mapper(uses = { AccountFactory.class, CdtFactory.class, CreditFactory.class })
public interface AccountOverviewFactory {

	@Mapping(source = "cuentas.cuenta", target = "accounts")
	@Mapping(target = "credits", expression = "java(com.demo.demo.factory.AccountOverviewFactory.getCreditosAndRotativos(productos))")
	@Mapping(source = "CDTs.CDT", target = "cdts")
	@Mapping(target = "accountsAvailableBalance", expression = "java(com.demo.demo.factory.AccountOverviewFactory.getTotalDisponibleCuentas(productos))")
	@Mapping(target = "accountsTotalBalance", expression = "java(com.demo.demo.factory.AccountOverviewFactory.getTotalTotalCuentas(productos))")
	@Mapping(target = "creditsBalance", expression = "java(com.demo.demo.factory.AccountOverviewFactory.getTotalCreditos(productos))")
	@Mapping(target = "usedQuotasBalance", expression = "java(com.demo.demo.factory.AccountOverviewFactory.getTotalCuposUtilizados(productos))")
	@Mapping(target = "cdtsBalance", expression = "java(com.demo.demo.factory.AccountOverviewFactory.getTotalCdts(productos))")
	AccountOverview from(Productos productos);

	static BigDecimal getTotalTotalCuentas(Productos productos) {
		if (productos.getCuentas().getCuenta().isEmpty()) {
			return BigDecimal.ZERO;
		}
		return productos.getCuentas().getCuenta().stream().map(a -> (new BigDecimal(a.getSalTot())))
				.reduce(BigDecimal.ZERO, BigDecimal::add).movePointLeft(2);
	}

	static BigDecimal getTotalDisponibleCuentas(Productos productos) {
		if (productos.getCuentas().getCuenta().isEmpty()) {
			return BigDecimal.ZERO;
		}
		return productos.getCuentas().getCuenta().stream()
				.filter(a -> (a.getDesPro() != null && !a.getDesPro().startsWith("Soñando")
						&& !a.getDesPro().toLowerCase().startsWith("mivivienda")))
				.map(a -> new BigDecimal(a.getValDis())).reduce(BigDecimal.ZERO, BigDecimal::add).movePointLeft(2);
	}

	static BigDecimal getTotalCreditos(Productos productos) {
		if (productos.getCreditos().getCredito().isEmpty()) {
			return BigDecimal.ZERO;
		}
		return productos.getCreditos().getCredito().stream().map(c -> new BigDecimal(c.getPagTot()))
				.reduce(BigDecimal.ZERO, BigDecimal::add).movePointLeft(2);
	}

	static BigDecimal getTotalCuposUtilizados(Productos productos) {
		if (productos.getRotativos().getRotativo().isEmpty()) {
			return BigDecimal.ZERO;
		}
		return productos.getRotativos().getRotativo().stream().map(r -> new BigDecimal(r.getUtilizaCr()))
				.reduce(BigDecimal.ZERO, BigDecimal::add).movePointLeft(2);
	}

	static BigDecimal getTotalCdts(Productos productos) {
		if (productos.getCDTs().getCDT().isEmpty()) {
			return BigDecimal.ZERO;
		}
		return productos.getCDTs().getCDT().stream().map(a -> new BigDecimal(a.getValApe()))
				.reduce(BigDecimal.ZERO, BigDecimal::add).movePointLeft(2);
	}

	static List<Credit> getCreditosAndRotativos(Productos productos) {

		List<Credit> lista = new ArrayList<>();

		if (productos.getCreditos() != null && !productos.getCreditos().getCredito().isEmpty()) {
			lista.addAll(Mappers.getMapper(CreditFactory.class).from(productos.getCreditos().getCredito()));
		}

		if (productos.getRotativos() != null && !productos.getRotativos().getRotativo().isEmpty()) {
			lista.addAll(Mappers.getMapper(CreditFactory.class).fromRotativo(productos.getRotativos().getRotativo()));
		}

		return lista;
	}

}
