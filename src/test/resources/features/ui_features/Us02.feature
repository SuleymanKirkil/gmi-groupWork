@Us02_invalid_credentials_are_not_alloed_to_sig_in
  Feature: US02-System Should Not allow anyone with invalid credentials
    Background:
      Given User goes to Url
      Given User clicks Register Button
   @Us02_TC01_Any_field_should_not_be_left_blank
   Scenario: US02_TC001_ALl fields should be filed
     When User enters all fields but not "SSN box" and tries to register
     Then User verifies that registration is not completed
     When User enters all fields but not "FirstName box" and tries to register
     Then User verifies that registration is not completed
     When User enters all fields but not "Lastname box" and tries to register
     Then User verifies that registration is not completed
     When User enters all fields but not "Address box" and tries to register
    Then User verifies that registration is not completed
     When User enters all fields but not "Username box" and tries to register
    Then User verifies that registration is not completed
     When User enters all fields but not "Email box" and tries to register
     Then User verifies that registration is not completed
     When User enters all fields but not "Phone Number box" and tries to register
     Then User verifies that registration is not completed
     When User enters all fields but not "New Password box" and tries to register
     Then User verifies that registration is not completed
     When User enters all fields but not "Password Confirmation box" and tries to register
     Then User verifies that registration is not completed


    @Us02_TC01_Any_field_should_not_be_left_blank_02
      Scenario: US02_TC02 All fields must be filled to register
      When User enters all fields but leaves a field empty
      |SSN           | FirstName   |   LastName     |Address       |
      |   555555555   |    ali      |    kara       |    tavşanlı   |
      |   231432342  |     null        |      sara     |     sacmanlı   |
      |   231432349  |    deli     |      null       |      dermanlı  |
      |   231432348  |    yelli    |       yara    |       null    |
      Then User verifies that registration is not completed

    @Us02_TC01_Any_field_should_not_be_left_blank_03
      Scenario: US02_TC01 All fields must be filled to register
      When User enters all fields
      Then User leaves "SSN box" empty and tries to register
      And User verifies that registration is not completed
      Then User leaves "FirstName box" empty and tries to register
      And User verifies that registration is not completed
      Then User leaves "Lastname box" empty and tries to register
      And User verifies that registration is not completed
      Then User leaves "Address box" empty and tries to register
      And User verifies that registration is not completed
      Then User leaves "Username box" empty and tries to register
      And User verifies that registration is not completed
      Then User leaves "Email box" empty and tries to register
      And User verifies that registration is not completed
      Then User leaves "Phone Number box" empty and tries to register
      And User verifies that registration is not completed
      Then User leaves "New Password box" empty and tries to register
      And User verifies that registration is not completed
      Then User leaves "Password Confirmation box" empty and tries to register
      And User verifies that registration is not completed

    @Us02_TC01_Any_field_should_not_be_left_blank_04
    Scenario: US02_TC01 All fields must be filled to register
      When User enters all fields
      Then User verifies All fields must be filled to be registered


    @Us02_TC02_registration_with_invalid_SSN
     Scenario: US02_TC02_SSN number can be any of char or special chars
       When User enters only char in the SSN Box and clicks next box
       And User enters all fields but not "SSN box" and tries to register
      Then User verifies that registration is not completed
      When User enters only symbols in the SSN Box and clicks next box
      And User enters all fields but not "SSN box" and tries to register
      Then User verifies that registration is not completed
      When User enters only char in the Phone Number Box and clicks next box
      And User enters all fields but not "Phone Number box" and tries to register
      Then User verifies that registration is not completed
      When User enters only symbols in the Phone Number Box and clicks next box
       And User enters all fields but not "Phone Number box" and tries to register
      Then User verifies that registration is not completed
      When User enters an email without @ and .com and clicks next box
      And User enters all fields but not "Email box" and tries to register
      Then User verifies that registration is not completed
      When User enters an email without @ but with .com and clicks next box
      And User enters all fields but not "Email box" and tries to register
      Then User verifies that registration is not completed
      When User enters an email without .com but @ and clicks next box
      And User enters all fields but not "Email box" and tries to register
      Then User verifies that registration is not completed





