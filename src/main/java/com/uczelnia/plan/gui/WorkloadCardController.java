package com.uczelnia.plan.gui;

import com.uczelnia.plan.dto.WorkloadCardDTO;
import com.uczelnia.plan.dto.WorkloadItemDTO;
import com.uczelnia.plan.service.ReportService;

import javax.swing.*;
import javax.swing.table.AbstractTableModel;
import java.awt.*;
import java.util.ArrayList;
import java.util.List;

public class WorkloadCardController {

    private JPanel mainPanel;
    private JLabel employeeNameLabel;
    private JLabel pensumLabel;
    private JLabel totalHoursLabel;
    private JTable workloadTable;
    private WorkloadTableModel tableModel;

    private ReportService reportService;

    public WorkloadCardController(ReportService reportService) {
        this.reportService = reportService;
        initializeUI();
    }

    private void initializeUI() {
        mainPanel = new JPanel(new BorderLayout());

        // Panel z podsumowaniem (góra)
        JPanel topPanel = new JPanel(new GridLayout(3, 1));
        employeeNameLabel = new JLabel("Pracownik: -");
        pensumLabel = new JLabel("Pensum: -");
        totalHoursLabel = new JLabel("Suma godzin: -");
        
        topPanel.add(employeeNameLabel);
        topPanel.add(pensumLabel);
        topPanel.add(totalHoursLabel);
        mainPanel.add(topPanel, BorderLayout.NORTH);

        // Tabela z przydziałami (środek)
        tableModel = new WorkloadTableModel();
        workloadTable = new JTable(tableModel);
        mainPanel.add(new JScrollPane(workloadTable), BorderLayout.CENTER);
    }

    public JPanel getMainPanel() {
        return mainPanel;
    }

    public void loadEmployeeData(Long employeeId) {
        if (reportService == null) return;

        WorkloadCardDTO card = reportService.generateWorkloadCard(employeeId);
        
        // Aktualizacja etykiet
        employeeNameLabel.setText("Pracownik: " + card.getEmployeeName());
        pensumLabel.setText("Pensum: " + card.getPensumLimit() + " (Max: " + card.getMaxPensumLimit() + ")");
        totalHoursLabel.setText("Suma godzin: " + card.getTotalCalculatedHours());

        // Kolorowanie etykiety sumy (na czerwono jeśli jest błąd)
        if (card.isHasErrors()) {
            totalHoursLabel.setForeground(Color.RED);
        } else {
            totalHoursLabel.setForeground(new Color(0, 150, 0));
        }

        // Zasilenie tabeli
        tableModel.setItems(card.getWorkloadItems());
    }

    // --- Model Tabeli w Swingu ---
    private static class WorkloadTableModel extends AbstractTableModel {
        private final String[] columnNames = {"Przedmiot", "Semestr", "Tryb", "W", "C", "L", "P", "Suma"};
        private List<WorkloadItemDTO> items = new ArrayList<>();

        public void setItems(List<WorkloadItemDTO> items) {
            this.items = items;
            fireTableDataChanged();
        }

        @Override public int getRowCount() { return items.size(); }
        @Override public int getColumnCount() { return columnNames.length; }
        @Override public String getColumnName(int column) { return columnNames[column]; }

        @Override
        public Object getValueAt(int rowIndex, int columnIndex) {
            WorkloadItemDTO item = items.get(rowIndex);
            switch (columnIndex) {
                case 0: return item.getCourseName();
                case 1: return item.getSemester();
                case 2: return item.getStudyMode();
                case 3: return item.getLectureHours();
                case 4: return item.getClassesHours();
                case 5: return item.getLabHours();
                case 6: return item.getProjectHours();
                case 7: return item.getTotalItemHours();
                default: return null;
            }
        }
    }
}
