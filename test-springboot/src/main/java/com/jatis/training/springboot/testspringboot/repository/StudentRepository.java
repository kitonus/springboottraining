package com.jatis.training.springboot.testspringboot.repository;

import org.springframework.data.repository.PagingAndSortingRepository;

import com.jatis.training.springboot.testspringboot.entity.StudentEntity;

public interface StudentRepository extends PagingAndSortingRepository<StudentEntity, String> {

}
