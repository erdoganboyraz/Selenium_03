package practice_burak_02;

import io.github.bonigarcia.wdm.WebDriverManager;
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

public class C05 {
    WebDriver driver;
    @Before
    public void setUp() throws Exception {
        WebDriverManager.chromedriver().setup();
        driver = new ChromeDriver();
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(15));
    }

    @Test
    public void test01() {
        // https://the-internet.herokuapp.com/dropdown adresine gidin.
        driver.get("https://the-internet.herokuapp.com/dropdown");
        // Index kullanarak Option 1 seçin ve sectiginiz option'u yazdırın
      WebElement option= driver.findElement(By.xpath("//*[@id='dropdown']"));
      Select optionDropdown=new Select(option);
      optionDropdown.selectByIndex(1);
        System.out.println(optionDropdown.getFirstSelectedOption().getText());

        // Value kullanarak Option 2 seçin ve sectiginiz option'u yazdırın
        optionDropdown.selectByValue("2");
        System.out.println(optionDropdown.getFirstSelectedOption().getText());

        // Visible Text kullanarak Option 1 seçin ve sectiginiz option'u yazdırın
        optionDropdown.selectByVisibleText("Option 1");

        // Tüm option'ları yazdırın
        List<WebElement>options=optionDropdown.getOptions();
        int counter=1;
        for (WebElement w:options) {
            System.out.println(counter+".option is"+w.getText());
            counter++;
        }
       Assert.assertEquals(3,options.size());



    }
}
