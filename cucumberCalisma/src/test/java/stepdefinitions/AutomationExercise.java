package stepdefinitions;

import com.github.javafaker.Faker;
import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import org.junit.Assert;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.Select;
import pages.AutomationExercisePage;
import utilities.ConfigReader;
import utilities.Driver;

public class AutomationExercise {

    AutomationExercisePage automationPage = new AutomationExercisePage();
    Select select;

    @Given("Launch browser")
    public void launchBrowser() {
        Driver.getDriver();
    }

    @Then("Navigate to url {string}")
    public void navigateToUrlHttpAutomationexerciseCom(String url) {
        Driver.getDriver().get(ConfigReader.getProperty(url));
    }//

    @And("Verify that home page is visible successfully")
    public void verifyThatHomePageIsVisibleSuccessfully() {
        String actualUrl=Driver.getDriver().getCurrentUrl();
        String expectedUrl="https://automationexercise.com/";
        Assert.assertEquals(actualUrl,expectedUrl);
    }

    @And("Click on Signup  Login button")
    public void clickOnSignupLoginButton() {
        automationPage.anasayfaLoginButton.click();
    }

    @And("Verify Login to your account is visible")
    public void verifyLoginToYourAccountIsVisible() {
        WebElement loginYourAccount = automationPage.loginToYourAccountText;
        Assert.assertTrue(loginYourAccount.isDisplayed());
    }

    @And("Enter correct email address and password")
    public void enterCorrectEmailAddressAndPassword() {
        automationPage.loginEmailBox.sendKeys(ConfigReader.getProperty("Email"));
        automationPage.loginPasswordBox.sendKeys(ConfigReader.getProperty("Password"));
    }

    @And("Click login button")
    public void clickLoginButton() {
        automationPage.loginButton.click();

    }

    @And("Verify that Logged in as username is visible")
    public void verifyThatLoggedInAsUsernameIsVisible() {
        WebElement loggedUsername = automationPage.loggedInAsUsernameText;
        Assert.assertTrue(loggedUsername.isDisplayed());
    }

    @And("Click Logout button")
    public void clickLogoutButton() {
        automationPage.logOutButton.click();
    }


    @And("Verify that user is navigated to login page")
    public void verifyThatUserIsNavigatedToLoginPage() {
        String expectedUrl ="https://automationexercise.com/login";
        String actualurl = Driver.getDriver().getCurrentUrl();
        Assert.assertEquals(expectedUrl,actualurl);
    }


    @And("Kullanici tarayiciyi kapatir")
    public void kullaniciTarayiciyiKapatir() {
        Driver.closeDriver();
    }

    @And("Verify New User Signup! is visible")
    public void verifyNewUserSignupIsVisible() {
        WebElement verifyNewUser= automationPage.verifyNewUserSignupText;
        Assert.assertTrue(verifyNewUser.isDisplayed());
    }

    @And("Enter name and email address")
    public void enterNameAndEmailAddress() {
        automationPage.newUserNameBox.sendKeys(Faker.instance().name().firstName());
        automationPage.newUserEmailBox.sendKeys(Faker.instance().internet().emailAddress());
    }

    @And("Click Signup button")
    public void clickSignupButton() {
        automationPage.newUserSignInButton.click();

    }

    @And("Verify that ENTER ACCOUNT INFORMATION is visible")
    public void verifyThatENTERACCOUNTINFORMATIONIsVisible() {
        WebElement accountInformation = automationPage.enterAccountInformationText;
        Assert.assertTrue(accountInformation.isDisplayed());
    }

    @And("Fill details: Title, Name, Email, Password, Date of birth")
    public void fillDetailsTitleNameEmailPasswordDateOfBirth() {
        automationPage.mrRadioButton.click();
        automationPage.newUserPasswordCreate.sendKeys(Faker.instance().internet().password());
        select =new Select(automationPage.newUserCreateDaysDropDown);
        select.selectByIndex(Faker.instance().random().nextInt(1,31));
        select =new Select(automationPage.newUserCreateMontsDropDown);
        select.selectByIndex(Faker.instance().random().nextInt(1,12));
        select =new Select(automationPage.newUserCreateYearsDropDown);
        select.selectByIndex(Faker.instance().random().nextInt(17,66));
    }

    @And("Select checkbox Sign up for our newsletter!")
    public void selectCheckboxSignUpForOurNewsletter() {
        automationPage.newsletterCheckBox.click();
    }

    @And("Select checkbox Receive special offers from our partners!")
    public void selectCheckboxReceiveSpecialOffersFromOurPartners() {
        automationPage.checkboxReceivespecialBox.click();
    }

    @And("Fill details: First name, Last name, Company, Address, Address, Country, State, City, Zipcode, Mobile Number")
    public void fillDetailsFirstNameLastNameCompanyAddressAddressCountryStateCityZipcodeMobileNumber() {
        automationPage.addressInformationFirstNamebox.sendKeys(Faker.instance().name().firstName());
        automationPage.addressInformationLastNamebox.sendKeys(Faker.instance().name().lastName());
        automationPage.addressInformationCompanybox.sendKeys(Faker.instance().animal().name());
        String address = Faker.instance().address().fullAddress();
        automationPage.addressInformationAddress1box.sendKeys(address);
        automationPage.addressInformationAddress2box.sendKeys(address);
        select =new Select(automationPage.addressinformationcountrydropDown);
        select.selectByIndex(Faker.instance().random().nextInt(0,6));
        automationPage.addressInformationStateBox.sendKeys(Faker.instance().address().state());
        automationPage.addressInformationCityBox.sendKeys(Faker.instance().address().city());
        automationPage.addressInformationZipCodeBox.sendKeys(Faker.instance().address().zipCode());
        automationPage.addressInformationMobilenumberBox.sendKeys(Faker.instance().phoneNumber().cellPhone());

    }

    @And("Click Create Account button")
    public void clickCreateAccountButton() {
        automationPage.createAccountButton.click();
    }

    @And("Verify that ACCOUNT CREATED! is visible")
    public void verifyThatACCOUNTCREATEDIsVisible() {
        WebElement accountCreated = automationPage.accountCreatedText;
        Assert.assertTrue(accountCreated.isDisplayed());
    }

    @And("Click Continue button")
    public void clickContinueButton() {
        automationPage.accountCreatedContinueButton.click();
    }

    @And("Click Delete Account button")
    public void clickDeleteAccountButton() {
        automationPage.deleteAccountButton.click();
    }

    @And("Verify that ACCOUNT DELETED! is visible and click Continue button")
    public void verifyThatACCOUNTDELETEDIsVisibleAndClickContinueButton() {
    }
}
