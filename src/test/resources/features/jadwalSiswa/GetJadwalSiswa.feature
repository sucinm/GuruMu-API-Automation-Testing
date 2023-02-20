@Session @Done
Feature: Get All Sesi Siswa

  @Test @PositiveCase
  Scenario: Get all murid session without param and bearer
    Given Get all murid session without param and bearer using path "sesiku"
    When Get sesi murid without param
    Then Should return status code 401
    And Response body message contain "Unauthorized"

  @Test @NegativeCase
  Scenario: Get all murid session without param and valid bearer
    Given Get all murid session without param and valid bearer using path "sesiku"
    And Murid already login with valid account
    When Get sesi murid without parameter
    Then Should return status code 400
    And Response body message contain "role/status tidak valid"

  @Test @PositiveCase
  Scenario: Get all murid session with valid param and bearer
    Given Get all murid session without param and valid bearer using path "sesiku?role=siswa&status=selesai"
    And Murid already login with valid account
    When Get sesi murid with valid param
    Then Should return status code 200
    And Response body message contain "sukses menampilkan sesi siswa"
    And Validate json schema all data sesi guru

  @Test @PositiveCase
  Scenario: Get all murid session with invalid extra parameter and valid bearer
    Given Get all murid session without param and valid bearer using path "sesiku?role=siswa&status=ongoing&reservasi_id=37"
    And Murid already login with valid account
    When Get sesi murid with invalid extra param
    Then Should return status code 200
    And Response body message contain "sukses menampilkan sesi siswa"
    And Validate json schema all data sesi guru

  @Test @NegativeCase
  Scenario: Get all murid session with invalid parameter data type
    Given Get all murid session without param and valid bearer using path "sesiku?role=siswa&status=%$"
    And Murid already login with valid account
    When Get sesi murid with invalid param data type
    Then Should return status code 400
    And Response body message contain "role/status tidak valid"

  @Test @NegativeCase
  Scenario: Get all murid session with invalid missing parameter
    Given Get all murid session without param and valid bearer using path "sesiku?role=siswa"
    And Murid already login with valid account
    When Get sesi murid with invalid param missing
    Then Should return status code 400
    And Response body message contain "role/status tidak valid"

  @Test @NegativeCase
  Scenario: Get all murid session with invalid blank parameter
    Given Get all murid session without param and valid bearer using path "sesiku?role=siswa&status="
    And Murid already login with valid account
    When Get sesi murid with invalid blank param
    Then Should return status code 400
    And Response body message contain "role/status tidak valid"