package domain.presentation.c;

import org.junit.Rule;
import org.junit.Test;
import org.junit.rules.ExternalResource;
import org.junit.rules.MethodRule;
import org.junit.rules.TestRule;
import org.junit.runner.Description;
import org.junit.runners.model.FrameworkMethod;
import org.junit.runners.model.Statement;

import static org.junit.Assert.assertTrue;

public class ExperimentMethodAndTestRuleTest {

    private static class MyFirstRule implements TestRule {

        @Override
        public Statement apply(Statement base, Description description) {
            System.out.println("Apply " + this.getClass().getSimpleName());
            return base;
        }

    }
























    private static class MySecondRule implements MethodRule {

        @Override
        public Statement apply(Statement base, FrameworkMethod method, Object target) {
            System.out.println("Apply " + this.getClass().getSimpleName());
            return base;
        }

    }




























    @Rule
    public final MyFirstRule first = new MyFirstRule();

    @Rule
    public final MySecondRule second = new MySecondRule();



























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























}
