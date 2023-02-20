@Session @Done
Feature: Get All Sesi Guru

  @Test @PositiveCase
  Scenario: Get all guru session without param and without bearer
    Given Get all data sesi guru with "sesiku" as path
    When Get sesi guru without parameter request
    Then Should return status code 401
    And Response body message contain "Unauthorized"

  @Test @NegativeCase
  Scenario: Get all guru session with invalid path and without bearer
    Given Get all data sesi guru with "sesikunich" as path
    When Get sesi guru without parameter request
    Then Should return status code 404
    And Response body message contain "Not Found"

  @Test @NegativeCase
  Scenario: Get all guru session without param and valid bearer
    Given Get all data sesi guru with "sesiku" as path
    And Guru already login with valid account
    When Get sesi guru without param request
    Then Should return status code 400
    And Response body message contain "role/status tidak valid"

  @Test @PositiveCase
  Scenario: Get sesi guru with valid bearer and valid param
    Given Get all data sesi guru with "sesiku?role=guru&status=selesai" as path
    And Guru already login with valid account
    When Get sesi guru request
    Then Should return status code 200
    And Response body message contain "sukses menampilkan sesi guru"
    And Validate json schema all data sesi guru

  @Test @NegativeCase
  Scenario: Get sesi guru with invalid parameter and valid bearer
    Given Get all data sesi guru with "sesiku?role=a&status=iniapa" as path
    And Guru already login with valid account
    When Get sesi guru with invalid param request
    Then Should return status code 400
    And Response body message contain "role/status tidak valid"

  @Test @NegativeCase
  Scenario: Get sesi guru with invalid parameter data type and valid bearer
    Given Get all data sesi guru with role as "guru" and status as "$%"
    And Guru already login with valid account
    When Get sesi guru with invalid param data type request
    Then Should return status code 400
    And Response body message contain "role/status tidak valid"

  @Test @NegativeCase
  Scenario: Get sesi guru with invalid parameter missing category and valid bearer
    Given Get all data sesi guru with role as "guru" and status as "$%"
    And Guru already login with valid account
    When Get sesi guru with invalid param data type request
    Then Should return status code 400
    And Response body message contain "role/status tidak valid"