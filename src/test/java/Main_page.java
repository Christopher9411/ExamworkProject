import org.junit.Assert;
import org.junit.jupiter.api.Assertions;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import static org.openqa.selenium.By.*;

public class Main_page {
    static WebDriver driver = Util.getDriver();
    // private static final By PAYEE_FIRSTNAME = xpath("//*[contains(@id,'customer.firstName')]");
    //Login function
    private static final By EMAIL_ADRESS = xpath("//*[@class=\"indpl_text indpl_email\"]");
    private static final By PASSWORD = xpath("//*[@class=\"indpl_text indpl_passwd\"]");
    private static final By LOGIN_BUTTON = xpath("//*[contains(@class,'indpl_submit')]");
    private static final By LOGOUT_BUTTON = cssSelector(".ahigh");


    //REGISTRATION
    private static final By REGISTRATION_EMAIL_ADRESS = xpath("//input[@id='nick']");
    private static final By REGISTRATION_PASSWORD = xpath("passwd");
    private static final By REGISTRATION_PASSWORD_AGAIN = id("passwd2");
    private static final By NICKNAME = id("forum_nick");
    private static final By WEBPAGE = id("forum_url");
    private static final By REGISTRATION_CONFIRM = xpath("//*[@id=\"regsubmit\"]");
    private static final By TERMS_OF_SERVICE_CHECKBOX = cssSelector(".input--checkbox__checkbox");
    private static final By CAPTCHA_BOX = xpath("//*[@class='recaptcha-checkbox-border']");


    public static void register() {
        WebElement registration_button = driver.findElement(By.xpath("//*[@class='indpl_reg_button']"));
        registration_button.click();
        WebElement email_adress = driver.findElement(By.xpath("//input[@id='nick']"));
        email_adress.sendKeys("nagy.kristof1994@gmail.com");
        WebElement password_field = driver.findElement(By.id("passwd"));
        password_field.sendKeys("teszt123");
        WebElement password_again = driver.findElement(By.id("passwd2"));
        password_again.sendKeys("teszt123");
        WebElement nickname = driver.findElement(By.id("forum_nick"));
        nickname.sendKeys("Teszter Józsi");
        WebElement webpage = driver.findElement(By.id("forum_url"));
        webpage.sendKeys("http//1234.hu");
        WebElement terms_of_service = driver.findElement((TERMS_OF_SERVICE_CHECKBOX));
        terms_of_service.click();



    }


    public static void login() {
        WebElement email = driver.findElement(EMAIL_ADRESS);
        email.sendKeys("nagy.kristof1994@gmail.com");
        WebElement password = driver.findElement(PASSWORD);
        password.sendKeys("teszt123");
        WebElement login_button = driver.findElement((LOGIN_BUTTON));
        login_button.click();
        WebDriverWait wait = new WebDriverWait(driver, 30);
        wait.until(ExpectedConditions.visibilityOfElementLocated(By.cssSelector(".ahigh")));
        WebElement logout_button = driver.findElement(LOGOUT_BUTTON);
        Assert.assertTrue(logout_button.isDisplayed());

    }


    public static void logout() {
        WebElement logout = driver.findElement((LOGOUT_BUTTON));
        logout.click();
        Assert.assertEquals("https://kilepes.blog.hu/", "https://kilepes.blog.hu/");
    }


    public static void fileread() {
        FileUtil utils = new FileUtil();
        String[] credential = utils.readCredential();
        WebElement email_adress = driver.findElement(EMAIL_ADRESS);
        email_adress.sendKeys(credential[0]);
        WebElement password = driver.findElement(PASSWORD);
        password.sendKeys(credential[1]);
        WebElement login_button = driver.findElement((LOGIN_BUTTON));
        login_button.click();
        WebElement logout = driver.findElement(LOGOUT_BUTTON);
        Assertions.assertEquals(true, logout.isDisplayed()); //ellenőrzés hogy a kilépési gomb meg van-e jelenítve
        driver.close();
    }


    public static void getText() {
        WebElement text = driver.findElement(cssSelector(".foot-forum > p:nth-child(2)"));
        String website_text = text.getText();
        System.out.println(website_text);
        Assert.assertEquals("Magyarország első és legnagyobb fórum szolgáltatása. A web kettő pre-bétája, amit 1997 óta töltenek meg tartalommal a fórumlakók. Fórumok változatos témákban, hangnemben, moderálva. Ha nem csak megosztani akarsz, hanem diskurálni egy egy témában, csatlakozz Te is, és ha kitartó vagy, társakra találhatsz.", website_text);

    }


}






























