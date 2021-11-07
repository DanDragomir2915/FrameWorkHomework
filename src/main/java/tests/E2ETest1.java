package tests;

import org.testng.annotations.Listeners;
import org.testng.annotations.Test;
import pages.*;
import utils.BaseTest;
import utils.TestNgListener;
import pages.CheckOutPage;


@Listeners(TestNgListener.class)
public class E2ETest1 extends BaseTest {

    NavigationMenuPage navPage;
    CheckOutPage checkOutPage;



    @Test()
    public void placeAnOrderAsRegisteredCustomer() throws InterruptedException {
        navPage = new NavigationMenuPage(driver);
        LoginPage loginPage = new LoginPage(driver);
        navPage.navigateTo(navPage.loginLink);
        HomePage homePage = loginPage.loginInApp();
        navPage.navigateTo(navPage.returnToHomePage);
        ProductPage productPage = homePage.searchAndNavigateToProductDetailsPage("Pretzels");
        productPage.addToCart();
        productPage.verifyProductIsAddedToCart();
        CartPage cartPage = productPage.pressViewCartButton();
        cartPage.increaseQuantityButton();
        cartPage.verifyCartPrice();
        cartPage.proceedToCheckOutClick();
        checkOutPage = new CheckOutPage(driver);
        checkOutPage.fillInBillingDetails("Dan","Dragomir","DB","Unirii","2","Cluj","6789","074564567","dan@test.com","Leave order at the door");
        checkOutPage.dropDownCountryCounty();
        checkOutPage.termsAndConditionsButtonClick();
        checkOutPage.placeOrderButton();
        cartPage.verifyThankYouMessageForCompletedOrder();
        cartPage.verifyOrderNumber();


    }


}
