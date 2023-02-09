Feature: Get All Sesi Guru

  @Test @PositiveCase
  Scenario: Get all guru session without form-data and bearer
    Given Get all data sesi guru with "sesiku" as path
    When Get all sesi guru request
    Then Should return status code 400
    And Response body message contain "sukses menampilkan menampilkan semua sesi"
    And Validate json schema all data sesi guru

  @Test @NegativeCase
  Scenario: Get all guru session with invalid path
    Given Get all data sesi guru with "sesikunich" as path
    When Get all sesi guru request
    Then Should return status code 404

  @Test @PositiveCase
  Scenario: Get all guru session without form-data and valid bearer
    Given Get sesi guru without form-data and valid bearer
    When Get sesi guru request
    Then Should return status code 200
    And Response body message contain "sukses menampilkan menampilkan semua sesi"
    And Validate json schema all data sesi guru

  @Test @PositiveCase
  Scenario: Get sesi guru with valid token and valid form-data
    Given Get sesi guru with valid token and valid form-data
    When Get sesi guru request
    Then Should return status code 200
    And Response body message contain "sukses menampilkan menampilkan semua sesi"
    And Validate json schema all data sesi guru

