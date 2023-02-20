@Student @Done
Feature: Delete Student
  @Test @PositiveCase
    Scenario: Delete murid with valid token
    Given Delete single data murid with valid token
    When Delete murid request
    Then Should return status code 200

  @Test @NegativeCase
    Scenario: Delete murid with expired token
    Given Delete single data murid with expired token
    When Delete murid request
    Then Should return status code 401

  @Test @NegativeCase
    Scenario: Delete murid without token
    Given Delete single data murid without token
    When Delete murid request
    Then Should return status code 401