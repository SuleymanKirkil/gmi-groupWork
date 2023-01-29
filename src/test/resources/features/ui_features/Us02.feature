@Us02_invalid_credentials_are_not_alloed_to_sig_in
  Feature: US02-System Should Not allow anyone with invalid credentials
    Background:
      Given User goes to Url
      Given User clicks Register Button
   @Us02_TC01_Any_field_should_not_be_left_blank
   Scenario: US02_TC001_ALl fields should be filed
     When User enters all fields but not SSn box and tries to register
     Then User verifies use default credentials message is displaced
     When User enters all fields but not Lastname box and tries to register
     Then User verifies use default credentials message is displaced
     When User enters all fields but not Address box tries to register
     Then User verifies use default credentials message is displaced
     When User enters all fields but not Username box tries to register
     Then User verifies use default credentials message is displaced
     When User enters all fields but not Email box tries to register
     Then User verifies use default credentials message is displaced
     When User enters all fields but not Phone Number box tries to register
     Then User verifies use default credentials message is displaced
     When User enters all fields but not New Password box tries to register
     Then User verifies use default credentials message is displaced
     When User enters all fields but not Password Confirmation box tries to register

    @Us02_TC02_registration_with_invalid_SSN
     Scenario: US02_TC02_SSN number can be any of char or special chars
       When User enters only char in the SSN Box and clicks next box
       And User enters all fields but not SSn box and tries to register
       Then User enters all fields but not Phone Number box tries to register
       When User enters only symbols in the SSN Box and clicks next box
       And User enters all fields but not SSn box and tries to register
       Then User enters all fields but not Phone Number box tries to register


