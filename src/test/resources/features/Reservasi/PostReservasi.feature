Feature: Post Reservasi
  @Test @PositiveCase
  Scenario Outline: Post add Lanjutkan Pembayaran with complete information
    Given Lanjutkan Pembayaran with valid json
    When Post Reservasi request
    Then Should return status code <code>
    And Response body data should contain 'status pembayaran' "<status_pembayaran>"
    And Response body message contain "<message>"
    Examples:
      | code | status_pembayaran | message               |
      | 201  | sukses            | sukses reservasi guru |

  @Test @PositiveCase
  Scenario Outline: Post add Lanjutkan Pembayaran with empty 'pesan'
    Given Lanjutkan Pembayaran without pesan json
    When Post Reservasi request
    Then Should return status code <code>
    And Response body data should contain 'status pembayaran' "<status_pembayaran>"
    And Response body message contain "<message>"
    Examples:
      | code | status_pembayaran | message               |
      | 201  | sukses            | sukses reservasi guru |

  @Test @NegativeCase
  Scenario Outline: Post add Lanjutkan Pembayaran with empty 'metode belajar'
    Given Lanjutkan Pembayaran without metode belajar json
    When Post Reservasi request
    Then Should return status code <code>
    And Response body message contain "<message>"
    Examples:
      | code | message                        |
      | 400  | kesalahan input dari sisi user |

  @Test @NegativeCase
  Scenario Outline: Post add Lanjutkan Pembayaran with empty 'tanggal'
    Given Lanjutkan Pembayaran without tanggal json
    When Post Reservasi request
    Then Should return status code <code>
    And Response body message contain "<message>"
    Examples:
      | code | message                        |
      | 400  | kesalahan input dari sisi user |

  @Test @NegativeCase
  Scenario Outline: Post add Lanjutkan Pembayaran with empty 'jam'
    Given Lanjutkan Pembayaran without jam json
    When Post Reservasi request
    Then Should return status code <code>
    And Response body message contain "<message>"
    Examples:
      | code | message                        |
      | 400  | kesalahan input dari sisi user |

  @Test @NegativeCase
  Scenario Outline: Post add Lanjutkan Pembayaran with empty 'metode pembayaran'
    Given Lanjutkan Pembayaran without metode pembayaran json
    When Post Reservasi request
    Then Should return status code <code>
    And Response body message contain "<message>"
    Examples:
      | code | message                        |
      | 400  | kesalahan input dari sisi user |

  @Test @NegativeCase
  Scenario Outline: Post add Lanjutkan Pembayaran without 'metode belajar', 'tanggal', 'jam', 'metode pembayaran'
    Given Lanjutkan Pembayaran with invalid json
    When Post Reservasi request
    Then Should return status code <code>
    And Response body message contain "<message>"
    Examples:
      | code | message                        |
      | 400  | kesalahan input dari sisi user |
