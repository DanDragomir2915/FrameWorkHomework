package pages;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import utils.SeleniumWrappers;

import java.util.List;

public class HomePage extends SeleniumWrappers {
    WebDriver driver;

    public HomePage(WebDriver driver){
        this.driver=driver;
        PageFactory.initElements(driver,this);
    }

    @FindBy(xpath="//input[@type='search']")public WebElement searchProductLink;
    @FindBy(xpath="//span[@class='dgwt-wcas-st']//span[1]")public List<WebElement> productList;




    public ProductPage searchAndNavigateToProductDetailsPage(String productName) {
        click(searchProductLink);
        sendKeys(searchProductLink,productName);
        click(productList.get(0));
        return new ProductPage(driver);
    }
}
