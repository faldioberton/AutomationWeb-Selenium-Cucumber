package objekrepository;

import org.openqa.selenium.By;

public class pageproduct {

    By field_username = By.name("user-name");
    By field_password = By.id("password");
    By btn_login = By.xpath("//input[@type='submit'][@data-test='login-button']");
    //By btn_addToCart = By.xpath("//*[@id='add-to-cart-sauce-labs-backpack']");
    By btn_addToCart = By.xpath("//button[contains(text(),'Add to cart')]");
    By btn_addsecondProduct = By.id("add-to-cart-sauce-labs-bike-light");
    By badge_amountProduct = By.className("shopping_cart_badge");

    public By getField_username() {
        return field_username;
    }

    public By getField_password() {
        return field_password;
    }

    public By getBtn_login() {
        return btn_login;
    }


    public By getBtn_addToCart() {
        return btn_addToCart;
    }

   // public By getBtn_addsecondProduct() {
      //  return btn_addsecondProduct;
 //   }

    public By getBadge_amountProduct() {
        return badge_amountProduct;
    }
}
