package com.acount.move.util;

import java.util.Random;

public class AccountUtil {

    public static String generateAccountNumber() {
        // Generar un número aleatorio de 6 dígitos
        Random random = new Random();
        int randomAccountNumber = 100_000 + random.nextInt(900_000); // Número aleatorio de 6 dígitos (100000-999999)

        // Formatear el número como una cadena de 6 dígitos
        String accountNumber = String.format("%06d", randomAccountNumber);
        return  accountNumber;
    }
}
