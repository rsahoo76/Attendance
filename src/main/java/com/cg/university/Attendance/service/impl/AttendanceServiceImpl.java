package com.cg.university.Attendance.service.impl;

import com.cg.university.Attendance.entity.Attendance;
import com.cg.university.Attendance.repository.AttendanceRepository;
import com.cg.university.Attendance.service.AttendanceService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Date;

@Service
public class AttendanceServiceImpl implements AttendanceService {

    @Autowired
    private AttendanceRepository attendanceRepository;

//    public void saveAttendance(AttendanceDTO request) {
//        Attendance attendance = new Attendance();
//        attendance.setTitle(request.getTitle());
//        attendance.setStart_time(request.getStart_time());
//        attendance.setEnd_time(request.getEnd_time());
//        attendance.setAttended(request.getAttended());
//
//        attendanceRepository.save(attendance);
//    }

    public Attendance saveAttendance(Attendance attendance) {

        return attendanceRepository.save(attendance);
    }

    public void updateStatus(String title, Date start, Date end, String status) {
        // Use title, start, and end to find the attendance record
        Attendance attendance = attendanceRepository.findByTitleAndStartAndEnd(title, start, end)
                .orElseThrow(() -> new RuntimeException("Attendance record not found"));

        attendance.setStatus(status);  // Update the status in the database
        attendanceRepository.save(attendance);
    }

//    public List<Attendance> getPendingAttendanceRequests() {
//        return attendanceRepository.findByStatus("PENDING");
//    }

    public void approveAttendance(Integer attendanceId, Boolean isApproved) {
        Attendance attendance = attendanceRepository.findById(attendanceId)
                .orElseThrow(() -> new RuntimeException("Attendance not found"));


        if (isApproved) {
            attendance.setAttended(Boolean.valueOf("APPROVED"));
        } else {
            attendance.setAttended(Boolean.valueOf("REJECTED"));
        }
        attendanceRepository.save(attendance);
    }
}