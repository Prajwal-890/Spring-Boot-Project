package com.google.ai.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;

import com.google.ai.dao.StudentDao;
import com.google.ai.dto.ResponseStructure;
import com.google.ai.dto.StudentDto;

@Service
public class StudentService {
	@Autowired
	StudentDao dao;
	
	
	public ResponseStructure<StudentDto> insert(List<StudentDto> dto){
		List<StudentDto> e = dao.insert(dto);
		ResponseStructure<StudentDto> responseStructure = new ResponseStructure<>();
		responseStructure.setStatus(HttpStatus.CREATED.value());
		responseStructure.setMessage("Data is inserted");
		responseStructure.setData(e);
		return responseStructure;
		
	}


	public ResponseStructure<StudentDto> fetchAll() {
		 List<StudentDto> dtos = dao.fetchAll();
		 ResponseStructure<StudentDto> responseStructure = new ResponseStructure<>();
		 if (dtos.isEmpty()) {
			responseStructure.setMessage("Data is empty");
			responseStructure.setStatus(HttpStatus.NOT_FOUND.value());
			responseStructure.setData(null);
			return responseStructure;
		}else {
			responseStructure.setMessage("Data is fetched");
			responseStructure.setStatus(HttpStatus.FOUND.value());
			responseStructure.setData(dtos);
			return responseStructure;
		}
	}


	public ResponseStructure<StudentDto> fetchById(int sid) {
		StudentDto dto = dao.fetchById(sid);
		ResponseStructure<StudentDto> responseStructure = new ResponseStructure<>();
		if (dto == null) {
			responseStructure.setMessage("Data is empty");
			responseStructure.setStatus(HttpStatus.NOT_FOUND.value());
			responseStructure.setData(null);
			return responseStructure;
		}else {
			responseStructure.setMessage("Data is fetched");
			responseStructure.setStatus(HttpStatus.FOUND.value());
//			responseStructure.setData(dto.get());
			return responseStructure;
		}
			
		
	}


	
	
	
}
