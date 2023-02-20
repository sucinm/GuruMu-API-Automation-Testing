@Login @Nice
Feature: Login User
  @Test @PositiveCase
  Scenario: Login with valid user JSON
    Given Post user login with valid User
    When Send request login user
    Then Should return status code 200
    And Response body contains email "sucimurid@gmail.com" and message "login sukses"
    And Validate json schema Login User

  @Test @NegativeCase
  Scenario: Login with invalid user JSON
    Given Post user login with invalid User
    When Send request login user
    Then Should return status code 404
    And Response body message contain "data not found"

  @Test @NegativeCase
  Scenario: Login with empty user JSON
    Given Post user login with empty json
    When Send request login user
    Then Should return status code 404
    And Response body message contain "data not found"

  @Test @NegativeCase
  Scenario: Login with invalid JSON format
    Given Post user login with invalid json format
    When Send request login user
    Then Should return status code 400
    And Response body message contain "kesalahan input dari sisi user"

  @Test @NegativeCase
  Scenario: Login with invalid JSON key
    Given Post user login with invalid json key
    When Send request login user
    Then Should return status code 404
    And Response body message contain "data not found"

  @Test @NegativeCase
   Scenario: Login with invalid path
    Given Post user login with valid User
    When Send request login user with invalid path
    Then Should return status code 404