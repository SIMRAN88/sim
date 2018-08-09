package com.tricon.User;

import java.util.Arrays;
import org.junit.BeforeClass;
import org.junit.Test;

import com.tricon.Student.daoimpl.StudentDao;
import com.tricon.Student.model.Student;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertNotNull;
import static org.junit.Assert.assertTrue;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.when;
import static org.mockito.Mockito.verify;

public class UserApplicationTests {
	

private static StudentDao studentDaoTestObject;
 private static Student stud1,stud2,stud3;
 
 @BeforeClass
 public static void setUp(){
	 StudentDao studentDaoTestObject = mock(StudentDao.class);
	 stud1 = new Student(1,"sim","goa");
	 stud2 = new Student(2,"ria","");
	 stud3 = new Student(3,"raj","patna");
  
   when(studentDaoTestObject.getUser()).thenReturn(Arrays.asList(stud1, stud2,stud3));
   when(studentDaoTestObject.getUserbyId(1)).thenReturn(stud1);
   when(studentDaoTestObject.getUserbyId(3)).thenReturn(stud3);
   when(studentDaoTestObject.addUser(stud1)).thenReturn(stud1);
   verify(studentDaoTestObject).removeUser(1);
   verify(studentDaoTestObject).removeUser(3);
   when(studentDaoTestObject.updateUser(stud1)).thenReturn("Updated Successfully");

 }
 @Test
 public void testGetUser(){


   Student newstud = studentDaoTestObject.getUserbyId(1);
   
   assertNotNull(newstud);
   assertEquals(1, newstud.getId());
   //assertNotEquals(0, newStudent.getId());
   
   
 }
@Test
 public void testGetUser1(){


   Student newUser = studentDaoTestObject.getUserbyId(1);
   
   assertEquals("sim", newUser.getName());
   assertEquals("goa", newUser.getAddress());
   assertFalse(newUser.getName()!="sim");
   assertTrue(newUser.getId()!=0);
   newUser=studentDaoTestObject.getUserbyId(3);
   assertNotNull(newUser);
   assertNotNull(newUser.getName());
   assertFalse(newUser.getId()==0);
   
 }

}