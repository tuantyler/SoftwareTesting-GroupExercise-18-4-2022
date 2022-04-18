package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;

public class NewCustomerPage {
    private WebDriver driver;
    private By customerName = By.name("name");
    private By rad1 = By.name("rad1");
    private By dob = By.name("dob");
    private By address = By.name("addr");
    private By city = By.name("city");
    private By state = By.name("state");
    private By pin = By.name("pinno");
    private By mobileNum = By.name("telephoneno");
    private By email = By.name("emailid");
    private By password = By.name("password");

    private By submitBtn = By.name("sub");
    private By clearBtn = By.name("res");
    public NewCustomerPage(WebDriver driver){
        this.driver = driver;
    }

    public Boolean allElemExisted(){
        if (driver.findElements(customerName).size() <= 0 || driver.findElements(rad1).size() <= 0) return false;
        if (driver.findElements(dob).size() <= 0) return false;
        if (driver.findElements(address).size() <= 0) return false;
        if (driver.findElements(city).size() <= 0) return false;
        if (driver.findElements(state).size() <= 0) return false;
        if (driver.findElements(pin).size() <= 0) return false;
        if (driver.findElements(email).size() <= 0) return false;
        if (driver.findElements(password).size() <= 0) return false;
        return true;
    }

    public void clickClear(){
        driver.findElement(clearBtn).click();
    }
    public Boolean isElemBlank(){
        if (!driver.findElements(customerName).isEmpty()) return false;
        if (!driver.findElements(address).isEmpty()) return false;
        if (!driver.findElements(city).isEmpty()) return false;
        if (!driver.findElements(state).isEmpty()) return false;
        if (!driver.findElements(pin).isEmpty()) return false;
        if (!driver.findElements(email).isEmpty()) return false;
        if (!driver.findElements(password).isEmpty()) return false;
        return true;
    }

    public Boolean checkValidationOfUserNameInput(){
        driver.findElement(customerName).click();
        driver.findElement(By.xpath("//html")).click();
        if (driver.findElement(By.id("message")).getAttribute("style").equals("visibility: visible;")) return true;
        return false;
    }

    public Boolean checkValidationOfMobileNumber(){
        driver.findElement(mobileNum).sendKeys("a123");
        if (driver.findElement(By.id("message7")).getAttribute("value").equals("Characters are not allowed")) return true;
        return false;
    }

    public Boolean checkValidationOfPIN_Char(){
        driver.findElement(mobileNum).sendKeys("a123");
        if (driver.findElement(By.id("message6")).getAttribute("value").equals("Characters are not allowed")) return true;
        return false;
    }
    public Boolean checkValidationOfPIN_Length(){
        driver.findElement(mobileNum).sendKeys("45567");
        if (driver.findElement(By.id("message6")).getAttribute("value").equals("PIN Code must have 6 Digits")) return true;
        return false;
    }
    public Boolean checkValidationOfUserNameInput_Num(){
        driver.findElement(customerName).sendKeys("a123");
        if (driver.findElement(By.id("message")).getAttribute("value").equals("Numbers are not allowed")) return true;
        return false;
    }

    public Boolean checkValidationOfCityInput_Num(){
        driver.findElement(customerName).sendKeys("a123");
        if (driver.findElement(By.id("message4")).getAttribute("value").equals("Numbers are not allowed")) return true;
        return false;
    }
    public Boolean checkValidationOfStateInput_Num(){
        driver.findElement(customerName).sendKeys("a123");
        if (driver.findElement(By.id("message5")).getAttribute("value").equals("Numbers are not allowed")) return true;
        return false;
    }

    public Boolean validateByIncorrectEmail(){
        driver.findElement(customerName).sendKeys("a123");
        if (driver.findElement(By.id("message9")).getAttribute("value").equals("Email-ID is not valid")) return true;
        return false;
    }

    public void clickSubmitButton(){
        driver.findElement(submitBtn).click();
    }
    public void clickEnterForm(){
        driver.findElement(customerName).click();
        driver.findElement(customerName).sendKeys(Keys.ENTER);
    }

    public String getAlert(){
        return driver.switchTo().alert().getText();
    }

    public void fillAll(){
        driver.findElement(customerName).sendKeys("Phan Tuan");
        driver.findElement(dob).sendKeys("07112001");
        driver.findElement(address).sendKeys("KTX VietHan");
        driver.findElement(city).sendKeys("DaNang");
        driver.findElement(state).sendKeys("DaNang");
        driver.findElement(pin).sendKeys("454545");
        driver.findElement(mobileNum).sendKeys("454545");
        driver.findElement(email).sendKeys("454545@gmail.com");
        driver.findElement(password).sendKeys("454545");

    }

    public String getCurrentURL(){
        return driver.getCurrentUrl();
    }

    public Boolean isPasswordFieldEncrypted(){
        return driver.findElement(password).getAttribute("type").equals("password");
    }
}
