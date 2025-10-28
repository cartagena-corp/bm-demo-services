package com.demo.demo.util;

import java.time.LocalDateTime;
import java.time.ZoneId;
import java.time.format.DateTimeFormatter;

public class ParameterUtil {
	
	private ParameterUtil() {
		throw new IllegalStateException("Utility class");
	}

	public static String getDRqCl(String documentType, String documentNumber,
			LocalDateTime today) {
		return new StringBuilder().append(documentType).append(documentNumber).append(toTimestamp(today)).toString();
	}
	
	private static String toTimestamp(final LocalDateTime today) {
		long m = today.atZone(ZoneId.of("America/Bogota")).toInstant().toEpochMilli();
		return String.valueOf(m);
	}
	
	public static String getFechaHora(final LocalDateTime date) {
		DateTimeFormatter dtf = DateTimeFormatter.ofPattern("dd/MM/yyyy HH:mm:ss");
		return date.format(dtf);
	}
	
	public static String getTransactionDate(LocalDateTime ldt) {
		return formatLocalDateTime(ldt, "yyyyMMdd");
	}
	
	public static String getTransactionHour(LocalDateTime ldt) {
		return formatLocalDateTime(ldt, "HHmmss");
	}
	
	private static String formatLocalDateTime(LocalDateTime ldt, String pattern) {
		DateTimeFormatter formatter = DateTimeFormatter.ofPattern(pattern);
		return ldt.format(formatter);
	}

}
