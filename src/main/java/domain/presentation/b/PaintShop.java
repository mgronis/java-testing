package domain.presentation.b;

public class PaintShop {

    public static FancyColour buyFancyColour(String colourName){
        switch (colourName){
            case "green":
                return FancyColour.GREEN_METALLIC;
            case "gold":
                return FancyColour.GOLD;
            default:
                return null;
        }
    }

    public enum FancyColour {
        GOLD,
        GREEN_METALLIC
    }

}
