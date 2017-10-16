package org.cubalibre.familink.api.utils;

import java.nio.charset.StandardCharsets;
import java.util.Base64;

public class Base64Utils {
    public static String encode(String value) throws Exception {
        return Base64.getEncoder().encodeToString(value.getBytes(StandardCharsets.UTF_8));
    }

    public static String decode(String value) throws Exception {
        byte[] base64DecodedValue = Base64.getDecoder().decode(value);  // Basic Base64 decoding
        return new String(base64DecodedValue, StandardCharsets.UTF_8);
    }
}
