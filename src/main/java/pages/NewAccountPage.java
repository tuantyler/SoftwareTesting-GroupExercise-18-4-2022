package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class NewAccountPage {
    WebDriver driver;
    private By csmid = By.name("cusid");
    private By inideposit = By.name("inideposit");
    private By resetBtn = By.name("reset");
    private By initDeposit = By.name("inideposit");
    public NewAccountPage(WebDriver driver){
        this.driver = driver;
    }
    public void fillAll(){
        driver.findElement(csmid).sendKeys("Phan Tuan");
        driver.findElement(inideposit).sendKeys("07112001");
    }

    public Boolean isElemBlank(){
        if (!driver.findElements(csmid).isEmpty()) return false;
        if (!driver.findElements(inideposit).isEmpty()) return false;
        return true;
    }

    public void clickReset(){
        driver.findElement(resetBtn).click();
    }

    public Boolean checkValidationOfInitDeposit_Num(){
        driver.findElement(initDeposit).sendKeys("a123");
        if (driver.findElement(By.id("message19")).getAttribute("value").equals("Characters are not allowed")) return true;
        return false;
    }
    public Boolean checkValidationOfCustomerID_Num(){
        driver.findElement(csmid).sendKeys("a123");
        if (driver.findElement(By.id("message14")).getAttribute("value").equals("Characters are not allowed")) return true;
        return false;
    }
}
