package com.besaba.revonline.pastebinapi.impl.user;

import com.besaba.revonline.pastebinapi.paste.PasteExpire;
import com.besaba.revonline.pastebinapi.paste.PasteVisiblity;
import com.besaba.revonline.pastebinapi.user.AccountType;
import com.besaba.revonline.pastebinapi.user.User;

public class UserImpl implements User {
  private final String userName;
  private final String avatar;
  private final String website;
  private final String email;
  private final String location;
  private final AccountType accountType;
  private final String defaultPasteLanguage;
  private final PasteExpire defaultPasteExpiration;
  private final PasteVisiblity defaultPasteVisibility;

  UserImpl(final String userName,
           final String avatar,
           final String website,
           final String email,
           final String location,
           final AccountType accountType,
           final String defaultPasteLanguage,
           final PasteExpire defaultPasteExpiration, final PasteVisiblity defaultPasteVisibility) {
    this.userName = userName;
    this.avatar = avatar;
    this.website = website;
    this.email = email;
    this.location = location;
    this.accountType = accountType;
    this.defaultPasteLanguage = defaultPasteLanguage;
    this.defaultPasteExpiration = defaultPasteExpiration;
    this.defaultPasteVisibility = defaultPasteVisibility;
  }

  @Override
  public String getUserName() {
    return userName;
  }

  @Override
  public String getAvatarUrl() {
    return avatar;
  }

  @Override
  public String getWebsite() {
    return website;
  }

  @Override
  public String getEmail() {
    return email;
  }

  @Override
  public String getLocation() {
    return location;
  }

  @Override
  public AccountType getAccountType() {
    return accountType;
  }

  @Override
  public String getDefaultPasteLanguage() {
    return defaultPasteLanguage;
  }

  @Override
  public PasteExpire getDefaultPasteExpiration() {
    return defaultPasteExpiration;
  }

  @Override
  public PasteVisiblity getDefaultPasteVisibility() {
    return defaultPasteVisibility;
  }
}
