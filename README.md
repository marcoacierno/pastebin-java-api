Pastebin API -- Java
=================

This library uses the official [Pastebin API](http://pastebin.com/api) to read information from Pastebin.

The documentation and Wiki is still in working

Fast examples
===

Read paste content
---

```
final PastebinFactory factory = new PastebinFactory();
final Pastebin pastebin = factory.createPastebin(DEV_KEY);
final String pasteKey = "LAZD9ZCs";
final Response<String> pasteResponse = pastebin.getRawPaste(pasteKey);
if (pasteResponse.hasError()) {
  System.out.println("Unable to read paste content!");
  return;
}
System.out.println(pasteResponse.get());
```

Read trending pastes
---

```
final PastebinFactory factory = new PastebinFactory();
final Pastebin pastebin = factory.createPastebin(DEV_KEY);
final Response<String> pasteResponse = pastebin.getTrendingPastes();
if (pasteResponse.hasError()) {
  System.out.println("Unable to read trendings!");
  return;
}
final List<Paste> pastes = pasteResponse.get();
for(Paste paste : pastes) {
  System.out.println("Paste title: " + paste.getTitle());
}
```

Getting started
==

Examples
--

Check [this](https://github.com/rrev/pastebin-java-api/blob/master/Pastebin-Java-Examples/src/com/besaba/revonline/pastebinexamples/Examples.java) 
file for a complete working example.

How to get data from Pastebin?
--

Using `Pastebin` class you can get informations from Pastebin. 

You can create a Pastebin object using `PastebinFactory` which will be useful to create a `Paste` object too.

```
final PastebinFactory factory = new PastebinFactory();
final Pastebin pastebin = factory.createPastebin(DEV_KEY);
```

In the `createPastebin` method you should pass your [dev key](http://pastebin.com/api#1) (be sure to login in Pastebin to read it)

**NOTE** `createPastebin` doesn't check if the key passed to the method is valid or not.

Now you can use your `Pastebin` instance to do everythng you want: posting a paste, get treading pastes, get a user
key, delete a paste etc..

Every request to Pastebin is wrapped inside a `Response<T>` object. It will be used to know 
if your request has been completed with success or not.

To post a Paste you will use the `PastebinFactory` to let it create a `PasteBuilder` object for you.
You will use this Builder to insert Paste information

```
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
```

**NOTE** `PasteBuilder` return an instance of itself to allow you to chain calls.

With the above code I create a Paste with the title `My first paste`, 
with text content `My first Paste published using Pastebin Java API`,
using the syntax `text`, visibility `Public` and it will expire in ten minutes.

Our `Paste` is ready. 

```
final Paste paste = pasteBuilder.build();
```

using `.build()` method we create the `Paste` object which will be passed to `pastebin.post` to post it.

```
final Response<String> postResult = pastebin.post(paste);

if (postResult.hasError()) {
  System.out.println("Si è verificato un errore mentre postavo il paste: " + postResult.getError());
  return;
}

System.out.println("Paste pubblicato! Url: " + postResult.get());
```

It will execute a request to Pastebin which will try to post the Paste.

If something went wrong, `hasError` will return true, and using `.getError()`  you will get the reason.

If everything is OK, `get()` will contains the object you asked.

`post()` method returns the paste key.

The same logic will apply to everything else in the API.
