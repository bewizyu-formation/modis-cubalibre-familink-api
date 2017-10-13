package org.cubalibre.familink.api.utils;

import java.nio.charset.StandardCharsets;
import java.text.SimpleDateFormat;
import java.util.Base64;
import java.util.Date;

public class Base64Utils {

    public static String encode(String value) throws Exception {
        return  Base64.getEncoder().encodeToString(value.getBytes(StandardCharsets.UTF_8));
    }

    public static String decode(String value) throws Exception {
        byte[] base64DecodedValue = Base64.getDecoder().decode(value);  // Basic Base64 decoding
        return new String(base64DecodedValue, StandardCharsets.UTF_8);
    }

    public static boolean isValidToken(String decodedToken) {
        boolean isValid;
        SimpleDateFormat formatter = new SimpleDateFormat("yyMMddHHmmss");

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
        String test = "try this howto";

        String res1 = Base64Utils.encode(test);
        System.out.println
                (test + " base64 -> " + res1);

        //
        String res2 = Base64Utils.decode(res1);
        System.out.println( res1 + " string --> "  + res2);

      /*
       * output
       *   try this howto base64 -> dHJ5IHRoaXMgaG93dG8=
       *   dHJ5IHRoaXMgaG93dG8= string --> try this howto
       */
    }

}
