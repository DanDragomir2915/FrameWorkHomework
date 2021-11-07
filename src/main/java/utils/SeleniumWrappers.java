package utils;

import org.openqa.selenium.StaleElementReferenceException;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.TestException;

import java.util.Random;

public class SeleniumWrappers extends BaseTest {

    public void doubleClick(WebElement element){
        try{
            waitForElementToBeDisplayed(element);
            Actions actions = new Actions(driver);
            actions.doubleClick(element).perform();
        }catch (Exception e){
            throw new TestException("Could not double click");
        }
    }


    public void hoverElement(WebElement element){

        try{
            waitForElementToBeDisplayed(element);
            Actions actions = new Actions(driver);
            actions.moveToElement(element).perform();
        }catch (Exception e){
            throw new TestException("the element was not present");
        }


    }

    public void dragAndDropSlider(WebElement element, int xOffset, int yOffset){
        try{
            waitForElementToBeDisplayed(element);
            Actions actions =  new Actions(driver);
            actions.dragAndDropBy(element, xOffset, yOffset).perform();

        }catch (Exception e) {
            throw new TestException("The element was not present");

        }
    }
    public void waitForElementToBeDisplayed(WebElement element){
        try{
            WebDriverWait wait = new WebDriverWait(driver,10);
            wait.until(ExpectedConditions.visibilityOf(element));
        }catch (Exception e){
            throw new TestException("The element was not present");
        }

    }
    public void waitForElementToBeClickable(WebElement element){
        try{
            WebDriverWait wait = new WebDriverWait(driver,10);
            wait.until(ExpectedConditions.elementToBeClickable(element));
        }catch (Exception e){
            throw new TestException("The element is not clickable");
        }

    }

    public void sendKeys(WebElement element,String value){
        try{
            element.clear();
            element.sendKeys(value);
        }catch (Exception e){
            throw new TestException("Sendkeys method failed");
        }

    }

    public void click(WebElement element){
        waitForElementToBeClickable(element);
        try{
            element.click();
        }catch (StaleElementReferenceException e){
            element.click();
        }catch (Exception e){
            throw new TestException("Element was not clickable-StaleElementException");
        }

    }


    public void selectDropDownByVisibleText(WebElement element, String Input){
        try {
            Log.info("Called the <selectDropDownByVisibleText> on element" + element);
            Select select = new Select(element);
            select.selectByVisibleText(Input);
        } catch (Exception e){
            Log.error("Failed on <selectDropDownByVisibleText>  on element" + element);
            throw new TestException("Dropdown was not present");
        }
    }

    public static int generateARandomNumber(int min, int max) {

        if (min >= max) {
            throw new IllegalArgumentException("max must be greater than min");
        }

        Random r = new Random();
        return r.nextInt((max - min) + 1) + min;
    }
}

