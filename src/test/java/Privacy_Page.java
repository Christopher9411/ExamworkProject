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
        WebDriverWait wait = new WebDriverWait(driver, 10);
        WebElement e = wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//*[@id=\"navilast\"]")));

        //WebElement e = driver.findElement(By.xpath("//*[@id=\"navilast\"]"));
        String text = e.getText();
        System.out.println(text);
    }


}





