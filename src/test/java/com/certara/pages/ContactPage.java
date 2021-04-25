package com.certara.pages;

import com.certara.utilities.Driver;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

import java.util.List;

public class ContactPage extends BasePage{

    @FindBy(css = ".banner-content")
    public WebElement bannerTitle;

    @FindBy(id = "FirstName")
    public WebElement firstNameBox;

    @FindBy(id = "LastName")
    public WebElement lastNameBox;

    @FindBy(id = "Email")
    public WebElement emailBox;

    @FindBy(id = "Company")
    public WebElement companyBox;

    @FindBy(id = "Area_of_Interest__c")
    public WebElement topicOfInterestButton;

    @FindBy(xpath = "//select[@id='Area_of_Interest__c']/option")
    public List<WebElement> interestOptions;

    @FindBy(id = "commentCapture")
    public WebElement messageBox;

    @FindBy(id = "optIn")
    public WebElement subscribeToUpdatesCheckbox;

    @FindBy(xpath = "//button[text()='Contact Us']")
    public WebElement contactUsButton;

    @FindBy(xpath = "//*[text()='Thank You!']")
    public WebElement contactSuccessMessage;


    public void fillOutTheFormWithValidCredentials(){
        firstNameBox.sendKeys("John");
        lastNameBox.sendKeys("Nash");
        emailBox.sendKeys("johnnash@yahoo.com");
        companyBox.sendKeys("JohnNashLTD");
        selectInterestArea();
        messageBox.sendKeys("I want to need info about covid vaccine");
        subscribeToUpdatesCheckbox.click();
    }

    public void selectInterestArea(){
        topicOfInterestButton.click();
       interestOptions.get(2).click();
    }

    public void fillOutTheFormWithInValidCredentials(String firstName, String lastName, String emailAddress, String organization, String topicOfInterest){

        firstNameBox.sendKeys(firstName);
        lastNameBox.sendKeys(lastName);
        emailBox.sendKeys(emailAddress);
        companyBox.sendKeys(organization);
        if(topicOfInterest.length()>0){
            selectInterestArea();
        }
    }

    public boolean verifyErrormessage(String expectedErrormessage){

        boolean flag;
        String locator = "//*[contains(text(),'"+expectedErrormessage+"')]";
        try{
            WebElement element = Driver.get().findElement(By.xpath(locator));
            flag=true;
        }catch (Exception e){
            flag = false;
        }
        return flag;
    }





}
