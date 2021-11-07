package pages;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import utils.SeleniumWrappers;

public class NavigationMenuPage extends SeleniumWrappers {
    public WebDriver driver;

    public NavigationMenuPage(WebDriver driver){
        this.driver = driver;
        PageFactory.initElements(driver,this);
    }

    @FindBy(xpath="//li[@id='menu-item-1892']/a[1]")public WebElement loginLink;
    @FindBy(xpath = "//img[@class='desktop-logo hide-mobile']") public WebElement returnToHomePage;
    @FindBy(xpath = " (//div[@class='button-icon']//i)[2]") public WebElement cartButtonHomePage;
    @FindBy(xpath="(//a[@href='https://keyfood.ro/blog/'])[2]") public WebElement blogPageLink;




    public void navigateTo(WebElement element){
        element.click();

    }


}

