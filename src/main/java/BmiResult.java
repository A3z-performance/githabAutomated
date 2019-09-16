public class BmiResult {
    int weight;
    int age;
    int high;
    String resultBmi;
    String resultResponse;

    public BmiResult(int weight, int age, int high, String resultBmi, String resultResponse){
        this.weight = weight;
        this.age = age;
        this.high = high;
        this.resultBmi = resultBmi;
        this.resultResponse = resultResponse;
    }
}
