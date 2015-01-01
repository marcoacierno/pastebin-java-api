package com.besaba.revonline.pastebinapi.paste;

/**
 *
 */
public interface PasteBuilder {
  public PasteBuilder setKey(final String key);

  public PasteBuilder setTitle(final String title);

  public PasteBuilder setSize(final long size);

  public PasteBuilder setUserFriendlyLanguage(final String language);

  public PasteBuilder setMachineFriendlyLanguage(final String language);

  public PasteBuilder setHits(final int hits);

  public PasteBuilder setExpire(final PasteExpire expire);

  public PasteBuilder setRaw(final String raw);

  public PasteBuilder setVisiblity(final PasteVisiblity visibility);

  public PasteBuilder setPublishDate(final long publishDate);

  public PasteBuilder setRemainingTime(final long remainingTime);

  public Paste build();
}
