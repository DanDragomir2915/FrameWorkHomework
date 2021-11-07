package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import utils.SeleniumWrappers;
import pages.BlogPostPage;

import java.util.List;

import static org.testng.Assert.assertTrue;

public class BlogPage extends SeleniumWrappers {

    public WebDriver driver;


    public BlogPage(WebDriver driver){
        this.driver = driver;
        PageFactory.initElements(driver,this);
    }


    @FindBy(xpath="//article[@id='post-1035']/div[1]/div[2]/div[1]/div[1]/a[1]") public WebElement firstBlogPostReadMoreButton;
    @FindBy(xpath="//article[@id='post-1023']/div[1]/div[2]/div[1]/div[1]/a[1]") public WebElement secondBlogPostReadMoreButton;
    @FindBy(xpath="(//a[@class='button'])[3]") public WebElement thirdBlogPostReadMoreButton;
    @FindBy(xpath="//article[@id='post-1033']/div[1]/div[2]/div[1]/div[1]/a[1]") public WebElement fourthBlogPostReadMoreButton;



    public void verifyBlogPostsPresence() {
        assertTrue(firstBlogPostReadMoreButton.isDisplayed());
        assertTrue(secondBlogPostReadMoreButton.isDisplayed());
        assertTrue(thirdBlogPostReadMoreButton.isDisplayed());
        assertTrue(fourthBlogPostReadMoreButton.isDisplayed());
    }


}
