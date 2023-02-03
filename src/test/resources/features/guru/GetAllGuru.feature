Feature: Get All Guru
  @Test @PositiveCase
  Scenario: Get all data guru with valid url
    Given Get all data guru with "guru" as path
    When Get all guru request
    Then Should return status code 200
    And Validate json schema all data guru

  @Test @NegativeCase
  Scenario: Get all data guru with invalid url
    Given Get all data guru with "gurus" as path
    When Get all guru request
    Then Should return status code 404