package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class LoginPage {
    private WebDriver driver;
    private By userNameTxt =  By.name("uid");
    private By passwordTxt = By.name("password");
    private By loginButton = By.name("btnLogin");
    private By resetButton = By.name("btnReset");
    public LoginPage(WebDriver driver) {
        this.driver = driver;
    }

    public NewCustomerPage autoLoginAndNavToNewCustomer(){
        setUserName("mngr399305");
        setPassword("UmezAjE");
        return clickLoginButton().navigateToNewCustomerPage();
    }

    public NewAccountPage autoLoginAndNavToNewAccount(){
        setUserName("mngr399305");
        setPassword("UmezAjE");
        return clickLoginButton().navigateToNewAccountPage();
    }
    public Boolean isPasswordFieldEncrypted(){
        return driver.findElement(passwordTxt).getAttribute("type").equals("password");
    }
    public void setUserName(String userName) {
        driver.findElement(userNameTxt).sendKeys(userName);
    }

    public void clickEnterForm(){
        driver.findElement(userNameTxt).click();
        driver.findElement(userNameTxt).sendKeys(Keys.ENTER);
    }
    public void setPassword(String password) {
        driver.findElement(passwordTxt).sendKeys(password);
    }

    public Boolean checkFieldBlank() {
       if (driver.findElement(userNameTxt).getAttribute("value").isEmpty() && driver.findElement(passwordTxt).getAttribute("value").isEmpty()){
           return true;
       }
       return false;
    }

    public Boolean isFieldFullFill(){
        if (driver.findElements(userNameTxt).size() > 0 == false || driver.findElements(passwordTxt).size() > 0 == false ) {
            return false;
        }
        return true;
    }

    public HomePage clickLoginButton(){
        driver.findElement(loginButton).click();
        return new HomePage(driver);
    }

    public void clickResetButton(){
        driver.findElement(resetButton).click();
    }

    public String getPageTitle(){
        return driver.getTitle();
    }

    public String getAlert(){
        return driver.switchTo().alert().getText();
    }


}
