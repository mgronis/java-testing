package domain.presentation.b;

import org.hamcrest.Matcher;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.junit.runners.Parameterized;

import java.util.Arrays;
import java.util.Collection;

import static domain.presentation.b.PaintShop.FancyColour.GOLD;
import static domain.presentation.b.PaintShop.FancyColour.GREEN_METALLIC;
import static domain.presentation.b.PaintShop.buyFancyColour;
import static org.hamcrest.CoreMatchers.is;
import static org.hamcrest.CoreMatchers.nullValue;
import static org.junit.Assert.assertThat;

@RunWith(Parameterized.class)
public class PaintShopTest {

    @Parameterized.Parameters
    public static Collection<Object[]> data(){
        return Arrays.asList(new Object[][]{
                {"green", is(GREEN_METALLIC)},
                {"gold", is(GOLD)},
                {"red", nullValue()}
        });
    }

    private final String colour;
    private final Matcher<PaintShop.FancyColour> expected;

    public PaintShopTest(String colour, Matcher expected) {
        this.colour = colour;
        this.expected = expected;
    }

    @Test
    public void shop() {
        assertThat(buyFancyColour(colour), expected);
    }

}