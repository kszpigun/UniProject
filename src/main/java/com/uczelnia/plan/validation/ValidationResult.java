// Klaudia - zbior bledow (do zwrotu do GUI)
package main.java.com.uczelnia.plan.validation;

import java.util.ArrayList;
import java.util.List;

public class ValidationResult {
  // lista na obiekty typu ValidatinError - ten obiekt zwraca: 1. nazwe miejsca gdzie jest blad, 2. tresc bledu, 3. czy blad jest krytyczny
  // w cpp - vector <ValidationError> errors;
  private List<ValidationError> errors = new ArrayList<>();

  // metoda pomocnicza do szybkiego dodawania nowego bledu
  public void addError(String field, String message, boolean isCritical) {
    errors.add(new ValidationError(field, message, isCritical)); // .add() to odpowiednik .push_back()
  }

  // czy sa jakies bledy
  public boolean isValid() {
    return errors.isEmpty();
  }

  // zwraca cala liste bledow, aby GUI moglo ja wyswietlic
  public List<ValidationError> getErrors() {
    return errors; // zwraca cala liste
  }
}