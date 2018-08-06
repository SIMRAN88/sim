package com.tricon.Student.serviceimpl;


import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.tricon.Student.dao.IStudentDao;
import com.tricon.Student.model.Student;
import com.tricon.Student.service.IStudentService;

@Service
public class StudentService implements IStudentService {

	@Autowired
	private IStudentDao studentDao; 
	
	@Override
	public List<Student> getUser() {
		return studentDao.getUser();
	}

	@Override
	public Student getUserbyId(int id) {
		// TODO Auto-generated method stub
		return studentDao.getUserbyId(id);
	}

	@Override
	public Student addUser(Student sim) {
		// TODO Auto-generated method stub
		return studentDao.addUser(sim);
	}

	@Override
	public void removeUser(int sim) {
		// TODO Auto-generated method stub
		studentDao.removeUser(sim);
	}

}
