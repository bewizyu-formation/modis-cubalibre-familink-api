package org.cubalibre.familink.api.utils;

import java.sql.Timestamp;
import java.text.SimpleDateFormat;
import java.util.Date;

public class TokenUtils {

    public static String generateToken(String userId) throws Exception {
        Date date = new Date();
        date.setTime(new Timestamp(System.currentTimeMillis()).getTime());
        String formattedDate = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss").format(date);

        String token = userId + "-" + formattedDate;
        System.out.println ("generated TOKEN (before encode ) = " + token);

        return Base64Utils.encode(token);
    }

    public static boolean isValidToken(String decodedToken) {
        boolean isValid;
        SimpleDateFormat formatter = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");

        try {
            String timeStampFromToken = getTimeStampFromToken(decodedToken);
            Date tokenDate = formatter.parse(timeStampFromToken);

            Date now = new Date();
            now.setTime(now.getTime() + 1 * 60 * 1000);

            isValid = tokenDate.before(now);
        } catch (Exception e) {
            isValid = false;
            System.out.println(e.getMessage());
        }

        System.out.println("isValid TOKEN = " + isValid);

        return isValid;
    }

    public static String getUserIdFromToken(String decodedToken) {
//        String[] parts = decodedToken.split("-");
//        Integer userId = Integer.parseInt(parts[0]);

        String userId = decodedToken.substring(0, decodedToken.indexOf("-"));
        System.out.println("TOKEN userId = " + userId);

        return userId;
    }

    public static String getTimeStampFromToken(String decodedToken) {
        String timestamp = decodedToken.substring(decodedToken.indexOf("-") + 1, decodedToken.length());
        System.out.println("TOKEN timestamp = " + timestamp);

        return timestamp;
    }

    public static void main(String[] args) throws Exception {
        // GENERATE TOKEN
        String userId = "105";

        String generatedToken = TokenUtils.generateToken(userId);
        System.out.println ("generated TOKEN (base64) -> " + generatedToken);

        String decodedToken = null;
        try {
            decodedToken = Base64Utils.decode(generatedToken);
        } catch (Exception e) {
            System.out.println(e.getMessage());
        }

        System.out.println ("decoded TOKEN = " + decodedToken);

        // TOKEN IS VALID
        boolean isValid = TokenUtils.isValidToken(decodedToken);
        if(isValid) {
            getUserIdFromToken(decodedToken);
            getTimeStampFromToken(decodedToken);
        } else {
            System.out.println("INVALID TOKEN");
        }
    /*
    * OUTPUT :
    *   generated TOKEN base64 -> MTA1LTIwMTctMTAtMTYgMDg6NTA6MjY=
    *   decodedToken -> 105-2017-10-16 08:50:26
    *   TOKEN timestamp = 2017-10-16 08:50:26
    *   isValid TOKEN = true
    *   TOKEN userId = 105
    *   TOKEN timestamp = 2017-10-16 08:50:26
    */
    }

}
