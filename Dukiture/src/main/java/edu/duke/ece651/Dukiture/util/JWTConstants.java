package edu.duke.ece651.Dukiture.util;

public class JWTConstants {
    public static final long TOKEN_VALIDITY_TIME = 60 * 60;   // in seconds
    public static final String SIGN_KEY = "dukiture";
    public static final String TOKEN_PREFIX = "Bearer ";
    public static final String HEADER_PREFIX = "Authorization";
}
