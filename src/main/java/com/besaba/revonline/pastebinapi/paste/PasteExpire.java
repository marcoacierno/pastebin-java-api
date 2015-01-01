package com.besaba.revonline.pastebinapi.paste;

/**
 *
 */
public enum PasteExpire {
  Never("N"),
  TenMinutes("10M"),
  OneHour("1H"),
  OneDay("1D"),
  OneWeek("1W"),
  TwoWeek("2W"),
  OneMonth("1M"),;

  private final String value;

  PasteExpire(final String value) {
    this.value = value;
  }

  public String getValue() {
    return value;
  }

  public static PasteExpire fromValue(final String value) {
    switch (value) {
      case "N": return Never;
      case "10M": return TenMinutes;
      case "1H": return OneHour;
      case "1D": return OneDay;
      case "1W": return OneWeek;
      case "2W": return TwoWeek;
      case "1M": return OneMonth;
    }

    throw new UnsupportedOperationException("PasteExpire " + value + " is not supported yet");
  }
}
