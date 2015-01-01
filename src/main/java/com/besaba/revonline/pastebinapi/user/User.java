package com.besaba.revonline.pastebinapi.user;

import com.besaba.revonline.pastebinapi.paste.PasteExpire;
import com.besaba.revonline.pastebinapi.paste.PasteVisiblity;

public interface User {
  public String getUserName();
  public String getAvatarUrl();
  public String getWebsite();
  public String getEmail();
  public String getLocation();
  public AccountType getAccountType();
  public String getDefaultPasteLanguage();
  public PasteExpire getDefaultPasteExpiration();
  public PasteVisiblity getDefaultPasteVisibility();
}
