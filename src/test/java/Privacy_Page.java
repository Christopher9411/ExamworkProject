import org.junit.jupiter.api.Assertions;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class Privacy_Page {
    static WebDriver driver = Util.getDriver();

    public static void save_privacy_text() {
        WebElement privacy_policy = driver.findElement(By.xpath("//*[@href='/adatkezeles/']"));
        privacy_policy.click();
        WebElement e = driver.findElement(By.xpath(" //*[@href='/adatkezeles/']"));
        WebDriverWait webdriverwait = new WebDriverWait(driver,5);
        WebDriverWait wait = new WebDriverWait(driver,5);
        wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//*[@href='/adatkezeles/']")));
        //WebElement e = driver.findElement(By.xpath("//*[@id=\"navilast\"]"));
        String text = e.getText();
        System.out.println(text);
        Assertions.assertEquals("Adatvédelmi tájékoztató", text);
    }


}





