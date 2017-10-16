package org.cubalibre.familink.api.utils;

import java.nio.charset.StandardCharsets;
import java.util.Base64;

public class Base64Utils {

    public static String encode(String value) throws Exception {
        return  Base64.getEncoder().encodeToString(value.getBytes(StandardCharsets.UTF_8));
    }

    public static String decode(String value) throws Exception {
        byte[] base64DecodedValue = Base64.getDecoder().decode(value);  // Basic Base64 decoding
        return new String(base64DecodedValue, StandardCharsets.UTF_8);
    }

    public static void main(String[] args) throws Exception {
        // userID = 105
        // timestamp = 1507495532
        String token = "105-1507495532";

        String encodedToken = Base64Utils.encode(token);
        System.out.println
                (token + " base64 -> " + encodedToken);

        String decodedToken = Base64Utils.decode(encodedToken);
        System.out.println( encodedToken + " string --> "  + decodedToken);

      /*
       * OUTPUT :
       * 105-1507495532 base64 -> MTA1LTE1MDc0OTU1MzI=
       *  MTA1LTE1MDc0OTU1MzI= string --> 105-1507495532
       */
    }

}
