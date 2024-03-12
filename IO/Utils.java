package IO;

import Interfaces.iUtils;

import java.nio.charset.StandardCharsets;
import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;

public class Utils implements iUtils {

    /**
     * Convierte un array de bytes en una cadena hexadecimal.
     * @param hash El array de bytes a convertir.
     * @return La cadena hexadecimal resultante.
     */
    private static String bytesToHex(byte[] hash) {
        StringBuilder hexString = new StringBuilder(2 * hash.length);
        for (int i = 0; i < hash.length; i++) {
            String hex = Integer.toHexString(0xff & hash[i]);
            if (hex.length() == 1) {
                hexString.append('0');
            }
            hexString.append(hex);
        }
        return hexString.toString();
    }
    /**
     * Crea un hash para una contraseña utilizando el algoritmo SHA3-256.
     * @param password La contraseña a ser hasheada.
     * @return El hash de la contraseña en formato hexadecimal, o null si el algoritmo no está disponible.
     */
    public static String hashPassword(String password) {
        try{
            final MessageDigest digest = MessageDigest.getInstance("SHA3-256");
            final byte[] hashbytes = digest.digest(password.getBytes(StandardCharsets.UTF_8));
            String sha3Hex = bytesToHex(hashbytes);
            return sha3Hex;
        }catch (NoSuchAlgorithmException e){
            return null;

        }

    }
}
