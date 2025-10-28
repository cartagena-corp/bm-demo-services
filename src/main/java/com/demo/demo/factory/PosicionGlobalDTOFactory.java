package com.demo.demo.factory;

import com.demo.demo.model.PosicionGlobalDTO;
import com.demo.demo.service.dto.AccountOverview;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;

import java.math.BigDecimal;
import java.text.NumberFormat;
import java.util.Currency;
import java.util.Locale;

@Mapper(uses = { CuentaDTOFactory.class, CreditoDTOFactory.class, CdtDTOFactory.class })
public interface PosicionGlobalDTOFactory {
	
	@Mapping(source = "accounts", target = "cuentas")
	@Mapping(source = "credits", target = "creditos")
	@Mapping(source = "cdts", target = "cdts")
	@Mapping(target = "totalCuenta", expression = "java(com.demo.demo.factory.PosicionGlobalDTOFactory.getAccountsAvailableBalanceFormatted(accountOverview))")
	@Mapping(target = "totalTotalCuenta", expression = "java(com.demo.demo.factory.PosicionGlobalDTOFactory.getAccountsTotalBalanceFormatted(accountOverview))")
	@Mapping(target = "totalCredito", expression = "java(com.demo.demo.factory.PosicionGlobalDTOFactory.getCreditsBalanceFormatted(accountOverview))")
	@Mapping(target = "totalCupoUtilizado", expression = "java(com.demo.demo.factory.PosicionGlobalDTOFactory.getUsedQuotasBalanceFormatted(accountOverview))")
	@Mapping(target = "totalCdt", expression = "java(com.demo.demo.factory.PosicionGlobalDTOFactory.getCdtsBalanceFormatted(accountOverview))")
	PosicionGlobalDTO from(AccountOverview accountOverview);

	static String getAccountsAvailableBalanceFormatted(AccountOverview accountOverview) {
		return new StringBuilder().append(formatter(accountOverview.getAccountsAvailableBalance())).toString();
	}
	
	static String getAccountsTotalBalanceFormatted(AccountOverview accountOverview) {
		return new StringBuilder().append(formatter(accountOverview.getAccountsTotalBalance())).toString();
	}

	static String getCreditsBalanceFormatted(AccountOverview accountOverview) {
		return new StringBuilder().append(formatter(accountOverview.getCreditsBalance())).toString();
	}
	
	static String getUsedQuotasBalanceFormatted(AccountOverview accountOverview) {
		return new StringBuilder().append(formatter(accountOverview.getUsedQuotasBalance())).toString();
	}

	static String getCdtsBalanceFormatted(AccountOverview accountOverview) {
		return new StringBuilder().append(formatter(accountOverview.getCdtsBalance())).toString();
	}
	
	static String formatter(BigDecimal value) {
		NumberFormat nf = NumberFormat.getCurrencyInstance(new Locale("es", "CO"));
		nf.setCurrency(Currency.getInstance("COP"));
		return nf.format(value);
	}

}
