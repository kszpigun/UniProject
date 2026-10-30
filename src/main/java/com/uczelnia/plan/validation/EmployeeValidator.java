// Klaudia - sprawdzanie pensum i limitów pracownika
package main.java.com.uczelnia.plan.validation;

import java.util.List;

import main.java.com.uczelnia.plan.model.Assignment;
import main.java.com.uczelnia.plan.model.Employee;
import main.java.com.uczelnia.plan.service.WorkloadCalculator;

public class EmployeeValidator {

    private WorkloadCalculator calculator = new WorkloadCalculator();

    public ValidationResult validateEmployee(Employee employee, List<Assignment> employeeAssignments) {
        ValidationResult result = new ValidationResult();

        if (employee == null) return result;

        int pensum = employee.getPensum(); // Pensum z bazy (np. 210h)
        int totalHours = calculator.calculateTotalEmployeeHours(employee, employeeAssignments); // Suma godzin pracownika

        // REGULA Z ZADANIA: "Pensum pracownika <= Suma godzin dla prowadzącego <= 3 * Pensum pracownika"

        // 1. Sprawdzenie niedomiaru (przydzielono mniej niż wynosi pensum)
        if (totalHours < pensum) {
            String msg = String.format("Niedomiar godzin! Wykonano: %dh, minimalne pensum: %dh", totalHours, pensum);

            // false = Ostrzeżenie / Niedomiar (kolor pomarańczowy w GUI)
            result.addError("pensum", msg, false);
        }
        // 2. Sprawdzenie nadmiaru (przydzielono więcej niż 3 * pensum)
        else if (totalHours > 3 * pensum) {
            String msg = String.format("Nadmiar godzin! Wykonano: %dh, maksymalny limit (3x Pensum): %dh", totalHours, 3 * pensum);

            // true = Błąd krytyczny / Nadmiar (kolor czerwony w GUI)
            result.addError("pensum", msg, true);
        }

        return result;
    }
}