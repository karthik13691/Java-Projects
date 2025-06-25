// Espresso class extends Coffee class
public class Espresso extends Coffee{

    // Espresso class has an additional property numberOfShots
    int numberOfShots;

    // Constructor for Espresso class
    public Espresso(String name, String roast, double price, int numberOfShots) {
        super(name, roast, price);
        this.numberOfShots=numberOfShots;
    }

    // Method to print details of the Espresso
    public void printEspressoDetails(int numberOfShots, double price) {
        System.out.println("You asked for " + numberOfShots +" servings! Every serving of Espresso costs "+ price +
                "$. Your total bill is " + (numberOfShots*price) + "$");
    }

}
