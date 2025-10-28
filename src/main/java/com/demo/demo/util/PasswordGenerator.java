package com.demo.demo.util;

import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;

public class PasswordGenerator {

    /**
     * Genera el hash BCrypt de una contraseña.
     * @param rawPassword La contraseña en texto plano.
     * @return El hash BCrypt.
     */
    public static String generateHash(String rawPassword) {
        BCryptPasswordEncoder encoder = new BCryptPasswordEncoder();
        return encoder.encode(rawPassword);
    }

    public static void main(String[] args) {
        String password = "123456";
        String hashedPassword = generateHash(password);

        System.out.println("----------------------------------------------------------------");
        System.out.println("Contraseña original: " + password);
        System.out.println("Hash BCrypt generado: " + hashedPassword);
        System.out.println("----------------------------------------------------------------");
        System.out.println("USA ESTE HASH EN TU INSERCIÓN SQL:");
        System.out.printf("INSERT INTO user (numero_documento, nombre_usuario, password) VALUES (123456789, 'Usuario Prueba', '%s');\n", hashedPassword);
        System.out.println("----------------------------------------------------------------");
    }
}
