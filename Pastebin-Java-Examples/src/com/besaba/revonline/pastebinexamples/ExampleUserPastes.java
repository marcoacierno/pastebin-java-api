package com.besaba.revonline.pastebinexamples;

import com.besaba.revonline.pastebinapi.Pastebin;
import com.besaba.revonline.pastebinapi.impl.factory.PastebinFactory;
import com.besaba.revonline.pastebinapi.paste.Paste;
import com.besaba.revonline.pastebinapi.response.Response;

import java.util.List;

public class ExampleUserPastes {
  public static final String DEV_KEY = "";
  public static final String USER_NAME = "";
  public static final String USER_PASSWORD = "";

  public static void main(String[] args) {
    PastebinFactory factory = new PastebinFactory();
    Pastebin pastebin = factory.createPastebin(DEV_KEY);

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
}
