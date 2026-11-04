package com.uczelnia.plan.gui;

/**
 * MAKIETA (Faza 1): Kontroler dla widoku Karty Obciążeń pojedynczego pracownika.
 * Docelowo będzie zawierał tabelę (np. TableView) prezentującą listę WorkloadItemDTO.
 */
public class WorkloadCardController {

    // TODO: Zdefiniować elementy UI (np. @FXML TableView<WorkloadItemDTO> workloadTable)
    // TODO: Zdefiniować kolumny (Przedmiot, Semestr, Tryb, W, C, L, P, Suma)
    // TODO: Zdefiniować etykiety podsumowujące (Pracownik, Suma godzin, Pensum)

    public void initialize() {
        // Inicjalizacja makiet - przygotowanie struktury kolumn tabeli
        setupColumns();
    }

    private void setupColumns() {
        // Tu w Fazie 3 podepniemy właściwości z WorkloadItemDTO do kolumn tabeli
        // np. wywołanie setCellValueFactory dla W, C, L, P
    }

    public void loadEmployeeData(Long employeeId) {
        // TODO: W Fazie 3 wywołamy tu ReportService.java, aby pobrać WorkloadCardDTO
        // i zasilimy tabelę pobranymi danymi.
    }
}
