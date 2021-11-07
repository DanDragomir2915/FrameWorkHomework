package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import utils.SeleniumWrappers;

import static org.testng.Assert.*;

public class CartPage extends SeleniumWrappers {
    public WebDriver driver;
    public String totalBeforeCoupon;
    public String totalAfterCoupon;

    public CartPage(WebDriver driver){
        this.driver = driver;
        PageFactory.initElements(driver,this);
    }

    @FindBy(xpath="//div[@class='quantity-button plus']//i[1]") public WebElement add1ToQtyFirstProduct;
    @FindBy(xpath="//tr[@class='order-total']/td/strong/span/bdi") public WebElement verifyCartPrice;
    @FindBy(xpath="//div[@class='wc-proceed-to-checkout']//a[1]") public WebElement proceedToCheckOutButton;
    @FindBy(xpath="//p[text()='Thank you. Your order has been received.']") public WebElement verifyThankYouMessageAfterOrderPlacement;
    @FindBy(css = "button[value='Apply coupon']") public WebElement couponCodeButton;
    @FindBy(css = "input[id='coupon_code']") public WebElement couponCodeInputField;

    @FindBy(xpath = "//main[@id='main']/div[1]/div[1]/div[1]/div[1]/div[1]/div[2]/div[1]/div[1]/div[1]/div[1]/table[1]/tbody[1]/tr[2]/td[1]/strong[1]/span[1]/bdi[1]") public WebElement totalPrice;
    @FindBy(xpath = "//main[@id='main']/div[1]/div[1]/div[1]/div[1]/div[1]/div[2]/div[1]/div[1]/div[1]/div[1]/table[1]/tbody[1]/tr[3]/td[1]/strong[1]/span[1]/bdi[1]") public WebElement afterCouponPrice;

    public void increaseQuantityButton() {
        click(add1ToQtyFirstProduct);
    }

    public void verifyCartPrice() {
        WebDriverWait wait = new WebDriverWait(driver,5);
        wait.until(ExpectedConditions.textToBePresentInElement(verifyCartPrice,"$5.98"));
        assertEquals(verifyCartPrice.getText(),"$5.98");

    }

    public void verifyThankYouMessageForCompletedOrder() {
        WebDriverWait wait = new WebDriverWait(driver, 5);
        wait.until(ExpectedConditions.textToBePresentInElement(verifyThankYouMessageAfterOrderPlacement, "Thank you. Your order has been received."));
        assertEquals(verifyThankYouMessageAfterOrderPlacement.getText(), "Thank you. Your order has been received.");
    }

    public void verifyOrderNumber(){
        WebElement orderNumber = driver.findElement(By.xpath("//ul[contains(@class,'woocommerce-order-overview woocommerce-thankyou-order-details')]//li[1]"));
        String actual_text = orderNumber.getText();
        actual_text= actual_text.replace("Order number: :","2303");

    }

    public void proceedToCheckOutClick(){

        click(proceedToCheckOutButton);
    }

    public String getTotal (WebElement totalElement){

        return totalElement.getText();
    }

    public void applyCuponCode(String couponCode) {
        totalBeforeCoupon = getTotal(totalPrice);
        sendKeys(couponCodeInputField, couponCode);
        click(couponCodeButton);
        totalAfterCoupon = getTotal(afterCouponPrice);
    }

    public void verifyCuponApplied(){

        assertNotEquals(totalBeforeCoupon, totalAfterCoupon);

    }

}
