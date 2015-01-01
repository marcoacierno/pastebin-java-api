package com.besaba.revonline.pastebinapi.impl.xml;

import com.besaba.revonline.pastebinapi.impl.user.UserBuilderImpl;
import com.besaba.revonline.pastebinapi.paste.PasteExpire;
import com.besaba.revonline.pastebinapi.paste.PasteVisiblity;
import com.besaba.revonline.pastebinapi.user.AccountType;
import com.besaba.revonline.pastebinapi.user.User;
import com.besaba.revonline.pastebinapi.user.internal.UserBuilder;
import org.xml.sax.SAXException;
import org.xml.sax.helpers.DefaultHandler;

public class UserXmlHandler extends DefaultHandler {
  private UserBuilder user = new UserBuilderImpl();
  private StringBuilder valueBuilder = new StringBuilder();

  @Override
  public void characters(final char[] ch, final int start, final int length) throws SAXException {
    valueBuilder.append(ch, start, length);
  }

  @Override
  public void endElement(final String uri, final String localName, final String qName) throws SAXException {
    final String value = valueBuilder.toString();

    switch (qName) {
      case "user_name":
        user.setUserName(value);
        break;
      case "user_avatar_url":
        user.setAvatarUrl(value);
        break;
      case "user_website":
        user.setWebsite(value);
        break;
      case "user_email":
        user.setEmail(value);
        break;
      case "user_location":
        user.setLocation(value);
        break;
      case "user_account_type":
        user.setAccountType(AccountType.fromValue(Integer.parseInt(value)));
        break;
      case "user_format_short":
        user.setDefaultPasteLanguage(value);
        break;
      case "user_expiration":
        user.setDefaultPasteExpiration(PasteExpire.fromValue(value));
        break;
      case "user_private":
        user.setDefaultPasteVisibility(PasteVisiblity.fromValue(Integer.parseInt(value)));
        break;
    }

    valueBuilder = new StringBuilder();
  }

  public User getUser() {
    return user.build();
  }
}
