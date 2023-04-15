package ma.enset.aes;

import jade.core.AID;
import jade.core.Agent;
import jade.lang.acl.ACLMessage;
import javax.crypto.Cipher;
import javax.crypto.SecretKey;
import javax.crypto.spec.SecretKeySpec;
import java.util.Arrays;
import java.util.Base64;

public class ClientAgent extends Agent {
    @Override
    protected void setup() {
        String secert = (String) getArguments()[0];
        String message = "Hello Server!!!";
        try {
            SecretKey secretKey = new SecretKeySpec(secert.getBytes() , "AES");
            Cipher cipher = Cipher.getInstance("AES");
            cipher.init(Cipher.ENCRYPT_MODE, secretKey);
            byte[] cryptMsg =   cipher.doFinal(message.getBytes());
            String cryptedEncodedMsg = Base64.getEncoder().encodeToString(cryptMsg);
            ACLMessage aclMessage = new ACLMessage(ACLMessage.INFORM);
            aclMessage.addReceiver(new AID("server" ,  AID.ISLOCALNAME));
            aclMessage.setContent(cryptedEncodedMsg);
            send(aclMessage);
            System.out.println(Arrays.toString(cryptMsg));
            System.out.println(cryptedEncodedMsg);
        }catch(Exception e){
            e.printStackTrace();
        }
    }
}
