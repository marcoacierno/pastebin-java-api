package com.besaba.revonline.pastebinapi.user.internal;

import com.besaba.revonline.pastebinapi.paste.PasteExpire;
import com.besaba.revonline.pastebinapi.paste.PasteVisiblity;
import com.besaba.revonline.pastebinapi.user.AccountType;
import com.besaba.revonline.pastebinapi.user.User;

public interface UserBuilder {
  public UserBuilder setUserName(final String userName);
  public UserBuilder setAvatarUrl(final String avatarUrl);
  public UserBuilder setWebsite(final String website);
  public UserBuilder setEmail(final String email);
  public UserBuilder setAccountType(final AccountType accountType);
  public UserBuilder setLocation(final String location);
  public UserBuilder setDefaultPasteLanguage(final String defaultPasteLanguage);
  public UserBuilder setDefaultPasteExpiration(final PasteExpire defaultPasteExpiration);
  public UserBuilder setDefaultPasteVisibility(final PasteVisiblity defaultPasteVisibility);
  public User build();
}
