@SecondRelease
Feature: Product functionality

  @Positive
  Scenario Outline: Ensure amount of card incremented when product added to cart

    #precondition
    Given user is on saucedemo homepage
    #steps
    When user Input <username> as username
    And user Input <password> as password
    And user Click enter
    #expected
    Then user Verify <status> login result
    #steps
    When user add first product to cart
    And user see initial amount
    When user add second product to cart

    #expected
    Then user verify amount of product in cart incremented

    Examples:
      | username                | password      | status  |
      | standard_user           | secret_sauce  | success |