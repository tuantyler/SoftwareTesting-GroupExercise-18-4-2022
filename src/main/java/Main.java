import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.*;

import java.time.Duration;
import java.util.NoSuchElementException;
import java.util.concurrent.TimeUnit;

public class Main {

    public static void main(String[] args) throws InterruptedException {
        System.setProperty("webdriver.chrome.driver", System.getProperty("user.dir") + "\\resources\\chromedriver.exe");
        WebDriver driver = new ChromeDriver();
        driver.navigate().to("https://the-internet.herokuapp.com/login");
        WebElement userNameInput =  driver.findElement(By.id("username"));
//        driver.findElement(By.xpath("//*[@id=\"login\"]/button")).click();

        //Additional Method
        userNameInput.sendKeys(Keys.chord(Keys.SHIFT,"vku"));
        System.out.println("Input Additional Method");
        userNameInput.clear();
        userNameInput.sendKeys("tomsmith");
        driver.findElement(By.id("password")).sendKeys("SuperSecretPassword!");
        System.out.println(userNameInput.getTagName());
        System.out.println(userNameInput.isEnabled());
        System.out.println(userNameInput.isSelected());
        driver.findElement(By.id("login")).submit();

        Thread.sleep(2000);

        driver.navigate().to("https://demoqa.com/automation-practice-form");
        driver.findElement(By.id("firstName")).sendKeys("Tuấn");
        driver.findElement(By.id("lastName")).sendKeys("Phan");
        driver.findElement(By.id("userEmail")).sendKeys("pvqtuan.19it3@vku.udn.vn");
        driver.findElement(By.id("uploadPicture")).sendKeys(System.getProperty("user.dir")+"\\resources\\test.img");

        Thread.sleep(2000);
        //Click radio button
        driver.navigate().to("https://formy-project.herokuapp.com/form");
        driver.findElement(By.xpath("//input[@value='radio-button-1']")).click();
        driver.findElement(By.xpath("//input[@value='checkbox-1']")).click();
        driver.findElement(By.xpath("//input[@value='checkbox-2']")).click();

        Select selectYrOfExp = new Select(driver.findElement(By.id("select-menu")));
        selectYrOfExp.selectByIndex(1);

        driver.findElement(By.id("datepicker")).sendKeys("07/11/2001");

        // WebDriverWait
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(20));
        driver.navigate().to("https://the-internet.herokuapp.com/dynamic_loading/2");
        driver.findElement(By.tagName("button")).click();
        wait.until(ExpectedConditions.visibilityOfElementLocated(By.id("finish")));
        System.out.print("Result after normal Waiting: " + driver.findElement(By.id("finish")).getText());

        driver.navigate().to("https://the-internet.herokuapp.com/dynamic_loading/2");
        driver.findElement(By.tagName("button")).click();
        FluentWait waitFluent = new FluentWait(driver).withTimeout(Duration.ofSeconds(20)).pollingEvery(Duration.ofSeconds(2)).ignoring(NoSuchElementException.class);
        waitFluent.until(ExpectedConditions.visibilityOfElementLocated(By.id("finish")));
        System.out.print("Result after Wating Fluently: " + driver.findElement(By.id("finish")).getText());


    }
}
