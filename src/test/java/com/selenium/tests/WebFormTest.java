package com.selenium.tests;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.Select;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

public class WebFormTest {

    private ThreadLocal<WebDriver> driverThread = new ThreadLocal<>();

    private WebDriver getDriver() {
        return driverThread.get();
    }

    @BeforeMethod
    public void setUp() {
        // Create a new instance of the ChromeDriver and set it to the ThreadLocal variable
        driverThread.set(new ChromeDriver());
    }

    @AfterMethod
    public void tearDown() {
        // Quit the WebDriver instance to close the browser after each test method
        getDriver().quit();
    }

    @Test
    public void checkFormSubmittedMessage() {
        // Navigate to the web form page
        getDriver().get("https://www.selenium.dev/selenium/web/web-form.html");
        // Create a new WebElement instance to interact with the form elements
        WebElement webElement;
        // Find the input field using its XPath and assign it to the webElement variable
        webElement = getDriver().findElement(By.xpath("//*[@id=\"my-text-id\"]"));
        // Send the text "AHMED" to the input field
        webElement.sendKeys("AHMED");
        // Find the password field using its XPath and assign it to the webElement variable
        webElement = getDriver().findElement(By.xpath("/html/body/main/div/form/div/div[1]/label[2]/input"));
        // Send the text "password" to the password field
        webElement.sendKeys("password");
        // Find the select dropdown using its XPath and assign it to the webElement variable
        webElement = getDriver().findElement(By.xpath("/html/body/main/div/form/div/div[2]/label[1]/select"));
        // Create a new Select instance using the webElement and select the option with value "3"
        Select dropDownSelect = new Select(webElement);
        dropDownSelect.selectByValue("3");
        // Find the text input using its XPath and assign it to the webElement variable
        webElement = getDriver().findElement(By.xpath("/html/body/main/div/form/div/div[2]/label[2]/input"));
        webElement.sendKeys("New York");
        // Find the checkbox using its XPath and assign it to the webElement variable
        webElement = getDriver().findElement(By.xpath("//*[@id='my-check-1']"));
        if (webElement.isSelected()) {
            webElement.click();
        }
        // Find the checkbox using its XPath and assign it to the webElement variable
        webElement = getDriver().findElement(By.xpath("//*[@id=\"my-check-2\"]"));
        if (!webElement.isSelected()) {
            webElement.click();
        }
        // Find the radio button using its XPath and assign it to the webElement variable
        webElement = getDriver().findElement(By.xpath("//*[@id='my-radio-2']"));
        if (webElement.isEnabled()) {
            webElement.click();
        }
        // Find the submit button using its XPath and assign it to the webElement variable
        webElement = getDriver().findElement(By.xpath("/html/body/main/div/form/div/div[2]/button"));
        webElement.submit();
        // Find the heading element using its XPath and assign it to the webElement variable
        webElement = getDriver().findElement(By.xpath("/html/body/main/div/div[1]/div/h1"));
        String myString = webElement.getText();
        // Assert that the text of the heading element is "Form submitted"
        Assert.assertEquals(myString, "Form submitted");

    }

    @Test
    public void checkDisabledInputIsDisable() {
        // Navigate to the web form page
        getDriver().navigate().to("https://www.selenium.dev/selenium/web/web-form.html");
        // Find the input field using its XPath and assign it to the webElement variable
        WebElement webElement = getDriver().findElement(By.xpath("/html/body/main/div/form/div/div[1]/label[4]/input"));
        // Assert that the input field is disabled
        Assert.assertFalse(webElement.isEnabled());

    }

    @Test
    public void checkReadonlyInput() {
        // Navigate to the web form page
        getDriver().navigate().to("https://www.selenium.dev/selenium/web/web-form.html");
        // Find the input field using its XPath and assign it to the webElement variable
        WebElement webElement = getDriver().findElement(By.xpath("/html/body/main/div/form/div/div[1]/label[5]/input"));
        // Assert that the input field is read-only by checking if the "readonly" attribute is present
        Assert.assertNotNull(webElement.getAttribute("readonly"));
    }

}
