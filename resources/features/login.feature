@FirstRelease
Feature: Login functionality

  @Positive
  Scenario Outline: Ensure user successfully login
    #precondition
    Given user is on SauceDemo homepage
    #steps
    When user input <username> as username
    And user input <password> as password
    And user click enter
    #expected
    Then user verify <status> login result

    Examples:
      | username                | password      | status  |
      | standard_user           | secret_sauce  | success |
      | performance_glitch_user | secret_sauce  | success |
      | failed_user             | secret_sauce  | failed  |

  @Negative
  Scenario Outline: Ensure user failed login with password null
    #precondition
    Given User Is On SauceDemo Homepage
    #steps
    When User Input <username> as Username
    And User Click Enter
    #expected
    Then User Verify Failed Login

    Examples:
      | username       |
      | standard_user  |