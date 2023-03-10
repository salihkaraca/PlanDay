import utilities.Webdriver;
import org.openqa.selenium.*;
import org.testng.Assert;
import org.testng.annotations.*;
import java.util.*;
import java.util.concurrent.TimeUnit;

public class planDay_Test {

    WebDriver driver;

    @BeforeMethod
    public void setUpMethod() {
        driver = Webdriver.getDriver("chrome");
        driver.manage().timeouts().implicitlyWait(20, TimeUnit.SECONDS);
        driver.manage().timeouts().pageLoadTimeout(20, TimeUnit.SECONDS);

    }

    @AfterMethod
    public void afterMethod() throws InterruptedException {
        Thread.sleep(2000);
        driver.quit();

    }

    @Test
    public void Planday_test_1() {

        driver.get("https://test1234.planday.com/");

        String title = driver.getTitle();

        System.out.println("title = " + title);

        Assert.assertEquals(title,"Planday");

        WebElement cookie = driver.findElement(By.id("cookie-consent-button"));

        cookie.click();

        WebElement Loginbutton = driver.findElement(By.id("MainLoginButton"));

        WebElement Username = driver.findElement(By.id("Username"));

        WebElement Password = driver.findElement(By.id("Password"));

        Assert.assertTrue(Loginbutton.isDisplayed(),"verify Login button input displayed");
        Assert.assertTrue(Username.isDisplayed(),"verify username input displayed");
        Assert.assertTrue(Password.isDisplayed(),"verify Password input displayed");

        Username.sendKeys("test@gmail.com");
        Password.sendKeys("abc123");

        Loginbutton.click();

        WebElement alert = driver.findElement(By.id("Username-validation-error"));
        Assert.assertTrue(alert.isDisplayed(),"Verify the proper error messages are shown");

    }

    @Test
    public void Planday_test_2() throws InterruptedException {

        driver.get("https://test1234.planday.com/");

        WebElement cookie = driver.findElement(By.id("cookie-consent-button"));

        cookie.click();

        WebElement Loginbutton = driver.findElement(By.id("MainLoginButton"));

        WebElement Username = driver.findElement(By.id("Username"));

        WebElement Password = driver.findElement(By.id("Password"));

        Assert.assertTrue(Loginbutton.isDisplayed(),"verify Login button input displayed");
        Assert.assertTrue(Username.isDisplayed(),"verify username input displayed");
        Assert.assertTrue(Password.isDisplayed(),"verify Password input displayed");

        Username.sendKeys("plandayqa@outlook.com");
        Password.sendKeys("APItesting21");

        Loginbutton.click();

        Thread.sleep(7000);

        WebElement scheduleBar = driver.findElement(By.xpath("//*[@id=\"root\"]/div/header/nav[1]/ul/li[2]/a"));

        scheduleBar.click();

        String currentUrl = driver.getCurrentUrl();
        System.out.println("currentUrl = " + currentUrl);

        boolean pageTitle = currentUrl.contains("/page/");

        Assert.assertTrue(pageTitle,"schedule/page/");

    }

    @Test
    public void Planday_test_3() {

        driver.get("https://test1234.planday.com/");

        WebElement cookie = driver.findElement(By.id("cookie-consent-button"));

        cookie.click();

        WebElement Loginbutton = driver.findElement(By.id("MainLoginButton"));

        WebElement Username = driver.findElement(By.id("Username"));

        WebElement Password = driver.findElement(By.id("Password"));

        Assert.assertTrue(Loginbutton.isDisplayed(),"verify Login button input displayed");
        Assert.assertTrue(Username.isDisplayed(),"verify username input displayed");
        Assert.assertTrue(Password.isDisplayed(),"verify Password input displayed");

        Username.sendKeys("plandayqa@outlook.com");
        Password.sendKeys("APItesting21");

        Loginbutton.click();

        WebElement scheduleBar = driver.findElement(By.xpath("//*[@id=\"root\"]/div/header/nav[1]/ul/li[2]/a"));

        scheduleBar.click();

        WebElement iframeElement = driver.findElement(By.xpath("//iframe[@title='Page content']"));

        driver.switchTo().frame(iframeElement);

        List<WebElement> headers = driver.findElements(By.xpath("(//div[@class='board-header__cell board-header__cell--edit'])"));

        Assert.assertEquals(headers.size(),7,"verify that 7 day is displayed.");
        System.out.println("headers.size() = " + headers.size());

        for (WebElement header : headers) {
            System.out.println(header.getText());
        }

    }

