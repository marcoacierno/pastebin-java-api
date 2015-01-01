package com.besaba.revonline.pastebinapi.response;

/**
 *
 */
public class Responses {
  public static <T> Response<T> success(final T data) {
    return new SuccessResponse<>(data);
  }

  public static <T> Response<T> failed(final String reason) {
    return new FailedResponse<>(reason);
  }
}
