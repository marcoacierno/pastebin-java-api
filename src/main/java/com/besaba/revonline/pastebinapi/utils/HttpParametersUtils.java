package com.besaba.revonline.pastebinapi.utils;

import java.io.UnsupportedEncodingException;
import java.net.URLEncoder;
import java.nio.charset.StandardCharsets;
import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;
import java.util.concurrent.ConcurrentMap;

/**
 *
 */
public class HttpParametersUtils {
  private final ConcurrentMap<String, String> parameters = new ConcurrentHashMap<>();

  public void put(final String key, final String value) {
    try {
      parameters.put(URLEncoder.encode(key, StandardCharsets.UTF_8.displayName()), URLEncoder.encode(value, StandardCharsets.UTF_8.displayName()));
    } catch (UnsupportedEncodingException e) {
      throw new AssertionError(e);// can't happen
    }
  }

  public void remove(final String key) {
    try {
      parameters.remove(URLEncoder.encode(key, StandardCharsets.UTF_8.displayName()));
    } catch (UnsupportedEncodingException e) {
      throw new AssertionError(e); // can't happen
    }
  }

  public String toUrlFormat() {
    final StringBuilder builder = new StringBuilder();

    for (final Map.Entry<String, String> entry : parameters.entrySet()) {
      builder.append(entry.getKey())
          .append("=")
          .append(entry.getValue())
          .append("&");
    }

    if (builder.length() > 0) {
      builder.setLength(builder.length() - 1);
    }

    return builder.toString();
  }
}
