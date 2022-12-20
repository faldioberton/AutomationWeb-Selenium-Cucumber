package stepdefinition;

import config.environment;
import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import objekrepository.pagelogin;

public class login extends environment {

    public int duration = 10;

    WebDriverWait wait = new WebDriverWait(driver, duration);

    pagelogin elementLogin = new pagelogin();

    @Given("user is on SauceDemo homepage")
    public void user_is_on_sauce_demo_homepage() {
        wait.until(
                ExpectedConditions.visibilityOfElementLocated(elementLogin.getBtn_login())
        );
    }
    @When("user input (.*) as username$")
    public void user_input_username(String username) {
        WebElement field_userName = driver.findElement(elementLogin.getField_username());
        field_userName.isDisplayed();
        field_userName.sendKeys(username);
    }

    @And("user input (.*) as password$")
    public void user_input_password(String password) {
        WebElement field_password = driver.findElement(elementLogin.getField_password());
        Assert.assertTrue(field_password.isEnabled());
        field_password.sendKeys(password);
    }
    @And("user click enter")
    public void user_click_enter() {
        WebElement field_password = driver.findElement(elementLogin.getBtn_login());
        field_password.sendKeys(Keys.ENTER);
    }
    @Then("user verify (.*) login result$")
    public void user_verify_success_login_result(String status) {
        if (status.contains("success")){
            wait.until(
                    ExpectedConditions.presenceOfElementLocated(By.xpath("//div[@class='header_secondary_container']/span[@class='title']"))
            );
        } else {
            driver.findElement(By.className("error-button"));
        }
    }
    @Given("User Is On SauceDemo Homepage")
    public void User_Is_On_Sauce_Demo_Homepage() {
        wait.until(
                ExpectedConditions.visibilityOfElementLocated(elementLogin.getBtn_login())
        );
    }

    @When("User Input (.*) as Username$")
    public void User_input_username(String usernames) {
        WebElement field_userName = driver.findElement(elementLogin.getField_username());
        field_userName.isDisplayed();
        field_userName.sendKeys(usernames);
    }

    @And("User Click Enter")
    public void User_Click_Enter() {
        WebElement field_password = driver.findElement(elementLogin.getBtn_login());
        field_password.sendKeys(Keys.ENTER);
    }

    @Then("User Verify Failed Login")
    public void User_Verify_Failed_Login() {
        driver.findElement(By.className("error-button"));
    }

}