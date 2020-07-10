package com.jiyun.mapper;

import java.util.List;

import org.apache.ibatis.annotations.Param;

import com.jiyun.pojo.Clazz;
import com.jiyun.pojo.Student;

public interface StuMapper {

	List<Student> selectAll();

	List<Clazz> findClazz();

	int add(Student stu);

	int update(Student stu);

	int del(@Param("ids")Integer[] ids);

}
