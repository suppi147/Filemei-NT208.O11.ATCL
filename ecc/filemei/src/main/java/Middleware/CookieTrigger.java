package Middleware;

import java.sql.SQLException;
import java.util.Random;

import javax.servlet.http.Cookie;
import DBController.SessionAction;
public class CookieTrigger {
	private static final String CHARACTERS = "ABCDEFGHIJKLMNOPQRSTUVWXYZabcdefghijklmnopqrstuvwxyz0123456789";
    private static final int STRING_LENGTH = 64;
    private String cookie;

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
	public Cookie GenCookie(int code) throws SQLException {
		this.cookie=generateRandomString();
		SessionAction sessionUpdate = new SessionAction();
		sessionUpdate.SetSessionByCode(this.cookie,code);
		Cookie loginCookie = new Cookie("filemeicookie",this.cookie);
		loginCookie.setMaxAge(30*60);
		return loginCookie;
	}
	public Cookie GenCookieByEmail(String email) throws SQLException {
		this.cookie=generateRandomString();
		SessionAction sessionUpdate = new SessionAction();
		sessionUpdate.SetSessionByEmail(this.cookie, email);
		Cookie loginCookie = new Cookie("filemeicookie",this.cookie);
		loginCookie.setMaxAge(30*60);
		return loginCookie;
	}
}
