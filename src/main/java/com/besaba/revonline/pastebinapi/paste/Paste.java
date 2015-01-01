package com.besaba.revonline.pastebinapi.paste;

import com.besaba.revonline.pastebinapi.response.Response;

/**
 * Rappresenta un paste
 */
public interface Paste {
  /**
   * Deve ritornare la chiave del Paste, un identificatore univoco per ogni paste.
   *
   * @return Identificatore univoco di ogni paste
   */
  public String getKey();

  /**
   * @return Il risultato della richiesta del titolo del paste
   */
  public String getTitle();

  /**
   * @return Il risultato della richiesta della lunghezza del paste (in bytes)
   */
  public long getSize();

  /**
   * @return Il risultato della richiesta del linguaggio in un formato amichevole per l'utente
   */
  public String getUserFriendlyLanguage();

  /**
   * @return Il risultato della richiesta del linguaggio in un formato amichevole per la macchina
   */
  public String getMachineFriendlyLanguage();

  /**
   * @return Ritorna il numero di visite di un paste
   */
  public int getHits();

  /**
   * @return Ritorna il risultato della richiesta del livello di visiblità del paste
   */
  public PasteVisiblity getVisiblity();

  /**
   * @return Ritorna il risultato della richiesta del valore Expire del paste
   */
  public PasteExpire getExpire();

  public long getPublishDate();

  public long getRemainingTime();

  /**
   * @return Il risultato della richiesta di ottenere il contenuto del paste
   */
  public Response<String> getRaw();
}
