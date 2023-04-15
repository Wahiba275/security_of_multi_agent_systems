package ma.enset.rsa;

import jade.core.ProfileImpl;
import jade.core.Runtime;
import jade.wrapper.AgentContainer;
import jade.wrapper.AgentController;
public class SimpleClientContainer {
    public static void main(String[] args)  throws Exception {
        Runtime runtime = Runtime.instance();
        ProfileImpl profile = new ProfileImpl();
        profile.setParameter(ProfileImpl.MAIN_HOST , "localhost");
        AgentContainer clientContainer = runtime.createAgentContainer(profile);
        String encodedPubKey = "MFwwDQYJKoZIhvcNAQEBBQADSwAwSAJBAIj/y15L3doKMCb94sLrWTGCdNEfZOQo9KO78u/kFOF1GP+YNhB7z92ABrNRgx1+5Xff9fZmhBBa7QCpLLJtuD8CAwEAAQ==";
        AgentController agentController = clientContainer.createNewAgent("client","ma.enset.rsa.ClientAgent",new Object[]{encodedPubKey});
        agentController.start();

    }
}
