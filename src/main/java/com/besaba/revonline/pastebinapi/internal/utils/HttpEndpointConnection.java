package com.besaba.revonline.pastebinapi.internal.utils;

import com.besaba.revonline.pastebinapi.response.Response;
import com.besaba.revonline.pastebinapi.response.Responses;
import org.jetbrains.annotations.NotNull;

import java.io.BufferedReader;
import java.io.DataOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.OutputStream;
import java.net.HttpURLConnection;
import java.net.URI;
import java.nio.charset.StandardCharsets;

public class HttpEndpointConnection<T> {
  private static final String PASTEBIN_API_ENDPOINT    = "https://pastebin.com/api/api_post.php";
  private static final String PASTEBIN_RAW_ENDPOINT    = "https://pastebin.com/raw.php";
  private static final String PASTEBIN_LOGIN_ENDPOINT  = "https://pastebin.com/api/api_login.php";

  private final HttpParametersUtils parameters = new HttpParametersUtils();

  private final String endpoint;

  protected HttpEndpointConnection(final String endpoint) {
    this.endpoint = endpoint;
  }

  public static <T> HttpEndpointConnection<T> connectToMainEndpoint() {
    return new HttpEndpointConnection<>(PASTEBIN_API_ENDPOINT);
  }

  public static <T> HttpEndpointConnection<T> connectToRawEndpoint() {
    return new HttpEndpointConnection<>(PASTEBIN_RAW_ENDPOINT);
  }

  public static <T> HttpEndpointConnection<T> connectToLoginEndpoint() {
    return new HttpEndpointConnection<>(PASTEBIN_LOGIN_ENDPOINT);
  }

  public HttpEndpointConnection<T> addParameter(@NotNull final String key, @NotNull final String value) {
    parameters.put(key, value);
    return this;
  }

  public HttpEndpointConnection<T> removeParameter(@NotNull final String key) {
    parameters.remove(key);
    return this;
  }

  public Response<T> executeAsPost() {
    HttpURLConnection connection = null;

    try {
      connection = openConnection(endpoint);
      connection.setDoOutput(true);
      connection.setRequestMethod("POST");

      sendParameters(connection.getOutputStream(), parameters);

      final String response = buildResponse(connection.getInputStream());
      return handleResponse(response);
    } catch (final IOException e) {
      return Responses.failed("Unable to connect to Pastebin endpoint!");
    } finally {
      if (connection != null) {
        connection.disconnect();
      }
    }
  }

  public Response<T> executeAsGet() {
    HttpURLConnection connection = null;

    try {
      connection = openConnection(endpoint + "?" + parameters.toUrlFormat());
      final String response = buildResponse(connection.getInputStream());
      return handleResponse(response);
    } catch (final IOException e) {
      return Responses.failed("Unable to connect to Pastebin endpoint!");
    } finally {
      if (connection != null) {
        connection.disconnect();
      }
    }
  }

  private Response<T> handleResponse(final String response) {
    if (response.contains("Bad API request")) {
      return Responses.failed(response);
    }

    @SuppressWarnings("unchecked")
    final Response<T> successResponse = (Response<T>) Responses.success(response);
    return successResponse;
  }

  private HttpURLConnection openConnection(final String to) throws IOException {
    return (HttpURLConnection) URI
        .create(to)
        .toURL()
        .openConnection();
  }

  private String buildResponse(@NotNull final InputStream source) throws IOException {
    final BufferedReader inputReader = new BufferedReader(new InputStreamReader(source));
    final StringBuilder responseBuilder = new StringBuilder();

    for(String line; (line = inputReader.readLine()) != null;) {
      responseBuilder.append(line);
      responseBuilder.append('\n');
    }

    return responseBuilder.toString();
  }

  private void sendParameters(final OutputStream destination, final HttpParametersUtils parametersUtils) throws IOException {
    final byte[] parameters = parametersUtils.toUrlFormat().getBytes(StandardCharsets.UTF_8);
    DataOutputStream dataOutputStream = null;

    try {
      dataOutputStream = new DataOutputStream(destination);
      dataOutputStream.write(parameters);
    } finally {
      if (dataOutputStream != null) {
        dataOutputStream.close();
      }
    }
  }
}
