package main.test;

import org.junit.Test;
import org.junit.Before;
import org.junit.After;
import static org.junit.Assert.*;
import static org.hamcrest.CoreMatchers.is;
import static org.hamcrest.core.IsNot.not;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.Dimension;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.JavascriptExecutor;

import java.util.*;

public class PlanTest {
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
    public void plan() {
        driver.get("https://plan.uz.zgora.pl/");
        driver.manage().window().setSize(new Dimension(1066, 9220));
        driver.findElement(By.linkText("Plan nauczycieli")).click();
        driver.findElement(By.linkText("B")).click();
        driver.findElement(By.linkText("dr inż. Jacek Bieganowski")).click();
        driver.findElement(By.cssSelector(".label:nth-child(1) > label:nth-child(3)")).click();
        driver.findElement(By.id("day3")).click();
        driver.findElement(By.id("day4")).click();
        driver.findElement(By.id("day5")).click();
        assertFalse(driver.findElement(By.id("day3")).isSelected());
        assertFalse(driver.findElement(By.id("day4")).isSelected());
        assertFalse(driver.findElement(By.id("day5")).isSelected());
    }
}
