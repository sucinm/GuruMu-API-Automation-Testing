Feature: Post Guru
  @Test @PositiveCase
  Scenario Outline: Add guru with valid json
    Given Add guru with valid json
    When Post guru request
    Then Should return status code 201
    And Response body data nama should contain "<name>"
    And Response body message contain "<message>"
    Examples:
      | name      | message                   |
      | budi didi | berhasil menambahkan data |

  @Test @NegativeCase
  Scenario: Add guru with invalid json
    Given Add guru with invalid json
    When Post guru request
    Then Should return status code 400