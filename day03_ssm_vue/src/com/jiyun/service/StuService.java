package com.jiyun.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.jiyun.mapper.StuMapper;
import com.jiyun.pojo.Clazz;
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

	public List<Clazz> findClazz() {
		// TODO Auto-generated method stub
		return sm.findClazz();
	}

	public int add(Student stu) {
		// TODO Auto-generated method stub
		int i = sm.add(stu);
		return i;
	}

	public int update(Student stu) {
		// TODO Auto-generated method stub
		int i = sm.update(stu);
		return i;
	}

	public int del(Integer[] ids) {
		// TODO Auto-generated method stub
		int i = sm.del(ids);
		return i;
	}

}
