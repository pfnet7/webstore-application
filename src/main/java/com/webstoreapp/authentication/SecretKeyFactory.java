package com.webstoreapp.authentication;

import io.jsonwebtoken.impl.crypto.MacProvider;
import javax.crypto.SecretKey;

final class SecretKeyFactory {

    private static final SecretKey secretKey = MacProvider.generateKey();

    static SecretKey getSecretKey() {
        return secretKey;
    }

}
