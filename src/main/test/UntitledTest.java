package main.test;

import org.junit.Test;
import org.junit.Before;
import org.junit.After;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.Dimension;
import org.openqa.selenium.JavascriptExecutor;

import java.util.*;

public class UntitledTest {
    private WebDriver driver;
    private Map<String, Object> vars;
    JavascriptExecutor js;

    @Before
    public void setUp() {
        driver = new FirefoxDriver();
        js = (JavascriptExecutor) driver;
        vars = new HashMap<String, Object>();
    }

    @After
    public void tearDown() {
        driver.quit();
    }

    @Test
    public void planUZ() {
        driver.get("https://plan.uz.zgora.pl//");
        driver.manage().window().setSize(new Dimension(1200, 5233));
        driver.findElement(By.cssSelector("html")).click();
        driver.findElement(By.linkText("Plan grup")).click();
        driver.findElement(By.linkText("Informatyka")).click();
        driver.findElement(By.cssSelector(".even:nth-child(14) > td")).click();
        driver.findElement(By.id("details-tab")).click();
        driver.findElement(By.linkText("dr inż. Jacek Bieganowski")).click();
        driver.findElement(By.id("day3")).click();
        driver.findElement(By.linkText("Plan grup")).click();
        driver.findElement(By.linkText("Informatyka")).click();
        driver.findElement(By.linkText("34INF-SSI-SP Informatyka / stacjonarne / pierwszego stopnia z tyt. inżyniera")).click();
        driver.findElement(By.linkText("dr inż. Jacek Bieganowski")).click();
        driver.findElement(By.linkText("Plan grup")).click();
        driver.findElement(By.linkText("Informatyka")).click();
        driver.findElement(By.linkText("34INF-SSI-SP Informatyka / stacjonarne / pierwszego stopnia z tyt. inżyniera")).click();
        driver.findElement(By.linkText("dr inż. Jacek Bieganowski")).click();
        driver.close();
    }
}
