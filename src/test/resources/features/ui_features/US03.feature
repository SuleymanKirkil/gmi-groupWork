Feature: Password_Should_Be_Secure_And_High_Level
  Background:
    Given User goes to Url
    And User clicks Register Button

    @Us_03_Tc01_Strength_Of_Password_Bar
    Scenario: Us03_Tc01_password strength bar
      When User enters single char as password user verifies strentgh of password is weak
      |lowercase letter|uppercase letter|number|special char|
      |      a         |     D          | 0    |         *  |

      And User enters two different types of chars as password user verifies strentgh of password is lower medium
        |lowercase-uppercase|uppercase-number|number-lowercase|special char-uppercase|
        |      aS           |     D9         |        0a      |      *M             |

      And User enters three different types of chars as password user verifies strentgh of password is upper medium
        |lowercase-uppercase|uppercase-number|number-lowercase|special char-uppercase|
        |      aS1          |     D5?        |        0a*     |      *Mf            |

      And User enters four different types of chars as password user verifies strentgh of password is high
        |lowercase-uppercase|uppercase-number|number-lowercase|special char-uppercase|
        |      aS1*         |     D5?h       |        0a*Z    |      *Mf2           |