package com.demo.demo.db.repository;

import com.demo.demo.db.domain.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface UserRepository extends JpaRepository<User, Long> {
    User findByNumeroDocumento(long numeroDocumento);
}