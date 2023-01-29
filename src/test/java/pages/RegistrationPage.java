package pages;

    import org.openqa.selenium.WebElement;
    import org.openqa.selenium.support.FindBy;
    import org.openqa.selenium.support.PageFactory;
    import utilities.Driver;

    public class RegistrationPage {
        public RegistrationPage() {
            PageFactory.initElements(Driver.getDriver(), this);
        }
        @FindBy(xpath = "//*[@data-icon='user']")
        public WebElement accountIcon;

        @FindBy(xpath = "//span[.='Register']")
        public WebElement registerButton;
        @FindBy(id = "register-submit")
        public WebElement registerButton2;

        @FindBy(id = "register-title")
        public WebElement registrationPageTitle;

        @FindBy(xpath = "//*[@id='ssn']")
        public WebElement ssnBox;

        @FindBy(xpath = "//*[text()='Please enter your social security number.']")
        public WebElement ssnBoxEmptyAlertText;

        @FindBy(xpath = "//*[text()='Ssn is invalid.']")
        public WebElement ssnInvalidAlertText;

        @FindBy(xpath = "//*[@id='firstname']")
        public WebElement firstNameBox;

        @FindBy(xpath = "//*[text()='Please enter your first name.']")
        public WebElement firstNameBoxEmptyAlertText;



        @FindBy(xpath = "//*[@id='lastname']")
        public WebElement lastNameBox;

        @FindBy(xpath = "//*[text()='Please enter your last name.']")
        public WebElement lastNameBoxEmptyAlertText;

        @FindBy(xpath = "//*[@id='address']")
        public WebElement addressBox;

        @FindBy(xpath = "//*[text()='Please enter your address.']")
        public WebElement addressBoxEmptyAlertText;
        @FindBy(id = "username")
        public WebElement userNameBox;

        @FindBy(xpath = "//*[@id='mobilephone']")
        public WebElement mobilePhoneBox;

        @FindBy(xpath = "//*[text()='Please enter your mobile phone number.']")
        public WebElement mobilePhoneEmptyAlertText;

        @FindBy(xpath = "//*[text()='Your mobile phone number is invalid.']")
        public WebElement mobilePhoneNumberInvalidAlertText;

        @FindBy(xpath = "//*[@id='email']")
        public WebElement emailBox;

        @FindBy(xpath = "//*[text()='Please enter your email.']")
        public WebElement emailBoxEmptyAlertText;

        @FindBy(xpath = "//*[text()='Your email is invalid.']")
        public WebElement emailInvalidAlertText;
        @FindBy(id = "firstPassword")
        public WebElement firstPasswordBox;
        @FindBy(id = "secondPassword")
        public WebElement secondPasswordBox;

        @FindBy(xpath = "//div[@class='alert alert-warning fade show']")
        public WebElement defaultCredentialsAlert;



}
