Feature: Get All Sesi Guru

  @Test @PositiveCase
  Scenario: Get all data sesi guru with valid url
    Given Get all data sesi guru with "sesiku" as path
    When Get all sesi guru request
    Then Should return status code 200
    And Validate json schema all data sesi guru