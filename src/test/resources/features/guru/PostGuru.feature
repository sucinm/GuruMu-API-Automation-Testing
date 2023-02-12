@Guru
Feature: Post Guru

  @Test @PositiveCase
  Scenario Outline: Add guru with valid json
    Given Add guru with "<nama>" as nama, "<email>" as email, and "<password>" as password
    When Post guru request
    Then Should return status code 201
    And Response body data nama should contain "<nama>"
    And Response body message contain "<message>"
    Examples:
      | nama      | email               | password  | message                           |
      | hapusguru | hapusguru@gmail.com | hapusguru | berhasil mendaftarkan profil guru |

  @Test @NegativeCase
  Scenario: Add guru with invalid json
    Given Add guru with invalid json
    When Post guru request
    Then Should return status code 400