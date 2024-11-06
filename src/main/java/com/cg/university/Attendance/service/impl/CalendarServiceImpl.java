package com.cg.university.Attendance.service.impl;

import com.cg.university.Attendance.entity.Calendar;
import com.cg.university.Attendance.repository.CalendarRepository;

import java.util.List;

public class CalendarServiceImpl {

    private CalendarRepository calendarRepository;
//    public List<Calendar> findAllevents(){
//        return this.calendarRepository.findAll();
//    }


    List<Calendar> findAllE(){
        return this.calendarRepository.findAll();
    }

    public List<Calendar> getAllEvents() {
        return calendarRepository.findAll();
    }
}
