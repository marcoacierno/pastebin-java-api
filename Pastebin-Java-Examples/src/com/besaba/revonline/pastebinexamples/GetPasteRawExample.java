package com.besaba.revonline.pastebinexamples;

import com.besaba.revonline.pastebinapi.Pastebin;
import com.besaba.revonline.pastebinapi.impl.factory.PastebinFactory;
import com.besaba.revonline.pastebinapi.response.Response;

public class GetPasteRawExample {
  public static final String DEV_KEY = "";

  public static void main(String[] args) {
    PastebinFactory factory = new PastebinFactory();
    Pastebin pastebin = factory.createPastebin(DEV_KEY);

    final String pasteToRead = "eF5wrPLv";
    final Response<String> rawResponse = pastebin.getRawPaste(pasteToRead);

    if (rawResponse.hasError()) {
      System.out.println("Impossibile leggere il contenuto del paste! " + rawResponse.hasError());
      return;
    }

    System.out.println(rawResponse.get());
  }
}
