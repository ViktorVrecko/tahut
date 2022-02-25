package tech.makers.tahut;

import static org.junit.jupiter.api.Assertions.assertTrue;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.springframework.boot.test.context.SpringBootTest;

@SpringBootTest(classes = TahutApplication.class)
public class CreateGroupTest {

    private WebDriver driver;
    
    @BeforeEach
    public void setup() {
        System.setProperty("webdriver.chrome.driver", "/usr/local/bin/chromedriver");
        driver = new ChromeDriver();
    }

    @Test
    public void createGroupAndAssignOwner() {
      driver.get("http://localhost:8080/login");
      driver.findElement(By.id("username")).sendKeys("admin");
      driver.findElement(By.id("password")).sendKeys("admin");
      driver.findElement(By.tagName("button")).click();
      driver.get("http://localhost:8080/groups");
      driver.findElement(By.id("groupname")).sendKeys("maventest");
      driver.findElement(By.id("submit")).click();
      String page = driver.getPageSource();
      assertTrue(page.contains("maventest"));
    }

    @AfterEach
    public void tearDown() {
        driver.close();
    }
}
