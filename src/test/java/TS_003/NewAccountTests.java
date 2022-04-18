package TS_003;

import directory.BaseTests;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import pages.LoginPage;
import pages.NewAccountPage;
import pages.NewCustomerPage;

public class NewAccountTests extends BaseTests {
    @Test
    @DisplayName("TC_033 - Verify that the validation of numeric fields Customer id by entering alphabets and characters")
    public void tc033(){
        NewAccountPage newAccountPage = new LoginPage(driver).autoLoginAndNavToNewAccount();
        Assertions.assertTrue(newAccountPage.checkValidationOfCustomerID_Num());
    }
    @Test
    @DisplayName("TC_034 - Verify that the validation of numeric fields Initial deposit by entering alphabets and characters")
    public void tc034(){
        NewAccountPage newAccountPage = new LoginPage(driver).autoLoginAndNavToNewAccount();
        Assertions.assertTrue(newAccountPage.checkValidationOfInitDeposit_Num());
    }
    @Test
    @DisplayName("TC_035 - Verify that the reset button clears the data from all the text boxes in the New Account form")
    public void tc035(){
        NewAccountPage newAccountPage = new LoginPage(driver).autoLoginAndNavToNewAccount();
        newAccountPage.fillAll();
        newAccountPage.clickReset();
        Assertions.assertTrue(newAccountPage.isElemBlank());
    }
}
