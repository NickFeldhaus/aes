package feldhaus;

import javax.crypto.KeyGenerator;
import javax.crypto.SecretKey;
import java.security.NoSuchAlgorithmException;
import java.security.SecureRandom;

public class Aes {

    public static void main(String[] args){
        aesForBits(128);
    }
    public static void aesForBits(int bitsUsed) {
        byte[] state = new byte[bitsUsed/8];//State initialisieren
        new SecureRandom().nextBytes(state);

        addRoundKey(state);

        for(int round=0; round<10;round++){ //10 Runden, weil ich 128 Bit nutze, bei 256 Bit wären hier 14 Runden
            subBytes(state);
            shiftRows(state);
            mixColums(state);
            addRoundKey(state);
        }
        subBytes(state);
        shiftRows(state);
        addRoundKey(state);
        System.out.println(state.toString());
    }


    public static void addRoundKey(byte[] state) {
        byte[] key = new byte[16];
        new SecureRandom().nextBytes(key);
        for(byte b : state){
            int i = 0;
            state[i] = (byte) (b ^ key[i]);//Klappt das hier?
            i++;
        }
    }
    private static void subBytes(byte[] state) {
    }
    private static void shiftRows(byte[] state) {
    }
    private static void mixColums(byte[] state) {
    }
}
