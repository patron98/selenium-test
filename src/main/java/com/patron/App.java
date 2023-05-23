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

    }
}
