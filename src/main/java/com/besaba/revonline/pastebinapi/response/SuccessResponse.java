package com.besaba.revonline.pastebinapi.response;

import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

/**
 *
 */
public class SuccessResponse<T> implements Response<T> {
  private final T result;

  public SuccessResponse(final T result) {
    this.result = result;
  }

  @NotNull
  @Override
  public T get() {
    return result;
  }

  @Override
  public boolean hasError() {
    return false;
  }

  @Nullable
  @Override
  public String getError() {
    return null;
  }
}
