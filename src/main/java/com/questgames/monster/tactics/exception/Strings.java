package com.questgames.monster.tactics.exception;

import org.springframework.validation.FieldError;

public class Strings {

	public static String formatCode(String key) {
		String[] keyStrings = key.split("(?=\\p{Lu})");
		//String keyUpdated = StringUtils.join(Arrays.asList(keyStrings), '_').toUpperCase();
		String keyUpdated = "";
		return keyUpdated;
	}

	public static String formatField(String field) {
		String[] fieldStrings = field.split("(?=\\p{Lu})");
		//String fieldUpdated = StringUtils.join(Arrays.asList(fieldStrings), '_').toUpperCase();
		String fieldUpdated = "";
		return fieldUpdated;
	}
	
	public static String formatResponseCode(FieldError error, String code) {
		String responseCode = String.format("%s_%s", Strings.formatField(error.getField()), code);
		return responseCode;
	}
}