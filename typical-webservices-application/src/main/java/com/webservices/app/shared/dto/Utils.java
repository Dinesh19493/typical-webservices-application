package com.webservices.app.shared.dto;
import java.security.SecureRandom;
import java.util.Random;
import java.util.UUID;
import org.springframework.stereotype.Component;

@Component
public class Utils {

	private final Random rand = new SecureRandom();
	private final String ALPHABET = "0123465789abcdefghijklmnopqrstuvwxyzABCDEFGHIJKLMNOPQRSTUVWXYZ";
	
	/* public UUID generateUserId() { return UUID.randomUUID(); } */
	
	public String generateRandomUserId(int length) {
		return generateRandomString(length);
	}

	private String generateRandomString(int length) {
		StringBuilder sb = new StringBuilder(length);
		
		for(int i=0; i<length; i++) {
			sb.append(ALPHABET.charAt(rand.nextInt(ALPHABET.length())));
		}
		return new String(sb.toString());
	}
}
