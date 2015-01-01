package com.besaba.revonline.pastebinapi.impl.factory;

import com.besaba.revonline.pastebinapi.Pastebin;
import com.besaba.revonline.pastebinapi.impl.PastebinImpl;
import com.besaba.revonline.pastebinapi.impl.paste.PasteBuilderImpl;
import com.besaba.revonline.pastebinapi.paste.PasteBuilder;
import org.jetbrains.annotations.NotNull;

public class PastebinFactory {
  public Pastebin createPastebin(@NotNull final String devKey) {
    return new PastebinImpl(devKey);
  }

  public PasteBuilder createPaste() {
    return new PasteBuilderImpl();
  }
}
