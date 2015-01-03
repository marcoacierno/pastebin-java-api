package com.besaba.revonline.pastebinexamples;

import com.besaba.revonline.pastebinapi.Pastebin;
import com.besaba.revonline.pastebinapi.impl.factory.PastebinFactory;
import com.besaba.revonline.pastebinapi.response.Response;
import com.besaba.revonline.pastebinapi.user.User;

public class GetUserInfoExample {
  public static final String DEV_KEY = "";
  public static final String USER_NAME = "";
  public static final String USER_PASSWORD = "";

  public static void main(String[] args) {
    PastebinFactory factory = new PastebinFactory();
    Pastebin pastebin = factory.createPastebin(DEV_KEY);

    final Response<String> userLoginKeyResponse = pastebin.login(USER_NAME, USER_PASSWORD);

    if (userLoginKeyResponse.hasError()) {
      System.out.println("Impossibile loggarti, " + userLoginKeyResponse.getError());
      return;
    }

    final String userKey = userLoginKeyResponse.get();
    final Response<User> userResponse = pastebin.getUser(userKey);

    if (userResponse.hasError()) {
      System.out.println("Impossibile ottenere le informazioni dell'utente, " + userResponse.getError());
      return;
    }

    final User user = userResponse.get();

    System.out.println("Name: " + user.getUserName());
    System.out.println("Email: " + user.getEmail());
    System.out.println("Location: " + user.getLocation());
    System.out.println("Account type: " + user.getAccountType());
    System.out.println("Default paste language: " + user.getDefaultPasteLanguage());
    System.out.println("Default paste expiration: " + user.getDefaultPasteExpiration());
    System.out.println("Default paste visibility: " + user.getDefaultPasteVisibility());
  }
}
