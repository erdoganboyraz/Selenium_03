package day12;

import com.github.javafaker.Faker;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import utilities.TestBase;

public class Erdi {
    @Test
    public void keyboardActionsTest(){
        Faker faker=new Faker();
        String fName=faker.name().firstName();
        System.out.println(fName);
        String lName=faker.name().lastName();
        System.out.println(lName);
        String username=faker.name().username();
        System.out.println(username);
        String title=faker.name().title();
        System.out.println(title);
        System.out.println(faker.address().city());

    }

}