    @Test
    public void Planday_test_4() {

        driver.get("https://test1234.planday.com/");

        WebElement cookie = driver.findElement(By.id("cookie-consent-button"));

        cookie.click();

        WebElement Loginbutton = driver.findElement(By.id("MainLoginButton"));

        WebElement Username = driver.findElement(By.id("Username"));

        WebElement Password = driver.findElement(By.id("Password"));

        Assert.assertTrue(Loginbutton.isDisplayed(),"verify Login button input displayed");
        Assert.assertTrue(Username.isDisplayed(),"verify username input displayed");
        Assert.assertTrue(Password.isDisplayed(),"verify Password input displayed");

        Username.sendKeys("plandayqa@outlook.com");
        Password.sendKeys("APItesting21");

        Loginbutton.click();

        WebElement scheduleBar = driver.findElement(By.xpath("//*[@id=\"root\"]/div/header/nav[1]/ul/li[2]/a"));

        scheduleBar.click();

        WebElement iframeElement = driver.findElement(By.xpath("//iframe[@title='Page content']"));

        driver.switchTo().frame(iframeElement);

        List<WebElement> headers = driver.findElements(By.className("row-header3__text__title"));

        Assert.assertEquals(headers.size(),4,"Verify that Table has 4 row and 3 employee.");

        for (WebElement header : headers) {
            System.out.println(header.getText());
        }

    }

    @Test
    public void Planday_test_5() throws InterruptedException {

        driver.get("https://test1234.planday.com/");

        WebElement cookie = driver.findElement(By.id("cookie-consent-button"));

        cookie.click();

        WebElement Loginbutton = driver.findElement(By.id("MainLoginButton"));

        WebElement Username = driver.findElement(By.id("Username"));

        WebElement Password = driver.findElement(By.id("Password"));

        Assert.assertTrue(Loginbutton.isDisplayed(),"verify Login button input displayed");
        Assert.assertTrue(Username.isDisplayed(),"verify username input displayed");
        Assert.assertTrue(Password.isDisplayed(),"verify Password input displayed");

        Username.sendKeys("plandayqa@outlook.com");
        Password.sendKeys("APItesting21");

        Loginbutton.click();

        WebElement scheduleBar = driver.findElement(By.xpath("//*[@id=\"root\"]/div/header/nav[1]/ul/li[2]/a"));

        scheduleBar.click();

        WebElement iframeElement = driver.findElement(By.xpath("//iframe[@title='Page content']"));

        driver.switchTo().frame(iframeElement);

        WebElement todayCell = driver.findElement(By.cssSelector("div[aria-label='10 March 2023 Employee One']"));

        todayCell.click();

        WebElement fromCell = driver.findElement(By.cssSelector("input[placeholder='From']"));

        WebElement toCell = driver.findElement(By.cssSelector("input[placeholder='To']"));

        fromCell.sendKeys("09.00");
        toCell.sendKeys("17.00");

        WebElement createButton = driver.findElement(By.xpath("//ul[@class='edit-shift-modal__footer-buttons-wrapper']//button[@class='styled__StyledButton-sc-ygpd71-0 styled__PrimaryButton-sc-ygpd71-1 hDziTz']"));

        createButton.click();

        Thread.sleep(2000);

        WebElement shift = driver.findElement(By.xpath("(//div[@class='shift-tile__inner'])[1]"));

        Assert.assertTrue(shift.isDisplayed());

    }
}
