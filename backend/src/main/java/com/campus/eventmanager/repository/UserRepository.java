package com.campus.eventmanager.repository;

import com.campus.eventmanager.model.User;
import com.campus.eventmanager.dto.UserGrowthDTO;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import java.util.List;
import java.util.Optional;

public interface UserRepository extends JpaRepository<User, Long> {

    boolean existsByEmail(String email);

    Optional<User> findByEmail(String email);

    @Query("SELECT new com.campus.eventmanager.dto.UserGrowthDTO(" +
           "CONCAT(YEAR(u.createdAt), '-', LPAD(CAST(MONTH(u.createdAt) AS string), 2, '0')), COUNT(u)) " +
           "FROM User u " +
           "GROUP BY YEAR(u.createdAt), MONTH(u.createdAt) " +
           "ORDER BY YEAR(u.createdAt), MONTH(u.createdAt)")
    List<UserGrowthDTO> getUserGrowthByMonth();
}