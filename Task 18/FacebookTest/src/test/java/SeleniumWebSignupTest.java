import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.AfterTest;
import org.testng.annotations.Test;

public class SeleniumWebSignupTest {

    private WebDriver driver;

    @Test
    public void start() throws InterruptedException {
        //locate chromedriver
        System.setProperty("webdriver.chrome.driver","resources/chromedriver");
        //open chrome
        driver = new ChromeDriver();
        //input url
        driver.get("https://selenium-blog.herokuapp.com");
        //make it load a bit
        Thread.sleep(10000);
        //max chrome
        driver.manage().window().maximize();
        //click signup
        driver.findElement(By.xpath("/html/body/div[2]/div/a[2]")).click();
        //username
        driver.findElement(By.id("user_username")).sendKeys("mahms");
        //email
        driver.findElement(By.id("user_email")).sendKeys("mahms@mailinator.com");
        //password
        driver.findElement(By.id("user_password")).sendKeys("admin");
        //submit
        driver.findElement(By.id("submit")).click();
        //make it load a bit
        Thread.sleep(10000);
        //click user
        driver.findElement(By.xpath("/html/body/div[2]/div[1]/ul/div/div/li[1]/a")).click();
        //click article
        driver.findElement(By.xpath("/html/body/div[2]/div/div/div/div[1]/a")).click();
        //logout
        driver.findElement(By.xpath("//*[@id=\"bs-example-navbar-collapse-1\"]/ul/li[3]/a")).click();
    }
    @AfterTest
        public void closeBrowser(){
            //close browser
            driver.quit();
        }
}
