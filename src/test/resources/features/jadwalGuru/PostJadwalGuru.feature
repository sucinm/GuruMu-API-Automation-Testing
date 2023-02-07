Feature: Post Jadwal Guru

  @Test @PositiveCase
  Scenario Outline: Add jadwal guru with valid json
    Given Add jadwal guru with valid json
    When Post jadwal guru request
    Then Should return status code 200
    And Response body data name should contain "<tanggal>" and "<jam>"
    And Response body message contain "<message>"
    Examples:
      | tanggal    | jam      | message                     |
      | 2015-07-20 | 01:00 PM | berhasil menambahkan jadwal |

  @Test @NegativeCase
  Scenario: Add jadwal guru with invalid json body name
    Given Add jadwal guru with invalid json body name
    When Post jadwal guru request
    Then Should return status code 400
    And Response body message contain "kesalahan input dari sisi user"

  @Test @NegativeCase
  Scenario: Add jadwal guru with invalid json body with extra category
    Given Add jadwal guru with invalid json body with extra category
    When Post jadwal guru request
    Then Should return status code 400
    And Response body message contain "kesalahan input dari sisi user"

  @Test @NegativeCase
  Scenario: Add jadwal guru with invalid json body with blank tanggal
    Given Add jadwal guru with invalid json body with blank tanggal
    When Post jadwal guru request
    Then Should return status code 400
    And Response body message contain "kesalahan input dari sisi user"

  @Test @NegativeCase
  Scenario: Add jadwal guru with invalid json body with blank jam
    Given Add jadwal guru with invalid json body with blank jam
    When Post jadwal guru request
    Then Should return status code 400
    And Response body message contain "kesalahan input dari sisi user"