import io.github.bonigarcia.wdm.WebDriverManager;
import org.junit.Assert;
import org.junit.jupiter.api.*;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;

import java.sql.Driver;
import java.util.Collections;


public class ForumTest {

    WebDriver driver;

    @BeforeEach
    public void Setup() {

        WebDriverManager.chromedriver().setup();
        ChromeOptions options = new ChromeOptions();
        //options.addArguments("--incognito");
        options.addArguments("--disable-notifications"); // visszautasít minden böngésző felkérést pl: értesítések küldése
        options.addArguments("start-maximized"); // teljes képernyőben való használat
        options.setExperimentalOption("useAutomationExtension", true);
        options.setExperimentalOption("excludeSwitches", Collections.singletonList("enable-automation"));
        options.addArguments("--remote-debugging-port=9222");
        driver = new ChromeDriver(options);
        driver.get("https://forum.index.hu/Topic/showTopicList");
        CookiePage cookiepage = new CookiePage(driver);
        cookiepage.handleCookie();
        Settings.driver = driver;
        Privacy_Page.driver = driver;
        Main_page.driver = driver;
        Forum.driver = driver;
    }


//Main_page


    @Test
    @Disabled
    @DisplayName("Regisztrálás az Index fórumra")
    public void Register () {
        Main_page.register();
    }


    @Test
    @DisplayName("Belépés az Index fórumra")
    public void Login_function () {
        Boolean isVisible = Main_page.login();
        Assertions.assertTrue(isVisible);


    }


    @Test
    @DisplayName("Kijelentkezés az Index fórumról")
    public void Logging_out () {
        Main_page.login();
        Main_page.logout();
        Assert.assertEquals("https://kilepes.blog.hu/", driver.getCurrentUrl());
    }


    @Test
    @DisplayName("Bejelentkezési adatok beolvasása fájlból")
    public void Read_from_file () {
        Main_page.fileread();

    }


    @Test
    @DisplayName("Szöveg kinyerése weboldalról és console-ba való kiprintelése")

    public void Print_text_from_main_page () {
        String result = Main_page.getText();
        Assert.assertEquals("Magyarország első és legnagyobb fórum szolgáltatása. A web kettő pre-bétája, amit 1997 óta töltenek meg tartalommal a fórumlakók. Fórumok változatos témákban, hangnemben, moderálva. Ha nem csak megosztani akarsz, hanem diskurálni egy egy témában, csatlakozz Te is, és ha kitartó vagy, társakra találhatsz.", result);
    }



    //Forum
    @Test
    @DisplayName("Fórum keresési találatok kilistázása")
    public void List_information () {
        Boolean isDisplayed = Forum.ListData();
        Assert.assertTrue(isDisplayed);


    }

    @Test
    @DisplayName("Fórum keresési találatokon keresztül történő loopolás")
    public void loop_through_list () {
        int counter= Forum.ListLooping();
        Assertions.assertEquals(9, counter);

    }


    @Test
    @DisplayName("Egyidejűleg több keresési fogalom beolvasása fájlból")
    public void read_multiple_info () {
        boolean isDisplayed= Forum.readfromfile();
        Assert.assertTrue(isDisplayed);

    }


    //Settings

    @Test
    @DisplayName("Profil információk hozzáadása")
    public void add_profile_information () {
        Main_page.login();
        boolean isNull=Settings.Add_data();
        Assert.assertFalse(isNull);

    }


    @Test
    @DisplayName("Profil információk módosítása")
    public void modify_profile_informations () {
        Main_page.login();
        String text= Settings.modify_data();
        Assert.assertEquals("wwww.teszterjózsi.hu", text);
    }


    @Test
    @DisplayName("Profil információk eltávolítása")
    public void remove_information () {
        Main_page.login();
        boolean isEmpty=  Settings.DataRemove();
        Assert.assertTrue(isEmpty);
    }


    @Test
    @DisplayName("Adatvédelmi információk szövegfájlba történő kiírása")
    public void writeprivacytextintodocument () {
        int lines= Privacy_Page.print_Privacy_into_file();
        Assertions.assertEquals(1, lines);


    }


    @AfterEach
    public void Close () {
        driver.close();


    }
}




























