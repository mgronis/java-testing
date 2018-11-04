package domain.presentation.a;

import org.junit.Test;
import org.mockito.ArgumentMatcher;

import java.awt.*;

import static org.hamcrest.CoreMatchers.is;
import static org.junit.Assert.assertThat;
import static org.mockito.ArgumentMatchers.argThat;
import static org.mockito.ArgumentMatchers.eq;
import static org.mockito.Mockito.*;
import static org.mockito.internal.progress.ThreadSafeMockingProgress.mockingProgress;

public class BikeServiceTest {

    public static final Bike GARRY = new Bike(1, Breaks.MECHANIC, Frame.STEEL, Color.BLUE, "Garry");

    private BikeService service = mock(BikeService.class);

    @Test
    public void firstArgumentMatchers(){
        when(service.standardService(with(GARRY))).thenReturn(true);

        Bike secondGarry = new Bike(1, Breaks.MECHANIC, Frame.STEEL, Color.BLUE, "Garry");
        boolean result = service.standardService(secondGarry);

        assertThat(result, is(true));
        verify(service).standardService(eq(GARRY));
    }






















    @Test
    public void secondArgumentMatchers(){
        when(service.standardService(with(GARRY))).thenReturn(true);

        Bike secondGarry = new Bike(1, Breaks.MECHANIC, Frame.STEEL, Color.BLUE, "Garry");
        boolean result = service.standardService(secondGarry);

        assertThat(result, is(true));
        verify(service).standardService(with(GARRY));
    }




















    public <T extends Bike> T with(T bike){
        mockingProgress().getArgumentMatcherStorage().reportMatcher(
                new ArgumentMatcher<Bike>() {
                    @Override
                    public boolean matches(Bike argument) {
                        return bike.getNoOfGears() == argument.getNoOfGears()
                                && bike.getFrame() == argument.getFrame()
                                && bike.getColor() == argument.getColor()
                                && bike.getBreaks() == argument.getBreaks()
                                && bike.getBrand().equals(argument.getBrand());
                    }
                });
        return bike;
    }

















    @Test
    public void thirdArgumentMatchers(){
        when(service.standardService(argThat(withBike(GARRY)))).thenReturn(true);

        boolean result = service.standardService(GARRY);

        assertThat(result, is(true));
        verify(service).standardService(argThat(withBike(GARRY)));
    }





















    public ArgumentMatcher<Bike> withBike(Bike bike) {
        return new ArgumentMatcher<Bike>() {
            @Override
            public boolean matches(Bike argument) {
                return bike.getNoOfGears() == argument.getNoOfGears()
                        && bike.getFrame() == argument.getFrame()
                        && bike.getColor() == argument.getColor()
                        && bike.getBreaks() == argument.getBreaks()
                        && bike.getBrand().equals(argument.getBrand());
            }
        };
    }

}