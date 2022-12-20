package stepdefinition;

import config.environment;
import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import objekrepository.pagelogin;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import java.util.List;
import objekrepository.pageproduct;

public class product extends environment {

    int prev_amount;
    public int duration = 10;
    WebDriverWait wait = new WebDriverWait(driver, duration);

    pagelogin elementLogin = new pagelogin();
    pageproduct elementProduct = new pageproduct();
    @Given("user is on saucedemo homepage")
    public void user_is_on_sauce_demo_homepage() {
        wait.until(
                ExpectedConditions.visibilityOfElementLocated(elementProduct.getBtn_login())
        );
    }
    @When("user Input (.*) as username$")
    public void user_Input_username(String username) {
        WebElement field_userName = driver.findElement(elementProduct.getField_username());
        field_userName.isDisplayed();
        field_userName.sendKeys(username);
    }

    @And("user Input (.*) as password$")
    public void user_Input_password(String password) {
        WebElement field_password = driver.findElement(elementProduct.getField_password());
        Assert.assertTrue(field_password.isEnabled());
        field_password.sendKeys(password);
    }
    @And("user Click enter")
    public void user_Click_enter() {
        WebElement field_password = driver.findElement(elementProduct.getField_password());
        field_password.sendKeys(Keys.ENTER);
    }

    @Then("user Verify (.*) login result$")
    public void user_Verify_success_login_result(String status) {
        if (status.contains("success")){
            wait.until(
                    ExpectedConditions.presenceOfElementLocated(By.xpath("//div[@class='header_secondary_container']/span[@class='title']"))
            );
        } else {
            driver.findElement(By.className("error-button"));
        }
    }

    @When("user add first product to cart")
    public void user_add_first_product_to_cart() {
       // wait.until(ExpectedConditions.elementToBeClickable(By.id("add-to-cart-sauce-labs-backpack")));
        //driver.findElement(By.id("add-to-cart-sauce-labs-backpack")).click();
        //List <WebElement> btn_addToCart = (List<WebElement>) driver.findElement(elementProduct.getBtn_addToCart());


        List<WebElement> btn_addToCart = driver.findElements(elementProduct.getBtn_addToCart());
        btn_addToCart.get(0).click();
       Assert.assertTrue(btn_addToCart.size() == 6);
    }

    @And("user see initial amount")
    public void user_see_initial_amount() {
        WebElement text_amountInCart = driver.findElement(elementProduct.getBadge_amountProduct());
        prev_amount = Integer.valueOf(text_amountInCart.getText());
    }

    @When("user add second product to cart")
    public void user_add_second_product_to_cart() {
        driver.findElement(elementProduct.getBtn_addToCart()).click();
       // driver.findElement(elementProduct.getBtn_addsecondProduct());
    }

    @Then("user verify amount of product in cart incremented")
    public void user_verify_amount_of_product_in_cart_incremented() {
        WebElement text_amountInCart = driver.findElement(elementProduct.getBadge_amountProduct());
        int curr_amount = Integer.valueOf(text_amountInCart.getText());
        Assert.assertTrue(curr_amount - prev_amount == 1);
    }

}