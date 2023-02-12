@Guru
Feature: Put Guru

  @Test @PositiveCase
  Scenario Outline: Update guru with valid token and valid form-data
    Given Add guru with "<nama>" as nama, "<email>" as email, and "<password>" as password
    When Post guru request
    Given Update guru with "<nama>" as nama, "<email>" as email, and "<password>" as password
    When Put guru request
    Then Should return status code 200
    And Response body message contain "sukses update data guru"
    Examples:
      | nama      | email               | password  |
      | hapusguru | hapusguru@gmail.com | hapusguru |

  @Test @NegativeCase
  Scenario: Update guru with expired token and valid form-data
    Given Update guru with "hapusguru" as nama, "hapusguru@gmail.com" as email, and "hapusguru" as password with expired token
    When Put guru request
    Then Should return status code 401

  @Test @NegativeCase
  Scenario: Update guru with expired token and invalid form-data
    Given Update guru with "hapusguru" as nama, "hapusguru@gmail.com" as email, and "hapusguru" as password with expired token and invalid form-data
    When Put guru request
    Then Should return status code 401

  @Test @NegativeCase
  Scenario: Update guru without token and valid form-data
    Given Update guru with "hapusguru" as nama, "hapusguru@gmail.com" as email, and "hapusguru" as password without token and valid form-data
    When Put guru request
    Then Should return status code 401

  @Test @NegativeCase
  Scenario: Update guru without token and invalid form-data
    Given Update guru with "hapusguru" as nama, "hapusguru@gmail.com" as email, and "hapusguru" as password without token and valid form-data
    When Put guru request
    Then Should return status code 401

  @Test @NegativeCase
  Scenario: Update guru with valid token and without form-data
    Given Update guru with "hapusguru" as nama, "hapusguru@gmail.com" as email, and "hapusguru" as password with valid token and without form-data
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


