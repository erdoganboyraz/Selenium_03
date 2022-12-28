package day05_Junit;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.junit.After;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

import java.time.Duration;
import java.util.List;

public class Odev {
    WebDriver driver;
    @Before
    public void setup(){
        WebDriverManager.chromedriver().setup();
        driver = new ChromeDriver();
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(15));
    }
  // @After
   // public void tearDown() throws InterruptedException {
      // Thread.sleep(3000);
      // driver.close();


   //}
   @Test
    public void test() throws InterruptedException {
       // 2- https://www.google.com/ adresine gidin
       driver.get("https://www.google.com");

       // 3- cookies uyarisini kabul ederek kapatin
       // 4- Sayfa basliginin “Google” ifadesi icerdigini test edin
      String actualTitle=driver.getTitle();
      String expectedTitle="Google";
       Assert.assertTrue(actualTitle.equals(expectedTitle));
       // 5- Arama cubuguna “Nutella” yazip aratin
       WebElement aramaCubugu= driver.findElement(By.xpath("//*[@class='gLFyf']"));
       aramaCubugu.sendKeys("Nutella",Keys.ENTER);
       // 6- Bulunan sonuc sayisini yazdirin
       WebElement aramaSonuc=driver.findElement(By.id("result-stats"));
       System.out.println(aramaSonuc.getText());
       // 7- sonuc sayisinin 10 milyon’dan fazla oldugunu test edin
       String [] sonucSayisi = aramaSonuc.getText().split(" ");
       System.out.println("Sonuc Sayısı : "+ sonucSayisi[2]);

       // 8- Sayfayi kapatin
       //1. "https://www.saucedemo.com" Adresine gidin
       driver.get("https://www.saucedemo.com");
       //2. Username kutusuna "standard_user" yazdirin
       Thread.sleep(3000);
       WebElement userNameBox= driver.findElement(By.xpath("//*[@id='user-name']"));
       userNameBox.sendKeys("standard_user");

       //3. Password kutusuna "secret_sauce" yazdirin
       Thread.sleep(3000);
       WebElement passwordBox=driver.findElement(By.cssSelector("input#password"));
       passwordBox.sendKeys("secret_sauce");

       //4. Login tusuna basin
       Thread.sleep(3000);
       driver.findElement(By.id("login-button")).click();

       //5. Ilk urunun ismini kaydedin ve bu urunun sayfasina gidin
       Thread.sleep(3000);
       WebElement ilkUrun=driver.findElement(By.xpath("//*[@alt='Sauce Labs Backpack']"));
       System.out.println(ilkUrun.getText());
       ilkUrun.click();

       //6. Add to Cart butonuna basin
       Thread.sleep(3000);
       driver.findElement(By.id("add-to-cart-sauce-labs-backpack")).click();

       //7. Alisveris sepetine tiklayin
       Thread.sleep(3000);
       driver.findElement(By.className("shopping_cart_badge")).click();

       //8. Sectiginiz urunun basarili olarak sepete eklendigini control edin
       WebElement SauceLabsBackpack=driver.findElement(By.xpath("//*[text()='Sauce Labs Backpack']"));
       if(SauceLabsBackpack.isDisplayed()){
           System.out.println("Urununu ekleme Testi PASSED");
       }else System.out.println("Urunu ekleme Testi FAILED ");

       //9. Sayfayi kapatin
       driver.close();
   }



}
