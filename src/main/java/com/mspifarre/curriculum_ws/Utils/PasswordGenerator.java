package com.mspifarre.curriculum_ws.Utils;

import java.security.SecureRandom;
import java.util.Base64;

public class PasswordGenerator {
    public static String generatePassword(int n){
        SecureRandom random = new SecureRandom();
        byte bytes[] = new byte[n];
        random.nextBytes(bytes);
        Base64.Encoder encoder = Base64.getEncoder().withoutPadding();
        return encoder.encodeToString(bytes);
    }
}
