package com.example;

import static org.junit.jupiter.api.Assertions.assertEquals;

import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

class AuthTest {
    private WebDriver driver;

    @BeforeEach
    public void setUp() {
        driver = new ChromeDriver();
    }

    @AfterEach
    public void tearDown() {
        if (driver != null) {
            driver.quit();
        }
    }

    @Test
    void shouldLoginSuccessfully() {
        driver.get("https://seleniumbase.io/simple/login");

        driver.findElement(By.id("username"))
                .sendKeys("demo_user");

        driver.findElement(By.id("password"))
                .sendKeys("secret_pass");

        driver.findElement(By.id("log-in"))
                .click();

        String heading = driver.findElement(By.tagName("h1"))
                .getText();

        assertEquals("Welcome!", heading);
    }

    @Test 
    void shouldFailLoginWithInvalidCredentials() {
        driver.get("https://seleniumbase.io/simple/login");

        driver.findElement(By.id("username"))
                .sendKeys("invalid_user");

        driver.findElement(By.id("password"))
                .sendKeys("wrong_pass");

        driver.findElement(By.id("log-in"))
                .click();

        String errorMessage = driver.findElement(By.id("top_message"))
                .getText();

        assertEquals("Invalid Username!", errorMessage);
    }

    @Test
    void shouldFailLoginWithEmptyCredentials() {
        driver.get("https://seleniumbase.io/simple/login");

        // กดปุ่ม Sign in ทันทีโดยไม่กรอก Username และ Password
        driver.findElement(By.id("log-in"))
                .click();

        String errorMessage = driver.findElement(By.id("top_message"))
                .getText();

        assertEquals("The Username is Required!", errorMessage);
    }

    @Test 
    void shouldFailLoginWithEmptyPassword() {
        driver.get("https://seleniumbase.io/simple/login");

        driver.findElement(By.id("username"))
                .sendKeys("demo_user");

        // กดปุ่ม Sign in โดยไม่กรอก Password
        driver.findElement(By.id("log-in"))
                .click();

        String errorMessage = driver.findElement(By.id("top_message"))
                .getText();

        assertEquals("The Password is Required!", errorMessage);
    }

    @Test 
    void shouldFailLoginWithEmptyUsername() {
        driver.get("https://seleniumbase.io/simple/login");

        driver.findElement(By.id("password"))
                .sendKeys("secret_pass");

        // กดปุ่ม Sign in โดยไม่กรอก Username
        driver.findElement(By.id("log-in"))
                .click();

        String errorMessage = driver.findElement(By.id("top_message"))
                .getText();

        assertEquals("The Username is Required!", errorMessage);
    }
}
