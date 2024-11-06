package com.cg.university.Attendance.service.impl;

import com.cg.university.Attendance.dto.LoginDTO;
import com.cg.university.Attendance.entity.User;
import com.cg.university.Attendance.repository.UserRepository;
import com.cg.university.Attendance.response.LoginResponse;
import com.cg.university.Attendance.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Lazy;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@Service
public class UserServiceImpl implements UserDetailsService, UserService {
    @Autowired
    private UserRepository userRepository;

    @Autowired
    @Lazy
    private PasswordEncoder passwordEncoder;

    public List<User> findAll() {
        return userRepository.findAll();
    }

//    public List<User> save(User user){
//        return userRepository.save(user);
//    }

    public Optional<User> getLoggedInUser() {
        // Get the email from the security context
        String email;
        Object principal = SecurityContextHolder.getContext().getAuthentication().getPrincipal();

        if (principal instanceof UserDetails) {
            email = ((UserDetails) principal).getUsername();  // In Spring Security, the username is usually the email
        } else {
            email = principal.toString();
        }
        return userRepository.findByEmail(email);  // Find user by email
    }

//    public User getCurrentUser() {
//        UserDetails userDetails = (UserDetails) SecurityContextHolder.getContext().getAuthentication().getPrincipal();
//        return userRepository.findByEmail(userDetails.getUsername());
//    }

/*
    public LoginResponse loginUser(LoginDTO loginDTO) {

        String msg = "";
        User user1 = userRepository.findByEmail(loginDTO.getEmail());
        if (user1 != null) {
            String password = loginDTO.getPassword();
            String encodedPassword = user1.getPassword();
            Boolean isPwdRight = passwordEncoder.matches(password, encodedPassword);
            if (isPwdRight) {
                Optional<User> user = userRepository.findOneByEmailAndPassword(loginDTO.getEmail(), encodedPassword);
                if (user.isPresent()) {
                    return new LoginResponse("Login Success", true);
                } else {
                    return new LoginResponse("Login Failed", false);
                }
            } else {
                return new LoginResponse("password Not Match", false);
            }
        }else {
            return new LoginResponse("Email not exits", false);
        }
    }
 */

//    @Override
//    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
//        return null;
//    }

//    @Override
//    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
//        return org.springframework.security.core.userdetails.User.withUsername("test1").password("password").authorities("user").build();
//    }

// @Bean issue
    /* 2/8
     */

    public LoginResponse loginUser(LoginDTO loginDTO) {
        User user1 = userRepository.findByEmail(loginDTO.getEmail()).get();
        System.out.println("loginUser called!");
        if (user1 != null) {
            String password = loginDTO.getPassword();
            String encodedPassword = user1.getPassword();
            Boolean isPwdRight = passwordEncoder.matches(password, encodedPassword);
            if (isPwdRight) {
                Optional<User> user = userRepository.findOneByEmailAndPassword(loginDTO.getEmail(), encodedPassword);
                if (user.isPresent()) {
                    return new LoginResponse("Login Success", true);
                } else {
                    return new LoginResponse("Login Failed", false);
                }
            } else {
                return new LoginResponse("password Not Match", false);
            }
        } else {
            return new LoginResponse("Email not exits", false);
        }

//        if (user != null) {
//            if (passwordEncoder.matches(loginDTO.getPassword(), user.getPassword())) {
//                return new LoginResponse("Login successful", true);
//            } else {
//                return new LoginResponse("Password does not match", false);
//            }
//        } else {
//            return new LoginResponse("Email not found", false);
//        }
    }

    /* Working Fine 2/8   */

    @Override
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
        String userName, password;
        List<GrantedAuthority> authorities;
        User user = userRepository.findByEmail(username).get();
//        System.out.println("Method called");
        System.out.println(user.getFirstname());
        if (user == null) {
            throw new UsernameNotFoundException("User details not found for the user : " + username);
        } else {
            userName = user.getEmail();
            password = user.getPassword();
            authorities = new ArrayList<>();
            authorities.add(new SimpleGrantedAuthority(user.getRoles().getName()));

//            for (Authorities authority : user.getAuthorities()) {
//                authorities.add(new SimpleGrantedAuthority(authority.getRole()));
//            }
        }
//        return (UserDetails) new User(userName,password);
        return org.springframework.security.core.userdetails.User.withUsername(username).password(password).authorities(authorities).build();
    }


}


/*
Authentication
@Override
public Authentication authenticate(Authentication authentication) throws AuthenticationException
{
    String username = authentication.getEmail();
    String pwd = authentication.getpassword().toString();
    UserDetails userDetails = UserServiceImpl.loadUserByUsername();
    if(passwordEncoder.matches(pwd,userDetails.getPassword())){
        return new UsernamePasswordAuthenticationToken(username, pwd, userDetails.getAuthorities());
    }
    else{
        throw new BadCredentialsException("Invalid Credentials");
    }
}
 */