import org.testng.annotations.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import io.github.bonigarcia.wdm.WebDriverManager;
//import org.openqa.selenium.support.ui.Select;

public class KongaTest {
    
    private WebDriver driver;

    @BeforeTest
    public void start() throws InterruptedException {
        //locate chromedriver
        System.setProperty("webdriver.chrome.driver","resources/chromedriver.exe");
        //open chrome
        ChromeOptions option = new ChromeOptions();
        option.addArguments("--remote-allow-origins=*");
        WebDriverManager.chromedriver().setup();
        driver = new ChromeDriver(option);
        //open url
        driver.get("https://www.konga.com");
        driver.manage().window().maximize();
        Thread.sleep(10000);
    }

     @Test (priority = 0)
    public void signIn() throws InterruptedException{
        //click login / signup
        driver.findElement(By.xpath("/html/body/div[1]/div/section/div[3]/nav/div[2]/div[1]/div/div/div[4]")).click();
        //input username
        driver.findElement(By.xpath("/html/body/div[1]/div/section/div[4]/section/section/aside/div[2]/div/form/div[1]/input")).sendKeys("");
        //input password
        driver.findElement(By.xpath("/html/body/div[1]/div/section/div[4]/section/section/aside/div[2]/div/form/div[2]/input")).sendKeys("");
        Thread.sleep(5000);
        //click login
        driver.findElement(By.xpath("/html/body/div[1]/div/section/div[4]/section/section/aside/div[2]/div/form/div[3]")).click();
        Thread.sleep(10000);
    }

    @Test (priority = 1)
    public void categories() throws InterruptedException{
        //select computers and accessories
        driver.findElement(By.xpath("/html/body/div[1]/div/section/div[3]/nav/div[2]/div[2]/div/a[2]")).click();
        Thread.sleep(5000);
        //select laptops
        driver.findElement(By.xpath("/html/body/div[1]/div/section/div[3]/section/main/section[3]/section/div/section/div[2]/div[2]/ul/li[3]")).click();
        Thread.sleep(5000);
        //tick apple macbooks
        driver.findElement(By.xpath("/html/body/div[1]/div/section/div[3]/section/main/section[3]/section/div/section/div[2]/div[2]/ul/li[3]/a/ul/li[1]")).click();
        Thread.sleep(5000);
    }

    @Test (priority = 2)
    public void cart() throws InterruptedException{
        //add macbook to cart
        driver.findElement(By.xpath("/html/body/div[1]/div/section/div[3]/section/main/section[3]/section/section/section/section/ul/li[1]/div/div/div[2]/form/div[3]")).click();
        Thread.sleep(5000);
        //go to cart
        driver.findElement(By.xpath("/html/body/div[1]/div/section/div[2]/nav/div[2]/div[1]/div/div/a[2]")).click();
        Thread.sleep(5000);
        //checkout
        driver.findElement(By.xpath("/html/body/div[1]/div/section/div[3]/section/section/aside/div[3]/div/div[2]")).click();
    }

