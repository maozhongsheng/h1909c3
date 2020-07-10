package com.jiyun.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.multipart.MultipartFile;

import com.jiyun.pojo.Clazz;
import com.jiyun.pojo.Student;
import com.jiyun.service.StuService;
import com.sun.org.apache.xpath.internal.operations.Mod;

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
		
		return list;
	}
	@RequestMapping("toAdd")

	public String toAdd(){
		
		return "add";
	}
	@RequestMapping("findClazz")
	@ResponseBody
	public List<Clazz> findClazz(){
		List<Clazz> list=ss.findClazz();
		
		return list;
	}
	@RequestMapping("add")
	@ResponseBody
	public int add(@RequestBody Student stu){
		int i = ss.add(stu);
		
		return i;
	}
	@RequestMapping("update")
	@ResponseBody
	public int update(@RequestBody Student stu){
		int i = ss.update(stu);
		
		return i;
	}
	@RequestMapping("del")
	@ResponseBody
	public int del(@RequestBody Integer[] ids){
		int i = ss.del(ids);
		
		return i;
	}
}
