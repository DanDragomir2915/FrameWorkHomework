package pages;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import utils.ReadProperties;
import utils.SeleniumWrappers;


public class LoginPage extends SeleniumWrappers {

    public WebDriver driver;

    public String username = ReadProperties.config.getProperty("user");
    public String password = ReadProperties.config.getProperty("pass");

    public LoginPage(WebDriver driver){

        this.driver = driver;
        PageFactory.initElements(driver,this);
    }


    @FindBy(xpath="//input[contains(@class,'woocommerce-Input woocommerce-Input--text')]")public WebElement usernameField;
    @FindBy(xpath="(//input[contains(@class,'woocommerce-Input woocommerce-Input--text')])[2]") public WebElement passwordField;
    @FindBy(xpath="//button[@type='submit']") public WebElement submitButton;
    @FindBy(xpath="//main[@id='main']/div[1]/div[1]/div[1]/div[1]/div[1]/div[1]/div[1]/div[1]/div[1]/nav[1]/ul[1]/li[7]/a[1]") public WebElement logoutButton;

    public HomePage loginInApp(){
        sendKeys(usernameField,username);
        sendKeys(passwordField,password);

        click(submitButton);
        waitForElementToBeDisplayed(logoutButton);

        return new HomePage(driver);
    }
}
