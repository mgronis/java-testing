package presentation;

public interface GenericService {

    String doSomeThing();

    CalculationResponse calculate(AnotherGenericService service);

}
