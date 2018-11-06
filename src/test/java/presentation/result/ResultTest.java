package presentation.result;

import org.hamcrest.CustomTypeSafeMatcher;
import org.hamcrest.Matcher;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.Mock;
import org.mockito.junit.MockitoJUnitRunner;
import presentation.start.AnotherGenericService;
import presentation.start.CalculationResponse;
import presentation.start.GenericService;
import presentation.start.UserJsonService;

import static org.hamcrest.Matchers.contains;
import static org.junit.Assert.assertThat;
import static org.mockito.ArgumentMatchers.eq;
import static org.mockito.Mockito.when;

@RunWith(MockitoJUnitRunner.class)
public class ResultTest {

    @Mock
    private GenericService genericService;

    private AnotherGenericService service = new UserJsonService();

    @Before
    public void setup(){
        when(genericService.doSomeThing()).thenThrow(new RuntimeException("Nope!"));
    }

    @Test
    public void calculationResults(){
        when(genericService.calculate(eq(service))).thenReturn(new CalculationResponse());

        CalculationResponse calculationResponse = genericService.calculate(service);

        assertThat(calculationResponse, isCompleteWithStatusOk());
        assertThat(calculationResponse.getParts(), contains("First result", "Second result"));
    }

    private Matcher<CalculationResponse> isCompleteWithStatusOk(){
        return new CustomTypeSafeMatcher<CalculationResponse>("Is completed and has status ok") {
            @Override
            protected boolean matchesSafely(CalculationResponse item) {
                return item.isComplete() && item.getStatus().equals("OK!");
            }
        };
    }

}
