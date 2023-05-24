package com.patron;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

public class App 
{
    public static void main( String[] args ) {
        String path = "https://the-internet.herokuapp.com/";

        WebDriver webDriver = new ChromeDriver();

        webDriver.get(path);

        WebElement formAuthenticationLink = webDriver.findElement(By.linkText("Form Authentication"));
        formAuthenticationLink.click();

        WebElement username = webDriver.findElement(By.id("username"));
        WebElement password = webDriver.findElement(By.id("password"));
        WebElement login = webDriver.findElement(By.cssSelector("button[type='submit']"));

        username.sendKeys("tomsmith");
        password.sendKeys("SuperSecretPassword!");
        login.click();

        WebElement successBanner = webDriver.findElement(By.cssSelector("div[class='flash success']"));
        String bannerTextCheck = """
                You logged into a secure area!
                ×""";
        String wrongText = "this is wrong";
        String bannerText = successBanner.getText();
        boolean textCheck = bannerTextCheck.equals(bannerText);
        boolean wrongCheck = bannerTextCheck.equals(wrongText);
        boolean isBannerDisplayed = successBanner.isDisplayed();

        System.out.println("The banner text is " + (wrongCheck ? "equal!" : "not equal"));
        System.out.println("The banner text is " + (textCheck ? "equal!" : "not equal"));
        System.out.println("Success banner is " + (isBannerDisplayed ? "displayed!" : "not displayed."));

        webDriver.close();

    }
}
