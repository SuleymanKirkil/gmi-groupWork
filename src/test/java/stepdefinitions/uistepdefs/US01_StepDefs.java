package stepdefinitions.uistepdefs;

import com.github.javafaker.Faker;
import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.junit.Assert;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebElement;
import org.openxmlformats.schemas.wordprocessingml.x2006.main.impl.HdrDocumentImpl;
import org.testng.asserts.SoftAssert;
import pages.RegistrationPage;
import utilities.Driver;
import utilities.JSUtils;
import utilities.ReusableMethods;

import java.security.Key;
import java.util.List;
import java.util.Map;

public class US01_StepDefs {

    RegistrationPage registrationPage = new RegistrationPage();
    Faker faker=new Faker();
    String fakeFirstName;
    String Lastname;
    String Address;
    String PhoneNumber;
    String Email;
    String password;
    SoftAssert softAssert=new SoftAssert();


    @Given("User goes to Url")
    public void userGoesToUrl() {
        Driver.getDriver().get("https://www.gmibank.com/");
    }

    @Given("User clicks Register Button")
    public void user_clicks_register_button() {
        registrationPage.accountIcon.click();
        registrationPage.registerButton.click();
        //Driver.wait(3);
    }

    @Then("User verifies Registration Page")
    public void userVerifiesRegistrationPage() {
        Assert.assertTrue("Registration", registrationPage.registrationPageTitle.isDisplayed());
    }

    @Given("User clicks SSN Box and clicks next box")
    public void user_clicks_ssn_box_and_clicks_next_box() {
        registrationPage.ssnBox.click();
        registrationPage.firstNameBox.click();
        Driver.wait(3);
    }

    @Then("User verifies {string} message is displayed")
    public void user_verifies_message_is_displayed(String message) {

        switch (message) {
            case "Please enter your social security number.":
                Assert.assertEquals(message, registrationPage.ssnBoxEmptyAlertText.getText());
                ReusableMethods.waitFor(3);
                break;
            case "Ssn is invalid.":
                Assert.assertEquals(message, registrationPage.ssnInvalidAlertText.getText());
                ReusableMethods.waitFor(3);
                break;
            case "Please enter your first name.":
                Assert.assertEquals(message,registrationPage.firstNameBoxEmptyAlertText.getText());
                break;
            case "Your first name is invalid":
                softAssert.assertEquals(registrationPage.firstNameBox.getAttribute("value"),"*");
               // softAssert.assertAll();
                break;
            case "Please enter your last name.":
                softAssert.assertEquals("Please enter your last name.",registrationPage.lastNameBoxEmptyAlertText.getText());
                softAssert.assertAll();
                break;
            case "Your last name is invalid":
                softAssert.assertEquals(Lastname,registrationPage.lastNameBox.getAttribute("value"));
                softAssert.assertAll();
                break;
            case "Please enter your address.":
                softAssert.assertEquals("Please enter your address.",registrationPage.addressBoxEmptyAlertText.getText());
                softAssert.assertAll();
                break;
            case "Your address is invalid":
                softAssert.assertEquals(Address,registrationPage.addressBox.getAttribute("value"));
                softAssert.assertAll();
                break;
            case "Please enter your mobile phone number.":

                break;

            case "Your mobile phone number is invalid.":

                break;
            case "Please enter your email.":
                softAssert.assertEquals("Please enter your email.",registrationPage.emailBoxEmptyAlertText.getText());
               softAssert.assertAll();
                break;
            case "Your email is invalid.":
                softAssert.assertEquals("Your email is invalid.",registrationPage.emailInvalidAlertText.getText());
                softAssert.assertAll();
                break;
            default:
                break;
        }

    }

