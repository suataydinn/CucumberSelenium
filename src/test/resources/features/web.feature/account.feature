@account @smoke
@browserWeb

Feature: Account Scenario

  Background:
    Given click account button

  Scenario Outline: Negative login users
    When click login button
    And send "<mail>" e-mail "<password>" password
    Then user see error message
    Examples:
      |   mail              |   password    |
      |  iç@gmail.com       |   test123     |
      |                     |   test123     |
      |  test@gmail.com     |   test123     |


  Scenario: Positive login users
      When click login button
      And send "yejici1903@merotx.com" e-mail "Test1230" password
      Then user should be able to login