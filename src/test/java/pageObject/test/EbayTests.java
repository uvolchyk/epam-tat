package pageObject.test;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.testng.Assert;
import org.testng.annotations.*;
import pageObject.page.EbayEnglishHomePage;

public class EbayTests {

    private WebDriver driver;

    @BeforeMethod
    public void setUp() {
        WebDriverManager.chromedriver().setup();
        ChromeOptions options = new ChromeOptions();
        options.addArguments("--no-sandbox");
        options.addArguments("--disable-dev-shm-usage");
        options.addArguments("--headless");
        driver = new ChromeDriver(options);
        driver.manage().window().maximize();
    }

    @Test
    public void searchForNonExistingPosition() {
        String evaluatedTitle = new EbayEnglishHomePage(driver)
                .openPage()
                .searchForTerm("dfsfhjdkalfkdnglf#$!@)(_!")
                .searchResultsTitle();
        String expectedContainment = "No exact matches found";
        Assert.assertTrue(evaluatedTitle.contains(expectedContainment));
        System.out.println("rock 🤘");
    }

    @AfterMethod
    public void tearDown() {
        driver.quit();
        driver = null;
    }
}
