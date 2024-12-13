package com.cg.university.Attendance.controller;

import com.cg.university.Attendance.dto.AttendanceDTO;
import com.cg.university.Attendance.dto.LoginDTO;
import com.cg.university.Attendance.dto.RegistrationDetailsDto;
import com.cg.university.Attendance.entity.*;
import com.cg.university.Attendance.repository.*;
import com.cg.university.Attendance.response.LoginResponse;
import com.cg.university.Attendance.service.HolidayService;
import com.cg.university.Attendance.service.UserService;
import com.cg.university.Attendance.service.impl.AttendanceServiceImpl;
import com.cg.university.Attendance.service.impl.UserServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.http.HttpStatus;

//import org.springframework.security.authentication.AuthenticationManager;
//import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
//import org.springframework.security.core.Authentication;
//import org.springframework.security.core.AuthenticationException;

//import org.springframework.security.authentication.AuthenticationManager;
//import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
//import org.springframework.security.core.Authentication;
//import org.springframework.security.core.AuthenticationException;
//import org.springframework.security.core.context.SecurityContextHolder;

import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@RestController
@CrossOrigin( origins = "http://localhost:4205", maxAge = 3600)
public class TestController {

    @Autowired
    private RolesRepository rolesRepository;

    @Autowired
    private DepartmentRepository departmentRepository;

    @Autowired
    private UserRepository userRepository;

    @Autowired
    private UserService userservice;

    @Autowired
    private CalendarRepository calendarRepository;

    @Autowired
    private HolidaysRepository holidaysRepository;

    @Autowired
    private HolidayService holidayService;

    @Autowired
    private AttendanceRepository attendanceRepository;

    @Autowired
    private AttendanceServiceImpl attendanceService;

    @Autowired
    private UserServiceImpl userService;
//    private Object HttpStatus;

//    @PostMapping("/test")
//    public ResponseEntity<Department> testPost(@RequestBody  Department department) {
//        System.out.print(department.getName());
//        return ResponseEntity.ok(new Department(12, "TestDept"));
//    }

    @PostMapping("/register")
    public ResponseEntity<?> register(@RequestBody RegistrationDetailsDto registrationDetailsDto) {
        System.out.println(registrationDetailsDto);

//        User user= new User();
//        user.setFirstname(registrationDetailsDto.getFirstname());
//        user.setLastname(registrationDetailsDto.getLastname());
//        user.setEmail(registrationDetailsDto.getEmail());
//        user.setPassword(registrationDetailsDto.getPassword());
//        user.setLocation(registrationDetailsDto.getLocation());
//        user.setPhoneNumber(registrationDetailsDto.getPhoneNumber());

        Department department = new Department();
        department.setName(registrationDetailsDto.getDepartment());
        departmentRepository.save(department);

        Roles role = new Roles();
        role.setActive(true);
        role.setName(registrationDetailsDto.getRoles());
//        role.setName(registrationDetailsDto.getRoles().toString());
//        role.setName(registrationDetailsDto.getRoles().getName());
        rolesRepository.save(role);

//        userRepository.save(user);

        User user = new User();
        user.setFirstname(registrationDetailsDto.getFirstname());
        user.setLastname(registrationDetailsDto.getLastname());
        user.setEmail(registrationDetailsDto.getEmail());
        user.setPassword(registrationDetailsDto.getPassword());
        user.setPhoneNumber(registrationDetailsDto.getPhoneNumber());
        user.setLocation(registrationDetailsDto.getLocation());

        user.setDepartment(department);
        user.setRoles(role);

        userRepository.save(user);

        return ResponseEntity.ok().build();
    }

//    @GetMapping("/usersList")
//    public List<User> UserList(@RequestBody RegistrationDetailsDto registrationDetailsDto)
//    {
//        return userRepository.findAll();
//    }
//

//    @PostMapping(path = "/login")
//    public ResponseEntity<?> loginEmployee(@RequestBody LoginDTO loginDTO)
//    {
//        LoginResponse loginResponse = userService.loginUser(loginDTO);
//        return ResponseEntity.ok(loginResponse);
//    }


