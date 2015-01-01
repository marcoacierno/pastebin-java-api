package com.besaba.revonline.pastebinapi.impl.paste;

import com.besaba.revonline.pastebinapi.paste.Paste;
import com.besaba.revonline.pastebinapi.paste.PasteExpire;
import com.besaba.revonline.pastebinapi.paste.PasteVisiblity;
import com.besaba.revonline.pastebinapi.paste.internal.Pastes;
import com.besaba.revonline.pastebinapi.response.Response;
import com.besaba.revonline.pastebinapi.response.Responses;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

public class PasteImpl implements Paste {
  @Nullable
  private final String key;
  @NotNull
  private final String title;
  private final long size;
  @Nullable
  private final String userFriendlyLanguage;
  @Nullable
  private final String machineFriendlyLanguage;
  private final int hits;
  @NotNull
  private final PasteVisiblity visiblity;
  @Nullable
  private final PasteExpire expire;
  private String raw;
  private final long remainingTime;
  private final long publishDate;

  PasteImpl(@Nullable final String key,
            @NotNull final String title,
            final long size,
            @Nullable final String userFriendlyLanguage,
            @Nullable final String machineFriendlyLanguage,
            final int hits,
            @NotNull final PasteVisiblity visiblity,
            @Nullable final PasteExpire expire,
            final String raw,
            final long publishDate,
            final long remainingTime) {
    this.key = key;
    this.title = title;
    this.size = size;
    this.userFriendlyLanguage = userFriendlyLanguage;
    this.machineFriendlyLanguage = machineFriendlyLanguage;
    this.hits = hits;
    this.visiblity = visiblity;
    this.expire = expire;
    this.raw = raw;
    this.publishDate = publishDate;
    this.remainingTime = remainingTime;
  }

  @Nullable
  @Override
  public String getKey() {
    return key;
  }

  @NotNull
  @Override
  public String getTitle() {
    return title;
  }

  @Override
  public long getSize() {
    return size;
  }

  @Nullable
  @Override
  public String getUserFriendlyLanguage() {
    return userFriendlyLanguage;
  }

  @Nullable
  @Override
  public String getMachineFriendlyLanguage() {
    return machineFriendlyLanguage;
  }

  @Override
  public int getHits() {
    return hits;
  }

  @NotNull
  @Override
  public PasteVisiblity getVisiblity() {
    return visiblity;
  }

  @Nullable
  @Override
  public PasteExpire getExpire() {
    return expire;
  }

  @Override
  public long getPublishDate() {
    return publishDate;
  }

  @Override
  public long getRemainingTime() {
    return remainingTime;
  }

  @NotNull
  @Override
  public Response<String> getRaw() {
    // if raw != null it means that I already downloaded the paste or the paste has been builded manually
    if (raw != null) {
      return Responses.success(raw);
    }

    // without a key I cannot download the paste
    if (key == null) {
      return Responses.failed("This paste doesn't support the raw response");
    }

    final Response<String> pasteDownloadResponse = Pastes.download(key);

    if (pasteDownloadResponse.hasError()) {
      return pasteDownloadResponse;
    }

    raw = pasteDownloadResponse.get();
    return Responses.success(raw);
  }
}
