package com.ghost.myapi.io.request

/**
 * Created by widi (widiytk@gmail.com) on 2021-07-16.
 **/

class LecturerRequest {

    String name

    String employeeId

    String image

    String googleScholar

    String scopus

    String orcid

    String sinta

    Long userId

    String password

    String newPassword

    String status

    List<LecturerJournalRequest> lecturerJournals

    List<LecturerEventRequest> lecturerEvents
}
