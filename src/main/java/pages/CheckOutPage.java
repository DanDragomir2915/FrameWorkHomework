package pages;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import utils.SeleniumWrappers;

import static org.testng.Assert.assertEquals;

public class CheckOutPage extends SeleniumWrappers {

    public WebDriver driver;

    public CheckOutPage(WebDriver driver) {
        this.driver = driver;
        PageFactory.initElements(driver, this);
    }

    @FindBy(xpath = "(//span[text()='Account']/following::input)[2]") public WebElement firstNameFieldCheckoutPage;
    @FindBy(xpath = "(//span[@class='woocommerce-input-wrapper']//input)[2]") public WebElement lastNameFieldCheckoutPage;
    @FindBy(xpath = "(//span[@class='woocommerce-input-wrapper']//input)[3]") public WebElement companyNameFieldCheckOutPage;
    @FindBy(xpath = "//input[@data-placeholder='House number and street name']") public WebElement streetAddressFieldCheckoutPage;
    @FindBy(xpath = "//input[@data-placeholder='Apartment, suite, unit, etc. (optional)']") public WebElement streetAddress2FieldCheckoutPage;
    @FindBy(css = "input#billing_city") public WebElement townCityFieldCheckOutPage;
    @FindBy(css = "input#billing_postcode") public WebElement postCodeZipFieldCheckOutPage;
    @FindBy(xpath = "//input[@type='tel']") public WebElement phoneFieldCheckOutPage;
    @FindBy(css = "input#billing_email") public WebElement emailFieldCheckOutPage;
    @FindBy(xpath = "//span[@class='woocommerce-input-wrapper']//textarea[1]") public WebElement orderNotesFieldCheckOutPage;
    @FindBy(xpath = "//input[contains(@class,'woocommerce-form__input woocommerce-form__input-checkbox')]") public WebElement termsAndConditionCheckButton;
    @FindBy(xpath = "//button[@class='button alt']") public WebElement placeOrderButton;
    @FindBy(css="select[name='billing_country']") public WebElement countryDropdownFieldCheckOutPage;
    @FindBy(css="select[name='billing_state']") public WebElement countyDropdownFieldCheckOutPage;

    public void fillInBillingDetails(String FirstName, String LastName, String CompanyName, String Street, String Street2, String Town, String PostCode, String Phone, String Email, String OrderNotes ) {

        click(firstNameFieldCheckoutPage);
        sendKeys(firstNameFieldCheckoutPage, FirstName);
        click(lastNameFieldCheckoutPage);
        sendKeys(lastNameFieldCheckoutPage, LastName);
        click(companyNameFieldCheckOutPage);
        sendKeys(companyNameFieldCheckOutPage, CompanyName);
        click(streetAddressFieldCheckoutPage);
        sendKeys(streetAddressFieldCheckoutPage, Street);
        click(streetAddress2FieldCheckoutPage);
        sendKeys(streetAddress2FieldCheckoutPage, Street2);
        click(townCityFieldCheckOutPage);
        sendKeys(townCityFieldCheckOutPage, Town);
        click(postCodeZipFieldCheckOutPage);
        sendKeys(postCodeZipFieldCheckOutPage, PostCode);
        click(phoneFieldCheckOutPage);
        sendKeys(phoneFieldCheckOutPage, Phone);
        click(emailFieldCheckOutPage);
        sendKeys(emailFieldCheckOutPage, Email);
        click(orderNotesFieldCheckOutPage);
        sendKeys(orderNotesFieldCheckOutPage, OrderNotes);

    }


    public void dropDownCountryCounty(){
        selectDropDownByVisibleText(countryDropdownFieldCheckOutPage, "Romania");
        selectDropDownByVisibleText(countyDropdownFieldCheckOutPage, "Cluj");
    }

    public void placeOrderButton(){

        click(placeOrderButton);

    }
    public void termsAndConditionsButtonClick(){

        click(termsAndConditionCheckButton);

    }
}