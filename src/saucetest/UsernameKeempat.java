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

public class UsernameKeempat {
    public static void main(String[] args) throws InterruptedException {
        //Install Webdriver
        System.setProperty("webdriver.chrome.driver", "resources/chromedriver.exe");
        WebDriver driver = new ChromeDriver();
        WebDriverWait wait = new WebDriverWait(driver, 10);
        //Untuk menuju ke halaman web nya
        driver.get("https://www.saucedemo.com/");
        //Verifikasi url yang sedang dibuka
        String actualUrl = driver.getCurrentUrl();
        System.out.println("Go to url : " + actualUrl);
        Assert.assertEquals("https://www.saucedemo.com/", actualUrl);
        //User benar memasukkan username dan password 'Type : Positif'
        //Mengisi field username
        driver.findElement(By.id("user-name")).sendKeys("performance_glitch_user");
        //Mengisi field password
        driver.findElement(By.id("password")).sendKeys("secret_sauce");
        //Klik login button
        driver.findElement(By.id("login-button")).click();
        driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
        System.out.println("Login berhasil");

    }
}
