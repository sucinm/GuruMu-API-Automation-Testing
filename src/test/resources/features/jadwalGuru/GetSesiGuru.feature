Feature: Get All Sesi Guru

  @Test @PositiveCase
  Scenario: Get all guru session with valid path and without bearer
    Given Get all data sesi guru with "sesiku" as path
    When Get all sesi guru request
    Then Should return status code 400
    And Response body message contain "missing or malformed jwt"

  @Test @NegativeCase
  Scenario: Get all guru session with invalid path and without bearer
    Given Get all data sesi guru with "sesikunich" as path
    When Get all sesi guru request
    Then Should return status code 404
    And Response body message contain "Not Found"

  @Test @PositiveCase
  Scenario: Get all guru session without param and valid bearer
    Given Get all data sesi guru with "sesiku" as path
    And Guru already login
    When Get sesi guru request
    Then Should return status code 201
    And Response body message contain "sukses menampilkan sesi guru"
    And Validate json schema all data sesi guru

  @Test @PositiveCase
  Scenario: Get sesi guru with valid bearer and valid param
    Given Get all data sesi guru with "sesiku?role=guru&status=selesai" as path
    And Guru already login
    When Get sesi guru request
    Then Should return status code 201
    And Response body message contain "sukses menampilkan sesi guru"
    And Validate json schema all data sesi guru

  @Test @NegativeCase
  Scenario: Get sesi guru with invalid parameter and valid bearer
    Given Get all data sesi guru with "sesiku?role=dokter&status=sarjana" as path
    And Guru already login
    When Get sesi guru request
    Then Should return status code 404
    And Response body message contain "Not Found"