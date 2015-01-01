package com.besaba.revonline.pastebinapi;

import com.besaba.revonline.pastebinapi.paste.Paste;
import com.besaba.revonline.pastebinapi.response.Response;
import com.besaba.revonline.pastebinapi.user.User;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

import java.util.List;

/**
 * La classe principale che permette di comunicare a Pastebin.
 */
public interface Pastebin {
  @NotNull
  public Response<String> post(@NotNull final Paste paste);
  @NotNull
  public Response<String> post(@NotNull final Paste paste, @Nullable final String userKey);
  @NotNull
  public Response<List<Paste>> getTrendingPastes();
  @NotNull
  public Response<String> getRawPaste(final String pasteKey);
  @NotNull
  public Response<String> login(@NotNull final String userName, @NotNull final String password);
  @NotNull
  public Response<User> getUser(@NotNull final String userKey);
  @NotNull
  public Response<List<Paste>> getPastesOf(@NotNull final String userKey);
  @NotNull
  public Response<List<Paste>> getPastesOf(@NotNull final String userKey, final int limit);
  public Response<Boolean> deletePaste(@NotNull final String pasteKey, @NotNull final String userKey);
}
