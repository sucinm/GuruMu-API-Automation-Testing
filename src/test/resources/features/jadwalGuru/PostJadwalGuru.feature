Feature: Post Jadwal Guru

  @Test @PositiveCase
  Scenario Outline: Add jadwal guru with valid json
    Given Add jadwal guru with valid json
    And Guru already login
    When Post jadwal guru request
    Then Should return status code 201
    And Response body data name should contain "<tanggal>" and "<jam>"
    And Response body message contain "<message>"
    Examples:
      | tanggal | jam | message                     | ]
      |         |     | berhasil menambahkan jadwal |

  @Test @NegativeCase
  Scenario: Add jadwal guru with invalid json body name
    Given Add jadwal guru with invalid json body name
    And Guru already login
    When Post jadwal guru request
    Then Should return status code 400
    And Response body message contain "missing or malformed jwt"

  @Test @NegativeCase
  Scenario: Add jadwal guru with invalid json body with extra category
    Given Add jadwal guru with invalid json body with extra category
    And Guru already login
    When Post jadwal guru request
    Then Should return status code 400
    And Response body message contain "missing or malformed jwt"

  @Test @NegativeCase
  Scenario: Add jadwal guru with invalid json body with blank tanggal
    Given Add jadwal guru with invalid json body with blank tanggal
    And Guru already login
    When Post jadwal guru request
    Then Should return status code 400
    And Response body message contain "missing or malformed jwt"

  @Test @NegativeCase
  Scenario: Add jadwal guru with invalid json body with blank jam
    Given Add jadwal guru with invalid json body with blank jam
    And Guru already login
    When Post jadwal guru request
    Then Should return status code 400
    And Response body message contain "missing or malformed jwt"

  @Test @NegativeCase
  Scenario: Add jadwal guru without bearer token
    Given Add jadwal guru with valid json
    And Guru already login without bearer token
    When Post jadwal guru request
    Then Should return status code 400
    And Response body message contain "missing or malformed jwt"