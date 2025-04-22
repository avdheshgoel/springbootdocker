package com.example.springbootdocker.repository;

import com.example.springbootdocker.entity.UserEntity;

import org.springframework.data.jpa.repository.JpaRepository;


public interface UserRepository extends JpaRepository<UserEntity, Long> {
}