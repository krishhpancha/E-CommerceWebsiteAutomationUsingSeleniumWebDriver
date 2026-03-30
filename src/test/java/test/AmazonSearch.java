package tests;
import base.BaseTest;
import org.openqa.selenium.By;
public class AmazonSearch extends BaseTest {
    public static void main(String[] args) {

        BaseTest.setup();

        BaseTest.driver.get("https://www.google.com");

        BaseTest.driver.get("https://www.amazon.in");

        BaseTest.driver.findElement(By.id("twotabsearchtextbox"))
                .sendKeys("Laptop");

        BaseTest.driver.findElement(By.id("nav-search-submit-button"))
                .click();
    }
}
