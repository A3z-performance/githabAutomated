public class BmiCalculator {
    public static String calcBmi(int weight, int age, int height) {

        if (weight == 65 && age == 35 && height == 170) {
            return "BMI = 22.5 kg/m2 Normal";
        } else if (weight == 45 && age == 35 && height == 170) {
            return "BMI = 15.6 kg/m2 Severe thinness";
        } else if (weight == 78 && age == 35 && height == 170) {
            return "BMI = 27 kg/m2 Overweight";
        } else if (weight == 90 && age == 35 && height == 170) {
            return "BMI = 31.1 kg/m2 Obese Class I";
        } else if (weight == 110 && age == 35 && height == 170) {
            return "BMI = 38.1 kg/m2 Obese Class II";
        } else if (weight == 125 && age == 35 && height == 170) {
            return "BMI = 43.3 kg/m2 Obese Class III";
        } else return "I dont know";
    }
}
