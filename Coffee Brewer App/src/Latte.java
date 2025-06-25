// Latte class extends Coffee class
public class Latte extends Coffee{

    // Latte class has additional properties milkType and syrupFlavor
    // Constructor for Latte class
    public Latte(String name, String roast, double price, String milkType, String syrupFlavor){
        super(name, roast, price);
    }
    String milkType;
    String syrupFlavor;

    // Method to print details of the Latte
    public void printLatteDetails(String milkType, String syrupFlavor){
        System.out.println("Your latte has " + milkType + " and " + syrupFlavor +". Your total bill is "+price+ " $");
    }
}
