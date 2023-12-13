package com.google.ai.dao;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Component;

import com.google.ai.dto.ResponseStructure;
import com.google.ai.dto.StudentDto;
import com.google.ai.repository.StudentRepository;

@Component
public class StudentDao {
	@Autowired
	StudentRepository repository;

	public List<StudentDto> insert(List<StudentDto> dtos) {
		return repository.saveAll(dtos);

	}

	public List<StudentDto> fetchAll() {
		return repository.findAll();
	}

	public StudentDto fetchById(int id) {
		Optional<StudentDto> od = repository.findById(id);
		StudentDto dto = od.get();
		return dto;
	}

	public String deleteById(int id) {
		Optional<StudentDto> od = repository.findById(id);
		StudentDto dto = od.get();
		if (dto == null) {
			return "no data found";
		} else {
			repository.deleteById(id);
			return "data is deleted";
		}
	}

	public String deleteAll() {
		List<StudentDto> list = repository.findAll();
		if (list.isEmpty()) {
			return "no data found";
		} else {
			repository.deleteAll();
			return "data deleted";
		}
	}

}
