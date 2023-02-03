Feature: Post Guru
  @Test @PositiveCase
  Scenario: Delete guru with valid token
    Given Delete single data guru with valid token
    When Delete guru request
    Then Should return status code 200

  @Test @NegativeCase
  Scenario: Delete guru with expired token
    Given Delete single data guru with expired token
    When Delete guru request
    Then Should return status code 401

  @Test @NegativeCase
  Scenario: Delete guru without token
    Given Delete single data guru without token
    When Delete guru request
    Then Should return status code 401