    @Then("User verifies that {string} message is displaced for below values")
    public void user_verifies_that_message_is_displaced_for_below_invalid_names(String message, io.cucumber.datatable.DataTable namesTable) {
        List<Map<String,String>> invalidNames = namesTable.asMaps(String.class,String.class);
        switch (message) {
            case "Please enter your social security number.":

                Assert.assertEquals(message, registrationPage.ssnBoxEmptyAlertText.getText());
                break;
            case "Ssn is invalid.":
                Assert.assertEquals(message, registrationPage.ssnInvalidAlertText.getText());
                ReusableMethods.waitFor(3);
                break;
            case "Please enter your first name.":
                Assert.assertEquals(message,registrationPage.firstNameBoxEmptyAlertText.getText());
                break;
            case "Your first name is invalid":
        for (Map<String,String> names:invalidNames){
                registrationPage.firstNameBox.clear();
                registrationPage.firstNameBox.sendKeys(names.get("invalid names"));
                softAssert.assertEquals(registrationPage.firstNameBox.getAttribute("value"),names.get("invalid names"));
                softAssert.assertAll();}
                break;
            case "Please enter your last name.":

                break;
            case "Your last name is invalid":
                for (Map<String,String> names:invalidNames) {
                    registrationPage.lastNameBox.clear();
                    registrationPage.lastNameBox.sendKeys(names.get("invalid lastnames"));
                    softAssert.assertEquals(registrationPage.lastNameBox.getAttribute("value"),names.get("invalid lastnames"));
                    softAssert.assertAll();
                }
                break;
            case "Please enter your address.":

                break;
            case "Your address is invalid":

                break;
            case "Please enter your mobile phone number.":

                break;

            case "Your mobile phone number is invalid.":

                break;
            case "Please enter your email.":

                break;
            case "Your email is invalid.":

                break;
            default:
                break;
        }
    }

    @Given("User enters {int} digit SSN in the SSN Box without {string} and clicks next box")
    public void user_enters_digit_ssn_in_the_ssn_box_without_and_clicks_next_box(Integer int1, String string) {
        registrationPage.ssnBox.click();
        registrationPage.ssnBox.sendKeys("123456789");
        //Driver.wait(3);
    }

    @Then("User verifies system put {string} between digits automatically")
    public void user_verifies_system_put_between_digits_automatically(String string) {
        String ssnId = registrationPage.ssnBox.getAttribute("value");
        Assert.assertEquals("123-45-6789", ssnId);
        //Driver.wait(3);
    }

    @When("User enters {int} digit SSN in the SSN Box and clicks next box")
    public void user_enters_digit_ssn_in_the_ssn_box_and_clicks_next_box(Integer int1) {
        registrationPage.ssnBox.clear();
        //Driver.wait(3);
        registrationPage.ssnBox.sendKeys("12345678");
        registrationPage.firstNameBox.click();

    }

    @Then("User verifies {string} message is displayed under SSN Box")
    public void user_verifies_message_is_displayed_under_ssn_box(String string) {
        Assert.assertTrue(registrationPage.ssnInvalidAlertText.isDisplayed());
    }

    @When("User enters on digit SSN in the SSN Box and clicks next box")
    public void userEntersOnDigitSSNInTheSSNBoxAndClicksNextBox() {
        registrationPage.ssnBox.clear();
        //Driver.wait(3);
        registrationPage.ssnBox.sendKeys("1234567890");
        registrationPage.firstNameBox.click();
    }

    @Then("User verifies system doesn't accept {int}. digit")
    public void user_verifies_system_doesn_t_accept_digit(Integer int1) {
        String ssnId = registrationPage.ssnBox.getAttribute("value");
        ssnId = ssnId.replace("-", "");
        System.out.println("ssnId Length:" + ssnId.length());
        Assert.assertEquals(9, ssnId.length());
        //Driver.wait(3);

    }

    @When("User enters only char in the SSN Box and clicks next box")
    public void user_enters_only_char_in_the_ssn_box_and_clicks_next_box() {
        registrationPage.ssnBox.clear();
        //Driver.wait(3);
        registrationPage.ssnBox.sendKeys("aaaaaaaaa");
        registrationPage.ssnBox.click();
    }

    @Then("User verifies system doesn't accept any char")
    public void user_verifies_system_doesn_t_accept_any_char() {
        Driver.wait(3);
        Assert.assertTrue(registrationPage.ssnBox.getAttribute("value").equals("a"));
    }

    @When("User enters only symbols in the SSN Box and clicks next box")
    public void user_enters_only_symbols_in_the_ssn_box_and_clicks_next_box() {
        registrationPage.ssnBox.clear();
        Driver.wait(3);
        registrationPage.ssnBox.sendKeys(".*??????!");
        registrationPage.ssnBox.click();
    }

    @Then("User verifies system doesn't accept any sepacial character")
    public void user_verifies_system_doesn_t_accept_any_sepacial_character() {
       // Assert.assertTrue(registrationPage.ssnBox.getAttribute("value").isEmpty());
    }

