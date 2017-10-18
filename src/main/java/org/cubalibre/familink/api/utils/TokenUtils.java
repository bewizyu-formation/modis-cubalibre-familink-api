package org.cubalibre.familink.api.utils;

public class TokenUtils {
    private static final int nbrMinValidToken = 200;

    public static String generateToken(int userId) throws Exception {
        long newValidTimeStamp = (System.currentTimeMillis() + nbrMinValidToken * 60 * 1000);
        String token = userId + "-" + newValidTimeStamp;
        System.out.println(Base64Utils.encode(token));
        return Base64Utils.encode(token);
    }

    public static boolean isValidToken(String token) {
        boolean isValid = false;
        long currentTimeStamp = System.currentTimeMillis();
        long timeStamp = getTimeStampFromToken(token);
        if (timeStamp - currentTimeStamp > 0) {
            isValid = true;
        }
        return isValid;
    }

    public static String getUserIdFromToken(String token) {
        return token.substring(0, token.indexOf("-"));
    }

    public static long getTimeStampFromToken(String decodedToken) {
        String timestamp = decodedToken.substring(decodedToken.indexOf("-") + 1, decodedToken.length());
        return Long.valueOf(timestamp);
    }

    public static void main(String[] args) throws Exception {
        int userId = 1;
        String generatedToken = TokenUtils.generateToken(userId);
        String token = "";
        try {
            token = Base64Utils.decode(generatedToken);
        } catch (Exception e) {
            System.out.println(e.getMessage());
        }
        if (TokenUtils.isValidToken(token)) {
            System.out.println("VALID TOKEN");
        } else {
            System.out.println("INVALID TOKEN");
        }
    }

}
