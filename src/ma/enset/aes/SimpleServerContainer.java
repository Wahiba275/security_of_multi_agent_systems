package ma.enset.aes;

import jade.core.ProfileImpl;
import jade.core.Runtime;
import jade.wrapper.AgentContainer;
import jade.wrapper.AgentController;



public class SimpleServerContainer {
    public static void main(String[] args) throws Exception {
        Runtime runtime = Runtime.instance();
        ProfileImpl profile = new ProfileImpl();
        profile.setParameter(ProfileImpl.MAIN_HOST , "localhost");
        AgentContainer clientContainer = runtime.createAgentContainer(profile);
        String secret = "1234561234560000";
        AgentController agentController = clientContainer.createNewAgent("server","ma.enset.aes.ServerAgent",new Object[]{secret });
        agentController.start();

    }
}
