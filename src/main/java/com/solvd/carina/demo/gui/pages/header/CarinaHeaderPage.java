package com.solvd.carina.demo.gui.pages.header;

import com.zebrunner.carina.webdriver.decorator.ExtendedWebElement;
import com.zebrunner.carina.webdriver.gui.AbstractUIObject;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.FindBy;

public class CarinaHeaderPage extends AbstractUIObject {

    @FindBy(xpath = "//a[@class='md-header-nav__button md-logo']")
    private ExtendedWebElement zebrunnerLogo;

    @FindBy(xpath = "//span[contains(text(), 'Carina')]")
    private ExtendedWebElement carinaText;

    @FindBy(css = "div.md-search")
    private ExtendedWebElement searchBox;

    @FindBy(xpath = "//label[@class='md-search__icon md-icon']")
    private ExtendedWebElement searchIcon;

    @FindBy(xpath = "//input[@placeholder='Search']")
    private ExtendedWebElement searchInput;

    @FindBy(xpath = "//div[@class='md-header-nav__source']/a")
    private ExtendedWebElement gitHubLink;

    @FindBy(css = "header.md-header")
    private ExtendedWebElement header;

    @FindBy(xpath = "//div[@class='md-footer-meta__inner md-grid']")
    private ExtendedWebElement footer;

    public boolean isLogoDisplayed() {
        return zebrunnerLogo.isElementPresent();
    }

    public String isCarinaTextPresent() {
        return carinaText.getText();
    }

    public boolean isSearchComponentPresent() {
        return searchBox.isElementPresent() && searchIcon.isElementPresent() && searchIcon.isElementPresent();
    }

    public boolean isInputTextLabeledProperly() {
        return "Search".equals(searchInput.getAttribute("placeholder"));
    }

    public CarinaHeaderPage(WebDriver driver) {
        super(driver);
    }

    public boolean isGitHubLinkPresent() {
        return gitHubLink.isElementPresent();
    }

    public void clickGitHubLink() {
        gitHubLink.click();
    }

    public void scrollToBottom() {
        footer.scrollTo();
    }

    public boolean isHeaderSticky() {
      return header.isElementPresent();
    }
}