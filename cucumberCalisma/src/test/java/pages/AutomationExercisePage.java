package pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import utilities.Driver;

// https://www.automationexercise.com/
public class AutomationExercisePage {

    public AutomationExercisePage() {
        PageFactory.initElements(Driver.getDriver(), this);
    }



    @FindBy(xpath = "//a[normalize-space()='Signup / Login']")
    public WebElement anasayfaLoginButton;

    @FindBy(xpath = "//input[@data-qa='login-email']")
    public WebElement loginEmailBox;

    @FindBy(xpath = "//input[@placeholder='Password']")
    public WebElement loginPasswordBox;

    @FindBy(xpath = "//button[@data-qa='login-button']")
    public WebElement loginButton;

    @FindBy(xpath = "//input[@placeholder='Name']")
    public WebElement newUserNameBox;

    @FindBy(xpath = "//input[@data-qa='signup-email']")
    public WebElement newUserEmailBox;

    @FindBy(xpath = "//button[@data-qa='signup-button']")
    public WebElement newUserSignInButton;

    @FindBy(xpath = "//a[normalize-space()='Home']")
    public WebElement homeButton;

    @FindBy(xpath = "//a[@href='/products']")
    public WebElement productsButton;

    @FindBy(xpath = "//body[1]/header[1]/div[1]/div[1]/div[1]/div[2]/div[1]/ul[1]/li[3]/a[1]")
    public WebElement sepeteGitButton;

    @FindBy(xpath = "//a[normalize-space()='Logout']")
    public WebElement logOutButton;

    @FindBy(xpath = "//a[normalize-space()='Delete Account']")
    public WebElement deleteAccountButton;

    @FindBy(xpath = "//li[9]//a[1]")
    public WebElement loginVerifyText;

    @FindBy(xpath = "//input[@id='search_product']")
    public WebElement searchProductInput;

    @FindBy(xpath = "//button[@id='submit_search']")
    public WebElement searchProductSubmit;

    @FindBy(xpath = "//button[normalize-space()='Continue Shopping']")
    public WebElement continueShoppingButton;

    @FindBy(xpath = "//a[normalize-space()='Proceed To Checkout']")
    public WebElement proceedToCheckOutButton;

    @FindBy(xpath = "//a[normalize-space()='Place Order']")
    public WebElement placeOrderButton;

    @FindBy(xpath = "//input[@name='name_on_card']")
    public WebElement nameOfCardInput;

    @FindBy(xpath = "//input[@name='card_number']")
    public WebElement cardNumberInput;

    @FindBy(xpath = "//input[@placeholder='ex. 311']")
    public WebElement cvcNumberInput;

    @FindBy(xpath = "//input[@placeholder='MM']")
    public WebElement expirationDateMM;

    @FindBy(xpath = "//input[@placeholder='YYYY']")
    public WebElement expirationYear;

    @FindBy(xpath = "//button[@id='submit']")
    public WebElement payAndConfirmOrderButton;

    @FindBy(xpath = "//p[normalize-space()='Congratulations! Your order has been confirmed!']")
    public WebElement YourOrderHasBeenConfirmedText;

    @FindBy(xpath = "//a[normalize-space()='Continue']")
    public WebElement continueButton;

    @FindBy(xpath = "//h2[normalize-space()='Login to your account']")
    public WebElement loginToYourAccountText;

    @FindBy(xpath = "//li[9]//a[1]")
    public WebElement loggedInAsUsernameText;

    @FindBy(xpath = "//h2[normalize-space()='New User Signup!']")
    public WebElement verifyNewUserSignupText;

    @FindBy(xpath = "//b[normalize-space()='Enter Account Information']")
    public WebElement enterAccountInformationText;

    @FindBy(xpath = "//input[@id='id_gender1']")
    public WebElement mrRadioButton;

    @FindBy(xpath = "//input[@id='id_gender2']")
    public WebElement mrsRadioButton;

    @FindBy(xpath = "//input[@id='password']")
    public WebElement newUserPasswordCreate;

    @FindBy(xpath = "//select[@id='days']")
    public WebElement newUserCreateDaysDropDown;

    @FindBy(xpath = "//select[@id='months']")
    public WebElement newUserCreateMontsDropDown;

    @FindBy(xpath = "//select[@id='years']")
    public WebElement newUserCreateYearsDropDown;

    @FindBy(xpath = "//input[@id='first_name']")
    public WebElement addressInformationFirstNamebox;

    @FindBy(xpath = "//input[@id='last_name']")
    public WebElement addressInformationLastNamebox;

    @FindBy(xpath = "//input[@id='company']")
    public WebElement addressInformationCompanybox;

    @FindBy(xpath = "//input[@id='address1']")
    public WebElement addressInformationAddress1box;

    @FindBy(xpath = "//input[@id='address2']")
    public WebElement addressInformationAddress2box;

    @FindBy(xpath = "//select[@id='country']")
    public WebElement addressinformationcountrydropDown;

    @FindBy(xpath = "//input[@id='state']")
    public WebElement addressInformationStateBox;

    @FindBy(xpath = "//input[@id='city']")
    public WebElement addressInformationCityBox;

    @FindBy(xpath = "//input[@id='zipcode']")
    public WebElement addressInformationZipCodeBox;

    @FindBy(xpath = "//input[@id='mobile_number']")
    public WebElement addressInformationMobilenumberBox;

    @FindBy(xpath = "//button[normalize-space()='Create Account']")
    public WebElement createAccountButton;

    @FindBy(xpath = "//input[@id='newsletter']")
    public WebElement newsletterCheckBox;

    @FindBy(xpath = "//input[@id='optin']")
    public WebElement checkboxReceivespecialBox;

    @FindBy(xpath = "//b[normalize-space()='Account Created!']")
    public WebElement accountCreatedText;

    @FindBy(xpath = "//a[normalize-space()='Continue']")
    public WebElement accountCreatedContinueButton;













}