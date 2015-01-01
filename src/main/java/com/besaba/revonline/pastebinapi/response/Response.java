package com.besaba.revonline.pastebinapi.response;

import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

/**
 * It's a Response from the Pastebin
 */
public interface Response<T> {
  /**
   * If the request has been completed with success, it should return the object or
   * should throw ParseException if failed.
   *
   *
   * @see Response#hasError()
   * @return If it's a successful request, it returns the object.
   */
  @NotNull
  public T get();

  /**
   * It should return true if the request failed, or false if not.
   *
   */
  public boolean hasError();

  /**
   * @return null if the request has been completed with success. Or the error string
   * if the request failed.
   */
  @Nullable
  public String getError();
}
