@Guru
Feature: Delete Guru

  @Test @PositiveCase
  Scenario Outline: Delete guru with valid token
    Given Add guru with "<nama>" as nama, "<email>" as email, and "<password>" as password
    When Post guru request
    Given Delete single data guru with "<email>" as email and "<password>" as password
    When Delete guru request
    Then Should return status code 200
    Examples:
      | nama      | email               | password  |
      | hapusguru | hapusguru@gmail.com | hapusguru |

  @Test @NegativeCase
  Scenario: Delete guru with expired token
    Given Delete single data guru with expired token
    When Delete guru request
    Then Should return status code 401

  @Test @NegativeCase
  Scenario: Delete guru without token
    Given Delete single data guru without token
    When Delete guru request
    Then Should return status code 401

