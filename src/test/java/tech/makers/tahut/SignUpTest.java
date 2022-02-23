package tech.makers.tahut;

import static org.junit.jupiter.api.Assertions.assertEquals;

import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.springframework.boot.test.context.SpringBootTest;

@SpringBootTest(classes = TahutApplication.class)
public class SignUpTest {

    private WebDriver driver;
    
    @BeforeEach
    public void setup() {
        System.setProperty("webdriver.chrome.driver", "/usr/local/bin/chromedriver");
        driver = new ChromeDriver();
    }

    @Test
    public void successfulSignUpRedirectsToSignIn() {
        this.createUser();
        String title = driver.getTitle();
        assertEquals("Please sign in", title);
    }

    private void createUser() {
        driver.get("http://localhost:8080/users/new");
        driver.findElement(By.id("username")).sendKeys("newuser");
        driver.findElement(By.id("password")).sendKeys("password");
        driver.findElement(By.id("submit")).click();
    }

    @AfterEach
    public void tearDown() {
        driver.close();
    }
}
