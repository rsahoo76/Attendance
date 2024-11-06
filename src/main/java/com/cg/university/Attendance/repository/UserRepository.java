package com.cg.university.Attendance.repository;

import com.cg.university.Attendance.entity.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.rest.core.annotation.RepositoryRestResource;
import org.springframework.web.bind.annotation.CrossOrigin;

import java.util.List;
import java.util.Optional;

@CrossOrigin(origins = "http://localhost:4205")
@RepositoryRestResource(collectionResourceRel = "User", path = "User")
public interface UserRepository extends JpaRepository<User, Long> {

    @Override
    Optional<User> findById(Long aLong);

    public List<User> findAll();

    Optional<User> findOneByEmailAndPassword(String email, String password);
    Optional<User> findByEmail(String email);

    Optional<User> findById(User userId);

//    User findByUsername(String name);
}
