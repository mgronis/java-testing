package domain.presentation.c;

import org.junit.Rule;
import org.junit.Test;
import org.junit.rules.ExternalResource;

import static org.junit.Assert.assertTrue;

public class ExperimentExternalResourceTest {

    @Rule
    public final SomeExternalResource externalResource = new SomeExternalResource();

    @Test
    public void t1(){
        System.out.println("Test 1...");
        assertTrue(true);
    }

    @Test
    public void t2(){
        System.out.println("Test 2...");
        assertTrue(true);
    }

    private static class SomeExternalResource extends ExternalResource {

        @Override
        protected void before() throws Throwable {
            System.out.println("Before " + this.getClass().getSimpleName());
            super.before();
        }

        @Override
        protected void after() {
            System.out.println("After " + this.getClass().getSimpleName());
            super.after();
        }

    }
}
