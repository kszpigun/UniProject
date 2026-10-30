// Klaudia - Sprawdzanie zasad przedmiotu
package main.java.com.uczelnia.plan.validation;

import java.util.List;

import main.java.com.uczelnia.plan.model.Assignment;
import main.java.com.uczelnia.plan.model.Course;
import main.java.com.uczelnia.plan.service.WorkloadCalculator;

public class CourseValidator {

    // Tworzymy instancję naszego kalkulatora
    private WorkloadCalculator calculator = new WorkloadCalculator();

    public ValidationResult validateCourse(Course course, List<Assignment> courseAssignments) {
        ValidationResult result = new ValidationResult(); // Tworzymy pusty obiekt na błędy

        if (course == null) {
            result.addError("course", "Przedmiot nie może być pusty.", true);
            return result;
        }

        // REGULA 1: "Nie zdarza się aby było więcej niż 5 pracowników na jednym przedmiocie"
        if (courseAssignments != null && courseAssignments.size() > 5) {
            result.addError("instructors", "Na jednym przedmiocie nie może być więcej niż 5 pracowników!", true);
        }

        // REGULA 2: "Suma roboczogodzin dla przedmiotu jest równa sumie godzin pracowników prowadzących ten przedmiot"
        int requiredHours = calculator.calculateCourseTotalHours(course); // Wymagane godziny (np. 60h)
        int actualAssignedHours = 0;

        if (courseAssignments != null) {
            for (Assignment assignment : courseAssignments) {
                actualAssignedHours += assignment.getAssignedHours(); // Sumujemy godziny z wpisanych przydziałów
            }
        }

        // Jeśli suma się nie zgadza – zgłaszamy błąd
        if (actualAssignedHours != requiredHours) {
            // String.format działa analogicznie do printf w C++
            String msg = String.format("Niezgodność godzin! Wymagane dla przedmiotu: %dh, a przypisano pracownikom: %dh.",
                                       requiredHours, actualAssignedHours);

            result.addError("hours", msg, true); // true = Błąd krytyczny (czerwony)
        }

        return result; // Zwracamy wynik z listą wyrytych błędów
    }
}