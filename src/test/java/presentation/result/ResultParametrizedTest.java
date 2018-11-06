package presentation.result;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.junit.runners.Parameterized;
import presentation.start.AnotherGenericService;
import presentation.start.UserJsonService;

import java.util.Arrays;
import java.util.Collection;

import static org.hamcrest.CoreMatchers.is;
import static org.junit.Assert.assertThat;
import static org.junit.runners.Parameterized.Parameters;

@RunWith(Parameterized.class)
public class ResultParametrizedTest {

    @Parameters(name = "name is {0}")
    public static Collection<Object[]> data(){
        return Arrays.asList(new Object[][] {
                { "Sten",    "{\"user\":\"Sten\"}" },
                { "Gurra",   "{\"user\":\"Gurra\"}" },
                { "Lisa",    "{\"user\":\"Lisa\"}" },
                { "Natasha", "{\"user\":\"Natasha\"}" },
                { "Bengt",   "{\"user\":\"Bengt\"}" },
                { "Olle",    "{\"user\":\"Olle\"}" },
                { "Elin",    "{\"user\":\"Elin\"}" },
                { "Ralf",    "{\"user\":\"Ralf\"}" },
                { "Josefin", "{\"user\":\"Josefin\"}" },
                { "Jenny",   "{\"user\":\"Jenny\"}" },
                { "Ellen",   "{\"user\":\"Ellen\"}" },
                { "Per",     "{\"user\":\"Per\"}" },
                { "Oscar",   "{\"user\":\"Oscar\"}" },
                { "Lisa",    "{\"user\":\"Lisa\"}" },
                { "Nisse",   "{\"user\":\"Nisse\"}" }
        });
    }

    private static final AnotherGenericService service = new UserJsonService();

    private final String user;
    private final String jsonResult;

    public ResultParametrizedTest(String user, String jsonResult) {
        this.user = user;
        this.jsonResult = jsonResult;
    }

    @Test
    public void serveUserWithJson(){
        String result = service.serveUserWithJson(user);

        assertThat(result, is(jsonResult));
    }

    private String userJson(String user) {
        return "{\"user\":\"" + user + "\"}";
    }

}
