package com.jatis.training.springboot.testspringboot.controller;

import java.util.HashMap;
import java.util.Map;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Sort;
import org.springframework.data.domain.Sort.Direction;
import org.springframework.http.HttpStatus;
import org.springframework.security.access.annotation.Secured;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.validation.FieldError;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;

import com.jatis.training.springboot.testspringboot.entity.StudentEntity;
import com.jatis.training.springboot.testspringboot.repository.StudentRepository;

@RestController
@RequestMapping("/student")
public class StudentController {
	
	@Autowired
	private StudentRepository studentRepo;

	@Secured({"ROLE_ADMIN"})
	@Transactional
	@PostMapping
	public StudentEntity saveStudent(@Valid @RequestBody StudentEntity student) {
		return studentRepo.save(student);
	}
	
	@GetMapping("/{page}/{size}")
	public Page<StudentEntity> findAll(@PathVariable("page") int page
			, @PathVariable("size") int size){
		return studentRepo.findAll(PageRequest.of(page, size, 
				Sort.by(Direction.ASC, "name", "studentNo")));
	}
	
	@GetMapping("/{studentNo}")
	public StudentEntity findById(@PathVariable("studentNo") String studentNo) {
		return studentRepo.findById(studentNo).orElse(null);
	}

	@ResponseStatus(HttpStatus.BAD_REQUEST)
	@ExceptionHandler(MethodArgumentNotValidException.class)
	public Map<String, String> handleValidationExceptions(
	  MethodArgumentNotValidException ex) {
	    Map<String, String> errors = new HashMap<>();
	    ex.getBindingResult().getAllErrors().forEach((error) -> {
	        String fieldName = ((FieldError) error).getField();
	        String errorMessage = error.getDefaultMessage();
	        errors.put(fieldName, errorMessage);
	    });
	    return errors;
	}}
