import org.apache.commons.io.FileUtils;
import org.junit.jupiter.api.Assertions;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.io.File;
import java.io.IOException;
import java.nio.charset.Charset;
import java.util.concurrent.TimeUnit;

import static org.openqa.selenium.By.xpath;

public class Privacy_Page {
    static WebDriver driver = Util.getDriver();
    private static final By PRIVACY_MENU = xpath(" //*[contains(text(),'Adatvédelmi tájékoztató')]");
    private static final By PRIVACY_TEXT = xpath("//*[@href='/adatkezeles/']");

   /* public static void save_privacy_text() {
        WebElement privacy_policy = driver.findElement(By.xpath("//*[@href='/adatkezeles/']"));
        privacy_policy.click();
        WebElement e = driver.findElement(By.xpath(" //*[@href='/adatkezeles/']"));
        WebDriverWait wait = new WebDriverWait(driver,5);
        wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//*[@href='/adatkezeles/']")));
        //WebElement e = driver.findElement(By.xpath("//*[@id=\"navilast\"]"));
        String text = e.getText();
        System.out.println(text);
        Assertions.assertEquals("Adatvédelmi tájékoztató", text);
    }

    */


    public static void print_Privacy_into_file() {
        WebElement privacy_policy = driver.findElement(PRIVACY_MENU);
        privacy_policy.click();
       // WebElement e = driver.findElement(By.xpath("//*[@href='/adatkezeles/']"));
        WebElement e = driver.findElement(PRIVACY_TEXT);
        //obtain text
        String s = e.getText();
        //write text to file

        File f = new File("savetxt.txt");
        try {
            FileUtils.writeStringToFile(f, s, Charset.defaultCharset());
        } catch (IOException exc) {
            exc.printStackTrace();
        }
    }
}



















