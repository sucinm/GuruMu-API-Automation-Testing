@Student
Feature: Put Student
  @Test @PositiveCase
    Scenario: Update murid with valid token and valid form-data
    Given Update murid with valid token and valid form-data
    When Put murid request
    Then Should return status code 200
    And Response body message contain "berhasil mengganti profil siswa"

  @Test @NegativeCase
    Scenario: Update murid with expired token and valid form-data
    Given Update murid with expired token and valid form-data
    When Put murid request
    Then Should return status code 401

  @Test @NegativeCase
    Scenario: Update murid with expired token and invalid form-data
    Given Update murid with expired token and invalid form-data
    When Put murid request
    Then Should return status code 401

  @Test @NegativeCase
    Scenario: Update murid without token and valid form-data
    Given Update murid without token and valid form-data
    When Put murid request
    Then Should return status code 401

  @Test @NegativeCase
    Scenario: Update murid without token and invalid form-data
    Given Update murid without token and invalid form-data
    When Put murid request
    Then Should return status code 401

  @Test @NegativeCase
    Scenario: Update murid with valid token and without form-data
    Given Update murid with valid token and without form-data
    When Put murid request
    Then Should return status code 400

  @Test @NegativeCase
    Scenario: Update murid with expired token and without form-data
    Given Update murid with expired token and without form-data
    When Put murid request
    Then Should return status code 401

  @Test @NegativeCase
    Scenario: Update murid without token and without form-data
    Given Update murid without token and without form-data
    When Put murid request
    Then Should return status code 401