package com.certara.pages;

import com.certara.utilities.BrowserUtils;
import com.certara.utilities.ConfigurationReader;
import com.certara.utilities.Driver;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;


public abstract class BasePage {

    @FindBy(id = "onetrust-accept-btn-handler")
    public WebElement acceptCookies;

    @FindBy(xpath = "//iframe[@name='_hjRemoteVarsFrame']")
    public WebElement settingsFrame;

    @FindBy(xpath = "//div[text()='Allow All']")
    public WebElement allowAllButton;

    public BasePage(){
        PageFactory.initElements(Driver.get(),this);
    }

    public void openCertaraWebPage(){
        Driver.get().get(ConfigurationReader.get("url"));
    }

    public String getPageTitle() {
        return Driver.get().getTitle();
    }

    public void navigateToModule(String module) {
        String moduleLocator="//a[contains(text(),'"+module+"')]";

        try {
            BrowserUtils.waitForPresenceOfElement(By.xpath(moduleLocator), 5);
            BrowserUtils.waitForVisibility(By.xpath(moduleLocator), 5);
            BrowserUtils.scrollToElement(Driver.get().findElement(By.xpath(moduleLocator)));
            Driver.get().findElement(By.xpath(moduleLocator)).click();
        } catch (Exception e) {
//            BrowserUtils.waitForStaleElement(Driver.get().findElement(By.xpath(moduleLocator)));
            BrowserUtils.clickWithTimeOut(Driver.get().findElement(By.xpath(moduleLocator)),  5);
        }
    }


}
