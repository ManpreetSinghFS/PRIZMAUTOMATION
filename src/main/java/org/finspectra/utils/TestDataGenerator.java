package org.finspectra.utils;

import java.util.UUID;

public class TestDataGenerator {

    private static String createdAccountName;

    private static String shortUuid() {
        return UUID.randomUUID().toString().replace("-", "").substring(0, 8).toUpperCase();
    }

    public static String generateAccountName() {
        createdAccountName = "AutoAccount_" + shortUuid();
        return createdAccountName;
    }

    public static String getCreatedAccountName() {
        return createdAccountName;
    }

    public static String generateContactFirstName() {
        return "AutoFirst_" + shortUuid();
    }

    public static String generateContactLastName() {
        return "AutoLast_" + shortUuid();
    }
}
