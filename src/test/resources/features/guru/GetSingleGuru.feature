@Guru
Feature: Get Single Guru
  @Test @PositiveCase
  Scenario: Get single data guru with valid id
    Given Get single data guru with 1 as ID
    When Get guru request
    Then Should return status code 200
    And Validate json schema single data guru

  @Test @NegativeCase
  Scenario: Get single data guru with unregister id
    Given Get single data guru with 255 as ID
    When Get guru request
    Then Should return status code 404

  @Test @NegativeCase
  Scenario: Get single data guru with special char as id
    Given Get single data guru with "<$#@" as ID
    When Get guru request
    Then Should return status code 404





