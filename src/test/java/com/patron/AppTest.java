package com.patron;

import org.junit.After;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

public class AppTest {
    private WebDriver webDriver;

    @Before
    public void setUp() {
        String path = "https://the-internet.herokuapp.com/";
        webDriver = new ChromeDriver();
        webDriver.get(path);

        // Perform actions to navigate and log in
        WebElement formAuthenticationLink = webDriver.findElement(By.linkText("Form Authentication"));
        formAuthenticationLink.click();

        WebElement username = webDriver.findElement(By.id("username"));
        WebElement password = webDriver.findElement(By.id("password"));
        WebElement login = webDriver.findElement(By.cssSelector("button[type='submit']"));

        username.sendKeys("tomsmith");
        password.sendKeys("SuperSecretPassword!");
        login.click();
    }

    @Test
    public void testBannerText() {
        WebElement successBanner = webDriver.findElement(By.cssSelector("div[class='flash success']"));
        String bannerText = successBanner.getText();

        Assert.assertEquals("The banner text is incorrect", "You logged into a secure area!\n×", bannerText);
    }

    @Test
    public void testBannerDisplayed() {
        WebElement successBanner = webDriver.findElement(By.cssSelector("div[class='flash success']"));
        boolean isBannerDisplayed = successBanner.isDisplayed();

        Assert.assertTrue("Success banner is not displayed", isBannerDisplayed);
    }

    @After
    public void tearDown() {
        webDriver.quit();
    }
}

