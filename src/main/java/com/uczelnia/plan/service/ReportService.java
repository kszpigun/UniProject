package com.uczelnia.plan.service;

import com.uczelnia.plan.dto.WorkloadCardDTO;
import com.uczelnia.plan.dto.WorkloadItemDTO;
import com.uczelnia.plan.model.Assignment;
import com.uczelnia.plan.model.Course;
import com.uczelnia.plan.model.Employee;
import com.uczelnia.plan.repository.AssignmentRepository;
import com.uczelnia.plan.repository.EmployeeRepository;
// Opcjonalnie: import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

// @Service - jeśli korzystacie ze Spring Boota
public class ReportService {

    private final EmployeeRepository employeeRepository;
    private final AssignmentRepository assignmentRepository;

    public ReportService(EmployeeRepository employeeRepository, AssignmentRepository assignmentRepository) {
        this.employeeRepository = employeeRepository;
        this.assignmentRepository = assignmentRepository;
    }

    /**
     * Główna metoda generująca kartę obciążenia dla konkretnego pracownika.
     */
    public WorkloadCardDTO generateWorkloadCard(Long employeeId) {
        // 1. Pobranie pracownika
        Employee employee = employeeRepository.findById(employeeId)
                .orElseThrow(() -> new IllegalArgumentException("Nie znaleziono pracownika o ID: " + employeeId));

        // 2. Pobranie wszystkich przydziałów (obsady) tego pracownika
        List<Assignment> assignments = assignmentRepository.findByEmployeeId(employeeId);

        // 3. Przygotowanie struktury DTO
        WorkloadCardDTO card = new WorkloadCardDTO();
        card.setEmployeeId(employee.getId());
        card.setEmployeeName(employee.getFirstName() + " " + employee.getLastName());
        card.setPensumLimit(employee.getPensum());
        card.setMaxPensumLimit(employee.getPensum() * 3);

        int totalHours = 0;
        List<WorkloadItemDTO> items = new ArrayList<>();

        // 4. Przeliczanie poszczególnych przydziałów na pozycje raportu (podział W/C/L/P, semestr, tryb)
        for (Assignment assignment : assignments) {
            Course course = assignment.getCourse();
            
            // Tutaj rozbijamy typy zajęć (np. przydział może być na konkretną formę, upraszczamy dla przykładu)
            int w = assignment.getLectureHours();
            int c = assignment.getClassesHours();
            int l = assignment.getLabHours();
            int p = assignment.getProjectHours();

            // Ustalenie semestru (Zimowy/Letni) oraz Trybu (Stacjonarne/Niestacjonarne) 
            // - docelowo zależy to od konfiguracji obiektu Course lub StudentGroup
            String semester = course.getSemesterType() != null ? course.getSemesterType() : "Nieznany";
            String studyMode = course.getStudyMode() != null ? course.getStudyMode() : "Nieznany";

            WorkloadItemDTO item = new WorkloadItemDTO(
                    course.getName(),
                    semester,
                    studyMode,
                    w, c, l, p
            );

            items.add(item);
            totalHours += item.getTotalItemHours();
        }

        card.setWorkloadItems(items);
        card.setTotalCalculatedHours(totalHours);

        // 5. Prosta walidacja raportowa (czy godziny mieszczą się w widelkach)
        boolean hasErrors = totalHours < card.getPensumLimit() || totalHours > card.getMaxPensumLimit();
        card.setHasErrors(hasErrors);

        return card;
    }
}
