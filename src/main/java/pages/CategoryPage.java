package pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import utils.SeleniumWrappers;

public class CategoryPage extends SeleniumWrappers {

    public WebDriver driver;

    public CategoryPage(WebDriver driver){
        this.driver = driver;
        PageFactory.initElements(driver,this);
    }

    @FindBy(css="ul#menu-sidebar-menu>li:nth-of-type(6)>a") public WebElement frozenFoodCategory;
    @FindBy(xpath="(//a[@href='https://keyfood.ro/product-category/beverages/'])[2]") public WebElement beveragesCategory;
    @FindBy(xpath="//img[@alt='Haagen-Dazs Caramel Cone Ice Cream']") public WebElement HaagenDazsIceCreamProduct;
    @FindBy(xpath="//a[@href='?add-to-cart=352']") public WebElement HaagenDazsIceCreamAddToCartButton;
    @FindBy(xpath="//img[@alt='Signature Wood-Fired Mushroom and Caramelized Red Onion Frozen Pizza']") public WebElement signatureWoodPizzaProduct;
    @FindBy(xpath="//a[@href='?add-to-cart=263']") public WebElement signatureWoodPizzaAddToCartButton;

    @FindBy(xpath="//img[@alt='Coca-Cola – 2 L Bottle']") public WebElement cola2lBottleProduct;
    @FindBy(xpath="(//a[contains(@class,'button-primary xsmall')])[2]") public WebElement cola2lBottleAddToCartButton;


}


