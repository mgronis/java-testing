package presentation.start;

public class UserJsonService implements AnotherGenericService {
    @Override
    public String serveUserWithJson(String user) {
        return "{\"user\":\"" + user + "\"}";
    }

}
