import org.junit.Assert;
import org.junit.jupiter.api.Assertions;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.util.concurrent.TimeUnit;

import static org.junit.Assert.assertTrue;


public class Forum {
    static WebDriver driver = Util.getDriver();

    // private static final By PAYEE_FIRSTNAME = xpath("//*[contains(@id,'customer.firstName')]");
    private static final By SEARCH_FIELD = By.cssSelector(".inp");
    private static final By SEARCH_BUTTON = By.xpath("//*[contains(@class,'btnok')]");

    //Forum pages
   // private static final By PAGE_2 = By.cssSelector("#maintd > form:nth-child(2) > table:nth-child(2) > tbody:nth-child(1) > tr:nth-child(1) > td:nth-child(1) > a:nth-child(2)");
    private static final By PAGE_2 = By.xpath("//*[@id=\"maintd\"]/form[1]/table/tbody/tr/td[1]/a[1]");
    private static final By PAGE_3 = By.xpath("/html/body/div[2]/div/table/tbody/tr[2]/td[2]/form[1]/table/tbody/tr/td[1]/a[4]");
    private static final By PAGE_4 = By.xpath("//*[@id=\"maintd\"]/form[1]/table/tbody/tr/td[1]/a[5]");
    private static final By PAGE_5 = By.xpath("//*[@id=\"maintd\"]/form[1]/table/tbody/tr/td[1]/a[6]");
    private static final By PAGE_6 = By.xpath("//*[@id=\"maintd\"]/form[1]/table/tbody/tr/td[1]/a[7]");
    private static final By PAGE_7 = By.xpath("//*[@id=\"maintd\"]/form[1]/table/tbody/tr/td[1]/a[8]");
    private static final By PAGE_8 = By.xpath("//*[@id=\"maintd\"]/form[1]/table/tbody/tr/td[1]/a[9]");
    private static final By PAGE_9 = By.xpath("//*[@id=\"maintd\"]/form[1]/table/tbody/tr/td[1]/a[10]");
    private static final By FORUM_HEADER= By.xpath(" //*[@id=\"navi\"]/a");
    private static final By NAVIGATION_BAR = By.cssSelector("#naviheader > div:nth-child(1) > div:nth-child(1) > a");
    private static final By NAVIGATION_ARROW =By.xpath("/html/body/div[2]/div/table/tbody/tr[2]/td[2]/form[1]/table/tbody/tr/td[1]/a[12]");




    /*public static void ListData() {
        WebElement search_field = driver.findElement(By.cssSelector(".inp"));
        search_field.sendKeys("autó");
        WebElement search_button = driver.findElement(By.xpath("//*[contains(@class,'btnok')]"));
        search_button.click();
        String topic_listing = driver.getCurrentUrl();
        Assert.assertEquals("https://forum.index.hu/Search/fastSearchTopic", topic_listing);
        //optionally put scrolling down here
    }
*/

    public static void ListData() {
        WebDriverWait waiting = new WebDriverWait(driver, 5);
        waiting.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//*[@class=' css-k8o10q']"))).click();
        WebElement search_field = driver.findElement(SEARCH_FIELD);
        search_field.sendKeys("autó");
        WebElement search_button = driver.findElement(SEARCH_BUTTON);
        search_button.click();
        driver.manage().timeouts().implicitlyWait(4, TimeUnit.SECONDS);
      //  String topic_listing = driver.getCurrentUrl();
        WebDriverWait wait = new WebDriverWait(driver,2);
        wait.until(ExpectedConditions.visibilityOfElementLocated(FORUM_HEADER));
       WebElement search= driver.findElement(FORUM_HEADER);
        //Assert.assertEquals("https://forum.index.hu/Topic/showTopicList", topic_listing);
        Assert.assertTrue(search.isDisplayed());
        //optionally put scrolling down here
    }




