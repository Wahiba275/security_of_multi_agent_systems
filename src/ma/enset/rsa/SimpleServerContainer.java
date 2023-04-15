package ma.enset.rsa;

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
        String encodedPK = "MIIBVgIBADANBgkqhkiG9w0BAQEFAASCAUAwggE8AgEAAkEAopawAhwjykFjzXV0/YiYDjxArYR4uvT8tAdlvqHj8iKeHn4+YUj+8CAZ3fjQixJIhCQSgOIFtAqU/uwwU2a5MwIDAQABAkEAgu4mPwy6JZ4S6Nm1pJXjHVOYIiOTtbqj5bYvURy9m7bEPKMyidjpES7iyrBtK9fUoYZYCWuGJI+cvieYFTQ6gQIhAP6lr4bReNxV2aK2FUXS92lfTLlCa8LNuJX/ICMp5QApAiEAo3PN5/dyIlIi0pzfMkK7mhBChZmPXuDIMP3V9JMxKfsCIQDUUWsnmrIN7Fq4yt6zyDHXnskG0nWtB//2uLCgAQdZ+QIgOry/zs82Pa0khGkJMCeZAQk8zoPbaK4AYtKlE2ndrgcCIQDj/VbTQMnrftbN3ssbQUuw1U51RPfWirQDfuVjdXTdcw==";
        AgentController agentController = clientContainer.createNewAgent("server","ma.enset.rsa.ServerAgent",new Object[]{encodedPK });
        agentController.start();

    }
}
