package com.besaba.revonline.pastebinapi.impl.xml;

import com.besaba.revonline.pastebinapi.impl.paste.PasteBuilderImpl;
import com.besaba.revonline.pastebinapi.paste.Paste;
import com.besaba.revonline.pastebinapi.paste.PasteBuilder;
import com.besaba.revonline.pastebinapi.paste.PasteVisiblity;
import org.xml.sax.Attributes;
import org.xml.sax.SAXException;
import org.xml.sax.helpers.DefaultHandler;

import java.util.ArrayList;
import java.util.List;

public class ParseXmlHandler extends DefaultHandler {

  private static final String XML_ROOT_ELEMENT = "paste";
  private static final String XML_PASTE_KEY = "paste_key";
  private static final String XML_PASTE_DATE = "paste_date";
  private static final String XML_PASTE_TITLE = "paste_title";
  private static final String XML_PASTE_LANGUAGE = "paste_format_long";
  private static final String XML_PASTE_MACHINE_LANGUAGE = "paste_format_short";
  private static final String XML_PASTE_HITS = "paste_hits";
  private static final String XML_PASTE_PRIVATE = "paste_private";
  private static final String XML_PASTE_SIZE = "paste_size";
  private static final String XML_EXPIRE_DATE = "paste_expire_date";

  private List<Paste> pastes = new ArrayList<>();
  private boolean onElement;
  private String value;
  private PasteBuilder info;

  @Override
  public void endDocument() throws SAXException {
    if (info != null) {
      pastes.add(info.build());
      value = "Untitled";
    }
  }

  @Override
  public void startElement(String uri, String localName, String qName, Attributes attributes)
      throws SAXException {
    onElement = true;

    if (qName.equals(XML_ROOT_ELEMENT)) {

      if (info != null) {
        pastes.add(info.build());
        info = null;
      }

      info = new PasteBuilderImpl();
    }
  }

  @Override
  public void endElement(String uri, String localName, String qName) throws SAXException {
    onElement = false;

    switch (qName) {
      case XML_PASTE_KEY:
        info.setKey(value);
        break;
      case XML_PASTE_TITLE:
        info.setTitle(value);
        break;
      case XML_PASTE_LANGUAGE:
        info.setUserFriendlyLanguage(value);
        break;
      case XML_PASTE_MACHINE_LANGUAGE:
        info.setMachineFriendlyLanguage(value);
        break;
      case XML_PASTE_HITS:
        info.setHits(Integer.parseInt(value));
        break;
      case XML_PASTE_PRIVATE:
        info.setVisiblity(PasteVisiblity.fromValue(Integer.parseInt(value)));
        break;
      case XML_PASTE_SIZE:
        info.setSize(Long.parseLong(value));
        break;
      case XML_PASTE_DATE:
        info.setPublishDate(Long.parseLong(value) * 1000);
        break;
      case XML_EXPIRE_DATE:
        info.setRemainingTime(Long.parseLong(value) * 1000);
        break;
    }
  }

  @Override
  public void characters(char[] ch, int start, int length) throws SAXException {
    if (onElement) {
      value = new String(ch, start, length);
      onElement = false;
    }
  }

  public List<Paste> getPastes() {
    return pastes;
  }

  /*
     <paste>
     K<paste_key>4eWYATXe</paste_key>
     <paste_date>1319458935</paste_date>
     K<paste_title>577 French MPs</paste_title>
     K<paste_size>29397</paste_size>
     K<paste_expire_date>0</paste_expire_date>
     K<paste_private>0</paste_private>
     K<paste_format_long>None</paste_format_long>
     K<paste_format_short>text</paste_format_short>
     <paste_url>http://pastebin.com/4eWYATXe</paste_url>
     K<paste_hits>804</paste_hits>
     </paste>
     */
}
