package com.uczelnia.plan.dto;

public class WorkloadItemDTO {
    private String courseName;
    private String semester;    // Zimowy / Letni
    private String studyMode;   // Stacjonarne / Niestacjonarne
    
    // Rozbicie na formy zajęć
    private int lectureHours;   // W - Wykład
    private int classesHours;   // C - Ćwiczenia
    private int labHours;       // L - Laboratorium
    private int projectHours;   // P - Projekt
    
    private int totalItemHours; // Suma godzin dla tej pozycji

    public WorkloadItemDTO() {}

    public WorkloadItemDTO(String courseName, String semester, String studyMode, 
                           int lectureHours, int classesHours, int labHours, int projectHours) {
        this.courseName = courseName;
        this.semester = semester;
        this.studyMode = studyMode;
        this.lectureHours = lectureHours;
        this.classesHours = classesHours;
        this.labHours = labHours;
        this.projectHours = projectHours;
        this.totalItemHours = lectureHours + classesHours + labHours + projectHours;
    }

    // --- GETTERY I SETTERY ---
    public String getCourseName() { return courseName; }
    public void setCourseName(String courseName) { this.courseName = courseName; }

    public String getSemester() { return semester; }
    public void setSemester(String semester) { this.semester = semester; }

    public String getStudyMode() { return studyMode; }
    public void setStudyMode(String studyMode) { this.studyMode = studyMode; }

    public int getLectureHours() { return lectureHours; }
    public void setLectureHours(int lectureHours) { this.lectureHours = lectureHours; }

    public int getClassesHours() { return classesHours; }
    public void setClassesHours(int classesHours) { this.classesHours = classesHours; }

    public int getLabHours() { return labHours; }
    public void setLabHours(int labHours) { this.labHours = labHours; }

    public int getProjectHours() { return projectHours; }
    public void setProjectHours(int projectHours) { this.projectHours = projectHours; }

    public int getTotalItemHours() { return totalItemHours; }
    public void setTotalItemHours(int totalItemHours) { this.totalItemHours = totalItemHours; }
}
