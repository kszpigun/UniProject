package com.uczelnia.plan.gui.component;

import com.uczelnia.plan.dto.WorkloadCardDTO;
import javafx.scene.control.TableCell;
import javafx.scene.control.TableColumn;
import javafx.scene.paint.Color;
import javafx.util.Callback;

/**
 * Komponent do renderowania komórek tabeli z uwzględnieniem statusu walidacji.
 */
public class StatusCellRenderer {

    // Kolory do oznaczania statusu
    private static final String ERROR_STYLE = "-fx-background-color: #ffcccc; -fx-text-fill: darkred;";
    private static final String OK_STYLE = "-fx-background-color: #ccffcc; -fx-text-fill: darkgreen;";
    private static final String DEFAULT_STYLE = "";

    /**
     * Zwraca fabrykę komórek dla kolumny typu Integer (np. kolumna z sumą godzin).
     * Jeśli pracownik ma przekroczony limit lub nie wyrabia pensum, komórka będzie czerwona.
     */
    public static <T> Callback<TableColumn<T, Integer>, TableCell<T, Integer>> getIntegerCellFactory(
            ValidationCondition<T> condition) {
        
        return column -> new TableCell<T, Integer>() {
            @Override
            protected void updateItem(Integer item, boolean empty) {
                super.updateItem(item, empty);
                
                if (empty || item == null) {
                    setText(null);
                    setStyle(DEFAULT_STYLE);
                } else {
                    setText(item.toString());
                    
                    // Wywołanie warunku określającego czy dany wiersz zawiera błąd
                    T rowData = getTableRow().getItem();
                    if (rowData != null) {
                        if (condition.hasError(rowData)) {
                            setStyle(ERROR_STYLE);
                        } else {
                            setStyle(OK_STYLE);
                        }
                    }
                }
            }
        };
    }

    /**
     * Interfejs pomocniczy określający warunek błędu dla danego obiektu w wierszu.
     */
    public interface ValidationCondition<T> {
        boolean hasError(T rowData);
    }
}
