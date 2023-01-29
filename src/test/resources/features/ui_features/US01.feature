@US_01_registiration
Feature: US01_System should allow any user to register with valid credentials

  Background:
    Given User goes to Url
    Given User clicks Register Button
    Then User verifies Registration Page

#  @goUrl
  @US_01-TC_01_SSN_Box_Testing
  Scenario: US_01-TC_01-registration_SSN_Box
    Given User clicks SSN Box and clicks next box
    And User verifies "Please enter your social security number." message is displayed
    When User enters 9 digit SSN in the SSN Box without '-' and clicks next box
    Then User verifies system put '-' between digits automatically
    When User enters 8 digit SSN in the SSN Box and clicks next box
    Then User verifies "Ssn is invalid." message is displayed under SSN Box
    When User enters on digit SSN in the SSN Box and clicks next box
    Then User verifies system doesn't accept 10. digit
    When User enters only char in the SSN Box and clicks next box
    Then User verifies system doesn't accept any char
    When User enters only symbols in the SSN Box and clicks next box
    Then User verifies system doesn't accept any sepacial character
    When User enters a valid SSN in the SSN Box and clicks next box
    Then User verifies any error message is not displayed
    When User enters valid SSN in the SSN Box and clicks next box
      |   valid SSN       |
      |   123412347      |
      |   324523556      |
      |   721112576      |
    When User enters invalid SSN in the SSN Box and clicks next box
      |   Invalid SSN   |
      |   12345678      |
      |   000344556     |
      |   123001234     |
      |   123120000     |
      |   912121234     |

  @US_01-TC_02_First_Name_Box_Testing
  Scenario: US_01-TC_02_First_Name_Box_Testing
    Given User enters a valid SSN in the SSN Box and clicks next box
    Then User clicks First Name Box and clicks next box
    And User verifies "Please enter your first name." message is displayed in firstName
    When User enters only symbols in the First Name Box and clicks next box
    Then User verifies that "Your first name is invalid" message is displaced for below values
      |   invalid names  |
      |   *              |
      |   12             |
      |   sena23         |
    When User enters a valid First Name in First Name Box and clicks next box
    Then User verifies any error message is not displayed

  @US_01-TC_03_Last_Name_Box_Testing
  Scenario: US_01-TC_03_Last_Name_Box_Testing
    Given User enters a valid SSN in the SSN Box and clicks next box
    Then User enters a valid First Name in First Name Box and clicks next box
    And User clicks Last Name Box and clicks next box
    Then User verifies "Please enter your last name." message is displayed
    When User enters only symbols in the Last Name Box and clicks next box
    Then User verifies "Your last name is invalid" message is displayed
    When User enters only digital numbers in Last Name Box and clicks next box.
    Then User verifies "Your last name is invalid" message is displayed
    When User enters chars with digital numbers and clicks next box
    Then User verifies "Your last name is invalid" message is displayed
    When User enters a valid Last Name in Last Name Box and clicks next box
    Then User verifies any error message is not displayed for lastname

  @US_01-TC_03_Last_Name_Box_Testing2
  Scenario: US_01-TC_03_Last_Name_Box_Testing
    Given User enters a valid SSN in the SSN Box and clicks next box
    Then User enters a valid First Name in First Name Box and clicks next box
    And User clicks Last Name Box and clicks next box
    Then User verifies "Please enter your last name." message is displayed
    Then User verifies that "Your last name is invalid" message is displaced for below values
      |   invalid lastnames  |
      |   **?              |
      |   1284             |
      |   seda22         |
    When User enters a valid Last Name in Last Name Box and clicks next box
    Then User verifies any error message is not displayed for lastname


  @US_01-TC_04_Address_Box_Testing
  Scenario: US_01-TC_04_Address_Box_Testing
    Given User enters a valid SSN in the SSN Box and clicks next box
    Then User enters a valid First Name in First Name Box and clicks next box
    And User enters a valid Last Name in Last Name Box and clicks next box
    And User clicks Address Box and clicks next box
    Then User verifies "Please enter your address." message is displayed
    When User enters only symbols in the Address Box and clicks next box
    Then User verifies "Your address is invalid" message is displayed
    When User enters a valid Address in Address Box and clicks next box
    Then User verifies any error message is not displayed in address box

  @US_01-TC_05_Mobilephone_Number_Box_Testing
  Scenario: US_01-TC_05_Mobilephone_Number_Box_Testing
    Given User enters a valid SSN in the SSN Box and clicks next box
    Then User enters a valid First Name in First Name Box and clicks next box
    And User enters a valid Last Name in Last Name Box and clicks next box
    And User enters a valid Address in Address Box and clicks next box
    When User clicks Mobilephone Number Box and clicks next box
    And User verifies "Please enter your mobile phone number." message is displayed
    When User enters 10 digit Mobilephone Number without '-' in the Mobilephone Number Box and clicks next box
    Then User verifies system put '-' between phone number digits automatically
    When User enters 9 digit Mobilephone Number in the Mobilephone Number Box and clicks next box
    Then User verifies "Your mobile phone number is invalid." message is displayed
    When User enters 11 digit Mobilephone Number in the Mobilephone Number Box and clicks next box
    Then User verifies system doesn't accept 11. digit Mobilephone Number
    When User enters only char in the  Mobilephone Number Box and clicks next box
    Then User verifies system doesn't accept any char in the Mobilephone Number Box
    When User enters only symbols in the Mobilephone Number Box and clicks next box
    Then User verifies system doesn't accept any sepacial character in the Mobilephone Number Box
    When User enters a valid Mobilephone Number in the Mobilephone Number Box and clicks next box
    Then User verifies error message is not displayed

  @US_01-TC_06_Email_Box_Testing
  Scenario: US_01-TC_06_Email_Box_Testing
    Given User enters a valid SSN in the SSN Box and clicks next box
    Then User enters a valid First Name in First Name Box and clicks next box
    And User enters a valid Last Name in Last Name Box and clicks next box
    And User enters a valid Address in Address Box and clicks next box
    And User enters a valid Mobilephone Number in the Mobilephone Number Box and clicks next box
    When User clicks Email Box and clicks next box
    And User verifies "Please enter your email." message is displayed
    When User enters an email without @ and .com and clicks next box
    Then User verifies "Your email is invalid." message is displayed
    When User enters an email without @ but with .com and clicks next box
    Then User verifies "Your email is invalid." message is displayed
    When User enters an email without .com but @ and clicks next box
    Then User verifies "Your email is invalid." message is displayed
    When User enters a valid email in the email box and clicks next box
    Then User verifies error message is not displayed in the email box

