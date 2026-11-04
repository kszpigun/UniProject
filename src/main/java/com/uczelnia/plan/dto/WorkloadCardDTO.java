package com.uczelnia.plan.dto;

import java.util.ArrayList;
import java.util.List;

public class WorkloadCardDTO {
    private Long employeeId;
    private String employeeName;
    private int pensumLimit;         // Wymagane minimum (pensum)
    private int maxPensumLimit;      // Maksimum (np. 3x pensum)
    private int totalCalculatedHours;// Obliczona suma wszystkich godzin
    private boolean hasErrors;       // Flaga informująca, czy karta ma błędy walidacji

    private List<WorkloadItemDTO> workloadItems;

    public WorkloadCardDTO() {
        this.workloadItems = new ArrayList<>();
    }

    // --- GETTERY I SETTERY ---
    public Long getEmployeeId() { return employeeId; }
    public void setEmployeeId(Long employeeId) { this.employeeId = employeeId; }

    public String getEmployeeName() { return employeeName; }
    public void setEmployeeName(String employeeName) { this.employeeName = employeeName; }

    public int getPensumLimit() { return pensumLimit; }
    public void setPensumLimit(int pensumLimit) { this.pensumLimit = pensumLimit; }

    public int getMaxPensumLimit() { return maxPensumLimit; }
    public void setMaxPensumLimit(int maxPensumLimit) { this.maxPensumLimit = maxPensumLimit; }

    public int getTotalCalculatedHours() { return totalCalculatedHours; }
    public void setTotalCalculatedHours(int totalCalculatedHours) { this.totalCalculatedHours = totalCalculatedHours; }

    public boolean isHasErrors() { return hasErrors; }
    public void setHasErrors(boolean hasErrors) { this.hasErrors = hasErrors; }

    public List<WorkloadItemDTO> getWorkloadItems() { return workloadItems; }
    public void setWorkloadItems(List<WorkloadItemDTO> workloadItems) { this.workloadItems = workloadItems; }
}
