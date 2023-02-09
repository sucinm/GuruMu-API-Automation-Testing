Feature: Post Student
  @Test @PositiveCase
    Scenario Outline: Add murid with valid json
    Given Add murid with valid json
    When Post murid request
    Then Should return status code 201
    And Response body data nama should contain "<name>"
    And Response body message contain "<message>"
    Examples:
    |name|message|
    | John Doe   | berhasil daftar akun baru  |

  @Test @NegativeCase
    Scenario: Add murid with invalid JSON
    Given Add murid with invalid JSON
    When Post murid request
    Then Should return status code 400