    @Test (priority = 3)
    public void addAddress() throws InterruptedException{
        //add address
        //random window pops out to add number, so i wrote this code to close the window
        Thread.sleep(5000);
        driver.findElement(By.xpath("/html/body/div[1]/div/section/div[2]/section/section/aside/div[1]/div/a")).click();
        //now add address
        Thread.sleep(5000);
        //button to add address
        driver.findElement(By.xpath("/html/body/div[1]/div/section/div[2]/section/main/div/form/div/div[1]/section[1]/div/div/div[2]/div[1]/div[2]/div[1]/div/button")).click();
        Thread.sleep(5000);
        //first name
        driver.findElement(By.xpath("/html/body/div[1]/div/section/div[2]/section/section/aside/div[2]/div/div/form/div[1]/div[1]/input")).sendKeys("");
        //last name
        driver.findElement(By.xpath("/html/body/div[1]/div/section/div[2]/section/section/aside/div[2]/div/div/form/div[1]/div[2]/input")).sendKeys("");
        //phone number
        driver.findElement(By.xpath("/html/body/div[1]/div/section/div[2]/section/section/aside/div[2]/div/div/form/div[2]/input")).sendKeys("");
        //house address
        driver.findElement(By.xpath("/html/body/div[1]/div/section/div[2]/section/section/aside/div[2]/div/div/form/div[3]/input")).sendKeys("");
        driver.findElement(By.xpath("/html/body/div[1]/div/section/div[2]/section/section/aside/div[2]/div/div/form/div[5]/input")).sendKeys("");
        //city
        Select city = new Select(driver.findElement(By.xpath("/html/body/div[1]/div/section/div[2]/section/section/aside/div[2]/div/div/form/div[6]/div/div/select")));
        city.selectByIndex(2);
        Thread.sleep(500);
        //lga
        Select lga = new Select(driver.findElement(By.xpath("/html/body/div[1]/div/section/div[2]/section/section/aside/div[2]/div/div/form/div[7]/div/div/select")));
        lga.selectByIndex(1);
        Thread.sleep(5000);
        //continue
        driver.findElement(By.xpath("/html/body/div[1]/div/section/div[2]/section/section/aside/div[2]/div/div/form/div[8]/div[1]/button")).click();
        Thread.sleep(5000);
        //save address
        driver.findElement(By.xpath("/html/body/div[1]/div/section/div[2]/section/section/aside/div[2]/div/div/div[2]/div/form/button")).click();
        Thread.sleep(5000);
        //use this address
        driver.findElement(By.xpath("/html/body/div[1]/div/section/div[2]/section/section/aside/div[3]/div/div/div/a")).click();
        Thread.sleep(5000);
    }
    
    @Test (priority = 4)
    public void checkout() throws InterruptedException{
        //pay
        driver.findElement(By.xpath("/html/body/div[1]/div/section/div[2]/section/main/div/form/div/div[1]/section[2]/div/div[2]/div[1]/div[1]/span")).click();
        Thread.sleep(5000);
        driver.findElement(By.xpath("/html/body/div[1]/div/section/div[2]/section/main/div/form/div/div[1]/section[2]/div/div[2]/div[3]/div[2]/div/button")).click();
        Thread.sleep(5000);
    }

    @Test (priority = 5)
    public void switchIframe() throws InterruptedException{
        //switch iframe
        WebElement iframe = driver.findElement(By.id("kpg-frame-component"));
        driver.switchTo().frame(iframe);
        driver.findElement(By.xpath("/html/body/section/section/section/div[2]/div[3]/div[1]/div[2]/div/div[2]/button")).click();
        Thread.sleep(5000);
        //add invalid card details
        driver.findElement(By.id("card-number")).sendKeys("4345 3434 5344 6244");
        driver.findElement(By.id("expiry")).sendKeys("0429");
        driver.findElement(By.id("cvv")).sendKeys("336");
        Thread.sleep(5000);
        //pay
        driver.findElement(By.id("validateCardForm")).click();
        //driver.findElement(By.id("card-pin-new")).sendKeys("1234");
        Thread.sleep(5000);
    }

    @Test (priority = 6)
    public void errorMessage() throws InterruptedException{
        //very error message
        String actualError = driver.findElement(By.xpath("/html/body/section/section/section/div[2]/div[3]/div/form[1]/div[2]/div[1]/div[1]/div[2]/label")).getText();
        String expectedError = "Invalid card number";
        Assert.assertEquals(actualError, expectedError);
        System.out.println(expectedError);
        Thread.sleep(5000);
    }

    @Test (priority = 7)
    public void closeIframe() throws InterruptedException{
        //close iframe
        driver.findElement(By.xpath("/html/body/section/section/section/div[2]/div[1]/aside")).click();
        driver.switchTo().defaultContent();
        Thread.sleep(5000);
    }

    @AfterTest
    public void closeBrowser(){
        //close browser
        driver.quit();
    }
}

