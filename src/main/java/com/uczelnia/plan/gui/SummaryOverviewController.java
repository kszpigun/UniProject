package com.uczelnia.plan.gui;

import com.uczelnia.plan.dto.WorkloadCardDTO;
import com.uczelnia.plan.gui.component.StatusCellRenderer;
import com.uczelnia.plan.service.ReportService;

import javax.swing.*;
import javax.swing.table.AbstractTableModel;
import java.awt.*;
import java.util.ArrayList;
import java.util.List;

public class SummaryOverviewController {

    private JPanel mainPanel;
    private JTable summaryTable;
    private SummaryTableModel tableModel;
    private ReportService reportService;

    public SummaryOverviewController(ReportService reportService) {
        this.reportService = reportService;
        initializeUI();
    }

    private void initializeUI() {
        mainPanel = new JPanel(new BorderLayout());

        tableModel = new SummaryTableModel();
        summaryTable = new JTable(tableModel);

        // Ustawiamy nasz StatusCellRenderer z Fazy 2 dla kolumny "Suma Godzin" (indeks 3)
        StatusCellRenderer<WorkloadCardDTO> renderer = new StatusCellRenderer<>(
                rowIndex -> tableModel.getRowData(rowIndex), // Provider wiersza
                dto -> dto != null && dto.isHasErrors()      // Warunek walidacji
        );
        summaryTable.getColumnModel().getColumn(3).setCellRenderer(renderer);

        mainPanel.add(new JScrollPane(summaryTable), BorderLayout.CENTER);
    }

    public JPanel getMainPanel() {
        return mainPanel;
    }

    public void loadAllEmployeesSummary(List<Long> employeeIds) {
        if (reportService == null) return;
        
        List<WorkloadCardDTO> cards = new ArrayList<>();
        for (Long id : employeeIds) {
            cards.add(reportService.generateWorkloadCard(id));
        }
        tableModel.setItems(cards);
    }

    // --- Model Tabeli w Swingu ---
    private static class SummaryTableModel extends AbstractTableModel {
        private final String[] columnNames = {"ID", "Pracownik", "Pensum", "Suma Godzin"};
        private List<WorkloadCardDTO> items = new ArrayList<>();

        public void setItems(List<WorkloadCardDTO> items) {
            this.items = items;
            fireTableDataChanged();
        }

        public WorkloadCardDTO getRowData(int rowIndex) {
            return items.get(rowIndex);
        }

        @Override public int getRowCount() { return items.size(); }
        @Override public int getColumnCount() { return columnNames.length; }
        @Override public String getColumnName(int column) { return columnNames[column]; }

        @Override
        public Object getValueAt(int rowIndex, int columnIndex) {
            WorkloadCardDTO card = items.get(rowIndex);
            switch (columnIndex) {
                case 0: return card.getEmployeeId();
                case 1: return card.getEmployeeName();
                case 2: return card.getPensumLimit();
                case 3: return card.getTotalCalculatedHours();
                default: return null;
            }
        }
    }
}
