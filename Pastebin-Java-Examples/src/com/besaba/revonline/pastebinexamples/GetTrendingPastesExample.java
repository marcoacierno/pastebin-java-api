package com.besaba.revonline.pastebinexamples;

import com.besaba.revonline.pastebinapi.Pastebin;
import com.besaba.revonline.pastebinapi.impl.factory.PastebinFactory;
import com.besaba.revonline.pastebinapi.paste.Paste;
import com.besaba.revonline.pastebinapi.response.Response;

import java.util.List;

public class GetTrendingPastesExample {
  public static final String DEV_KEY = "";

  public static void main(String[] args) {
    PastebinFactory factory = new PastebinFactory();
    Pastebin pastebin = factory.createPastebin(DEV_KEY);

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
