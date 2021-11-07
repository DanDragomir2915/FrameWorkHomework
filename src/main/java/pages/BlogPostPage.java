package pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import utils.SeleniumWrappers;

public class BlogPostPage extends SeleniumWrappers {


    public WebDriver driver;


    public BlogPostPage(WebDriver driver) {
        this.driver = driver;
        PageFactory.initElements(driver, this);
    }

    @FindBy(id="comment") public WebElement blogPostCommentInputArea;
    @FindBy(id="author") public WebElement blogPostNameInputArea;
    @FindBy(id="email") public WebElement blogPostEmailInputArea;
    @FindBy(id="url") public WebElement blogPostWebsiteInputArea;
    @FindBy(id = "submit") public WebElement postCommentButton;
    @FindBy(xpath = "//em[text()='Your comment is awaiting moderation.']") public WebElement replyAwaitsModerationMessage;


    public void commentFillInDetails(String comment,String name,String email,String websiteInfo){
        sendKeys(blogPostCommentInputArea,comment);
        sendKeys(blogPostNameInputArea, name);
        sendKeys(blogPostEmailInputArea, email);
        sendKeys(blogPostWebsiteInputArea, websiteInfo);
        postCommentButton.click();
    }

}