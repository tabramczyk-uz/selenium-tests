package main.test;

import org.junit.Test;
import org.junit.Before;
import org.junit.After;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.Dimension;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.openqa.selenium.JavascriptExecutor;
import java.time.Duration;

import static org.junit.Assert.assertEquals;

public class ReservationTest {
    private WebDriver driver;
    private WebDriverWait wait;
    private JavascriptExecutor js;

    @Before
    public void setUp() {
        driver = new FirefoxDriver();
        js = (JavascriptExecutor) driver;
        wait = new WebDriverWait(driver, Duration.ofSeconds(15));
    }

    @After
    public void tearDown() {
        if (driver != null) {
            driver.quit();
        }
    }

    @Test
    public void reservation() {
        driver.get("https://rezerwacja.zielona-gora.pl/");
        driver.manage().window().setSize(new Dimension(1936, 1080));

        try {
            WebElement cookieCloseButton = wait.until(
                    ExpectedConditions.elementToBeClickable(By.cssSelector(".cookies .close"))
            );
            cookieCloseButton.click();
            wait.until(ExpectedConditions.invisibilityOfElementLocated(By.className("cookies")));
        } catch (Exception e) {
            System.out.println("Baner cookies nie pojawił się lub nie dało się go zamknąć.");
        }

        WebElement selectServiceContainer = wait.until(
                ExpectedConditions.elementToBeClickable(By.cssSelector(".multiselect__tags, .multiselect"))
        );

        js.executeScript("arguments[0].scrollIntoView({block: 'center'});", selectServiceContainer);
        selectServiceContainer.click();

        WebElement registrationOption = wait.until(
                ExpectedConditions.elementToBeClickable(By.xpath("//span[contains(text(), 'Rejestracja pojazdu sprowadzonego z zagranicy')]"))
        );
        registrationOption.click();

        WebElement calendarOption = wait.until(
                ExpectedConditions.elementToBeClickable(By.xpath("//div[contains(text(), '30')]"))
        );
        calendarOption.click();

        WebElement hourOption = wait.until(
                ExpectedConditions.elementToBeClickable(By.xpath("//div[contains(text(), '10:30')]"))
        );
        hourOption.click();

        driver.findElement(By.cssSelector(".field-3241 > input")).sendKeys("admin");
        driver.findElement(By.cssSelector(".field-3186 > input")).sendKeys("qwerty123");
        driver.findElement(By.cssSelector(".submit-button")).click();
        WebElement headerSummary = wait.until(ExpectedConditions.visibilityOfElementLocated(
                By.cssSelector("h2.bookero-plugin-header-summary")
        ));

        String headerText = headerSummary.getText().trim();

        assertEquals("Podsumowanie", headerText);
    }
}

