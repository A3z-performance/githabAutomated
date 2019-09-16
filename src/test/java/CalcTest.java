import io.github.bonigarcia.wdm.ChromeDriverManager;
import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;
import org.testng.annotations.*;

import java.util.List;

public class CalcTest {
    private Calc calc = new Calc();

    @BeforeMethod
    public void setUp() throws Exception {
        System.out.println("@BeforeMethod");
    }

    @AfterMethod
    public void tearDown() throws Exception {
        System.out.println("@AfterMethod");
    }

    @BeforeGroups
    public void beforeGroups() throws Exception {
        System.out.println("BeforeGroups");
    }

    @AfterGroups
    public void afterGroups() throws Exception {
        System.out.println("@AfterGroups");
    }

    @BeforeClass
    public void beforeClass() throws Exception {
        System.out.println("@BeforeClass");
    }

    @BeforeTest
    public void beforeTest() throws Exception {
        System.out.println("@BeforeTest");
    }

    @AfterTest
    public void afterTest() throws Exception {
        System.out.println("@AfterTest");
    }

    @AfterClass
    public void afterClass() throws Exception {
        System.out.println("@AfterClass");
    }

    @BeforeSuite
    public void beforeSuite() throws Exception {
        System.out.println("@BeforeSuite");
    }

    @AfterSuite
    public void afterSuite() throws Exception {
        System.out.println("@AfterSuite");
    }

    @Test(groups = {"smoke"})
    public void testSum() throws Exception {
        Assert.assertEquals(5, calc.sum(2, 3));
        System.out.println("TEST sum");
    }

    @Test(expectedExceptions = NullPointerException.class)
    public void testNullPointerException() {
        System.out.println("TEST null");
        List list = null;
        int size = list.size();

    }

    @Test(timeOut = 1000)
    public void waitLongTime() throws Exception {
        Thread.sleep(1001);
    }

    @Test
    public void initEnvironmentTest() {
        System.out.println("This is initEnvironmentTest");
    }

    @Test(dependsOnMethods = {"initEnvironmentTest"})
    public void testmethod() {
        System.out.println("This is testmethod");
    }

    @DataProvider
    public Object[][] summLocalData() {
        return new Object[][]{
                {5, calc.sum(2, 3)},
                {10, calc.sum(3, 7)},
                {1000, calc.sum(345, 655)},
                {123, calc.sum(12, 111)},
        };

    }

    @Test(dataProvider = "summLocalData")
    public void sum(int result, int sumDigit){
        Assert.assertEquals(result, sumDigit);
    }

}
