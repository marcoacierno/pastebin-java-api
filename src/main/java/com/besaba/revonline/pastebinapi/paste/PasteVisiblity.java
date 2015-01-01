package com.besaba.revonline.pastebinapi.paste;

/**
 *
 */
public enum PasteVisiblity {
  Private(2),
  Unlisted(1),
  Public(0);
  private int value;

  PasteVisiblity(final int value) {
    this.value = value;
  }

  public int getValue() {
    return value;
  }

  public static PasteVisiblity fromValue(final int value) {
    switch (value) {
      case 0: return Public;
      case 1: return Unlisted;
      case 2: return Private;
    }

    throw new UnsupportedOperationException("Unsupported visibility level");
  }
}
