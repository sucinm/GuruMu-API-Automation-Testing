Feature: Get Single Ulasan
  @Test @PositiveCase
  Scenario: Get single data ulasan with valid id
    Given Get single data ulasan with 1 as ID
    When Get ulasan request
    Then Should return status code 200
    And Validate json schema single data ulasan

  @Test @NegativeCase
  Scenario: Get single data ulasan with unregister id
    Given Get single data ulasan with 255 as ID
    When Get ulasan request
    Then Should return status code 404

  @Test @NegativeCase
  Scenario: Get single data ulasan with special char as id
    Given Get single data ulasan with "<$#@" as ID
    When Get ulasan request
    Then Should return status code 404





