// Klaudia - przeliczanie rorboczogodzin
package com.uczelnia.plan.service;

import java.util.List;

import com.uczelnia.plan.model.Assignment;
import com.uczelnia.plan.model.Course;
import com.uczelnia.plan.model.Employee;

public class WorkloadCalculator {

    // 1. Obliczanie całkowitej liczby roboczogodzin przedmiotu.
    // Wzór z zadania: grupy * tygodnie * godziny/tydzień * prowadzący
    // Przykładowo: 1 * 15 * 2h * 2os = 60 roboczogodzin
    public int calculateCourseTotalHours(Course course) {
        if (course == null) return 0; // Ochrona przed nullem (odpowiednik sprawdzania `if (course == nullptr)`)

        return course.getStudentGroupCount()*course.getWeeksCount()*course.getHoursPerWeek()*course.getInstructorsCount();
    }

    // 2. Sumowanie godzin przydzielonych dla konkretnego pracownika ze wszystkich jego przydziałów
    public int calculateTotalEmployeeHours(Employee employee, List<Assignment> allAssignments) {
        if (employee == null || allAssignments == null) return 0;

        int totalHours = 0;

        // Pętla for-each po przydziałach (w C++: for (const auto& assignment : allAssignments))
        for (Assignment assignment : allAssignments) {

            // Sprawdzamy, czy ten przydział należy do szukanego pracownika.
            // Porównujemy ID pracownika przy użyciu metody .equals()
            if (assignment.getEmployee() != null &&
                assignment.getEmployee().getId().equals(employee.getId())) {

                totalHours += assignment.getAssignedHours(); // Dodajemy godziny z tego przydziału
            }
        }

        return totalHours;
    }
}