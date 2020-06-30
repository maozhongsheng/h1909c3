package com.jiyun.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import com.jiyun.pojo.Student;
import com.jiyun.service.StuService;

@Controller
public class StuController {
@Autowired
private StuService ss;
	
@RequestMapping("toShow")

public String toShow(){
	
	return "show";
}

	@RequestMapping("selectAll")
	@ResponseBody
	public List<Student>  selectAll(){
		List<Student> list=ss.selectAll();
		System.out.println(list);
		
		return list;
	}
	
}
