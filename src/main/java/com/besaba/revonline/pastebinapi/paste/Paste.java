package com.besaba.revonline.pastebinapi.paste;

import com.besaba.revonline.pastebinapi.response.Response;

/**
 * A paste
 */
public interface Paste {
  /**
   * Should return the key of the paste.
   *
   * @return The paste key
   */
  public String getKey();

  /**
   * @return The paste title
   */
  public String getTitle();

  /**
   * @return The paste size (in bytes)
   */
  public long getSize();

  /**
   * @return The language of the paste (in a user-friendly format)
   */
  public String getUserFriendlyLanguage();

  /**
   * @return The language of the paste (in a machine-friendly format)
   */
  public String getMachineFriendlyLanguage();

  /**
   * @return The number of views of the paste
   */
  public int getHits();

  /**
   * @return The visibility of the paste
   */
  public PasteVisiblity getVisiblity();

  /**
   * @return The expire duration of the paste
   */
  public PasteExpire getExpire();

  /**
   * @return Returns when the paste has been published
   */
  public long getPublishDate();

  /**
   * @return Returns how much time left before the paste expires
   */
  public long getRemainingTime();

  /**
   * @return Request the paste raw
   */
  public Response<String> getRaw();
}
