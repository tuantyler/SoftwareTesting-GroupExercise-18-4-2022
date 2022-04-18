package pages;

import org.openqa.selenium.WebDriver;

public class HomePage {
    private WebDriver driver;
    public HomePage(WebDriver driver) {
        this.driver = driver;
    }
    public String getPageTitle(){
        return driver.getTitle();
    }
    public void getBack(){
        driver.navigate().back();
    }
    public NewCustomerPage navigateToNewCustomerPage(){
        driver.navigate().to("https://www.demo.guru99.com/V4/manager/addcustomerpage.php");
        return new NewCustomerPage(driver);
    }
    public NewAccountPage navigateToNewAccountPage(){
        driver.navigate().to("https://www.demo.guru99.com/V4/manager/addAccount.php");
        return new NewAccountPage(driver);
    }
    public String getCurrentURL(){
        return driver.getCurrentUrl();
    }
}
