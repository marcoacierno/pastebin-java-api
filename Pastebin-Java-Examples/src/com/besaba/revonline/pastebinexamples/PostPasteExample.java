package com.besaba.revonline.pastebinexamples;

import com.besaba.revonline.pastebinapi.Pastebin;
import com.besaba.revonline.pastebinapi.impl.factory.PastebinFactory;
import com.besaba.revonline.pastebinapi.paste.Paste;
import com.besaba.revonline.pastebinapi.paste.PasteBuilder;
import com.besaba.revonline.pastebinapi.paste.PasteExpire;
import com.besaba.revonline.pastebinapi.paste.PasteVisiblity;
import com.besaba.revonline.pastebinapi.response.Response;

public class PostPasteExample {
  public static final String DEV_KEY = "";

  public static void main(String[] args) {
    PastebinFactory factory = new PastebinFactory();
    Pastebin pastebin = factory.createPastebin(DEV_KEY);
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
      System.out.println("Something wrong: " + postResult.getError());
      return;
    }

    System.out.println("Paste published! Url: " + postResult.get());
  }
}
