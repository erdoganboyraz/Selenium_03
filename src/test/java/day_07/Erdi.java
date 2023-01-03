package day_07;

import org.junit.Assert;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import utilities.TestBase;

import java.util.Set;

public class Erdi extends TestBase {
    @Test
    public void test01() throws InterruptedException {
        // 2. Navigate to url 'http://automationexercise.com'
        // 3. Verify that home page is visible successfully
        driver.get("http://automationexercise.com");
        String actualTitle = driver.getTitle();
        System.out.println(actualTitle);
        String expectedTitle = "Automation Exercise";
        Assert.assertEquals(expectedTitle,actualTitle);
        // 4. Click on 'Products' button
        driver.findElement(By.xpath("//*[@class='material-icons card_travel']")).click();
        // 5. Verify user is navigated to ALL PRODUCTS page successfully
        String actualTitle2 = driver.getTitle();
        String expectedTitle2 = "Automation Exercise ";
        System.out.println("actualTitle2 = " + actualTitle2);
        Assert.assertEquals(expectedTitle2,actualTitle2);
        // 6. The products list is visible
        // 7. Click on 'View Product' of first product
        // 8. User is landed to product detail page
        // 9. Verify that detail detail is visible: product name, category, price, availability, condition, brand
          }
}

