package com.solvd.carina.demo.gui.pages.navigation;

import com.zebrunner.carina.webdriver.decorator.ExtendedWebElement;
import com.zebrunner.carina.webdriver.gui.AbstractUIObject;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.FindBy;

import java.util.List;

public class NavigationPage extends AbstractUIObject {

    @FindBy(xpath = "//nav[@aria-label='Navigation']//label[@for='__drawer']")
    private ExtendedWebElement carinaHeading;

    @FindBy(xpath = "//nav[@aria-label='Navigation']")
    private List<ExtendedWebElement> navigationMenu;

    @FindBy(xpath = "//nav[@aria-label='Navigation']/*")
    List<ExtendedWebElement> navigationBarNestedTags;

    @FindBy(xpath = "//nav[@aria-label='Navigation']//a")
    List<ExtendedWebElement> navLinksList;

    @FindBy(xpath = "//li[contains(@class,'md-nav__item md-nav__item--nested')]")
    List<ExtendedWebElement> parentNavElement;

    @FindBy(xpath = "//li[@class='md-nav__item md-nav__item--nested']//a")
    List<ExtendedWebElement> hiddenElements;

    public boolean isCarinaHeadingFirstElement() {
        if (navigationBarNestedTags.size() > 0) {
            return navigationBarNestedTags.get(0).getText().equals(carinaHeading.getText());
        }
        return false;
    }

    public boolean isNavigationLinkPresent() {
        for (ExtendedWebElement linkElements : navigationMenu) {
            if (linkElements.isElementPresent()) {
                return true;
            }
        }
        return false;
    }

    public boolean isCurrentPageLinkHighlighted() {
        for (ExtendedWebElement link : navLinksList) {
            if (link.getText().equals("Overview")) {
                String classes = link.getAttribute("class");
                if (classes.contains("active")) {
                    return true;
                }
            }
        }
        return false;
    }

    public boolean areHiddenElementsDisplayed() {
        for (ExtendedWebElement element : hiddenElements) {
            if (element.isElementPresent() && element.isVisible()) {
                return false;
            }
        }
        return true;
    }


    public boolean areSubPageLinksRevealedAfterClickingParent() {
        for (ExtendedWebElement parentNavElement : parentNavElement) {
              parentNavElement.click();
            }
            for (ExtendedWebElement hiddenElement : hiddenElements) {
                if (!hiddenElement.isElementPresent()) {
                    return false;
                }
            }
        return true;
    }

    public NavigationPage(WebDriver driver) {
        super(driver);
    }
}
