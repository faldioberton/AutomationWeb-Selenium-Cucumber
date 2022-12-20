package saucetest;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedCondition;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import java.util.concurrent.TimeUnit;

import java.awt.*;

import static java.awt.SystemColor.menu;


public class SeleniumTest {

    public static void main(String[] args) throws InterruptedException {
        //Install Webdriver
        System.setProperty("webdriver.chrome.driver", "resources/chromedriver.exe");
        WebDriver driver = new ChromeDriver();
        WebDriverWait wait = new WebDriverWait(driver, 6);
        //Untuk menuju ke halaman web nya
        driver.get("https://www.saucedemo.com/");
        //Verifikasi url yang sedang dibuka
        String actualUrl = driver.getCurrentUrl();
        System.out.println("Go to url : " +actualUrl);
        Assert.assertEquals("https://www.saucedemo.com/", actualUrl);
        System.out.println("LOGIN PAGE SAUCEDEMO");
        //User benar memasukkan username dan password 'Type : Positif'
        //Mengisi field username
        driver.findElement(By.id("user-name")).sendKeys("standard_user");
        //Mengisi field password
        driver.findElement(By.id("password")).sendKeys("secret_sauce");
        //Klik login button
        driver.findElement(By.id("login-button")).click();
        System.out.println("Login berhasil");
        //Get Text
        //WebElement el = driver.findElement(By.xpath("//*[@id=\"inventory_container\"]/div"));
        //String linkText = el.getText();
        //System.out.println(linkText);
        //System.out.println("User berada di page PRODUCTS");
        //Assert url Product di saucedemo
        String producturl = driver.getCurrentUrl();
        System.out.println("Go to url : " +producturl);
        Assert.assertEquals("https://www.saucedemo.com/inventory.html", producturl);
        //Assert Product
        driver.findElement(By.xpath("//*[@id=\"header_container\"]/div[2]/span")).isDisplayed();
        System.out.println("PAGE PR0ODUCTS");
        //Delay
        driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
        //Scroll ke bawah
        driver.findElement(By.id("item_3_title_link")).sendKeys(Keys.ARROW_DOWN);
        System.out.println("Scroll down");
        //Menambahkan product Red T-Shirt
        driver.findElement(By.id("add-to-cart-test.allthethings()-t-shirt-(red)")).click();
        System.out.println("Product Red T-Shirt succeed add to chart");
        //Menambahkan product T-Shirt Sauce Labs Onesie
        driver.findElement(By.id("add-to-cart-sauce-labs-onesie")).click();
        System.out.println("Product Sauce Labs Onesie succeed add to chart");
        //Scroll ke atas
        driver.findElement(By.xpath("//*[@id=\"header_container\"]/div[2]/div[2]/span/select")).sendKeys(Keys.ARROW_UP);
        System.out.println("Scroll up");
        //Melihat product di shopping chart/ di keranjang belanja
        driver.findElement(By.id("shopping_cart_container")).click();
        System.out.println("Klik shopping cart");
        //Assert url cart
        String carturl = driver.getCurrentUrl();
        System.out.println("Go to url : " +carturl);
        Assert.assertEquals("https://www.saucedemo.com/cart.html", carturl);
        //Assert your chart
        driver.findElement(By.xpath("//*[@id=\"header_container\"]/div[2]/span")).isDisplayed();
        System.out.println("PAGE YOUR CART");
        //Jika ingin menambah product
        driver.findElement(By.id("continue-shopping")).click();
        System.out.println("Klik Continue Shopping");
        driver.findElement(By.xpath("//*[@id=\"header_container\"]/div[2]/span")).isDisplayed();
        System.out.println("Back to PAGE PRODUCTS");
        //Menambahkan Product Sauce Labs Backpack
        System.out.println("Add Product Sauce Labs Backpack");
        driver.findElement(By.id("add-to-cart-sauce-labs-backpack")).click();
        System.out.println("Product Sauce Labs Backpack succeed add to chart");
        //Kembali lagi ke shopping chart
        driver.findElement(By.id("shopping_cart_container")).click();
        System.out.println("Klik Shopping cart");
        driver.findElement(By.xpath("//*[@id=\"header_container\"]/div[2]/span")).isDisplayed();
        System.out.println("Go to PAGE YOUR CART");
        //Menghapus satu product di shopping chart
        System.out.println("Remove Product Sauce Labs Onesie");
        driver.findElement(By.id("remove-sauce-labs-onesie")).click();
        System.out.println("Product Sauce Labs Onesie succeed remove from shopping chart");
        //Checkout product
        driver.findElement(By.id("checkout")).click();
        System.out.println("Klik checkout");
        //Assert Url checkout
        String checkouturl = driver.getCurrentUrl();
        System.out.println("Go to url : " +checkouturl);
        Assert.assertEquals("https://www.saucedemo.com/checkout-step-one.html", checkouturl);
        //Assert checkout
        driver.findElement(By.xpath("//*[@id=\"header_container\"]/div[2]/span")).isDisplayed();
        System.out.println("PAGE CHECKOUT");
        //Click tombol cancel
        driver.findElement(By.id("cancel")).click();
        System.out.println("Klik Cancel");
        driver.findElement(By.xpath("//*[@id=\"header_container\"]/div[2]/span")).isDisplayed();
        System.out.println("Back to PAGE YOUR CART");
        //Kembali ke checkout info
        driver.findElement(By.id("checkout")).click();
        System.out.println("Klik Checkout");
        driver.findElement(By.xpath("//*[@id=\"header_container\"]/div[2]/span")).isDisplayed();
        System.out.println("Go to PAGE CHECKOUT");
        //Mengisi field first name
        driver.findElement(By.id("first-name")).sendKeys("Faldi");
        //Mengisi field last name
        driver.findElement(By.id("last-name")).sendKeys("Silaen");
        //Mengisi Postal Code
        driver.findElement(By.id("postal-code")).sendKeys("1234");
        //Klik continue button
        driver.findElement(By.id("continue")).click();
        System.out.println("Klik Continue");
        //Assert Url Overview
        String overviewurl = driver.getCurrentUrl();
        System.out.println("Go to url : " +overviewurl);
        Assert.assertEquals("https://www.saucedemo.com/checkout-step-two.html", overviewurl);
        //Assert Overview
        driver.findElement(By.xpath("//*[@id=\"header_container\"]/div[2]/span")).isDisplayed();
        System.out.println("PAGE OVERVIEW");
        //Get Text from page overview
        WebElement element = driver.findElement(By.xpath("//*[@id=\"checkout_summary_container\"]"));
        String linkText = element.getText();
        System.out.println(linkText);
        driver.findElement(By.id("cancel")).isEnabled();
        driver.findElement(By.id("finish")).click();
        System.out.println("Klik Finish");
        //Assert Url page complete
        String completeurl = driver.getCurrentUrl();
        System.out.println("Go to url : " +completeurl);
        Assert.assertEquals("https://www.saucedemo.com/checkout-complete.html", completeurl);
        //Assert page complete
        driver.findElement(By.xpath("//*[@id=\"header_container\"]/div[2]/span")).isDisplayed();
        System.out.println("PAGE COMPLETE");
        //Get Text dari page complete
        WebElement text = driver.findElement(By.xpath("//*[@id=\"checkout_complete_container\"]/h2"));
        String overview = text.getText();
        System.out.println(overview);
        // Assert.assertEquals(driver.findElement(By.xpath("//*[@id=\"checkout_complete_container\"]/img")).isDisplayed());
        //Displayed Image
        boolean status = driver.findElement(By.xpath("//*[@id=\"checkout_complete_container\"]/img")).isDisplayed();
        System.out.println("Element selected is :"+status);
        driver.findElement(By.xpath("//*[@id=\"back-to-products\"]")).click();
        System.out.println("Klik Back Home");
        // Logout user
        System.out.println("Go to PAGE PRODUCTS");
        driver.findElement(By.id("react-burger-menu-btn")).click();
        System.out.println("Klik Burger Menu");
        wait.until(ExpectedConditions.elementToBeClickable(By.id("logout_sidebar_link")));
        WebElement logout = driver.findElement(By.id("logout_sidebar_link"));
        logout.click();
        System.out.println("Klik Logout");
        System.out.println("User succeed logout");
        driver.quit();
    }
}
