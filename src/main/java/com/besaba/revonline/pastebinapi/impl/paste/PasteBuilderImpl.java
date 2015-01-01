package com.besaba.revonline.pastebinapi.impl.paste;

import com.besaba.revonline.pastebinapi.paste.Paste;
import com.besaba.revonline.pastebinapi.paste.PasteBuilder;
import com.besaba.revonline.pastebinapi.paste.PasteExpire;
import com.besaba.revonline.pastebinapi.paste.PasteVisiblity;

public class PasteBuilderImpl implements PasteBuilder {
  private String key;
  private String title;
  private long size;
  private String userLanguage;
  private String machineLanguage;
  private int hits;
  private String raw;
  private PasteVisiblity visiblity;
  private PasteExpire expire;
  private long publishDate;
  private long remainingTime;

  @Override
  public PasteBuilder setKey(final String key) {
    this.key = key;
    return this;
  }

  @Override
  public PasteBuilder setTitle(final String title) {
    this.title = title;
    return this;
  }

  @Override
  public PasteBuilder setSize(final long size) {
    this.size = size;
    return this;
  }

  @Override
  public PasteBuilder setUserFriendlyLanguage(final String language) {
    this.userLanguage = language;
    return this;
  }

  @Override
  public PasteBuilder setMachineFriendlyLanguage(final String language) {
    this.machineLanguage = language;
    return this;
  }

  @Override
  public PasteBuilder setHits(final int hits) {
    this.hits = hits;
    return this;
  }

  @Override
  public PasteBuilder setExpire(final PasteExpire expire) {
    this.expire = expire;
    return this;
  }

  @Override
  public PasteBuilder setRaw(final String raw) {
    this.raw = raw;
    return this;
  }

  @Override
  public PasteBuilder setVisiblity(final PasteVisiblity visibility) {
    this.visiblity = visibility;
    return this;
  }

  @Override
  public PasteBuilder setPublishDate(final long publishDate) {
    this.publishDate = publishDate;
    return this;
  }

  @Override
  public PasteBuilder setRemainingTime(final long remainingTime) {
    this.remainingTime = remainingTime;
    return this;
  }

  @Override
  public Paste build() {
    return new PasteImpl(
        key,
        title,
        size,
        userLanguage,
        machineLanguage,
        hits,
        visiblity,
        expire,
        raw,
        publishDate,
        remainingTime
    );
  }
}
