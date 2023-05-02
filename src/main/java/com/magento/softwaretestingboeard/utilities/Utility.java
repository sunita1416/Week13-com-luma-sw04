package com.magento.softwaretestingboeard.utilities;

import com.magento.softwaretestingboeard.browserfactory.ManageBrowser;
import org.openqa.selenium.*;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.*;

import java.time.Duration;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.function.Function;

public class Utility extends ManageBrowser {
    //This method will click on element
    public void clickOnElement(By by) {  //locator return type is By and by is variable
        driver.findElement(by).click();
    }
    //This method will send keys to element
    public void sendTextToElement(By by, String text) {
        driver.findElement(by).sendKeys(text);
    }
    //This method will get text from element
    public String getTextElement(By by) {
        return driver.findElement(by).getText();
    }
    //************************* Alert Methods *****************************************************

    //This method is for switch to alert
    public void switchToAlert() {
        Alert alert = driver.switchTo().alert();
    }
    //This method is to accept the alert pop up
    public void acceptAlert() {
        Alert alert = driver.switchTo().alert();
        alert.accept();
    }
    //This method is to cancel the alert pop up
    public void dismissAlert() {
        Alert alert = driver.switchTo().alert();
        alert.dismiss();
    }
    //This method is to get the text from alert pop up
    public void getAlertText() {
        Alert alert = driver.switchTo().alert();
        alert.getText();
    }
    //This method is to send text in alert pop up
    public void sendAlertText(String text) {
        Alert alert = driver.switchTo().alert();
        alert.sendKeys(text);
    }
    //*************************** Select Class Methods ***************************************//
    //This method is to select option from the dropdown list using it;s inner text
    public void selectByVisibleTextFromDropDown(By by, String text) {
        WebElement element = driver.findElement(by);
        Select select = new Select(element);
        select.selectByVisibleText(text);
    }
    //This method is to select option from dropdown using it's value attribute
    public void selectByValue(By by, String value) {
        WebElement element = driver.findElement(by);
        Select select = new Select(element);
        select.selectByValue(value);
    }
    //This method is to select from dropdown using index
    public void selectByIndex(By by, int index) {
        WebElement element = driver.findElement(by);
        Select select = new Select(element);
        select.selectByIndex(index);
    }
    //This method is to get option from drop down list
    public void getOptions(By by, String text) {
        List<WebElement> elements = driver.findElements(by);
        for (WebElement element : elements){
            if (element.getText().equalsIgnoreCase(text)){
                element.click();
                break;
            }
        }
    }
    //This method is to work with list of elements
    public void listOfElements(By by, String text) {
        List<WebElement> elements = driver.findElements(by);
        try {
            for (WebElement element : elements){
                if (element.getText().equalsIgnoreCase(text)){
                    element.click();
                    break;
                }
            }
        }catch (StaleElementReferenceException e){
            elements = driver.findElements(by);
        }
    }
    //*******************************Window Handle Methods********************************************************

