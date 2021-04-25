package com.certara.step_definitions;

import com.certara.utilities.BrowserUtils;
import com.certara.utilities.Driver;
import com.certara.utilities.Pages;
import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import org.junit.Assert;

public class ContactPageStepDefs {

    Pages pages = new Pages();

    @Given("I open the certara website")
    public void i_open_the_certara_website() {
        pages.contactPages().openCertaraWebPage();
        pages.contactPages().acceptCookies.click();
        BrowserUtils.waitForPageToLoad(10);
        pages.contactPages().allowAllButton.click();

    }


    @Then("I navigate to {string} page")
    public void i_navigate_to_page(String module) {
        pages.contactPages().navigateToModule(module);

    }
    @Then("I verify {string} is displayed")
    public void i_verify_is_displayed(String expectedBanner) {
        BrowserUtils.waitForVisibility(pages.contactPages().bannerTitle,10);
        String actualBanner = pages.contactPages().bannerTitle.getText();

        Assert.assertEquals("verify banner", expectedBanner,actualBanner);
    }
    @Then("I fill out the form with valid credentials")
    public void i_fill_out_the_form_with_valid_credentials() {
        pages.contactPages().fillOutTheFormWithValidCredentials();
    }

    @And("I click Contact Us button")
    public void iClickContactUsButton() {
        pages.contactPages().contactUsButton.click();
    }

    @Then("I verify {string} message is displayed")
    public void iVerifyMessageIsDisplayed(String expectedMessage) {

        BrowserUtils.waitForVisibility(pages.contactPages().contactSuccessMessage,10);
        String actualMessage = pages.contactPages().contactSuccessMessage.getText();

        Assert.assertEquals("verify contact success message", expectedMessage,actualMessage);
    }

    @Then("I fill out the form with below informations {string}, {string}, {string}, {string} {string}")
    public void iFillOutTheFormWithBelowInformations(String firstName, String lastName, String emailAddress, String organization, String topicOfInterest) {

        pages.contactPages().fillOutTheFormWithInValidCredentials(firstName,lastName,emailAddress,organization,topicOfInterest);

    }

    @Then("I verify related {string} is displayed")
    public void iVerifyRelatedIsDisplayed(String errorMessage) {

        Assert.assertTrue(pages.contactPages().verifyErrormessage(errorMessage));
    }
}
