package presentation;

import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;

import java.awt.*;
import java.util.Collection;
import java.util.Iterator;

import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertTrue;
import static org.mockito.Mockito.*;

public class PresentationTest {

    private static GenericService genericService;

    private AnotherGenericService service;

    @BeforeClass
    public static void setupClass(){
        genericService = mock(GenericService.class);

        when(genericService.doSomeThing()).thenThrow(new RuntimeException("Nope!"));
    }

    @Before
    public void setup(){
        service = mock(AnotherGenericService.class);

        when(service.valiedUserInput(eq("Sven"), eq(Color.BLUE), eq(101.2))).thenThrow(new IllegalArgumentException("Försök inte!"));
        when(service.valiedUserInput(eq("Lena"), eq(Color.RED), eq(1.22345))).thenReturn(true);
        when(service.valiedUserInput(eq("Ulla"), eq(Color.GREEN), eq(11.6678709))).thenThrow(new IllegalArgumentException("Försök inte!"));
    }

    @Test
    public void test1(){
        when(service.serveUserWithJson("Steve med Lloyden")).thenReturn("Fräsige värre");

        CalculationResponse calculationResponse = genericService.calculate(service);

        assertTrue(calculationResponse.isComplete() == true);
        assertTrue(calculationResponse.getStatus().equals("OK!"));

        Collection<String> parts = calculationResponse.getParts();

        assertFalse(parts.isEmpty());
        assertTrue(parts.size() == 2);

        Iterator<String> iterator = parts.iterator();
        assertTrue(iterator.next().equals("First result"));
        assertTrue(iterator.next().equals("Second result"));
    }

    @Test
    public void testServeUserWithJson0(){
        String result = service.serveUserWithJson("Sten");

        assertTrue(result.equals("{\"user\":\"Sten\"}"));
    }

    @Test
    public void testServeUserWithJson1(){
        String result = service.serveUserWithJson("Gurra");

        assertTrue(result.equals("{\"user\":\"Gurra\"}"));
    }

    @Test
    public void testServeUserWithJson2(){
        String result = service.serveUserWithJson("Lisa");

        assertTrue(result.equals("{\"user\":\"Lisa\"}"));
    }

    @Test
    public void testServeUserWithJson3(){
        String result = service.serveUserWithJson("Natasha");

        assertTrue(result.equals("{\"user\":\"Natasha\"}"));
    }

    @Test
    public void testServeUserWithJson4(){
        String result = service.serveUserWithJson("Bengt");

        assertTrue(result.equals("{\"user\":\"Bengt\"}"));
    }

    @Test
    public void testServeUserWithJson5(){
        String result = service.serveUserWithJson("Olle");

        assertTrue(result.equals("{\"user\":\"Olle\"}"));
    }

    @Test
    public void testServeUserWithJson6(){
        String result = service.serveUserWithJson("Elin");

        assertTrue(result.equals("{\"user\":\"Elin\"}"));
    }

    @Test
    public void testServeUserWithJson7(){
        String result = service.serveUserWithJson("Ralf");

        assertTrue(result.equals("{\"user\":\"Ralf\"}"));
    }

    @Test
    public void testServeUserWithJson8(){
        String result = service.serveUserWithJson("Josefin");

        assertTrue(result.equals("{\"user\":\"Josefin\"}"));
    }

    @Test
    public void testServeUserWithJson9(){
        String result = service.serveUserWithJson("Jenny");

        assertTrue(result.equals("{\"user\":\"Jenny\"}"));
    }

    @Test
    public void testServeUserWithJson10(){
        String result = service.serveUserWithJson("Ellen");

        assertTrue(result.equals("{\"user\":\"Ellen\"}"));
    }

    @Test
    public void testServeUserWithJson11(){
        String result = service.serveUserWithJson("Per");

        assertTrue(result.equals("{\"user\":\"Per\"}"));
    }

    @Test
    public void testServeUserWithJson12(){
        String result = service.serveUserWithJson("Oscar");

        assertTrue(result.equals("{\"user\":\"Oscar\"}"));
    }

    @Test
    public void testServeUserWithJson13(){
        String result = service.serveUserWithJson("Lisa");

        assertTrue(result.equals("{\"user\":\"Lisa\"}"));
    }
    
    @Test
    public void testServeUserWithJson14(){
        String result = service.serveUserWithJson("Nisse");

        assertTrue(result.equals("{\"user\":\"Nisse\"}"));
    }

}
