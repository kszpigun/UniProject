DROP TABLE IF EXISTS assignments;
DROP TABLE IF EXISTS courses;
DROP TABLE IF EXISTS student_groups;
DROP TABLE IF EXISTS employees;

CREATE TABLE employees (
    id BIGINT AUTO_INCREMENT PRIMARY KEY,
    first_name VARCHAR(255) NOT NULL,
    last_name VARCHAR(255) NOT NULL,
    pensum INT NOT NULL DEFAULT 240
);

CREATE TABLE student_groups (
    id BIGINT AUTO_INCREMENT PRIMARY KEY,
    name VARCHAR(255) NOT NULL
);

CREATE TABLE courses (
    id BIGINT AUTO_INCREMENT PRIMARY KEY,
    name VARCHAR(255) NOT NULL,
    semester_type VARCHAR(50),
    study_mode VARCHAR(50),
    version BIGINT DEFAULT 0
);

CREATE TABLE assignments (
    id BIGINT AUTO_INCREMENT PRIMARY KEY,
    employee_id BIGINT NOT NULL,
    student_group_id BIGINT,
    course_id BIGINT NOT NULL,
    lecture_hours INT DEFAULT 0,
    classes_hours INT DEFAULT 0,
    lab_hours INT DEFAULT 0,
    project_hours INT DEFAULT 0,
    has_errors BOOLEAN DEFAULT FALSE,
    error_messages VARCHAR(1000),
    FOREIGN KEY (employee_id) REFERENCES employees(id),
    FOREIGN KEY (student_group_id) REFERENCES student_groups(id),
    FOREIGN KEY (course_id) REFERENCES courses(id)
);
