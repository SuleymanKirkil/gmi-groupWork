package stepdefinitions.uistepdefs;

import io.cucumber.java.en.*;
import org.junit.Assert;
import pages.RegistrationPage;

import java.util.List;
import java.util.Map;

public class US03_StepDefs {
RegistrationPage registrationPage=new RegistrationPage();
    @When("User enters single char as password user verifies strentgh of password is weak")
    public void user_enters_single_char_as_password_user_verifies_strentgh_of_password_is_weak(io.cucumber.datatable.DataTable dataTable) {
        List<Map<String,String>>  password= dataTable.asMaps(String.class,String.class);
        for (int i=0;i<dataTable.row(0).size();i++) {
            registrationPage.firstPasswordBox.sendKeys(dataTable.row(1).get(i));
            int strength= registrationPage.listOfNoOfGrayStrengthBar.size();
            System.out.println("gücü neymiş bakalım ="+strength);
            Assert.assertTrue(strength==4);
            registrationPage.firstPasswordBox.clear();
            }

        }

    @When("User enters two different types of chars as password user verifies strentgh of password is lower medium")
    public void user_enters_two_different_types_of_chars_as_password_user_verifies_strentgh_of_password_is_lower_medium(io.cucumber.datatable.DataTable dataTable)  {
        for (int i = 0; i < dataTable.row(0).size(); i++) {
            registrationPage.firstPasswordBox.sendKeys(dataTable.row(1).get(i));

            int strength = registrationPage.listOfNoOfGrayStrengthBar.size();
            System.out.println("gücü neymiş bakalım =" + strength);
            Assert.assertTrue(strength == 3);
            registrationPage.firstPasswordBox.clear();
        }
    }
    @When("User enters three different types of chars as password user verifies strentgh of password is upper medium")
    public void user_enters_three_different_types_of_chars_as_password_user_verifies_strentgh_of_password_is_upper_medium(io.cucumber.datatable.DataTable dataTable) {
        for (int i = 0; i < dataTable.row(0).size(); i++) {
            registrationPage.firstPasswordBox.sendKeys(dataTable.row(1).get(i));

            int strength = registrationPage.listOfNoOfGrayStrengthBar.size();
            System.out.println("gücü neymiş bakalım =" + strength);
            Assert.assertTrue(strength == 2);
            registrationPage.firstPasswordBox.clear();
        }
    }
    @When("User enters four different types of chars as password user verifies strentgh of password is high")
    public void user_enters_four_different_types_of_chars_as_password_user_verifies_strentgh_of_password_is_high(io.cucumber.datatable.DataTable dataTable) {
        for (int i = 0; i < dataTable.row(0).size(); i++) {
            registrationPage.firstPasswordBox.sendKeys(dataTable.row(1).get(i));

            int strength = registrationPage.listOfNoOfGrayStrengthBar.size();
            System.out.println("gücü neymiş bakalım =" + strength);
            Assert.assertTrue(strength == 1);
            registrationPage.firstPasswordBox.clear();
        }
    }






}
