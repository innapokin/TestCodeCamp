import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

public class SeleniumWebSignupTest {

    private WebDriver driver;

    @BeforeTest
    public void start() throws InterruptedException {
        //locate chromedriver
        System.setProperty("webdriver.chrome.driver","resources/chromedriver");
        //open chrome
        //driver = new ChromeDriver();
        ChromeOptions option = new ChromeOptions();
        option.addArguments("--remote-allow-origins=*");
        WebDriverManager.chromedriver().setup();
        driver = new ChromeDriver(option);
        //input url
        driver.get("https://selenium-blog.herokuapp.com");
        //test 1
        if (driver.getCurrentUrl().contains("https://selenium-blog.herokuapp.com"))
            //pass
            System.out.println("Correct Webpage");
        else 
            System.out.println("Wrong Webpage");
        //make it load a bit
        Thread.sleep(5000);
        //max chrome
        driver.manage().window().maximize();
        //click signup
        driver.findElement(By.xpath("/html/body/div[2]/div/a[2]")).click();
        Thread.sleep(5000);
    }

    @Test (priority = 0)
    public void negativeSignup() throws InterruptedException{
        //test 3 = verify username is not less than 3 characters
        //username
        driver.findElement(By.id("user_username")).sendKeys("s1");
        //email
        driver.findElement(By.id("user_email")).sendKeys("mahms@mailinator.com");
        //password
        driver.findElement(By.id("user_password")).sendKeys("admin");
        //submit
        driver.findElement(By.id("submit")).click();
        //make it load a bit
        Thread.sleep(5000);
    }

    @Test (priority = 1)
    public void positiveSignup() throws InterruptedException{
        //username
        driver.findElement(By.id("user_username")).clear();
        driver.findElement(By.id("user_username")).sendKeys("mahms231");
        //email
        driver.findElement(By.id("user_email")).clear();
        driver.findElement(By.id("user_email")).sendKeys("mahms231@mailinator.com");
        //password
        driver.findElement(By.id("user_password")).clear();
        driver.findElement(By.id("user_password")).sendKeys("admin");
        //submit
        driver.findElement(By.id("submit")).click();
        //make it load a bit
        Thread.sleep(5000);
    }
    
    @Test (priority = 2)
    public void clickUserItem() throws InterruptedException {
        //click user
        driver.findElement(By.xpath("/html/body/div[2]/div[1]/ul/div/div/li[1]/a")).click();
        //test 2 = verify signup page is clicked on
        if (driver.getCurrentUrl().contains("https://selenium-blog.herokuapp.com/signup"))
            //pass
            System.out.println("Correct Webpage");
        else 
            System.out.println("Wrong Webpage");
        Thread.sleep(5000);
    }

    @Test (priority = 3)
    public void verifyItem() throws InterruptedException {
        //click article
        driver.findElement(By.xpath("/html/body/div[2]/div/div/div/div[1]/a")).click();
        //test 9 = confirm page url
        if (driver.getCurrentUrl().contains("https://selenium-blog.herokuapp.com/users/1"))
            //pass
            System.out.println("Correct User1 Page");
        else 
            System.out.println("Wrong User1 Page");                
        Thread.sleep(5000);
    }

    @Test (priority = 4)
    public void logoutSuccessfully () {
        //test 10 = verify user logs out and goes to home page
        if (driver.getTitle().contains("Alphablog"))
            //pass
            System.out.println("Correct Title");
        else 
            System.out.println("Wrong Title");
        //logout
        driver.findElement(By.xpath("//*[@id=\"bs-example-navbar-collapse-1\"]/ul/li[3]/a")).click();
    }

    @AfterTest
    public void closeBrowser(){
        //close browser
        driver.quit();
    }
}
