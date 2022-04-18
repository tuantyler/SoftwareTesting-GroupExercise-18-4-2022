package TS_001;

import directory.BaseTests;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import pages.HomePage;
import pages.LoginPage;

public class LoginTests extends BaseTests {
    @Test
    @DisplayName("TC_001 - Verify login page title")
    public void tc001(){
        LoginPage loginPage = new LoginPage(driver);
        loginPage.getPageTitle();
        String homePageTitle = loginPage.getPageTitle();
        Assertions.assertTrue(homePageTitle.contains("Guru99 Bank HomePage"));
    }
    @Test
    @DisplayName("TC_002 - Verify all login related elements and fields are present on the login page")
    public void tc002(){
        LoginPage loginPage = new LoginPage(driver);
        Assertions.assertTrue(loginPage.isFieldFullFill());
    }
    @Test
    @DisplayName("TC_003 - Verify that the User is able to Login with Valid Credentials")
    public void tc003(){
        LoginPage loginPage = new LoginPage(driver);
        loginPage.setUserName("mngr399305");
        loginPage.setPassword("UmezAjE");
        HomePage homePage = loginPage.clickLoginButton();
        String homePageTitle = homePage.getPageTitle();
        Assertions.assertTrue(homePageTitle.contains("Guru99 Bank Manager HomePage"));
    }
    @Test
    @DisplayName("TC_004 - Verify that the User is not able to Login with an invalid Username and invalid Password")
    public void tc004(){
        LoginPage loginPage = new LoginPage(driver);
        loginPage.setUserName("mngr399305_invalid");
        loginPage.setPassword("UmezAjE_invalid");
        loginPage.clickLoginButton();
        String statusAlert = loginPage.getAlert();
        Assertions.assertTrue(statusAlert.contains("User or Password is not valid"));
    }
    @Test
    @DisplayName("TC_005 - Verify that the User is not able to Login with a Valid Username and invalid Password")
    public void tc005(){
        LoginPage loginPage = new LoginPage(driver);
        loginPage.setUserName("mngr399305");
        loginPage.setPassword("UmezAjE_invalid");
        loginPage.clickLoginButton();
        String statusAlert = loginPage.getAlert();
        Assertions.assertTrue(statusAlert.contains("User or Password is not valid"));
    }
    @Test
    @DisplayName("TC_006 - Verify that the User is not able to log in with an invalid Username and Valid Password")
    public void tc006(){
        LoginPage loginPage = new LoginPage(driver);
        loginPage.setUserName("mngr399305_invalid");
        loginPage.setPassword("UmezAjE");
        loginPage.clickLoginButton();
        String statusAlert = loginPage.getAlert();
        Assertions.assertTrue(statusAlert.contains("User or Password is not valid"));
    }
    @Test
    @DisplayName("TC_007 - Verify that the User is not able to log in with a blank Username or Password")
    public void tc007(){
        LoginPage loginPage = new LoginPage(driver);
        loginPage.clickLoginButton();
        String statusAlert = loginPage.getAlert();
        Assertions.assertTrue(statusAlert.contains("User or Password is not valid"));
    }
    @Test
    @DisplayName("TC_008 -Verify that the reset button clears the data from all the text boxes in the login form")
    public void tc008(){
        LoginPage loginPage = new LoginPage(driver);
        loginPage.setUserName("mngr399305_invalid");
        loginPage.setPassword("UmezAjE");
        loginPage.clickResetButton();
        Assertions.assertTrue(loginPage.checkFieldBlank());
    }
    @Test
    @DisplayName("TC_009 - Verify that clicking on the browser back button after successful login should not take the User to log out mode")
    public void tc009(){
        LoginPage loginPage = new LoginPage(driver);
        loginPage.setUserName("mngr399305");
        loginPage.setPassword("UmezAjE");
        HomePage homePage = loginPage.clickLoginButton();
        homePage.getBack();
        String homePageTitle = homePage.getPageTitle();
        Assertions.assertTrue(homePageTitle.contains("Guru99 Bank Manager HomePage"));
    }
    @Test
    @DisplayName("TC_010 - Verify if the data in password field is either visible as asterisk or bullet signs.")
    public void tc010(){
        LoginPage loginPage = new LoginPage(driver);
        Assertions.assertTrue(loginPage.isPasswordFieldEncrypted());
    }
    @Test
    @DisplayName("TC_011 - Verify if the ‘Enter’ key of the keyboard is working correctly on the login page.")
    public void tc011(){
        LoginPage loginPage = new LoginPage(driver);
        loginPage.clickEnterForm();
        String statusAlert = loginPage.getAlert();
        Assertions.assertTrue(statusAlert.contains("User or Password is not valid"));
    }
    @Test
    @DisplayName("TC_012 - Verify the messages for invalid login.")
    public void tc012(){
        LoginPage loginPage = new LoginPage(driver);
        loginPage.setUserName("mngr399305_invalid");
        loginPage.setPassword("UmezAjE_invalid");
        loginPage.clickLoginButton();
        String statusAlert = loginPage.getAlert();
        Assertions.assertTrue(statusAlert.contains("User or Password is not valid"));
    }
    @Test
    @DisplayName("TC_013 - Verify that the user will get into their dashboard screen after login with the correct credentials.")
    public void tc013(){
        LoginPage loginPage = new LoginPage(driver);
        loginPage.setUserName("mngr399305");
        loginPage.setPassword("UmezAjE");
        HomePage homePage = loginPage.clickLoginButton();
        String homePageURL = homePage.getCurrentURL();
        Assertions.assertTrue(homePageURL.equals("https://www.demo.guru99.com/V4/manager/Managerhomepage.php"));
    }
}
