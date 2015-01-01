package com.besaba.revonline.pastebinapi.response;

import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

/**
 * Rappresenta una risposta ottenuta dalla API
 */
public interface Response<T> {
  /**
   * Deve leggere il valore che la richiesta ha prodotto se presente (quindi hasError() == false)
   * altrimenti generare l'eccezione PasteException
   *
   * @return Se presente ritorna il risultato della risposta oppure genera PasteException
   */
  @NotNull
  public T get();

  /**
   * Deve ritornare true se la richiesta è fallita e quindi una chiamata a get()
   * può causare l'eccezione PasteException oppure false se la richiesta
   * è stata completata con successo.
   */
  public boolean hasError();

  /**
   * Se hasError() ritorna false questo metodo deve contenere il motivo per cui la
   * richiesta è fallita.
   * <p/>
   * Se hasError() ritorna true, questo metodo può ritornare null.
   *
   * @return Il metivo del fallimento
   */
  @Nullable
  public String getError();
}
