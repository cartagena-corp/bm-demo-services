package com.demo.demo.util;

import org.apache.commons.lang3.RandomStringUtils;
import org.apache.commons.lang3.StringUtils;

public class TokenizationUtil {
	
	private TokenizationUtil() {
		throw new IllegalStateException("Utility class");
	}

	public static String generateAccountToken(String product) {
		return generateToken(product, true);
	}

	public static String generateLoanToken(String product) {
		return generateToken(product, false);
	}

	public static String generateCdtToken(String product) {
		return generateToken(product, true);
	}

	public static String generateRotaryToken(String product) {
		return generateToken(product, true);
	}

	private static String generateToken(String product, boolean containSubOperation) {
		String sucursalAndModulo = StringUtils.substring(product, 0, 6);
		String tokenized = containSubOperation ? RandomStringUtils.randomNumeric(8) : RandomStringUtils.randomNumeric(5);
		String toShow = StringUtils.substring(product, containSubOperation ? 14 : 11);
		return new StringBuilder().append(sucursalAndModulo).append(tokenized).append(toShow).toString();
	}

}
