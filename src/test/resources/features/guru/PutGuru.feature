Feature: Put Guru
  @Test @PositiveCase
  Scenario: Update guru with valid token and valid form-data
    Given Update guru with valid token and valid form-data
    When Put guru request
    Then Should return status code 200
    And Response body message contain "sukses mengganti profil guru"

  @Test @NegativeCase
  Scenario: Update guru with expired token and valid form-data
    Given Update guru with expired token and valid form-data
    When Put guru request
    Then Should return status code 401

  @Test @NegativeCase
  Scenario: Update guru with expired token and invalid form-data
    Given Update guru with expired token and invalid form-data
    When Put guru request
    Then Should return status code 401

  @Test @NegativeCase
  Scenario: Update guru without token and valid form-data
    Given Update guru without token and valid form-data
    When Put guru request
    Then Should return status code 401

  @Test @NegativeCase
  Scenario: Update guru without token and invalid form-data
    Given Update guru without token and invalid form-data
    When Put guru request
    Then Should return status code 401

  @Test @NegativeCase
  Scenario: Update guru with valid token and without form-data
    Given Update guru with valid token and without form-data
    When Put guru request
    Then Should return status code 400

  @Test @NegativeCase
  Scenario: Update guru with expired token and without form-data
    Given Update guru with expired token and without form-data
    When Put guru request
    Then Should return status code 401

  @Test @NegativeCase
  Scenario: Update guru without token and without form-data
    Given Update guru without token and without form-data
    When Put guru request
    Then Should return status code 401


