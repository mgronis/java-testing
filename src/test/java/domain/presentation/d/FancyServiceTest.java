package domain.presentation.d;

import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.Mock;
import org.mockito.junit.MockitoJUnitRunner;

import static org.hamcrest.CoreMatchers.is;
import static org.junit.Assert.assertThat;
import static org.mockito.Mockito.when;

@RunWith(MockitoJUnitRunner.class)
public class FancyServiceTest {

    @Mock
    private FancyService service;







































    @Before
    public void setup(){
        when(service.doFancyStuff()).thenReturn("Nice!!");
    }

    @Test
    public void t(){
        assertThat(service.doFancyStuff(), is("Nice!!"));
    }




















}