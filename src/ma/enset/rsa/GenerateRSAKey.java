package ma.enset.rsa;

import java.security.KeyPair;
import java.security.NoSuchAlgorithmException;
import java.security.PrivateKey;
import java.security.PublicKey;
import java.util.Base64;

public class GenerateRSAKey {
    public static void main(String[] args) throws NoSuchAlgorithmException {
        KeyPair keyPair = CryptographUtils.generateRSAKeys();
        PrivateKey privateKey = keyPair.getPrivate();
        PublicKey publicKey = keyPair.getPublic();
        String encodedPK =  Base64.getEncoder().encodeToString(privateKey.getEncoded());
        String encodedPubK = Base64.getEncoder().encodeToString(publicKey.getEncoded());
        System.out.println("===Private Key===");
        System.out.println(encodedPK);
        System.out.println("===Public key===");
        System.out.println(encodedPubK);

    }
}
