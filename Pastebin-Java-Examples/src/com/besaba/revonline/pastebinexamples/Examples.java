package com.besaba.revonline.pastebinexamples;

import com.besaba.revonline.pastebinapi.Pastebin;
import com.besaba.revonline.pastebinapi.impl.factory.PastebinFactory;
import com.besaba.revonline.pastebinapi.paste.Paste;
import com.besaba.revonline.pastebinapi.paste.PasteBuilder;
import com.besaba.revonline.pastebinapi.paste.PasteExpire;
import com.besaba.revonline.pastebinapi.paste.PasteVisiblity;
import com.besaba.revonline.pastebinapi.response.Response;
import com.besaba.revonline.pastebinapi.user.User;

import java.util.List;

public class Examples {
  // replace with your dev key
  private static final String DEV_KEY = "";
  public static final String USER_NAME = "";
  public static final String USER_PASSWORD = "";

  // create the pastebin factory and pastebin main object
  private static PastebinFactory factory = new PastebinFactory();
  private static Pastebin pastebin = factory.createPastebin(DEV_KEY);

  public static void main(String[] args) {
//    exampleGetTrendingPastes();
//    examplePostPaste();
//    exampleRaw();
//    exampleUserPastes();
//    exampleGetUserInfo();
    examplePostLoggedPaste();
  }

  private static void examplePostLoggedPaste() {
    final Response<String> userLoginKeyResponse = pastebin.login(USER_NAME, USER_PASSWORD);

    if (userLoginKeyResponse.hasError()) {
      System.out.println("Impossibile loggarti, " + userLoginKeyResponse.getError());
      return;
    }

    final String userKey = userLoginKeyResponse.get();

    // get a pastebuilder to build the paste I want to publish
    final PasteBuilder pasteBuilder = factory.createPaste();

    // Title paste
    pasteBuilder.setTitle("My first paste");
    // What will be inside the paste?
    pasteBuilder.setRaw("My first Paste published using Pastebin Java API");
    // Which syntax will use the paste?
    pasteBuilder.setMachineFriendlyLanguage("text");
    // What is the visibility of this paste?
    pasteBuilder.setVisiblity(PasteVisiblity.Public);
    // When the paste will expire?
    pasteBuilder.setExpire(PasteExpire.TenMinutes);

    // when i'm ready, create the Paste object
    final Paste paste = pasteBuilder.build();

    // ask to Pastebin to post the paste
    // the .post method: if the paste has been published will return the key assigned
    // by pastebin
    final Response<String> postResult = pastebin.post(paste, userKey);

    if (postResult.hasError()) {
      System.out.println("Si è verificato un errore mentre postavo il paste: " + postResult.getError());
      return;
    }

    System.out.println("Paste pubblicato! Url: " + postResult.get());
  }

  private static void exampleGetUserInfo() {
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

  private static void exampleUserPastes() {
    final Response<String> userLoginKeyResponse = pastebin.login(USER_NAME, USER_PASSWORD);

    if (userLoginKeyResponse.hasError()) {
      System.out.println("Impossibile loggarsi! " + userLoginKeyResponse.getError());
      return;
    }

    final String userKey = userLoginKeyResponse.get();

    final Response<List<Paste>> pastesResponse = pastebin.getPastesOf(userKey, 5);

    if (pastesResponse.hasError()) {
      System.out.println("Impossibile leggere i pastes! " + pastesResponse.getError());
      return;
    }

    final List<Paste> pastes = pastesResponse.get();

    for (final Paste paste : pastes) {
      System.out.println(paste.getTitle());
      System.out.println("---");
    }
  }

  private static void exampleRaw() {
    final String pasteToRead = "eF5wrPLv";
    final Response<String> rawResponse = pastebin.getRawPaste(pasteToRead);

    if (rawResponse.hasError()) {
      System.out.println("Impossibile leggere il contenuto del paste! " + rawResponse.hasError());
      return;
    }

    System.out.println(rawResponse.get());
  }

  private static void examplePostPaste() {
    // get a pastebuilder to build the paste I want to publish
    final PasteBuilder pasteBuilder = factory.createPaste();

    // Title paste
    pasteBuilder.setTitle("My first paste");
    // What will be inside the paste?
    pasteBuilder.setRaw("My first Paste published using Pastebin Java API");
    // Which syntax will use the paste?
    pasteBuilder.setMachineFriendlyLanguage("text");
    // What is the visibility of this paste?
    pasteBuilder.setVisiblity(PasteVisiblity.Public);
    // When the paste will expire?
    pasteBuilder.setExpire(PasteExpire.TenMinutes);

    // when i'm ready, create the Paste object
    final Paste paste = pasteBuilder.build();

    // ask to Pastebin to post the paste
    // the .post method: if the paste has been published will return the key assigned
    // by pastebin
    final Response<String> postResult = pastebin.post(paste);

    if (postResult.hasError()) {
      System.out.println("Si è verificato un errore mentre postavo il paste: " + postResult.getError());
      return;
    }

    System.out.println("Paste pubblicato! Url: " + postResult.get());
  }

  /**
   * In this example the API will ask to Pastebin to get all the
   * trending pastes and will print in the console the name
   * of the paste and the hits
   */
  private static void exampleGetTrendingPastes() {
    final Response<List<Paste>> trendingPastesResponse = pastebin.getTrendingPastes();

    if (trendingPastesResponse.hasError()) {
      System.out.println("Impossibile leggere i trending pastes: " + trendingPastesResponse.getError());
      return;
    }

    final List<Paste> trendingPastes = trendingPastesResponse.get();
    for (final Paste trendingPaste : trendingPastes) {
      System.out.println("Paste " + trendingPaste.getTitle());
      System.out.println("Hits: " + trendingPaste.getHits());

      System.out.println("----");
    }
  }
}
