package com.uczelnia.plan.gui;

/**
 * MAKIETA (Faza 1): Kontroler dla widoku Zbiorczego Podsumowania.
 * Wyświetla listę wszystkich pracowników wraz z ich stopniem realizacji pensum.
 */
public class SummaryOverviewController {

    // TODO: Zdefiniować tabelę dla wszystkich pracowników
    // Kolumny: ID, Imię i Nazwisko, Pensum, Zrealizowane Godziny, Status (Nadmiar/Niedomiar/OK)

    public void initialize() {
        // Przygotowanie kolumn tabeli zbiorczej
        setupSummaryColumns();
    }

    private void setupSummaryColumns() {
        // Tu w Fazie 3 zdefiniujemy kolumny
        // Podepniemy tu również StatusCellRenderer do kolorowania wierszy na czerwono/zielono
    }

    public void loadAllEmployeesSummary() {
        // TODO: Pobranie z ReportService zbiorczej listy kart wszystkich pracowników
    }
}
