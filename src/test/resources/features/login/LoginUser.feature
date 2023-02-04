Feature: Login User
  @Test @PositiveCase
  Scenario: Login with valid user
    Given Post user login with valid User
    When Send request login user
    Then Should return status code 200
    And Response body contains email "johndoe@gmail.com" and message "login sukses"
    And Validate json schema Login User

  @Test @NegativeCase
  Scenario: Login with invalid user
    Given Post user login with invalid User
    When Send request login user
    Then Should return status code 400
    And Response body message contain "kesalahan input dari sisi user"


