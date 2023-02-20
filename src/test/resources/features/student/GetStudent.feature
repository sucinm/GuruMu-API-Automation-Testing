@Student @Done
Feature: Get Student
  @Test @PositiveCase
    Scenario: Get data murid with token
    Given Get data murid with token
    When Get murid request
    Then Should return status code 200
    And Validate json schema data murid

  @Test @NegativeCase
    Scenario: Get data murid without token
    Given Get data murid without token
    When Get murid request
    Then Should return status code 401

  @Test @NegativeCase
    Scenario: Get data murid with expired token
    Given Get data murid with expired token
    When Get murid request
    Then Should return status code 401