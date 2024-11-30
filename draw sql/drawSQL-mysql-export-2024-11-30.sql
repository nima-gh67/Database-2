CREATE TABLE `student`(
    `id_student` BIGINT UNSIGNED NOT NULL AUTO_INCREMENT PRIMARY KEY,
    `name` VARCHAR(255) NOT NULL,
    `age` VARCHAR(255) NOT NULL,
    `num_phone` BIGINT NOT NULL
);
CREATE TABLE `teacher`(
    `id_teacher` BIGINT UNSIGNED NOT NULL AUTO_INCREMENT PRIMARY KEY,
    `name` VARCHAR(255) NOT NULL,
    `age` VARCHAR(255) NOT NULL,
    `lesson` VARCHAR(255) NOT NULL
);
CREATE TABLE `lesson`(
    `id_lesson` BIGINT UNSIGNED NOT NULL AUTO_INCREMENT PRIMARY KEY,
    `name` CHAR(255) NOT NULL,
    `The basis of the lesson` CHAR(255) NOT NULL
);
CREATE TABLE `school`(
    `id_student` BIGINT UNSIGNED NOT NULL AUTO_INCREMENT PRIMARY KEY,
    `id_teacher` BIGINT NOT NULL,
    `id_lesson` BIGINT NOT NULL
);
ALTER TABLE
    `school` ADD CONSTRAINT `school_id_teacher_foreign` FOREIGN KEY(`id_teacher`) REFERENCES `teacher`(`id_teacher`);
ALTER TABLE
    `school` ADD CONSTRAINT `school_id_student_foreign` FOREIGN KEY(`id_student`) REFERENCES `student`(`id_student`);
ALTER TABLE
    `school` ADD CONSTRAINT `school_id_lesson_foreign` FOREIGN KEY(`id_lesson`) REFERENCES `lesson`(`id_lesson`);