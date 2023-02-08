Feature: Get All Ulasan
  @Test @PositiveCase
  Scenario: Get all data ulasan with valid url
    Given Get all data ulasan with "ulasan" as path
    When Get all ulasan request
    Then Should return status code 201
    And Validate json schema all data ulasan

  @Test @NegativeCase
  Scenario: Get all data ulasan with invalid url
    Given Get all data ulasan with "ulasans" as path
    When Get all ulasan request
    Then Should return status code 404

