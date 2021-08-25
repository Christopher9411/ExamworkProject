

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.WebDriver;

import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;

import java.util.Collections;
import java.util.HashMap;
import java.util.Map;

public class Util {
    public static WebDriver driver;

    public static WebDriver getDriver() {
        if (driver == null) {
            WebDriverManager.chromedriver().setup();
            ChromeOptions options = new ChromeOptions();
            options.addArguments("--incognito");
            options.addArguments("--disable-notifications"); // visszautasít minden böngésző felkérést pl: értesítések küldése
            options.addArguments("start-maximized"); // teljes képernyőben való használat
            options.setExperimentalOption("useAutomationExtension", true);
            options.setExperimentalOption("excludeSwitches", Collections.singletonList("enable-automation"));
            driver = new ChromeDriver(options);
            driver.get("https://forum.index.hu/Topic/showTopicList");
            driver.manage().deleteAllCookies();

        }

        return driver;
    }
}