    @When("User enters a valid SSN in the SSN Box and clicks next box")
    public void user_enters_a_valid_ssn_in_the_ssn_box_and_clicks_next_box() {
        registrationPage.ssnBox.clear();
        Driver.wait(3);
        registrationPage.ssnBox.sendKeys("345-67-6788");
        //registrationPage.ssnBox.click();
    }

    @When("User enters valid SSN in the SSN Box and clicks next box")
    public void user_enters_valid_ssn_in_the_ssn_box_and_clicks_next_box(io.cucumber.datatable.DataTable credentials) {
        List<Map<String, String>> customerCredentials = credentials.asMaps(String.class, String.class);

        for (Map<String, String> each : customerCredentials) {
            registrationPage.ssnBox.clear();
            registrationPage.ssnBox.sendKeys(each.get("valid SSN"));
            registrationPage.firstNameBox.click();
        }
    }

    @When("User enters invalid SSN in the SSN Box and clicks next box")
    public void user_enters_invalid_ssn_in_the_ssn_box_and_clicks_next_box(io.cucumber.datatable.DataTable credentials) {
        List<Map<String, String>> customerCredentials = credentials.asMaps(String.class, String.class);

        for (Map<String, String> each : customerCredentials) {
            registrationPage.ssnBox.clear();
            registrationPage.ssnBox.sendKeys(each.get("Invalid SSN"));
            Assert.assertTrue(registrationPage.ssnInvalidAlertText.getText().contains("invalid"));
            registrationPage.firstNameBox.click();
        }
    }


    @Then("User verifies any error message is not displayed")
    public void user_verifies_any_error_message_is_not_displayed() {
    Assert.assertEquals(registrationPage.firstNameBox.getAttribute("value"),fakeFirstName);

    }
    @Then("User verifies any error message is not displayed for lastname")
    public void user_verifies_any_error_message_is_not_displayed_for_lastname() {
        Assert.assertEquals(registrationPage.lastNameBox.getAttribute("value"),Lastname);
    }


    @When("User enters only symbols in the First Name Box and clicks next box")
    public void user_enters_only_symbols_in_the_first_name_box_and_clicks_next_box() {
        registrationPage.firstNameBox.sendKeys("*");
        registrationPage.lastNameBox.click();
    }

    @Then("User verifies {string} message is displayed invalid FirstName")
    public void userVerifiesMessageIsDisplayedInvalidFirstName(String message) {
        softAssert.assertEquals(registrationPage.firstNameBox.getAttribute("value"),"*");
        softAssert.assertAll();
    }

    @Then("User clicks First Name Box and clicks next box")
    public void user_clicks_first_name_box_and_clicks_next_box() {
        registrationPage.firstNameBox.click();
        registrationPage.lastNameBox.click();
    }

    @Then("User verifies {string} message is displayed in firstName")
    public void user_verifies_message_is_displayed_in_first_name(String message) {

       Assert.assertEquals(message,registrationPage.firstNameBoxEmptyAlertText.getText());
    }

    @Then("User clicks Last Name Box and clicks next box")
    public void user_clicks_last_name_box_and_clicks_next_box() {
    registrationPage.lastNameBox.click();
    registrationPage.addressBox.click();

    }

    @Then("User clicks Address Box and clicks next box")
    public void user_clicks_address_box_and_clicks_next_box() {
    registrationPage.addressBox.click();
    registrationPage.emailBox.click();
    }


    @When("User enters only digital numbers in First Name Box and clicks next box")
    public void user_enters_only_digital_numbers_in_first_name_box_and_clicks_next_box() {

    }

    @When("User enters chars with digital numbers and clicks next box")
    public void user_enters_chars_with_digital_numbers_and_clicks_next_box() {
        Lastname = "sevgi37";
        registrationPage.lastNameBox.clear();
        registrationPage.lastNameBox.sendKeys(Lastname);
        registrationPage.addressBox.click();
    }

    @When("User enters a valid First Name in First Name Box and clicks next box")
    public void user_enters_a_valid_first_name_in_first_name_box_and_clicks_next_box() {
        registrationPage.firstNameBox.clear();
        fakeFirstName = faker.name().firstName();
        registrationPage.firstNameBox.sendKeys(fakeFirstName);

    }

    @When("User enters only symbols in the Last Name Box and clicks next box")
    public void user_enters_only_symbols_in_the_last_name_box_and_clicks_next_box() {
        Lastname = "**/?";
        registrationPage.lastNameBox.clear();
        registrationPage.lastNameBox.sendKeys(Lastname);
        registrationPage.addressBox.click();

    }

