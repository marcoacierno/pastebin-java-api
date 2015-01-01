package com.besaba.revonline.pastebinapi.impl.user;

import com.besaba.revonline.pastebinapi.paste.PasteExpire;
import com.besaba.revonline.pastebinapi.paste.PasteVisiblity;
import com.besaba.revonline.pastebinapi.user.AccountType;
import com.besaba.revonline.pastebinapi.user.User;
import com.besaba.revonline.pastebinapi.user.internal.UserBuilder;

public class UserBuilderImpl implements UserBuilder {
  private String userName;
  private String avatar;
  private String website;
  private String email;
  private String location;
  private AccountType accountType;
  private String defaultPasteLanguage;
  private PasteExpire defaultPasteExpiration;
  private PasteVisiblity defaultPasteVisibility;

  @Override
  public UserBuilder setUserName(final String userName) {
    this.userName = userName;
    return this;
  }

  @Override
  public UserBuilder setAvatarUrl(final String avatarUrl) {
    this.avatar = avatarUrl;
    return this;
  }

  @Override
  public UserBuilder setWebsite(final String website) {
    this.website = website;
    return this;
  }

  @Override
  public UserBuilder setEmail(final String email) {
    this.email = email;
    return this;
  }

  @Override
  public UserBuilder setAccountType(final AccountType accountType) {
    this.accountType = accountType;
    return this;
  }

  @Override
  public UserBuilder setLocation(final String location) {
    this.location = location;
    return this;
  }

  @Override
  public UserBuilder setDefaultPasteLanguage(final String defaultPasteLanguage) {
    this.defaultPasteLanguage = defaultPasteLanguage;
    return this;
  }

  @Override
  public UserBuilder setDefaultPasteExpiration(final PasteExpire defaultPasteExpiration) {
    this.defaultPasteExpiration = defaultPasteExpiration;
    return this;
  }

  @Override
  public UserBuilder setDefaultPasteVisibility(final PasteVisiblity defaultPasteVisibility) {
    this.defaultPasteVisibility = defaultPasteVisibility;
    return this;
  }

  @Override
  public User build() {
    return new UserImpl(
        userName,
        avatar,
        website,
        email,
        location,
        accountType,
        defaultPasteLanguage,
        defaultPasteExpiration,
        defaultPasteVisibility
    );
  }
}
