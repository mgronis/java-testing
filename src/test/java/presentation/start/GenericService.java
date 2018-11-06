package presentation.start;

public interface GenericService {

    String doSomeThing();

    CalculationResponse calculate(AnotherGenericService service);

}
