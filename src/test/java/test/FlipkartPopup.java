package tests;
import base.BaseTest;
import org.openqa.selenium.By;
public class FlipkartPopup extends BaseTest {
    public static void main(String[] args) {

        setup();

        driver.get("https://www.flipkart.com");

        try{
            driver.findElement(By.xpath("//button[text()='✕']")).click();
        }catch(Exception e){
            System.out.println("Popup not present");
        }

        driver.findElement(By.name("q")).sendKeys("Mobile");


}
}
