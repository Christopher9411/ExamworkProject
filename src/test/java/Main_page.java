import org.junit.jupiter.api.Assertions;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import static org.openqa.selenium.By.*;

public class Main_page {
    static WebDriver driver;
    // private static final By PAYEE_FIRSTNAME = xpath("//*[contains(@id,'customer.firstName')]");
    //Login function
    private static final By EMAIL_ADRESS = xpath("//*[@id=\"indpl_login_box_180\"]/descendant::*[@name=\"username\"]");
    private static final By PASSWORD = xpath("//*[@class=\"indpl_text indpl_passwd\"]");
    private static final By LOGIN_BUTTON = xpath("//*[contains(@class,'indpl_submit')]");
    private static final By LOGOUT_BUTTON = cssSelector(".ahigh");
    private static final By ACCEPT_COOKIES = xpath(" //*[@class=' css-k8o10q']");



    //REGISTRATION
    private static final By REGISTRATION_EMAIL_ADRESS = xpath("//input[@id='nick']");
    private static final By REGISTRATION_PASSWORD = xpath("passwd");
    private static final By REGISTRATION_PASSWORD_AGAIN = id("passwd2");
    private static final By NICKNAME = id("forum_nick");
    private static final By WEBPAGE = id("forum_url");
    private static final By REGISTRATION_CONFIRM = xpath("//*[@id=\"regsubmit\"]");
    private static final By TERMS_OF_SERVICE_CHECKBOX = cssSelector(".input--checkbox__checkbox");
    private static final By CAPTCHA_BOX = xpath("//*[@class='recaptcha-checkbox-border']");
    private static final By CAPTCHA_TICK_BOX = cssSelector(".recaptcha-checkbox-border]");


    public static void register() {
        WebElement cookies_accept = driver.findElement(ACCEPT_COOKIES);
        cookies_accept.click();
        WebElement registration_button = driver.findElement(By.xpath("//*[@class='indpl_reg_button']"));
        registration_button.click();
        WebDriverWait waiting = new WebDriverWait(driver,4);
        waiting.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//*[@class=' css-k8o10q']"))).click();
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
        WebDriverWait wait = new WebDriverWait(driver,5);
        wait.until(ExpectedConditions.visibilityOfElementLocated(CAPTCHA_TICK_BOX));
        WebElement captcha_box = driver.findElement(CAPTCHA_TICK_BOX);
        captcha_box.click();
    }


    public static boolean login() {
        //WebDriverWait waiting = new WebDriverWait(driver, 5);
        // waiting.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//*[@class=' css-k8o10q']"))).click();
        WebDriverWait waiting = new WebDriverWait(driver, 5);
         waiting.until(ExpectedConditions.elementToBeClickable(EMAIL_ADRESS)).sendKeys("nagy.kristof1994@gmail.com");
        WebElement password = driver.findElement(PASSWORD);
        password.sendKeys("teszt123");
        WebElement login_button = driver.findElement((LOGIN_BUTTON));
        login_button.click();
        WebDriverWait wait = new WebDriverWait(driver, 5);
        wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//a[@href='/Rights/logout']")));
        WebElement logout_button = driver.findElement(LOGOUT_BUTTON);
        return logout_button.isDisplayed();


    }


    public static void logout() {
        WebElement logout = driver.findElement((LOGOUT_BUTTON));
        logout.click();
        //  WebElement accept_cookies = driver.findElement(ACCEPT_COOKIES);
        //accept_cookies.click();

    }


    public static void fileread() {
        FileUtil2 utils = new FileUtil2();
        String[] credential = utils.readCredential2();
        //  WebDriverWait waiting = new WebDriverWait(driver, 5);
        //  waiting.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//*[@class=' css-k8o10q']"))).click();
        WebElement email_adress = driver.findElement(EMAIL_ADRESS);
        email_adress.sendKeys(credential[0]);
        WebElement password = driver.findElement(PASSWORD);
        password.sendKeys(credential[1]);
        WebElement login_button = driver.findElement((LOGIN_BUTTON));
        login_button.click();
        WebDriverWait wait = new WebDriverWait(driver, 5);
        wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//a[@href='/Rights/logout']")));
        WebElement logout = driver.findElement(LOGOUT_BUTTON);
        Assertions.assertEquals(true, logout.isDisplayed()); //ellenőrzés hogy a kilépési gomb meg van-e jelenítve
    }


    public static String getText() {

        WebElement text = driver.findElement(cssSelector(".foot-forum > p:nth-child(2)"));
        //  WebDriverWait waiting = new WebDriverWait(driver, 5);
        //   waiting.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//*[@id=\"qc-cmp2-ui\"]/div[2]/div/button[2]")));
        String website_text = text.getText();
        System.out.println(website_text);
        return website_text;


    }


}




























































