package com.cg.university.Attendance.service.impl;

import com.cg.university.Attendance.entity.Holidays;
import com.cg.university.Attendance.repository.HolidaysRepository;
import com.cg.university.Attendance.service.HolidayService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class HolidayServiceImpl implements HolidayService {
    @Autowired
    private HolidaysRepository holidaysRepository;

    public List<Holidays> getAllHolidays() {
        return holidaysRepository.findAll();
    }
}
