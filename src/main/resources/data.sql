-- Przykładowi pracownicy z limitem pensum
INSERT INTO employees (first_name, last_name, pensum) VALUES ('Jan', 'Kowalski', 240);
INSERT INTO employees (first_name, last_name, pensum) VALUES ('Anna', 'Nowak', 180);

-- Przykładowe grupy studenckie
INSERT INTO student_groups (name) VALUES ('Informatyka 1A');
INSERT INTO student_groups (name) VALUES ('Informatyka 1B');

-- Przykładowe przedmioty z określonym semestrem i trybem studiów
INSERT INTO courses (name, semester_type, study_mode, version) VALUES ('Bazy Danych', 'Zimowy', 'Stacjonarne', 0);
INSERT INTO courses (name, semester_type, study_mode, version) VALUES ('Programowanie w Java', 'Letni', 'Niestacjonarne', 0);

-- Przykładowe przydziały z rozbiciem na godziny (W/C/L/P) oraz flagami błędów
INSERT INTO assignments (employee_id, student_group_id, course_id, lecture_hours, classes_hours, lab_hours, project_hours, has_errors, error_messages)
VALUES (1, 1, 1, 30, 0, 30, 0, FALSE, NULL);

INSERT INTO assignments (employee_id, student_group_id, course_id, lecture_hours, classes_hours, lab_hours, project_hours, has_errors, error_messages)
VALUES (2, 2, 2, 15, 15, 30, 15, FALSE, NULL);
