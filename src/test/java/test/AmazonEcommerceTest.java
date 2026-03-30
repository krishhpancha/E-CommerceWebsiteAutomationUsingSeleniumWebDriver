package tests;


    import base.BaseTest;
    import org.openqa.selenium.*;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.openqa.selenium.support.ui.ExpectedConditions;

import java.time.Duration;
import java.util.List;

public class AmazonEcommerceTest extends BaseTest {

        public static void main(String[] args) {

            setup();

            driver.get("https://www.amazon.in");

            WebDriverWait wait =
                    new WebDriverWait(driver, Duration.ofSeconds(10));

            // Search Product
            WebElement searchBox =
                    wait.until(ExpectedConditions
                            .visibilityOfElementLocated(By.id("twotabsearchtextbox")));

            searchBox.sendKeys("Laptop");

            driver.findElement(By.id("nav-search-submit-button")).click();

            // Capture Product List
            List<WebElement> products =
                    wait.until(ExpectedConditions
                            .visibilityOfAllElementsLocatedBy(
                                    By.cssSelector("h2 span")));

            System.out.println("===== PRODUCT LIST =====");

            for (WebElement product : products) {
                System.out.println(product.getText());
            }

            // Count Products
            System.out.println("Total Products Found: " + products.size());

            // Click First Product
            products.get(0).click();

            // Switch Window (Amazon opens new tab)
            String mainWindow = driver.getWindowHandle();

            for(String window : driver.getWindowHandles()){
                if(!window.equals(mainWindow)){
                    driver.switchTo().window(window);
                }
            }

            // Validate Title
            String title = driver.getTitle();

            System.out.println("Page Title: " + title);

            if(title.toLowerCase().contains("laptop")){
                System.out.println("✅ TEST PASS");
            }else{
                System.out.println("❌ TEST FAIL");
            }

            close();
        }
}
