package org.cubalibre.familink.api.utils;

import java.sql.Timestamp;
import java.text.SimpleDateFormat;
import java.util.Date;

public class TokenUtils {

    public static String generateToken(String userId) throws Exception {
        Date date = new Date();
        date.setTime(new Timestamp(System.currentTimeMillis()).getTime());
        String formattedDate = new SimpleDateFormat("dd-MM-yyyy").format(date);

        String token = userId + "-" + formattedDate;

        return Base64Utils.encode(token);
    }

    public static boolean isValidToken(String decodedToken) {
        boolean isValid;
        SimpleDateFormat formatter = new SimpleDateFormat("dd-MM-yyyy");

        String userId = decodedToken.substring(0, decodedToken.indexOf("-"));
        System.out.println(userId);

        String timestamp = decodedToken.substring(decodedToken.indexOf("-"), decodedToken.length());
        System.out.println(timestamp);

        try {
            Date date = new Date();
            date.setTime(date.getTime() + 1 * 60 * 1000);
            Date date2 = formatter.parse(decodedToken);
            isValid = (date2.before(date));

        } catch (Exception e) {
            isValid = false;
            System.out.println(e.getMessage());
        }
        return isValid;
    }

    public static void main(String[] args) throws Exception {
        // GENERATE TOKEN
        String userId = "5";

        String encodedToken = TokenUtils.generateToken(userId);
        System.out.println (userId + " base64 -> " + encodedToken);

        // TOKEN IS VALID
        String decodedToken = null;
        try {
            decodedToken = Base64Utils.decode(encodedToken);
        } catch (Exception e) {
            e.printStackTrace();
        }

        String decodedUserId = decodedToken.substring(0, decodedToken.indexOf("-"));
        System.out.println(userId);

        //
        boolean isValid = TokenUtils.isValidToken(decodedUserId);
        System.out.println(encodedToken + " userId --> " + decodedUserId +  " => " + isValid );

      /*
       * output
       *   try this howto base64 -> dHJ5IHRoaXMgaG93dG8=
       *   dHJ5IHRoaXMgaG93dG8= string --> try this howto
       */
    }

}
