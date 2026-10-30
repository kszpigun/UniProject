// Klaudia - klasa reprezentujaca pojedynczy blad
package main.java.com.uczelnia.plan.validation;

public class ValidationError {
  private String fieldName; // nazwa pola w ktorym wystapil blad
  private String message; // tresc komunikatu dla uzytkownika
  private boolean isCritical; // krytyczny - czerwony, ostrzezenie - pomaranczowy
  // Konstruktor
  public ValidationError(String fieldName, String message, boolean isCritical) {
    this.fieldName = fieldName;
    this.message = message;
    this.isCritical = isCritical;
  }
  // Gettery
  public String getFieldName() {
    return fieldName;
  }
  public String getMessage() {
    return message;
  }
  public boolean getIsCritical() {
    return isCritical;
  }
}