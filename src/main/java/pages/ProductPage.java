package pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import utils.SeleniumWrappers;

import static org.testng.Assert.assertTrue;

public class ProductPage extends SeleniumWrappers {

    public WebDriver driver;

    public ProductPage(WebDriver driver){
        this.driver = driver;
        PageFactory.initElements(driver,this);
    }

    @FindBy(className="woocommerce-message") public WebElement verifyProductIsAddedToCartMessage;
    @FindBy(xpath="//button[@type='submit']") public WebElement addToCartButton;
    @FindBy(xpath="(//a[@class='button wc-forward'])[2]") public WebElement viewCartButton;


    public void addToCart() {
        click(addToCartButton);
    }

    public CartPage pressViewCartButton() {
        click(viewCartButton);
        return new CartPage(driver);
    }

    public void verifyProductIsAddedToCart() {
        assertTrue(verifyProductIsAddedToCartMessage.isDisplayed());
    }
}
