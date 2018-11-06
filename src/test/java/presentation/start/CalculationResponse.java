package presentation.start;

import org.assertj.core.util.Lists;

import java.util.Collection;

public class CalculationResponse {

    public boolean isComplete() {
        return true;
    }

    public String getStatus() {
        return "OK!";
    }

    public Collection<String> getParts() {
        return Lists.newArrayList("First result", "Second result");
    }
}
