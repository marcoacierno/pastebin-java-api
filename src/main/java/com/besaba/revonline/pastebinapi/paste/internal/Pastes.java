package com.besaba.revonline.pastebinapi.paste.internal;

import com.besaba.revonline.pastebinapi.impl.xml.ParseXmlHandler;
import com.besaba.revonline.pastebinapi.paste.Paste;
import com.besaba.revonline.pastebinapi.response.Response;
import com.besaba.revonline.pastebinapi.utils.HttpEndpointConnection;
import org.jetbrains.annotations.NotNull;
import org.xml.sax.InputSource;
import org.xml.sax.SAXException;

import javax.xml.parsers.ParserConfigurationException;
import javax.xml.parsers.SAXParserFactory;
import java.io.IOException;
import java.io.StringReader;
import java.util.List;

public class Pastes {
  public static Response<String> download(@NotNull final String key) {
    final HttpEndpointConnection<String> endpointConnection = HttpEndpointConnection.connectToRawEndpoint();
    endpointConnection.addParameter("i", key);
    return endpointConnection.executeAsGet();
  }

  public static List<Paste> getPastesFromXmlResponse(final String response)
      throws SAXException, IOException, ParserConfigurationException {
    final ParseXmlHandler xmlParser = new ParseXmlHandler();
    SAXParserFactory.newInstance().newSAXParser().parse(
        new InputSource(new StringReader(response)),
        xmlParser
    );

    return xmlParser.getPastes();
  }
}
