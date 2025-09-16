// Online Java Compiler
// Use this editor to write, compile and run your Java code online

class Main {
    public static void main(String[] args) {
        InsuranceCalculator calc=new InsuranceCalculator();
        calc.calculateDiscount();
    }
}
class InsuranceCalculator {
    public int calculateDiscount(CustomerProfile customer) {
        if(customer.isLoyal())
        return 20;
        return 0;
    }
}
public interface CustomerProfile {
    public boolean isLoyal();
}
class VehicleInsurance implements CustomerProfile{
    public boolean isLoyal() {
        return new Random().nextBoolean();
    }
}
public class HealthInsurance implements CustomerProfile{
    public boolean isLoyal() {
        return new Random().nextBoolean;
        }
}