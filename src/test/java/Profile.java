import org.junit.Assert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.util.concurrent.TimeUnit;

public class Profile {
    static WebDriver driver = Util.getDriver();
    //  private static final By SEARCH_FIELD = By.cssSelector(".inp");
    private static final By SETTINGS = By.cssSelector(".boxbold > li:nth-child(3)");
    private static final By ABOUT_ME = By.cssSelector("tr.mainsettings:nth-child(7) > td:nth-child(2) > textarea:nth-child(1)");
    private static final By SEARCH_FIELD = By.cssSelector(".inp");
    private static final By SEARCH_BUTTON = By.xpath("//*[contains(@class,'btnok')]");
    private static final By WEBSITE = By.xpath("//*[contains(@name,'homepage')]");
    private static final By WEBSITE_FIELD = By.xpath("//*[@id=\"usersettings\"]/tbody/tr[6]/td[2]/input");
    private static final By TERMS_OF_SERVICE = By.xpath("//*[@id=\"chk_policy\"]");
    private static final By CONFIRM_CHANGES = By.cssSelector(("#btn_settings_ok"));


    public static void Add_data() {
        WebElement settings = driver.findElement(SETTINGS);
        settings.click();
        WebDriverWait wait = new WebDriverWait(driver, 5);
        wait.until(ExpectedConditions.visibilityOfElementLocated(ABOUT_ME));
        WebElement about_me_field = driver.findElement(ABOUT_ME);
        about_me_field.clear();
        about_me_field.sendKeys("Ez egy tesztfiók amely Chromedriveres automata tesztelésre lett létrehozva.");
        WebElement terms_of_service = driver.findElement(TERMS_OF_SERVICE);
        terms_of_service.click();
        WebDriverWait waiting = new WebDriverWait(driver, 10);
        waiting.until(ExpectedConditions.visibilityOfElementLocated((CONFIRM_CHANGES))).click();
        Assert.assertNotNull(about_me_field);
    }





  /*  public static void DataRemove() {
            By byElement = By.cssSelector("td.histe_subject:nth-child(1)");
            WebDriverWait wait = new WebDriverWait(driver, 30);
            wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//a[@href='/User/UserSettings']"))).click();
            driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
            WebElement about_me = driver.findElement(By.xpath("//*[@name='introduction']"));
            about_me.click();
            about_me.clear();
            Terms_of_ServiceMethod.TermsOfService();
            String about_me_field = driver.findElement(By.xpath("//*[@name='introduction']")).getText();
            Assert.assertTrue(about_me_field.isEmpty());
        }

*/

    public static void DataRemove() {
        By byElement = By.cssSelector("td.histe_subject:nth-child(1)");
        WebDriverWait wait = new WebDriverWait(driver, 30);
        wait.until(ExpectedConditions.visibilityOfElementLocated((SETTINGS))).click();
        driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
        WebElement about_me = driver.findElement((ABOUT_ME));
        about_me.click();
        about_me.clear();
        WebElement terms_of_service = driver.findElement((TERMS_OF_SERVICE));
        terms_of_service.click();
        WebDriverWait waiting = new WebDriverWait(driver, 10);
        waiting.until(ExpectedConditions.visibilityOfElementLocated((CONFIRM_CHANGES))).click();
        String about_me_field = driver.findElement((ABOUT_ME)).getText();
        Assert.assertTrue(about_me_field.isEmpty());
    }








    /*public void modify_data () {
            WebElement settings = driver.findElement(SETTINGS);
            settings.click();
            WebElement website = driver.findElement(By.xpath("//*[contains(@name,'homepage')]"));
            website.clear();
            website.sendKeys("wwww.teszterjózsi.hu");
            Terms_of_ServiceMethod.TermsOfService();
            String text = driver.findElement(By.xpath("//*[@id=\"usersettings\"]/tbody/tr[6]/td[2]/input")).getAttribute("value");
            WebDriverWait waiting = new WebDriverWait(driver, 10);
            Assert.assertEquals("wwww.teszterjózsi.hu", text);
            driver.close();

        }
    }
*/


    public static void modify_data() {
        WebElement settings = driver.findElement(SETTINGS);
        settings.click();
        WebDriverWait waiting = new WebDriverWait(driver, 10);
        waiting.until(ExpectedConditions.visibilityOfElementLocated(WEBSITE));
        WebElement website = driver.findElement((WEBSITE));
        website.clear();
        website.sendKeys("wwww.teszterjózsi.hu");
        WebElement terms_of_service = driver.findElement(TERMS_OF_SERVICE);
        terms_of_service.click();
        WebDriverWait wait= new WebDriverWait(driver, 10);
        waiting.until(ExpectedConditions.visibilityOfElementLocated((CONFIRM_CHANGES))).click();
        String text = driver.findElement((WEBSITE_FIELD)).getAttribute("value");
        Assert.assertEquals("wwww.teszterjózsi.hu", text);
        driver.close();

    }


   /* @Test
    public static void modify_informations() {
        LoginMethod.login();
        WebElement settings = driver.findElement(By.cssSelector(".boxbold > li:nth-child(3)"));
        settings.click();
        WebElement website = driver.findElement(By.xpath("//*[contains(@name,'homepage')]"));
        website.clear();
        website.sendKeys("wwww.teszterjózsi.hu");
        Terms_of_ServiceMethod.TermsOfService();
        String text = driver.findElement(By.xpath("//*[@id=\"usersettings\"]/tbody/tr[6]/td[2]/input")).getAttribute("value");
        WebDriverWait waiting = new WebDriverWait(driver, 10);
        Assertions.assertEquals("wwww.teszterjózsi.hu", text);
        driver.close();
    }
*/


}