    /*public static void ListLooping() {
        WebElement search_field = driver.findElement(By.cssSelector(".inp"));
        search_field.sendKeys("kutya");
        WebElement search_button = driver.findElement(By.cssSelector("#kereso > div > form > input.btnok"));
        search_button.click();
        WebElement page2 = driver.findElement(By.xpath("/html/body/div[2]/div/table/tbody/tr[2]/td[2]/form[1]/table/tbody/tr/td[1]/a[1]"));
        page2.click();
        WebElement page3 = driver.findElement(By.xpath("//*[@id=\"maintd\"]/form[1]/table/tbody/tr/td[1]/a[4]"));
        page3.click();
        WebElement page4 = driver.findElement(By.xpath("//*[@id=\"maintd\"]/form[1]/table/tbody/tr/td[1]/a[5]"));
        page4.click();
        WebElement page5 = driver.findElement(By.xpath("//*[@id=\"maintd\"]/form[1]/table/tbody/tr/td[1]/a[6]"));
        page5.click();
        WebElement page6 = driver.findElement(By.xpath("//*[@id=\"maintd\"]/form[1]/table/tbody/tr/td[1]/a[7]"));
        page6.click();
        WebElement page7 = driver.findElement(By.xpath("//*[@id=\"maintd\"]/form[1]/table/tbody/tr/td[1]/a[8]"));
        page7.click();
        WebElement page8 = driver.findElement(By.xpath("//*[@id=\"maintd\"]/form[1]/table/tbody/tr/td[1]/a[9]"));
        page8.click();
        WebElement page9 = driver.findElement(By.xpath("//*[@id=\"maintd\"]/form[1]/table/tbody/tr/td[1]/a[10]"));
        page9.click();
        String Website_link = driver.getCurrentUrl();
        Assert.assertEquals("https://forum.index.hu/Search/showTopicResult?tr_start=240&tr_step=30&o=10&tq_text=kutya&tq_in=1&tq_act=&tq_cre=0&tq_user=", Website_link);
        driver.close();


    }

     */


    public static void ListLooping() {
        WebDriverWait waiting = new WebDriverWait(driver, 5);
        waiting.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//*[@class=' css-k8o10q']"))).click();
        WebElement search_field = driver.findElement((SEARCH_FIELD));
        search_field.sendKeys("kutya");
        WebElement search_button = driver.findElement((SEARCH_BUTTON));
        search_button.click();
        WebDriverWait wait = new WebDriverWait(driver, 5);
        wait.until(ExpectedConditions.visibilityOfElementLocated(PAGE_2)).click();
        WebDriverWait rest = new WebDriverWait(driver, 5);
        rest.until(ExpectedConditions.visibilityOfElementLocated(PAGE_3)).click();
        WebDriverWait sleep = new WebDriverWait(driver, 7);
        rest.until(ExpectedConditions.visibilityOfElementLocated(PAGE_4)).click();
        WebDriverWait sleep2 = new WebDriverWait(driver, 7);
        sleep2.until(ExpectedConditions.visibilityOfElementLocated(PAGE_5)).click();
        WebDriverWait sleep3 = new WebDriverWait(driver, 7);
        sleep3.until(ExpectedConditions.visibilityOfElementLocated(PAGE_6)).click();
        WebDriverWait sleep4 = new WebDriverWait(driver, 7);
        sleep4.until(ExpectedConditions.visibilityOfElementLocated(PAGE_7)).click();
        WebDriverWait sleep5 = new WebDriverWait(driver, 5);
        sleep5.until(ExpectedConditions.visibilityOfElementLocated(PAGE_8)).click();
        WebDriverWait sleep6 = new WebDriverWait(driver, 5);
        sleep5.until(ExpectedConditions.visibilityOfElementLocated(PAGE_9)).click();
        WebElement navigation_bar = driver.findElement(By.xpath("/html/body/div[2]/div/table/tbody/tr[2]/td[2]/form[1]/table/tbody/tr/td[1]/a[10]"));
        String Website_link = driver.getCurrentUrl();
        Assert.assertEquals("https://forum.index.hu/Search/showTopicResult?tr_start=240&tr_step=30&o=10&tq_text=kutya&tq_in=1&tq_act=&tq_cre=0&tq_user=", Website_link);
        driver.close();
    }




















    public static void readfromfile() {
        FileUtil2 utils = new FileUtil2();
        String credential = utils.readCredential();
        WebDriverWait waiting = new WebDriverWait(driver, 5);
        waiting.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//*[@class=' css-k8o10q']"))).click();
        WebElement search_field = driver.findElement(SEARCH_FIELD);
        search_field.sendKeys(credential);
        WebElement search_button = driver.findElement(SEARCH_BUTTON);
        search_button.click();
        WebElement navigation =driver.findElement(NAVIGATION_BAR);
        Assert.assertTrue(navigation.isDisplayed());


    }








}








