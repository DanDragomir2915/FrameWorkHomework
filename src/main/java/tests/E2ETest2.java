package tests;
import org.testng.annotations.Listeners;
import org.testng.annotations.Test;
import pages.*;
import utils.BaseTest;
import utils.TestNgListener;

@Listeners(TestNgListener.class)
public class E2ETest2 extends BaseTest {

    @Test
    public void placeAnOrderAsUnregisteredCustomer() throws InterruptedException {

        NavigationMenuPage navPage = new NavigationMenuPage(driver);
        CategoryPage categoryPage = new CategoryPage(driver);
        categoryPage.click(categoryPage.frozenFoodCategory);
        categoryPage.hoverElement(categoryPage.HaagenDazsIceCreamProduct);
        categoryPage.click(categoryPage.HaagenDazsIceCreamAddToCartButton);
        categoryPage.hoverElement(categoryPage.signatureWoodPizzaProduct);
        categoryPage.click(categoryPage.signatureWoodPizzaAddToCartButton);
        navPage.navigateTo(navPage.returnToHomePage);
        categoryPage.click(categoryPage.beveragesCategory);
        categoryPage.hoverElement(categoryPage.cola2lBottleProduct);
        categoryPage.click(categoryPage.cola2lBottleAddToCartButton);
        navPage.navigateTo(navPage.cartButtonHomePage);
        CartPage cartPage = new CartPage(driver);
        cartPage.applyCuponCode("keyfood31122021");
        cartPage.verifyCuponApplied();
        cartPage.proceedToCheckOutClick();
        CheckOutPage checkOutPage = new CheckOutPage(driver);
        checkOutPage.fillInBillingDetails("Dan","Dragomir","DB","Unirii","2","Cluj","6789","074564567","dan@test.com","Leave order at the door");
        checkOutPage.dropDownCountryCounty();
        checkOutPage.termsAndConditionsButtonClick();
        checkOutPage.placeOrderButton();
        cartPage.verifyThankYouMessageForCompletedOrder();
        cartPage.verifyOrderNumber();

    }
}
