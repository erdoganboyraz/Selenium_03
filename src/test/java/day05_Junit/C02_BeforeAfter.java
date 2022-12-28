package day05_Junit;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;

public class C02_BeforeAfter {
    @Before
public void setUp(){
    System.out.println("Her Test Methodundan Once Calisir.");
}
    @After
    public void tearDown(){
        System.out.println("Her Test Methodundan Sonra Calisir.");
    }
    @Test
    public void test01() throws InterruptedException {
        System.out.println("Ilk Test");
        Thread.sleep(3000);
    }
    @Test
    public void test02() throws InterruptedException {
        System.out.println("Ikinci Test");
        Thread.sleep(3000);
    }
   // @Before notasyanunun kullanildigi method'a genelde setup( ) ismi verilir.
   // @after notasyanunun kullanildigi metoda genelde teardown() ismi verilir
}
