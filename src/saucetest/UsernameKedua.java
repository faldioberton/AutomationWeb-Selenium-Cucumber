package saucetest;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import org.openqa.selenium.WebElement;

public class UsernameKedua {
    public  static void main(String[] args) throws InterruptedException {
        System.setProperty("webdriver.chrome.driver", "resources/chromedriver.exe");
        WebDriver driver = new ChromeDriver();
        WebDriverWait wait = new WebDriverWait(driver, 10);

        //Untuk menuju ke halaman web nya
        driver.get("https://www.saucedemo.com/");
        //Verifikasi url yang sedang dibuka
        String actualUrl = driver.getCurrentUrl();
        System.out.println("Go to url : " +actualUrl);
        Assert.assertEquals("https://www.saucedemo.com/", actualUrl);
        //User benar memasukkan username dan password 'Type : Positif'
        //Mengisi field username
        driver.findElement(By.id("user-name")).sendKeys("locked_out_user");
        //Mengisi field password
        driver.findElement(By.id("password")).sendKeys("secret_sauce");
        //Klik login button
        driver.findElement(By.id("login-button")).click();
        WebElement element = driver.findElement(By.xpath("//*[@id=\"login_button_container\"]/div/form/div[3]/h3"));
        String linkText = element.getText();
        System.out.println( linkText);
        System.out.println("User tidak bisa login");

    }
}