    @GetMapping("/users")
    public List<User> findAll() {
        return userRepository.findAll();
    }

//    @GetMapping("/holidays")
//    public List<Holidays> findAllholidays(){
//        return holidaysRepository.findAll();
//    }

    @GetMapping("/holiday")
    public List<Holidays> getAllHolidays() {
        System.out.println("Holidays");
        return holidayService.getAllHolidays();
    }

    /*
    @GetMapping("/calendar")
    public List<Calendar> gettimetable(){
        return this.calendarRepository.findAll();
    }
    */

    @GetMapping("/Calendarevents")
    public List<Calendar> findAllevents() {

        return calendarRepository.findAll();
    }

//    @PreAuthorize("hasRole('TEACHER')")
//    @PostMapping("/Attendance")
//    public ResponseEntity<?> attended(@RequestBody AttendanceDTO attendanceDto) {
////        User user = new User();
//        Attendance attendance = new Attendance();
//        attendance.setAttended(attendanceDto.getAttended());
//        attendanceRepository.save(attendance);
//        return ResponseEntity.ok().build();
//    }

    @GetMapping("/userdetail")
    public Optional<User> GetUser(@RequestBody User userId){
        Optional<User> user_1 = userRepository.findById(userId)   ;
        return user_1;
    }

    @PostMapping("/save")
    public ResponseEntity<?> saveAttendance(@RequestBody AttendanceDTO attendanceRequest) {
        Optional<User> user = userRepository.findByEmail(attendanceRequest.getUserEmail());
        if (!user.isPresent()) {
            return new ResponseEntity<>("User not found", HttpStatus.BAD_REQUEST);
        }

        // Created new attendance object here
        Attendance attendance = new Attendance();
        attendance.setTitle(attendanceRequest.getTitle());
        attendance.setUser_id(user.get());
        attendance.setStart(attendanceRequest.getStart());
        attendance.setEnd(attendanceRequest.getEnd());
        attendance.setAttended(attendanceRequest.getAttended());
        attendance.setNotes(attendanceRequest.getNotes());

        // Saved the attendance
        Attendance savedAttendance = attendanceService.saveAttendance(attendance);

        return new ResponseEntity<>(savedAttendance, HttpStatus.CREATED);

/*
        //Tried Fetching user from userId
        Optional<User> user = userRepository.findById(attendanceRequest.getUser_id());
        if (!user.isPresent()) {
            return new ResponseEntity<>("User not found", HttpStatus.BAD_REQUEST);
        }
        Attendance attendance = new Attendance();
        attendance.setTitle(attendanceRequest.getTitle());
        attendance.setStart_time(attendanceRequest.getStart_time());
        attendance.setEnd_time(attendanceRequest.getEnd_time());
        attendance.setAttended(attendanceRequest.getAttended());
        attendance.setUser_id(user.get());
//        attendance.setNotes(attendanceRequest.getNotes());

        Attendance savedAttendance = attendanceService.saveAttendance(attendance);

        return new ResponseEntity<>(savedAttendance, HttpStatus.CREATED);

 */
    }

    @PostMapping("/updateAttendanceStatus")
    public ResponseEntity<String> updateStatus(@RequestBody AttendanceDTO Attendancedto) {
        System.out.println("Status Update called...");
        try {
            attendanceService.updateStatus(Attendancedto.getTitle(), Attendancedto.getStart(), Attendancedto.getEnd(), Attendancedto.getStatus());
            return ResponseEntity.ok("Status updated successfully");
        } catch (Exception e) {
            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body("Error updating status");
        }
    }
    /*
    @PostMapping("/save")
    public ResponseEntity<String> saveAttendance(@RequestBody AttendanceDTO request) {
        attendanceService.saveAttendance(request);
        return ResponseEntity.ok("Attendance submitted for approval.");
    }

//    @GetMapping("/pending")
//    public ResponseEntity<List<Attendance>> getPendingRequests() {
//        List<Attendance> pendingRequests = attendanceService.getPendingAttendanceRequests();
//        return ResponseEntity.ok(pendingRequests);
//    }

    @PreAuthorize("hasRole('TEACHER')")
    @PostMapping("/approve")
    public ResponseEntity<String> approveAttendance(@RequestParam Integer id, @RequestParam Boolean approve) {
        attendanceService.approveAttendance(id, approve);
        return ResponseEntity.ok(approve ? "Attendance approved." : "Attendance rejected.");
    }

     */

//    @GetMapping("/user")
//    public User GetUserforDashboard(){
//        User user = new User();
//        return userRepository.findByEmail(user.getEmail());
//    }

