package testsuite;

import browserfactory.BaseTest;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

import java.time.Duration;

public class LoginTest extends BaseTest {

    String basUrl = "http://the-internet.herokuapp.com/login";

    @Before

    public void setUp(){

        openBrowser(basUrl);
    }
    @Test
    
    public void userSholdLoginSuccessfullyWithValidCredentials(){


        //* Enter “tomsmith” username

        WebElement EnterUsername = driver.findElement(By.xpath("//input[@id='username']"));
                EnterUsername.sendKeys("tomsmith");



        //* Enter “SuperSecretPassword!” password
        WebElement EnterPassword = driver.findElement(By.xpath("//input[@type='password']"));
        EnterPassword.sendKeys("SuperSecretPassword!");



        //* Click on ‘LOGIN’ button

        WebElement ClickLogin = driver.findElement(By.xpath("//button[@type='submit']"));
        ClickLogin.click();



        //* Verify the text “Secure Area”

        WebElement VerifyText = driver.findElement(By.xpath("//i[@class='icon-lock']"));
        VerifyText.getText();



    }
    @Test
    public void verifyTheUsernameErrorMessage(){


        //* Enter “tomsmith1” username

        WebElement EnterUsername = driver.findElement(By.xpath("//input[@name='username']"));
        EnterUsername.sendKeys("tomsmith1");



        //* Enter “SuperSecretPassword!” password

        WebElement EnterPassword = driver.findElement(By.xpath("//input[@type='password']"));
        EnterPassword.sendKeys("SuperSecretPassword");



        //* Click on ‘LOGIN’ button

        WebElement ClickLogin = driver.findElement(By.xpath("//button[@type='submit']"));
        ClickLogin.click();



        //* Verify the error message “Your username is invalid!”

        WebElement VerifyError = driver.findElement(By.xpath("//div[@class='flash error']"));
        VerifyError.getText();



    }

    @Test
    public void verifyThePasswordErrorMessage(){

        //* Enter “tomsmith” username

        WebElement EnterUsername = driver.findElement(By.xpath("//input[@name='username']"));
        EnterUsername.sendKeys("tomsmith");



        //* Enter “SuperSecretPassword” password

        WebElement EnterPassword = driver.findElement(By.xpath("//input[@type='password']"));
        EnterPassword.sendKeys("SuperSecretPassword");




        //* Click on ‘LOGIN’ button

        WebElement ClickLogin = driver.findElement(By.xpath("//button[@type='submit']"));
        ClickLogin.click();



        //* Verify the error message “Your password is invalid!”

        WebElement VerifyError = driver.findElement(By.xpath("//div[@id='flash']"));
        VerifyError.getText();




    }

    @After
    public void tearDown(){

        // closeBrowser();
    }




}