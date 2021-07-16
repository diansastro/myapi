package com.ghost.myapi.enums

import org.springframework.http.HttpStatus

/**
 * Created by widi (widiytk@gmail.com) on 2021-07-16.
 **/

enum MetaResponse {

    SUCCESS(HttpStatus.OK.value(), Boolean.TRUE, "Success"),
    FAILED(HttpStatus.BAD_REQUEST.value(), Boolean.FALSE, "Bad request"),
    INVALID_CREDENTIAL(HttpStatus.BAD_REQUEST.value(), Boolean.FALSE, "Invalid credential"),
    USERNAME_ALREADY_EXISTS(HttpStatus.BAD_REQUEST.value(), Boolean.FALSE, "Username already exists"),
    USER_NOT_FOUND(HttpStatus.BAD_REQUEST.value(), Boolean.FALSE, "User not found"),
    DEPARTMENT_NOT_FOUND(HttpStatus.BAD_REQUEST.value(), Boolean.FALSE, "Department not found"),
    STILL_IN_USE(HttpStatus.BAD_REQUEST.value(), Boolean.FALSE, "Still in use"),
    MAJORS_NOT_FOUND(HttpStatus.BAD_REQUEST.value(), Boolean.FALSE, "Majors not found"),
    EMPLOYEE_ID_ALREADY_USE(HttpStatus.BAD_REQUEST.value(), Boolean.FALSE, "Employee id already use"),
    EMAIL_ALREADY_USE(HttpStatus.BAD_REQUEST.value(), Boolean.FALSE, "Email already use"),
    SEMESTER_NOT_FOUND(HttpStatus.BAD_REQUEST.value(), Boolean.FALSE, "Semester not found"),
    COURSE_CODE_ALREADY_EXISTS(HttpStatus.BAD_REQUEST.value(), Boolean.FALSE, "Course code already exists"),
    COURSE_NOT_FOUND(HttpStatus.BAD_REQUEST.value(), Boolean.FALSE, "Course not found"),
    SEMESTER_COURSE_NOT_FOUND(HttpStatus.BAD_REQUEST.value(), Boolean.FALSE, "Semester course not found"),
    CLASS_NOT_FOUND(HttpStatus.BAD_REQUEST.value(), Boolean.FALSE, "Class not found"),
    SCHEDULE_NOT_FOUND(HttpStatus.BAD_REQUEST.value(), Boolean.FALSE, "Schedule not found"),
    STUDENT_NOT_FOUND(HttpStatus.BAD_REQUEST.value(), Boolean.FALSE, "Student not found"),
    FIELD_CANNOT_BE_NULL(HttpStatus.BAD_REQUEST.value(), Boolean.FALSE, "All field cannot be null"),
    OLD_PASSWORD_NOT_MATCH(HttpStatus.BAD_REQUEST.value(), Boolean.FALSE, "Old password did not match"),
    NEW_PASSWORD_NOT_MATCH(HttpStatus.BAD_REQUEST.value(), Boolean.FALSE, "New password did not match"),
    FAILED_TO_ADD_EVENT(HttpStatus.BAD_REQUEST.value(), Boolean.FALSE, "Failed to create an event"),
    EVENT_NOT_FOUND(HttpStatus.BAD_REQUEST.value(), Boolean.FALSE, "Event not found"),
    FAILED_TO_ADD_CALENDAR(HttpStatus.BAD_REQUEST.value(), Boolean.FALSE, "Failed to create an academic calendar"),
    CALENDAR_NOT_FOUND(HttpStatus.BAD_REQUEST.value(), Boolean.FALSE, "Academic calendar not found"),
    EXAM_NOT_FOUND(HttpStatus.BAD_REQUEST.value(), Boolean.FALSE, "Exam calendar not found"),
    QUESTION_NOT_FOUND(HttpStatus.BAD_REQUEST.value(), Boolean.FALSE, "Question not found")

    int code

    Boolean status

    String message

    MetaResponse() {
    }

    MetaResponse(Integer code, Boolean status, String message) {
        this.code = code
        this.status = status
        this.message = message
    }

    Integer getCode() {
        return code
    }

    void setCode(int code) {
        this.code = code
    }

    Boolean getStatus() {
        return status
    }

    void setStatus(Boolean status) {
        this.status = status
    }

    String getMessage() {
        return message
    }

    void setMessage(String message) {
        this.message = message
    }
}