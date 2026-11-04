package com.uczelnia.plan.gui.component;

import javax.swing.JTable;
import javax.swing.table.DefaultTableCellRenderer;
import java.awt.Color;
import java.awt.Component;

/**
 * Komponent do renderowania komórek tabeli z uwzględnieniem statusu walidacji w Swing.
 */
public class StatusCellRenderer<T> extends DefaultTableCellRenderer {

    private final ValidationCondition<T> condition;
    private final TableModelRowProvider<T> rowProvider;

    public StatusCellRenderer(TableModelRowProvider<T> rowProvider, ValidationCondition<T> condition) {
        this.rowProvider = rowProvider;
        this.condition = condition;
    }

    @Override
    public Component getTableCellRendererComponent(JTable table, Object value,
                                                   boolean isSelected, boolean hasFocus,
                                                   int row, int column) {
        // Pobierz domyślny wygląd komórki
        Component c = super.getTableCellRendererComponent(table, value, isSelected, hasFocus, row, column);

        // Pobierz obiekt dla danego wiersza z modelu
        int modelRow = table.convertRowIndexToModel(row);
        T rowData = rowProvider.getRowData(modelRow);

        if (!isSelected) { // Nie nadpisujemy koloru zaznaczenia
            if (rowData != null && condition.hasError(rowData)) {
                c.setBackground(new Color(255, 204, 204)); // Jasnoczerwony
                c.setForeground(new Color(139, 0, 0));     // Ciemnoczerwony tekst
            } else {
                c.setBackground(new Color(204, 255, 204)); // Jasnozielony
                c.setForeground(new Color(0, 100, 0));     // Ciemnozielony tekst
            }
        }

        return c;
    }

    public interface ValidationCondition<T> {
        boolean hasError(T rowData);
    }

    public interface TableModelRowProvider<T> {
        T getRowData(int rowIndex);
    }
}
