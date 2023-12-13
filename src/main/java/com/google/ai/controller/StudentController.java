package com.google.ai.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RequestPart;
import org.springframework.web.bind.annotation.RestController;

import com.google.ai.dao.StudentDao;
import com.google.ai.dto.ResponseStructure;
import com.google.ai.dto.StudentDto;
import com.google.ai.service.StudentService;


//@Controller


@RequestMapping("/students")
@RestController
public class StudentController {

	@Autowired
	StudentDao dao;
	
	@Autowired
	StudentService service;

//	@GetMapping("/sample")
//	public String hello() {
//		return "sample";
//	}

	@PostMapping("/students")
	public ResponseStructure<StudentDto> insert(@RequestBody List<StudentDto> dtos) {
		return service.insert(dtos);
	}

	@GetMapping("/students")
	public ResponseStructure<StudentDto> fetchAll() {
		return service.fetchAll();
	}

//	http://localhost:8081/students/fetchbyid
//  JSON objects
	@GetMapping("/studentsid") // Receive the request in the form of JSON --> RequestBody
	public ResponseStructure<StudentDto> fetchById(@RequestBody StudentDto id) {
		int sid = id.getId();
		return service.fetchById(sid);
	}

//	http://localhost:8081/students/deletebyid/4 -->PathVariable
	@DeleteMapping("/student")
	public String deleteById(@PathVariable int id) {
		return dao.deleteById(id);
	}

	@DeleteMapping("/deleteall")
	public String deleteall() {
		return dao.deleteAll();
	}

//	http://localhost:8081/students/updatebyid?id=4 -->RequestParam	
	@PutMapping("/updatebyid")
	public int update(@RequestParam int id) {
		return id;
	}

}
