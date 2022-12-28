package day06;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.junit.After;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.Select;

import java.time.Duration;
import java.util.List;

public class Calısma {
  /*
   1. Launch browser
2. Navigate to url 'http://automationexercise.com'
            3. Verify that home page is visible successfully
4. Click on 'Signup / Login' button
5. Verify 'New User Signup!' is visible
6. Enter name and email address
7. Click 'Signup' button
8. Verify that 'ENTER ACCOUNT INFORMATION' is visible
9. Fill details: Title, Name, Email, Password, Date of birth
10. Select checkbox 'Sign up for our newsletter!'
            11. Select checkbox 'Receive special offers from our partners!'
            12. Fill details: First name, Last name, Company, Address, Address2, Country, State, City, Zipcode, Mobile Number
13. Click 'Create Account button'
            14. Verify that 'ACCOUNT CREATED!' is visible
15. Click 'Continue' button
16. Verify that 'Logged in as username' is visible
17. Click 'Delete Account' button
18. Verify that 'ACCOUNT DELETED!' is visible and click 'Continue' button


   */
  WebDriver driver;
    // 1. Launch browser
    @Before
    public void setup(){
        WebDriverManager.chromedriver().setup();
        driver = new ChromeDriver();
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(15));
    }
    //2. Navigate to url 'http://automationexercise.com'
    //3. Verify that home page is visible successfully
    @Test
    public void test_VerifyHomePageIsVisible(){
        driver.get("http://automationexercise.com");
        String expectedTitle = "Automation Exercise";
        String actualTitle = driver.getTitle();
        Assert.assertEquals(expectedTitle, actualTitle);
    }
    //4. Click on 'Signup / Login' button
    //5. Verify 'Login to your account' is visible
    @Test
    public void test_VerifyLoginToYourAccountIsVisble(){
        test_VerifyHomePageIsVisible();
        driver.findElement(By.xpath("//*[text()=' Signup / Login']")).click();
        WebElement wantedText = driver.findElement(By.xpath("//h2[text()='Login to your account']"));
        Assert.assertTrue(wantedText.isDisplayed());
    }
    //6. Enter correct email address and password
    //7. Click 'login' button
    //8. Verify that 'Logged in as username' is visible
    @Test
    public void test_VerifyLoggedInAsUsernameIsVisible(){
        test_VerifyLoginToYourAccountIsVisble();
        driver.findElement(By.xpath("//*[@data-qa='login-email']")).sendKeys("chakan87@hotmail.com");
        driver.findElement(By.xpath("//*[@data-qa='login-password']")).sendKeys("051207");
        driver.findElement(By.xpath("//*[@data-qa='login-button']")).click();
        WebElement wantedText = driver.findElement(By.xpath("//*[text()=' Logged in as ']"));
        System.out.println("Verify that 'Logged in as username' is visible= " + wantedText.isDisplayed());
        Assert.assertTrue(wantedText.isDisplayed());
    }
    //9. Click 'Delete Account' button
    //10. Verify that 'ACCOUNT DELETED!' is visible
    @Test
    public void test_VerifyAccountDeletedIsVisible(){
        test_VerifyLoggedInAsUsernameIsVisible();
        driver.findElement(By.xpath("//*[text()=' Delete Account']")).click();
        WebElement wantedText = driver.findElement(By.xpath("//b[text()='Account Deleted!']"));
        Assert.assertTrue(wantedText.isDisplayed());
        driver.findElement(By.xpath("//*[@data-qa='continue-button']")).click();
    }

    @After
    public void tearDown(){
        driver.close();
    }

}
