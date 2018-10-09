package domain.presentation.d;

import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.junit.runners.Parameterized;
import org.junit.runners.Parameterized.Parameters;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;
import org.mockito.junit.MockitoJUnitRunner;

import java.util.Arrays;
import java.util.Collection;

import static org.hamcrest.CoreMatchers.is;
import static org.junit.Assert.assertThat;
import static org.mockito.Mockito.when;

@RunWith(Parameterized.class)
public class FancyServiceParametrizedTest {

    @Parameters
    public static Collection<Object[]> data(){
        return Arrays.asList(new Object[][]{{}});
    }

    @Mock
    private FancyService service;

    @Before
    public void setup(){
        MockitoAnnotations.initMocks(this);
        when(service.doFancyStuff()).thenReturn("Nice!!");
    }

    @Test
    public void t(){
        assertThat(service.doFancyStuff(), is("Nice!!"));
    }

}