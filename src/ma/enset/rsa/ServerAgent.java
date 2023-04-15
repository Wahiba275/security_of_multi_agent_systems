package ma.enset.rsa;

import jade.core.Agent;
import jade.core.behaviours.CyclicBehaviour;
import jade.lang.acl.ACLMessage;

import javax.crypto.Cipher;
import java.security.KeyFactory;
import java.security.PrivateKey;
import java.security.spec.PKCS8EncodedKeySpec;
import java.util.Base64;

public class ServerAgent extends Agent {
    @Override
    protected void setup() {
        String encodedPK = (String) getArguments()[0];
        addBehaviour(new CyclicBehaviour() {
            @Override
            public void action() {
                ACLMessage receive = receive();
                if(receive!=null){
                    String cryptedEncodedMsg = receive.getContent();
                    byte[] cryptMsg = Base64.getDecoder().decode(cryptedEncodedMsg);
                    try {
                        byte[] encodedPrivateKey = Base64.getDecoder().decode(encodedPK);
                        KeyFactory keyFactory  = KeyFactory.getInstance("RSA");
                        PrivateKey privateKey = keyFactory.generatePrivate(new PKCS8EncodedKeySpec(encodedPrivateKey));
                        Cipher cipher = Cipher.getInstance("RSA");
                        cipher.init(Cipher.DECRYPT_MODE , privateKey);
                        byte[] decryptMsg = cipher.doFinal(cryptMsg);
                        System.out.println(new String(decryptMsg));
                    } catch (Exception e) {
                        e.printStackTrace();
                    }
                }else{
                    block();
                }
            }
        });
    }
}
