package com.besaba.revonline.pastebinapi.user;

import com.besaba.revonline.pastebinapi.paste.PasteExpire;
import com.besaba.revonline.pastebinapi.paste.PasteVisiblity;

/**
 * Contains the User information returned by Pastebin.
 */
public interface User {
  /**
   * @return The user name
   */
  public String getUserName();

  /**
   * @return The user avatar
   */
  public String getAvatarUrl();

  /**
   * @return The user website
   */
  public String getWebsite();

  /**
   * @return The user email
   */
  public String getEmail();

  /**
   * @return The user location
   */
  public String getLocation();

  /**
   * @return The account type
   */
  public AccountType getAccountType();

  /**
   * @return The default paste language used by the user
   */
  public String getDefaultPasteLanguage();

  /**
   * @return The default paste expiration used by the user
   */
  public PasteExpire getDefaultPasteExpiration();

  /**
   * @return The default paste visibility used by the user
   */
  public PasteVisiblity getDefaultPasteVisibility();
}