    //This method will close all windows
    public void closeAllWindows(List<String> hList, String parentWindow) {
        for (String str : hList){
            if (!str.equals(parentWindow)){
                driver.switchTo().window(str).close();
            }
        }
    }
    //This method will switch to parent window
    public void switchToParentWindow(String parentWindowId) {
        driver.switchTo().window(parentWindowId);
    }
    //This method will find that we switch to right window
    public boolean switchToRightWindow(String windowTitle, List<String> hList) {
        for (String str : hList){
            String title = driver.switchTo().window(str).getTitle();
            if (title.contains(windowTitle)){
                System.out.println("Found the right window....");
                return true;
            }
        }
        return false;
    }
    //*************************** Action Methods ***************************************//
    //This method will use to hover mouse on element
    public void mouseHoverToElement(By by) {
        Actions actions = new Actions(driver);
        actions.moveToElement(driver.findElement(by)).build().perform();
    }
    //This method will use to hover mouse on element and click
    public void mouseHoverToElementAndClick(By by) {
        Actions actions = new Actions(driver);
        actions.moveToElement(driver.findElement(by)).click().build().perform();
    }
    //************************** Waits Methods *********************************************//
    //This method will use to wait until  VisibilityOfElementLocated
    public WebElement waitUntilVisibilityOfElementLocated(By by, int time) {
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(time));
        return wait.until(ExpectedConditions.visibilityOfElementLocated(by));
    }
    public WebElement waitForElementWithFluentWait(By by, int time, int pollingTime) {
        FluentWait<WebDriver> webDriverFluentWait = new FluentWait<WebDriver>(driver);
        webDriverFluentWait.withTimeout(Duration.ofSeconds(time));
        webDriverFluentWait.pollingEvery(Duration.ofSeconds(pollingTime));
        webDriverFluentWait.ignoring(NoSuchElementException.class);
        Wait<WebDriver> wait = webDriverFluentWait;

        WebElement element = wait.until(new Function<WebDriver, WebElement>() {
            public WebElement apply(WebDriver driver){
                return driver.findElement(by);
            }
        });
        return element;
    }
    //************************** Verification *********************************************//

    //This method is to verify the text
    public void verifyText(String displayMessage, String expectedText, String actualText) {
    }

    //This method is to verify that sorting is done in reverse order or not
    public void verifySortedElementsInReverseOrder(By by, By by1, String sortName) {
        List<WebElement> elements = driver.findElements(by);
        ArrayList<String> originalElementList = new ArrayList<>();
        for (WebElement e : elements) {
            originalElementList.add(e.getText());
        }
        System.out.println(originalElementList);

        // sort By reverse order
        Collections.reverse(originalElementList);
        System.out.println(originalElementList);

        //1.3 Select Sort By position "Name: Z to A"
        selectByVisibleTextFromDropDown(by1, sortName);
        // After filter Z -A Get all the products name and stored into array list
        elements = driver.findElements(by);
        ArrayList<String> afterSortByReverseList = new ArrayList<>();
        for (WebElement e : elements){
            afterSortByReverseList.add(e.getText());
        }
        System.out.println(afterSortByReverseList);
    }
    //This method is to verify elements are in ascending order or not
    public void verifyElementsInAscendingOrder(By by, By by1, String text){
        List<WebElement> elements = driver.findElements(by);
        List<String> elementsBefore = new ArrayList<>();
        for (WebElement e : elements){
            elementsBefore.add(e.getText());
        }
        System.out.println("Before Sorting : " + elementsBefore);

        //Select Sort By filter “Product Name”
        selectByVisibleTextFromDropDown(by1, text);

        // After Sorting value
        elements =driver.findElements(by);
        List<String> elementsAfter = new ArrayList<>();
        for(
                WebElement value :elements){
            elementsAfter.add(value.getText());
        }
        //Sort the before name list into Ascending Order
        elementsBefore.sort(String.CASE_INSENSITIVE_ORDER);// Ascending order
        System.out.println("After sorting:" + elementsAfter);
    }
    //This method is to verify elements are in ascending order or not of type double

    public void verifyElementsOfDoubleInAscendingOrder(By by,By by1, String text){
        List<WebElement> elementList = driver.findElements(by);
        List<Double> elementsListBefore = new ArrayList<>();
        for (WebElement value : elementList) {
            //Converting price in to Double and Removing $ from price
            elementsListBefore.add(Double.valueOf(value.getText().replace("$", "")));
        }
        // Select Sort By filter “Price”
        selectByVisibleTextFromDropDown(by1,text);
        // After Sorting Products by Price
        elementList = driver.findElements(by);
        List<Double> elementsListAfter = new ArrayList<>();
        for (WebElement value : elementList) {
            //Converting price in to Double and Removing $ from price
            elementsListAfter.add(Double.valueOf(value.getText().replace("$", "")));
        }
        // Sort the jacketPriceListBefore to Ascending Order
        Collections.sort(elementsListBefore);
    }
    // This method is to clear the textField
    public void clearField(By by){
        driver.findElement(by).clear();
    }
    public String getTheAttributeValue(By by, String value){
        String qty = driver.findElement(by).getAttribute(value);
        return qty;
    }


    }