    @When("User enters only digital numbers in Last Name Box and clicks next box.")
    public void user_enters_only_digital_numbers_in_last_name_box_and_clicks_next_box() {
        Lastname = "12363";
        registrationPage.lastNameBox.clear();
        registrationPage.lastNameBox.sendKeys(Lastname);
        registrationPage.addressBox.click();
    }

    @When("User enters a valid Last Name in Last Name Box and clicks next box")
    public void user_enters_a_valid_last_name_in_last_name_box_and_clicks_next_box() {
        Lastname = "Karaca";
        registrationPage.lastNameBox.clear();
        registrationPage.lastNameBox.sendKeys(Lastname);
        registrationPage.addressBox.click();
    }

    @When("User enters only symbols in the Address Box and clicks next box")
    public void user_enters_only_symbols_in_the_address_box_and_clicks_next_box() {
    Address = "***???? //";
    registrationPage.addressBox.clear();
    registrationPage.addressBox.sendKeys(Address);
    registrationPage.emailBox.click();
    }

    @When("User enters a valid Address in Address Box and clicks next box")
    public void user_enters_a_valid_address_in_address_box_and_clicks_next_box() {
        Address = "Tarsus m. Çarşı s. No:9";
        registrationPage.addressBox.clear();
        registrationPage.addressBox.sendKeys(Address);
        registrationPage.emailBox.click();
    }

    @Then("User verifies any error message is not displayed in address box")
    public void user_verifies_any_error_message_is_not_displayed_in_address_box() {
      Assert.assertEquals(Address,registrationPage.addressBox.getAttribute("value"));
    }


    @When("User enters only char in the  Mobilephone Number Box and clicks next box")
    public void user_enters_only_char_in_the_mobilephone_number_box_and_clicks_next_box() {
    PhoneNumber= "alim";
    registrationPage.mobilePhoneBox.clear();
    registrationPage.mobilePhoneBox.sendKeys(PhoneNumber);
    registrationPage.emailBox.click();
    }

    @Then("User verifies system doesn't accept any char in the Mobilephone Number Box")
    public void user_verifies_system_doesn_t_accept_any_char_in_the_mobilephone_number_box() {
    Assert.assertNotEquals(PhoneNumber,registrationPage.mobilePhoneBox.getAttribute("value"));
        Assert.assertEquals("",registrationPage.mobilePhoneBox.getAttribute("value"));
        Assert.assertTrue(registrationPage.mobilePhoneNumberInvalidAlertText.isDisplayed());
    }

    @When("User enters only symbols in the Mobilephone Number Box and clicks next box")
    public void user_enters_only_symbols_in_the_mobilephone_number_box_and_clicks_next_box() {
        PhoneNumber= "**?";
        registrationPage.mobilePhoneBox.clear();
        registrationPage.mobilePhoneBox.sendKeys(PhoneNumber);
        registrationPage.emailBox.click();
    }

    @Then("User verifies system doesn't accept any sepacial character in the Mobilephone Number Box")
    public void user_verifies_system_doesn_t_accept_any_sepacial_character_in_the_mobilephone_number_box() {
        Assert.assertTrue(registrationPage.mobilePhoneNumberInvalidAlertText.isDisplayed());
    }

    @When("User enters a valid Mobilephone Number in the Mobilephone Number Box and clicks next box")
    public void user_enters_a_valid_mobilephone_number_in_the_mobilephone_number_box_and_clicks_next_box() {
    PhoneNumber="5559982323";
    registrationPage.mobilePhoneBox.clear();
    registrationPage.mobilePhoneBox.sendKeys(PhoneNumber);
    registrationPage.emailBox.click();
    }

    @Then("User verifies error message is not displayed")
    public void user_verifies_error_message_is_not_displayed() {
    Assert.assertEquals(PhoneNumber,registrationPage.mobilePhoneBox.getAttribute("value"));
    }

    @When("User clicks Email Box and clicks next box")
    public void user_clicks_email_box_and_clicks_next_box() {
    registrationPage.emailBox.click();
    registrationPage.addressBox.click();
    }

    @When("User enters an email without @ and .com and clicks next box")
    public void user_enters_an_email_without_and_and_clicks_next_box() {
    Email= "slimucuzcu";
    registrationPage.emailBox.clear();
    registrationPage.emailBox.sendKeys(Email);
    registrationPage.addressBox.click();
    }

