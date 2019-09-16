import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;
import org.testng.annotations.*;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.Scanner;

public class BmiCalculatorTest {

    private static WebDriver driver;
    static String url = "https://www.calculator.net/bmi-calculator.html";
    static File dataFile;
    ArrayList<String[]> data;

    @BeforeClass
    public static void setupClass() {
        WebDriverManager.chromedriver().setup();
        driver = new ChromeDriver();
        driver.manage().window().maximize();
        driver.get(url);

    }

    @BeforeMethod
    public void setupTest() {


    }


    @BeforeTest
    public void bfTest() throws FileNotFoundException {
        dataFile = new File("C:\\Users\\student\\testData\\data.txt");
        data = new ArrayList<String[]>();

        String dataUnit;
        Scanner sc = new Scanner(dataFile);

        int i = 0;
        while (sc.hasNextLine())
         {
             dataUnit = sc.nextLine();
            String[] dataDelim = dataUnit.split(", ");

                data.add(dataDelim);


        }
        sc.close();

    }

    @AfterTest
    public void afTest() {
        if (driver != null) {
            driver.quit();
        }

    }

    @AfterMethod
    public void teardown() {

    }

//    @DataProvider
//    public Object[][] bmiData() {
//        return new Object[][]{
//                {65, 35, 170},
//                {45, 35, 170},
//                {78, 35, 170},
//                {90, 35, 170},
//                {110, 35, 170},
//                {125, 35, 170},
//        };
//
//    }

    @DataProvider
    public Object[][] bmiData() {
        Object[][] arr = new Object[data.size()][data.get(0).length];
        int i = 0;
        for(String[] s: data){
            arr[i] = s;
            i++;
        }

        return arr;

    }


    @Test(dataProvider = "bmiData")
    public void testCalculator(int weight, int age, int height) {


        WebElement ageInput = driver.findElement(By.id("cage"));
        WebElement heightInput = driver.findElement(By.id("cheightmeter"));
        WebElement weightInput = driver.findElement(By.id("ckg"));
        WebElement calculateButton = driver.findElement(By.xpath("//*[@alt=\"Calculate\"]"));


        weightInput.clear();
        weightInput.sendKeys(String.valueOf(weight));

        ageInput.clear();
        ageInput.sendKeys(String.valueOf(age));

        heightInput.clear();
        heightInput.sendKeys(String.valueOf(height));


        calculateButton.click();
        WebElement bmiDigits = driver.findElement(By.xpath("//*[@class=\"bigtext\"]/b"));
        WebElement bmiText = driver.findElement(By.xpath("//*[@class=\"bigtext\"]/font/b"));
        String s1 = bmiDigits.getText();
        String s2 = bmiText.getText();


        Assert.assertEquals(BmiCalculator.calcBmi(weight, age, height), s1 + " " + s2);

    }

    @Test(dataProvider = "bmiData")
    public void testCalculatorFile(String weight, String age, String height, String bmiDig, String bmi) {
        WebElement ageInput = driver.findElement(By.id("cage"));
        WebElement heightInput = driver.findElement(By.id("cheightmeter"));
        WebElement weightInput = driver.findElement(By.id("ckg"));
        WebElement calculateButton = driver.findElement(By.xpath("//*[@alt=\"Calculate\"]"));


        weightInput.clear();
        weightInput.sendKeys(weight);

        ageInput.clear();
        ageInput.sendKeys(age);

        heightInput.clear();
        heightInput.sendKeys(height);


        calculateButton.click();
        WebElement bmiDigits = driver.findElement(By.xpath("//*[@class=\"bigtext\"]/b"));
        WebElement bmiText = driver.findElement(By.xpath("//*[@class=\"bigtext\"]/font/b"));
        String s1 = bmiDigits.getText();
        String s2 = bmiText.getText();


        Assert.assertEquals(bmiDig + " " + bmi, s1 + " " + s2);
    }


}
