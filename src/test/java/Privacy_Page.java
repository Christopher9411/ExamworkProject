import org.apache.commons.io.FileUtils;
import org.junit.jupiter.api.Assertions;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.IOException;
import java.nio.charset.Charset;

import static org.openqa.selenium.By.xpath;

public class Privacy_Page {
    static WebDriver driver;


    private static final By PRIVACY_MENU = xpath(" //*[contains(text(),'Adatvédelmi tájékoztató')]");
    private static final By PRIVACY_TEXT = xpath("//*[@href='/adatkezeles/']");
    private static final By ACCEPT_COOKIES = xpath("//*[@id=\"qc-cmp2-ui\"]/div[2]/div/button[2]");






    public static int print_Privacy_into_file() {
        // WebElement cookies_accept = driver.findElement(ACCEPT_COOKIES);
        //  cookies_accept.click();
        WebElement privacy_policy = driver.findElement(PRIVACY_MENU);
        privacy_policy.click();
        // WebElement e = driver.findElement(By.xpath("//*[@href='/adatkezeles/']"));
        WebElement e = driver.findElement(PRIVACY_TEXT);
        //obtain text
        String s = e.getText();
        //write text to file

        File f = new File("Privacy.txt");
        try {
            FileUtils.writeStringToFile(f, s, Charset.defaultCharset());
        } catch (IOException exc) {
            exc.printStackTrace();
        }

        int lines = 0;
        try {
            BufferedReader reader = new BufferedReader(new FileReader("Privacy.txt"));
            while (reader.readLine() != null) lines++;
            reader.close();
        } catch (Exception ex) {
            ex.printStackTrace();
        }


        return lines;
    }











}











