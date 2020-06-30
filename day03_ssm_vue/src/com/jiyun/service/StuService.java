package com.jiyun.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.jiyun.mapper.StuMapper;
import com.jiyun.pojo.Student;

@Service
@Transactional
public class StuService {
	@Autowired
private StuMapper sm;

	public List<Student> selectAll() {
		// TODO Auto-generated method stub
		return sm.selectAll();
	}

}
