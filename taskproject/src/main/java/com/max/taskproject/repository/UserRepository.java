package com.max.taskproject.repository;

import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.max.taskproject.entity.Users;
@Repository
public interface UserRepository extends JpaRepository<Users, Long> {



}
