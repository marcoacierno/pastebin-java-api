package com.besaba.revonline.pastebinapi.impl.user.internal;

import com.besaba.revonline.pastebinapi.impl.xml.UserXmlHandler;
import com.besaba.revonline.pastebinapi.user.User;
import org.jetbrains.annotations.NotNull;
import org.xml.sax.InputSource;
import org.xml.sax.SAXException;

import javax.xml.parsers.ParserConfigurationException;
import javax.xml.parsers.SAXParserFactory;
import java.io.IOException;
import java.io.StringReader;

public class Users {
  @NotNull
  public static User buildFromXmlResponse(@NotNull final String response)
      throws ParserConfigurationException, SAXException, IOException {
    final UserXmlHandler userHandler = new UserXmlHandler();
    SAXParserFactory
        .newInstance()
        .newSAXParser()
        .parse(
            new InputSource(new StringReader(response)),
            userHandler
        );
    return userHandler.getUser();
  }
}