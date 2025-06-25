// BMICalculator class is a utility class that's used to calculate the BMI value in both Imperial and Metric systems
public class BMICalculator {

    // Please declare 4 attributes/properties to represent weight in pounds, height in inches, weight in kilos and height in meters
    float weightInPounds;
    float weightInKilos;
    float heightInInches;
    float heightInMeters;

    // Please use this default no arguments constructor to initialize the 4 properties to some initial values
    public BMICalculator() {
        weightInPounds = 220.5f;
        weightInKilos = 103.5f;
        heightInMeters = 1.8f;
        heightInInches = 70.5f;
    }

    // Please implement the calculateBmiImperial() method to take in weight and height to calculate and return the BMI value in the Imperial system
    public double calculateBmiImperial(double weightInPounds, double heightInInches) {
        if (heightInInches == 0.0) return 0.0;
        return (703 * weightInPounds) / (heightInInches * heightInInches);
    }

    // Please implement the calculateBmiMetric() method to take in weight and height to calculate and return the BMI value in the Metric system
    public double calculateBmiMetric(double weightInKilos, double heightInMeters) {
        if (heightInMeters == 0.0) return 0.0;
        return weightInKilos / (heightInMeters * heightInMeters);

    }

    // Please implement the getBMICategory() method so that it takes the BMI value and returns the BMI category based on it
    public String getBMICategory(double bmi) {
        if (bmi < 18.5)  return "Underweight";
        else if (bmi < 25)  return "Normal weight";
        else if (bmi < 30) return "Overweight";
        else return "Obese";
    }
}
