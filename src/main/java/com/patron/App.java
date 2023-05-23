package com.patron;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public class App 
{
    public static void main( String[] args ) {
        String path = "https://the-internet.herokuapp.com/";

        WebDriver webDriver = new ChromeDriver();

        webDriver.get(path);

    }
}