    @When("User enters an email without @ but with .com and clicks next box")
    public void user_enters_an_email_without_but_with_and_clicks_next_box() {
        Email= "slimucuzcu.com";
        registrationPage.emailBox.clear();
        registrationPage.emailBox.sendKeys(Email);
        registrationPage.addressBox.click();
    }

    @When("User enters an email without .com but @ and clicks next box")
    public void user_enters_an_email_without_but_and_clicks_next_box() {
        Email= "slim@ucuzcu";
        registrationPage.emailBox.clear();
        registrationPage.emailBox.sendKeys(Email);
        registrationPage.addressBox.click();
    }

    @When("User enters a valid email in the email box and clicks next box")
    public void user_enters_a_valid_email_in_the_email_box_and_clicks_next_box() {
        Email= "slim@ucuzcu.com";
        registrationPage.emailBox.clear();
        registrationPage.emailBox.sendKeys(Email);
        registrationPage.addressBox.click();
    }
    @Then("User verifies error message is not displayed in the email box")
    public void user_verifies_error_message_is_not_displayed_in_the_email_box() {
       Assert.assertEquals(Email,registrationPage.emailBox.getAttribute("value"));
    }

    @When("User enters all fields but not SSn box and tries to register")
    public void user_enters_all_fields_but_not_s_sn_box() {
    registrationPage.firstNameBox.sendKeys(faker.name().firstName());
    registrationPage.lastNameBox.sendKeys(faker.name().lastName());
    registrationPage.addressBox.sendKeys(faker.address().fullAddress());
    registrationPage.mobilePhoneBox.sendKeys(faker.phoneNumber().phoneNumber());
    registrationPage.userNameBox.sendKeys(faker.name().username());
    registrationPage.emailBox.sendKeys(faker.internet().emailAddress());
    registrationPage.emailBox.sendKeys(faker.internet().emailAddress());
    password=faker.internet().password(5,15,true);
    registrationPage.firstPasswordBox.sendKeys(password);
    registrationPage.secondPasswordBox.sendKeys(password);
    registrationPage.registerButton2.click();
    }
    @Then("User verifies use default credentials message is displaced")
    public void user_verifies_use_default_credentials_message_is_displaced() {
     Assert.assertTrue(registrationPage.defaultCredentialsAlert.isDisplayed());
    }
    @When("User enters all fields but not Lastname box and tries to register")
    public void user_enters_all_fields_but_not_lastname_box() {
   registrationPage.userNameBox.sendKeys(faker.idNumber().ssnValid());
        registrationPage.firstNameBox.sendKeys(faker.name().firstName());
        registrationPage.addressBox.sendKeys(faker.address().fullAddress());
        registrationPage.mobilePhoneBox.sendKeys(faker.phoneNumber().phoneNumber());
        registrationPage.userNameBox.sendKeys(faker.name().username());
        registrationPage.emailBox.sendKeys(faker.internet().emailAddress());
        registrationPage.emailBox.sendKeys(faker.internet().emailAddress());
        password=faker.internet().password(5,15,true);
        registrationPage.firstPasswordBox.sendKeys(password);
        registrationPage.secondPasswordBox.sendKeys(password);
        registrationPage.registerButton2.click();
    }
    @When("User enters all fields but not Address box tries to register")
    public void user_enters_all_fields_but_not_address_box() {
        registrationPage.userNameBox.sendKeys(faker.idNumber().ssnValid());
        registrationPage.firstNameBox.sendKeys(faker.name().firstName());
        registrationPage.lastNameBox.sendKeys(faker.name().lastName());
        registrationPage.mobilePhoneBox.sendKeys(faker.phoneNumber().phoneNumber());
        registrationPage.userNameBox.sendKeys(faker.name().username());
        registrationPage.emailBox.sendKeys(faker.internet().emailAddress());
        registrationPage.emailBox.sendKeys(faker.internet().emailAddress());
        password=faker.internet().password(5,15,true);
        registrationPage.firstPasswordBox.sendKeys(password);
        registrationPage.secondPasswordBox.sendKeys(password);
        registrationPage.registerButton2.click();
    }
    @When("User enters all fields but not Username box tries to register")
    public void user_enters_all_fields_but_not_username_box() {
        registrationPage.userNameBox.sendKeys(faker.idNumber().ssnValid());
        registrationPage.firstNameBox.sendKeys(faker.name().firstName());
        registrationPage.lastNameBox.sendKeys(faker.name().lastName());
        registrationPage.addressBox.sendKeys(faker.address().fullAddress());
        registrationPage.mobilePhoneBox.sendKeys(faker.phoneNumber().phoneNumber());
        registrationPage.emailBox.sendKeys(faker.internet().emailAddress());
        registrationPage.emailBox.sendKeys(faker.internet().emailAddress());
        password=faker.internet().password(5,15,true);
        registrationPage.firstPasswordBox.sendKeys(password);
        registrationPage.secondPasswordBox.sendKeys(password);
        registrationPage.registerButton2.click();
    }
    @When("User enters all fields but not Email box tries to register")
    public void user_enters_all_fields_but_not_email_box() {
        registrationPage.userNameBox.sendKeys(faker.idNumber().ssnValid());
        registrationPage.firstNameBox.sendKeys(faker.name().firstName());
        registrationPage.lastNameBox.sendKeys(faker.name().lastName());
        registrationPage.addressBox.sendKeys(faker.address().fullAddress());
        registrationPage.mobilePhoneBox.sendKeys(faker.phoneNumber().phoneNumber());
        registrationPage.userNameBox.sendKeys(faker.name().username());
        registrationPage.emailBox.sendKeys(faker.internet().emailAddress());
        password=faker.internet().password(5,15,true);
        registrationPage.firstPasswordBox.sendKeys(password);
        registrationPage.secondPasswordBox.sendKeys(password);
        registrationPage.registerButton2.click();
    }
    @When("User enters all fields but not Phone Number box tries to register")
    public void user_enters_all_fields_but_not_phone_number_box() {
        registrationPage.userNameBox.sendKeys(faker.idNumber().ssnValid());
        registrationPage.firstNameBox.sendKeys(faker.name().firstName());
        registrationPage.lastNameBox.sendKeys(faker.name().lastName());
        registrationPage.addressBox.sendKeys(faker.address().fullAddress());
        registrationPage.userNameBox.sendKeys(faker.name().username());
        registrationPage.emailBox.sendKeys(faker.internet().emailAddress());
        registrationPage.emailBox.sendKeys(faker.internet().emailAddress());
        password=faker.internet().password(5,15,true);
        registrationPage.firstPasswordBox.sendKeys(password);
        registrationPage.secondPasswordBox.sendKeys(password);
        registrationPage.registerButton2.click();
    }
    @When("User enters all fields but not New Password box tries to register")
    public void user_enters_all_fields_but_not_new_password_box() {
        registrationPage.userNameBox.sendKeys(faker.idNumber().ssnValid());
        registrationPage.firstNameBox.sendKeys(faker.name().firstName());
        registrationPage.lastNameBox.sendKeys(faker.name().lastName());
        registrationPage.addressBox.sendKeys(faker.address().fullAddress());
        registrationPage.mobilePhoneBox.sendKeys(faker.phoneNumber().phoneNumber());
        registrationPage.userNameBox.sendKeys(faker.name().username());
        registrationPage.emailBox.sendKeys(faker.internet().emailAddress());
        registrationPage.emailBox.sendKeys(faker.internet().emailAddress());
        password=faker.internet().password(5,15,true);
        registrationPage.secondPasswordBox.sendKeys(password);
        registrationPage.registerButton2.click();
    }
    @When("User enters all fields but not Password Confirmation box tries to register")
    public void user_enters_all_fields_but_not_password_confirmation_box() {
        registrationPage.userNameBox.sendKeys(faker.idNumber().ssnValid());
        registrationPage.firstNameBox.sendKeys(faker.name().firstName());
        registrationPage.lastNameBox.sendKeys(faker.name().lastName());
        registrationPage.addressBox.sendKeys(faker.address().fullAddress());
        registrationPage.mobilePhoneBox.sendKeys(faker.phoneNumber().phoneNumber());
        registrationPage.userNameBox.sendKeys(faker.name().username());
        registrationPage.emailBox.sendKeys(faker.internet().emailAddress());
        registrationPage.emailBox.sendKeys(faker.internet().emailAddress());
        password=faker.internet().password(5,15,true);
        registrationPage.firstPasswordBox.sendKeys(password);
        registrationPage.registerButton2.click();
    }

}
