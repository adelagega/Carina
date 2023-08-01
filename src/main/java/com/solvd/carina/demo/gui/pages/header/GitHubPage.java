package com.solvd.carina.demo.gui.pages.header;

import com.zebrunner.carina.webdriver.gui.AbstractPage;
import org.openqa.selenium.WebDriver;

public class GitHubPage extends AbstractPage {
    public GitHubPage(WebDriver driver) {
        super(driver);
    }

    public String getCurrentUrl() {
        return getDriver().getCurrentUrl();
    }
}
