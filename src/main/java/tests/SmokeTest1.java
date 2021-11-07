package tests;

import org.testng.Assert;
import org.testng.annotations.Listeners;
import org.testng.annotations.Test;
import pages.BlogPage;
import pages.BlogPostPage;
import pages.NavigationMenuPage;
import utils.BaseTest;
import utils.SeleniumWrappers;
import utils.TestNgListener;

import static org.testng.Assert.assertTrue;

@Listeners(TestNgListener.class)
public class SmokeTest1 extends BaseTest {


    @Test
    public void smokeTest1()  {

        NavigationMenuPage navPage = new NavigationMenuPage(driver);
        navPage.navigateTo(navPage.blogPageLink);
        BlogPage blogPage = new BlogPage(driver);
        blogPage.verifyBlogPostsPresence();

        //first blog check
        blogPage.click(blogPage.firstBlogPostReadMoreButton);
        BlogPostPage blogPostPage = new BlogPostPage(driver);
        blogPostPage.commentFillInDetails("This is a test with random number :" + SeleniumWrappers.generateARandomNumber(1,1000),"Dan","dan@test.com","TestCO");
        assertTrue(blogPostPage.replyAwaitsModerationMessage.isDisplayed());
        navPage.navigateTo(navPage.blogPageLink);


        //second blog check
        blogPage.click(blogPage.secondBlogPostReadMoreButton);
        blogPostPage.commentFillInDetails("This is a test with random number :" + SeleniumWrappers.generateARandomNumber(1,1000),"Dan","dan@test.com","TestCO");
        assertTrue(blogPostPage.replyAwaitsModerationMessage.isDisplayed());
        navPage.navigateTo(navPage.blogPageLink);


        //third blog check
        blogPage.click(blogPage.thirdBlogPostReadMoreButton);
        blogPostPage.commentFillInDetails("This is a test with random number :" + SeleniumWrappers.generateARandomNumber(1,1000),"Dan","dan@test.com","TestCO");
        assertTrue(blogPostPage.replyAwaitsModerationMessage.isDisplayed());
        navPage.navigateTo(navPage.blogPageLink);


        //third blog check
        blogPage.click(blogPage.fourthBlogPostReadMoreButton);
        blogPostPage.commentFillInDetails("This is a test with random number :" + SeleniumWrappers.generateARandomNumber(1,1000),"Dan","dan@test.com","TestCO");
        assertTrue(blogPostPage.replyAwaitsModerationMessage.isDisplayed());

    }
}