    @GetMapping("/loggedUser")
    public Optional<User> getLoggedInUser() {
        return userService.getLoggedInUser();
    }
//    @GetMapping("/currentuser")
//    public UserDetails getCurrentUser(@AuthenticationPrincipal UserDetails userDetails) {
//        return userDetails;
//    }

//    @GetMapping("/Attendance")
//    public List<Attendance> findAllAttendance() {
//        return attendanceRepository.findAll();
//    }

    @GetMapping("/Attendance")
    public List<AttendanceDTO> findAllAttendance() {
        List<Attendance> attendances = attendanceRepository.findAll();
//        List<AttendanceDTO> attendanceDTOs = attendances.stream()
//                .map(AttendanceDTO::new)
//                .collect(Collectors.toList());

        List<AttendanceDTO> attendanceDTOs = attendances.stream()
                .map(attendance -> new AttendanceDTO(attendance))  // Use lambda instead of method reference
                .collect(Collectors.toList());


        return attendanceDTOs;
    }

    @PostMapping("/login")
    public ResponseEntity<LoginResponse> login(@RequestBody LoginDTO loginDTO) {
/*
        try {
            LoginResponse response = userService.loginUser(loginDTO);
            return ResponseEntity.ok(response);
        } catch (ResponseStatusException ex) {
            // Return an unauthorized status if authentication fails
            return ResponseEntity.status(HttpStatus.UNAUTHORIZED).body(new LoginResponse( "Invalid credentials", false));
        }
 */
        return ResponseEntity.ok(userService.loginUser(loginDTO));
    }

/* 2/8
    @PostMapping("/login")
    public ResponseEntity<LoginResponse> loginUser(@RequestBody LoginDTO loginDTO) {
        LoginResponse loginResponse = userservice.loginUser(loginDTO);
        System.out.println(loginResponse.isSuccess() +"login....");

        if (loginResponse.isSuccess()) {
            return ResponseEntity.ok(loginResponse);
        } else {
            return ResponseEntity.status(401).body(loginResponse);
        }
    }
 */

// @Bean issue
    /*
    @PostMapping("/login")
    public ResponseEntity<LoginResponse> login(@RequestBody LoginDTO loginDTO) {
        try {
            Authentication authentication = authenticationManager.authenticate(
                    new UsernamePasswordAuthenticationToken(loginDTO.getEmail(), loginDTO.getPassword())
            );
            SecurityContextHolder.getContext().setAuthentication(authentication);
            // Call the userService to generate the LoginResponse
            LoginResponse loginResponse = userservice.loginUser(loginDTO);
            return ResponseEntity.ok(loginResponse);
        } catch (AuthenticationException e) {
            // Return a failure response if authentication fails
            LoginResponse loginResponse = new LoginResponse("Login failed: " + e.getMessage(), false);
            return ResponseEntity.status(HttpStatus.UNAUTHORIZED).body(loginResponse);
        }
    }
 */

/*
    //Login Controller
    @Autowired
    private AuthenticationManager authenticationManager;

    @PostMapping("/login")
    public LoginResponse login(@RequestBody LoginDTO loginDTO) {
        try {
            Authentication authentication = authenticationManager.authenticate(
                    new UsernamePasswordAuthenticationToken(loginDTO.getEmail(), loginDTO.getPassword())
            );
            // If authentication is successful, return success response
            return new LoginResponse("Login successful", true);
        } catch (AuthenticationException e) {
            // If authentication fails, return failure response
            return new LoginResponse("Login failed: " + e.getMessage(), false);
        }
    }
 */
    
}
