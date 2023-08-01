package com.solvd.carina.demo;

import com.solvd.carina.demo.gui.pages.header.CarinaHeaderPage;
import com.solvd.carina.demo.gui.pages.header.GitHubPage;
import com.solvd.carina.demo.gui.pages.navigation.NavigationPage;
import com.zebrunner.carina.core.IAbstractTest;
import org.testng.Assert;
import org.testng.annotations.Test;



public class ZebrunnerTest implements IAbstractTest {


    @Test
    public void testZebrunnerLogo() {
        CarinaHeaderPage headerPage = new CarinaHeaderPage(getDriver());
        headerPage.open();
        Assert.assertTrue(headerPage.isLogoDisplayed(), "Logo validation failed");
    }

    @Test
    public void testCarinaText() {
        CarinaHeaderPage headerPage = new CarinaHeaderPage(getDriver());
        headerPage.open();
        Assert.assertEquals(headerPage.isCarinaTextPresent(), "Carina");
    }

    @Test
    public void testSearchComp() {
        CarinaHeaderPage headerPage = new CarinaHeaderPage(getDriver());
        headerPage.open();
        Assert.assertTrue(headerPage.isSearchComponentPresent(), "Search component validation failed");
        Assert.assertTrue(headerPage.isInputTextLabeledProperly(), "Search input label validation failed");
    }

   @Test
    public void testGitHubLinkandGitHubRedirect() {
        CarinaHeaderPage headerPage = new CarinaHeaderPage(getDriver());
        headerPage.open();
        Assert.assertTrue(headerPage.isGitHubLinkPresent(), "Github link validation failed");
        headerPage.clickGitHubLink();
        GitHubPage gitHubPage = new GitHubPage(getDriver());
        Assert.assertEquals(gitHubPage.getCurrentUrl(),"https://github.com/zebrunner/carina/", "Link does not redirect to github");
   }

   @Test
   public void testIsHeaderSticky() {
        CarinaHeaderPage headerPage = new CarinaHeaderPage(getDriver());
        headerPage.open();
        headerPage.scrollToBottom();
        Assert.assertTrue(headerPage.isHeaderSticky(), "Header is not sticky");
   }

   @Test
    public void isCarinaHeadingFirstElement() {
       NavigationPage navigationPage = new NavigationPage(getDriver());
       navigationPage.open();
       Assert.assertTrue(navigationPage.isCarinaHeadingFirstElement(), "no");
   }

   @Test
    public void testNavigationMenu() {
        NavigationPage navigationPage = new NavigationPage(getDriver());
        navigationPage.open();
        Assert.assertTrue(navigationPage.isNavigationLinkPresent(), "Navigation link is not present");
        Assert.assertTrue(navigationPage.isCurrentPageLinkHighlighted(), "Current page link is not highlighted");
        Assert.assertTrue(navigationPage.areHiddenElementsDisplayed(), "Some elements that should be hidden are displayed!" );
        Assert.assertTrue(navigationPage.areSubPageLinksRevealedAfterClickingParent(), "Sub-pages are revealed ");
   }
}
