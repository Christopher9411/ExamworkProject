import org.apache.commons.io.FileUtils;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

import java.io.File;
import java.io.IOException;
import java.nio.charset.Charset;
import java.util.concurrent.TimeUnit;

class WriteToText{
    public static void main(String[] args) {
        System.setProperty("webdriver.chrome.driver", "chromedriver.exe");
        WebDriver driver = new ChromeDriver();
        //implicit wait
        driver.manage().timeouts().implicitlyWait(5, TimeUnit.SECONDS);
        //URL launch
        driver.get("https://forum.index.hu/adatkezeles/");
        // identify element
        WebElement e = driver.findElement(By.cssSelector("#navilast"));
        //obtain text
        String s = e.getText();
        //write text to file

        File f = new File("savetxt.txt");
        try{
            FileUtils.writeStringToFile(f, s, Charset.defaultCharset());
        }catch(IOException exc){
            exc.printStackTrace();
        }








    }












}
