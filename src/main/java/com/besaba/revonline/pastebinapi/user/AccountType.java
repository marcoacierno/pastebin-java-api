package com.besaba.revonline.pastebinapi.user;

public enum AccountType {
  Normal(0),
  Pro(1);

  private int value;

  AccountType(final int value) {
    this.value = value;
  }

  public int getValue() {
    return value;
  }

  public static AccountType fromValue(final int value) {
    switch (value) {
      case 0: return Normal;
      case 1: return Pro;
    }

    throw new UnsupportedOperationException("Account type with value " + value + " is not supported yet");
  }
}
