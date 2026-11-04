package com.uczelnia.plan.test;

import com.uczelnia.plan.dto.WorkloadCardDTO;
import com.uczelnia.plan.dto.WorkloadItemDTO;
import com.uczelnia.plan.gui.SummaryOverviewController;
import com.uczelnia.plan.gui.WorkloadCardController;
import com.uczelnia.plan.service.ReportService;

import javax.swing.*;
import java.awt.*;
import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;

/**
 * FAZA 4: Klasa testowa weryfikująca scenariusz z zadania.
 * Symuluje ReportService, podając z góry ustalone dane, by przetestować GUI Norberta.
 */
public class ReportIntegrationTest {

    public static void main(String[] args) {
        SwingUtilities.invokeLater(() -> {
            JFrame frame = new JFrame("TEST FAZY 4: Raporty i Podsumowania - Norbert");
            frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
            frame.setSize(800, 500);
            frame.setLocationRelativeTo(null);

            // 1. Tworzymy zmockowany serwis raportowy zawierający warianty z zadania
            ReportService mockService = createMockReportService();

            // 2. Przygotowujemy kontrolery
            WorkloadCardController cardController1 = new WorkloadCardController(mockService);
            WorkloadCardController cardController2 = new WorkloadCardController(mockService);
            WorkloadCardController cardController3 = new WorkloadCardController(mockService);
            SummaryOverviewController summaryController = new SummaryOverviewController(mockService);

            // Ładujemy dane dla poszczególnych pracowników
            cardController1.loadEmployeeData(1L); // Pracownik 1 (30h)
            cardController2.loadEmployeeData(2L); // Pracownik 2 (10h) - Niedomiar (czerwony)
            cardController3.loadEmployeeData(3L); // Pracownik 3 (20h)
            summaryController.loadAllEmployeesSummary(Arrays.asList(1L, 2L, 3L));

            // 3. Budujemy układ w zakładkach, aby pokazać wszystkie widoki na raz
            JTabbedPane tabbedPane = new JTabbedPane();
            tabbedPane.addTab("Karta: Pracownik 1 (30h)", cardController1.getMainPanel());
            tabbedPane.addTab("Karta: Pracownik 2 (10h - Błąd)", cardController2.getMainPanel());
            tabbedPane.addTab("Karta: Pracownik 3 (20h)", cardController3.getMainPanel());
            tabbedPane.addTab("Podsumowanie Zbiorcze", summaryController.getMainPanel());

            frame.add(tabbedPane, BorderLayout.CENTER);
            frame.setVisible(true);
        });
    }

    /**
     * Nadpisujemy ReportService, aby zwracał "sztywne" dane dla scenariusza:
     * Przedmiot "Łączność w systemach radiokomunikacyjnych (497)": 60 roboczogodzin łącznie.
     * Wariant 2 z zadania: Pracownik1 (30h), Pracownik2 (10h), Pracownik3 (20h).
     */
    private static ReportService createMockReportService() {
        return new ReportService(null, null) {
            @Override
            public WorkloadCardDTO generateWorkloadCard(Long employeeId) {
                WorkloadCardDTO card = new WorkloadCardDTO();
                card.setEmployeeId(employeeId);
                card.setPensumLimit(20);    // Ustalmy testowe pensum na 20h
                card.setMaxPensumLimit(60); // 3x pensum

                // Dane wspólne przedmiotu z zadania
                String courseName = "Łączność w sys. radiokom. (497)";
                String semester = "Zimowy";
                
                if (employeeId == 1L) {
                    card.setEmployeeName("Pracownik 1 (Wariant 2)");
                    card.getWorkloadItems().add(new WorkloadItemDTO(courseName, semester, "Stacjonarne", 30, 0, 0, 0));
                    card.setTotalCalculatedHours(30); // 30h - OK (pensum 20-60)
                } else if (employeeId == 2L) {
                    card.setEmployeeName("Pracownik 2 (Wariant 2)");
                    card.getWorkloadItems().add(new WorkloadItemDTO(courseName, semester, "Stacjonarne", 10, 0, 0, 0));
                    card.setTotalCalculatedHours(10); // 10h - NIEDOMIAR (błąd, powinno być na czerwono)
                } else if (employeeId == 3L) {
                    card.setEmployeeName("Pracownik 3 (Wariant 2)");
                    card.getWorkloadItems().add(new WorkloadItemDTO(courseName, semester, "Niestacjonarne", 0, 20, 0, 0));
                    card.setTotalCalculatedHours(20); // 20h - OK
                }

                // Własnoręczna logika walidacji na potrzeby mocka
                card.setHasErrors(card.getTotalCalculatedHours() < card.getPensumLimit() || 
                                  card.getTotalCalculatedHours() > card.getMaxPensumLimit());

                return card;
            }
        };
    }
}
