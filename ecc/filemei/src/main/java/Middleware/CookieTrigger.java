package Middleware;

import java.util.Random;

import javax.servlet.http.Cookie;

public class CookieTrigger {
	private static final String CHARACTERS = "ABCDEFGHIJKLMNOPQRSTUVWXYZabcdefghijklmnopqrstuvwxyz0123456789";
    private static final int STRING_LENGTH = 64;

	public static String generateRandomString() {
        Random random = new Random();
        StringBuilder sb = new StringBuilder(STRING_LENGTH);

        for (int i = 0; i < STRING_LENGTH; i++) {
            int randomIndex = random.nextInt(CHARACTERS.length());
            char randomChar = CHARACTERS.charAt(randomIndex);
            sb.append(randomChar);
        }

        return sb.toString();
    }
	public Cookie GenCookie() {
		Cookie loginCookie = new Cookie("filemeicookie",generateRandomString());
		loginCookie.setMaxAge(30*60);
		return loginCookie;
	}
}
