package com.xiaoshu.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import com.github.pagehelper.util.StringUtil;
import com.xiaoshu.dao.ClazzMapper;
import com.xiaoshu.dao.StudentMapper;
import com.xiaoshu.dao.UserMapper;
import com.xiaoshu.entity.Clazz;
import com.xiaoshu.entity.CountVo;
import com.xiaoshu.entity.Student;
import com.xiaoshu.entity.StudentExample;
import com.xiaoshu.entity.User;
import com.xiaoshu.entity.UserExample;
import com.xiaoshu.entity.UserExample.Criteria;

@Service
public class StuService {

	@Autowired
	UserMapper userMapper;
	@Autowired
	private StudentMapper sm;
	
	@Autowired
	private ClazzMapper cm;
	
	// 查询所有
	public List<User> findUser(User t) throws Exception {
		return userMapper.select(t);
	};

	// 数量
	public int countUser(User t) throws Exception {
		return userMapper.selectCount(t);
	};

	// 通过ID查询
	public User findOneUser(Integer id) throws Exception {
		return userMapper.selectByPrimaryKey(id);
	};

	// 新增
	public void addStu(Student stu) throws Exception {
		sm.insert(stu);
	};

	// 修改
	public void updateStu(Student stu) throws Exception {
		sm.updateByPrimaryKey(stu);
	};

	// 删除
	public void deleteStu(Integer id) throws Exception {
		sm.deleteByPrimaryKey(id);
	};

	// 登录
	public User loginUser(User user) throws Exception {
		UserExample example = new UserExample();
		Criteria criteria = example.createCriteria();
		criteria.andPasswordEqualTo(user.getPassword()).andUsernameEqualTo(user.getUsername());
		List<User> userList = userMapper.selectByExample(example);
		return userList.isEmpty()?null:userList.get(0);
	};

	// 通过用户名判断是否存在，（新增时不能重名）
	public Student findByName(String sName) throws Exception {
		StudentExample example = new StudentExample();
		com.xiaoshu.entity.StudentExample.Criteria criteria = example.createCriteria();
		criteria.andSnameEqualTo(sName);
		List<Student> list = sm.selectByExample(example);
		
		return list.isEmpty()?null:list.get(0);
	};

	// 通过角色判断是否存在
	public User existUserWithRoleId(Integer roleId) throws Exception {
		UserExample example = new UserExample();
		Criteria criteria = example.createCriteria();
		criteria.andRoleidEqualTo(roleId);
		List<User> userList = userMapper.selectByExample(example);
		return userList.isEmpty()?null:userList.get(0);
	}

	public PageInfo<Student> findStuPage(Student stu, int pageNum, int pageSize, String ordername, String order) {
		PageHelper.startPage(pageNum, pageSize);
		ordername = StringUtil.isNotEmpty(ordername)?ordername:"sid";
		order = StringUtil.isNotEmpty(order)?order:"desc";
		
		List<Student> stuList = sm.findAll(stu);
		PageInfo<Student> pageInfo = new PageInfo<Student>(stuList);
		return pageInfo;
	}

	public List<Clazz> findAllClazz() {
		// TODO Auto-generated method stub
		List<Clazz> list = cm.selectAll();
		return list;
	}
//查询学生列表
	public List<Student> findAllStu() {
		// TODO Auto-generated method stub
		List<Student> list = sm.findAll(null);
		return list;
	}

	public List<CountVo> countStu() {
		// TODO Auto-generated method stub
		List<CountVo> list= sm.countStu();
		
		return list;
	}


}
