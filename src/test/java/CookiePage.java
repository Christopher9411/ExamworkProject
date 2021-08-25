import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class CookiePage {
    WebDriver webdriver;
    final By COOKIE = By.xpath("//*[@id=\"qc-cmp2-ui\"]/div[2]/div/button[2]");

    public CookiePage(WebDriver webdriver){
        this.webdriver = webdriver;


    }
    public void handleCookie(){
        try{
            Thread.sleep(3000);
            WebElement cookies = webdriver.findElement(COOKIE);
            cookies.click();
        }

        catch(Exception e){
            e.printStackTrace();
        }
    }
}
