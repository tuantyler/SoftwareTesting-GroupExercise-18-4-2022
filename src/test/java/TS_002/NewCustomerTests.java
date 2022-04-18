package TS_002;

import directory.BaseTests;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import pages.LoginPage;
import pages.NewCustomerPage;

public class NewCustomerTests extends BaseTests {
    @Test
    @DisplayName("TC_014 - Verify all login related elements and fields are present on the New Customer page.")
    public void tc014(){
        NewCustomerPage newCustomerPage = new LoginPage(driver).autoLoginAndNavToNewCustomer();
        Assertions.assertTrue(newCustomerPage.allElemExisted());
    }

    @Test
    @DisplayName("TC_015 - Verify that the validation of required fields by not filling any data and submit")
    public void tc015(){
        NewCustomerPage newCustomerPage = new LoginPage(driver).autoLoginAndNavToNewCustomer();
        newCustomerPage.clickSubmitButton();
        Assertions.assertTrue( newCustomerPage.getAlert().equals("please fill all fields"));
    }

    @Test
    @DisplayName("TC_016 - Verify that entering blank spaces on mandatory fields lead to validation error")
    public void tc016(){
        NewCustomerPage newCustomerPage = new LoginPage(driver).autoLoginAndNavToNewCustomer();
        Assertions.assertTrue( newCustomerPage.checkValidationOfUserNameInput());
    }
    @Test
    @DisplayName("TC_017 - Verify that the validation of numeric fields Mobile Number by entering alphabets and characters")
    public void tc017(){
        NewCustomerPage newCustomerPage = new LoginPage(driver).autoLoginAndNavToNewCustomer();
        Assertions.assertTrue( newCustomerPage.checkValidationOfMobileNumber());
    }
    @Test
    @DisplayName("TC_018 - Verify that the validation of numeric fields PIN by entering alphabets and characters")
    public void tc018(){
        NewCustomerPage newCustomerPage = new LoginPage(driver).autoLoginAndNavToNewCustomer();
        Assertions.assertTrue( newCustomerPage.checkValidationOfPIN_Char());
    }
    @Test
    @DisplayName("TC_019 - Verify that the validation of input length the of PIN fields ")
    public void tc019(){
        NewCustomerPage newCustomerPage = new LoginPage(driver).autoLoginAndNavToNewCustomer();
        Assertions.assertTrue( newCustomerPage.checkValidationOfPIN_Length());
    }
    @Test
    @DisplayName("TC_020 - Verify that the validation of non numeric fields Username by entering alphabets, characters and number")
    public void tc020(){
        NewCustomerPage newCustomerPage = new LoginPage(driver).autoLoginAndNavToNewCustomer();
        Assertions.assertTrue( newCustomerPage.checkValidationOfUserNameInput_Num());
    }
    @Test
    @DisplayName("TC_021 - Verify that the validation of non numeric fields City by entering alphabets, characters and number")
    public void tc021(){
        NewCustomerPage newCustomerPage = new LoginPage(driver).autoLoginAndNavToNewCustomer();
        Assertions.assertTrue( newCustomerPage.checkValidationOfCityInput_Num());
    }
    @Test
    @DisplayName("TC_022 - Verify that the validation of non numeric fields State by entering alphabets, characters and number")
    public void tc022(){
        NewCustomerPage newCustomerPage = new LoginPage(driver).autoLoginAndNavToNewCustomer();
        Assertions.assertTrue( newCustomerPage.checkValidationOfStateInput_Num());
    }
    @Test
    @DisplayName("TC_023 - Verify that the validation of email field by entering incorrect email id")
    public void tc023(){
        NewCustomerPage newCustomerPage = new LoginPage(driver).autoLoginAndNavToNewCustomer();
        Assertions.assertTrue( newCustomerPage.validateByIncorrectEmail());
    }
    @Test
    @DisplayName("TC_024 - Verify that clicking on submit button after entering all the mandatory fields without validation errors, submits the data to the server")
    public void tc024(){
        NewCustomerPage newCustomerPage = new LoginPage(driver).autoLoginAndNavToNewCustomer();
        newCustomerPage.fillAll();
        newCustomerPage.clickSubmitButton();
        Assertions.assertTrue(newCustomerPage.getCurrentURL().contains("https://www.demo.guru99.com/V4/manager/CustomerRegMsg.php"));
    }
    @Test
    @DisplayName("TC_025 - Verify that system generates a validation message when entering existing email")
    public void tc025(){
        NewCustomerPage newCustomerPage = new LoginPage(driver).autoLoginAndNavToNewCustomer();
        newCustomerPage.fillAll();
        newCustomerPage.clickSubmitButton();
        Assertions.assertTrue(newCustomerPage.getAlert().contains("Email Address Already Exist !!"));
    }
    @Test
    @DisplayName("TC_026 - Verify if the ‘Enter’ key of the keyboard is working correctly on the New Customer page.")
    public void tc026(){
        NewCustomerPage newCustomerPage = new LoginPage(driver).autoLoginAndNavToNewCustomer();
        newCustomerPage.clickEnterForm();
        Assertions.assertTrue( newCustomerPage.getAlert().equals("please fill all fields"));
    }
    @Test
    @DisplayName("TC_027 - Verify that the reset button clears the data from all the text boxes in the New Customer form")
    public void tc027(){
        NewCustomerPage newCustomerPage = new LoginPage(driver).autoLoginAndNavToNewCustomer();
        newCustomerPage.fillAll();
        newCustomerPage.clickClear();
        Assertions.assertTrue(newCustomerPage.isElemBlank());
    }
    @Test
    @DisplayName("TC_028 - Verify all login related elements and fields are present on the New Customer page.")
    public void tc028(){
        NewCustomerPage newCustomerPage = new LoginPage(driver).autoLoginAndNavToNewCustomer();
        Assertions.assertTrue(newCustomerPage.allElemExisted());
    }
    @Test
    @DisplayName("TC_029 - Verify that the validation of required fields by not filling any data and submit")
    public void tc029(){
        NewCustomerPage newCustomerPage = new LoginPage(driver).autoLoginAndNavToNewCustomer();
        newCustomerPage.fillAll();
        newCustomerPage.clickClear();
        Assertions.assertTrue(newCustomerPage.isElemBlank());
    }
    @Test
    @DisplayName("TC_030 - Verify that entering blank spaces on mandatory fields lead to validation error")
    public void tc030(){
        NewCustomerPage newCustomerPage = new LoginPage(driver).autoLoginAndNavToNewCustomer();
        Assertions.assertTrue( newCustomerPage.checkValidationOfUserNameInput());
    }
    @Test
    @DisplayName("TC_031 - Verify if the data in password field is either visible as asterisk or bullet signs.")
    public void tc031(){
        NewCustomerPage newCustomerPage = new LoginPage(driver).autoLoginAndNavToNewCustomer();
        Assertions.assertTrue(newCustomerPage.isPasswordFieldEncrypted());
    }
    @Test
    @DisplayName("TC_032 - Verify if the ‘Enter’ key of the keyboard is working correctly on the login page.")
    public void tc032(){
        NewCustomerPage newCustomerPage = new LoginPage(driver).autoLoginAndNavToNewCustomer();
        newCustomerPage.clickEnterForm();
        Assertions.assertTrue( newCustomerPage.getAlert().equals("please fill all fields"));
    }

}
