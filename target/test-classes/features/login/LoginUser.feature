Feature: Login User
  @Test @PositiveCase
  Scenario: Login with valid user JSON
    Given Post user login with valid User
    When Send request login user
    Then Should return status code 200
<<<<<<< HEAD
    And Response body contains email "fikri@gmail.com" and message "login sukses"
=======
    And Response body contains email "johndoe@gmail.com" and message "login sukses"
>>>>>>> ea14746 (feature/api-login: Add scenario for login)
    And Validate json schema Login User

  @Test @NegativeCase
  Scenario: Login with invalid user JSON
    Given Post user login with invalid User
    When Send request login user
    Then Should return status code 400
    And Response body message contain "kesalahan input dari sisi user"

  @Test @NegativeCase
  Scenario: Login with empty user JSON
    Given Post user login with empty json
    When Send request login user
    Then Should return status code 400
    And Response body message contain "kesalahan input dari sisi user"

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
    Then Should return status code 400
    And Response body message contain "kesalahan input dari sisi user"

  @Test @NegativeCase
   Scenario: Login with invalid path
    Given Post user login with valid User
    When Send request login user with invalid path
    Then Should return status code 404