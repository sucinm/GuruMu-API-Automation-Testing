Feature: Post Ulasan
  @Test @PositiveCase
  Scenario: Add ulasan with valid json
    Given Add ulasan with valid json and 1 as ID
    When Post ulasan request
    Then Should return status code 201
    And Response body message contain "sukses memberikan ulasan dan penilaian"

  @Test @NegativeCase
  Scenario: Add ulasan with invalid json
    Given Add ulasan with invalid json and 1 as ID
    When Post ulasan request
    Then Should return status code 400


  @Test @NegativeCase
  Scenario: Add ulasan with valid json without ID guru
    Given Add ulasan with valid json without ID guru
    When Post ulasan request
    Then Should return status code 400


