package com.xadmin.SpringBootCrud.service;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.xadmin.SpringBootCrud.bean.Subject;
import com.xadmin.SpringBootCrud.repository.SubjectRepository;

@Service
public class SubjectService {
	@Autowired
	
	public SubjectRepository subjectRepo;// this is a reference variable not a object as we cannot create object of interfaces

	public List<Subject> getAllSubjects()
	{
		// now we call repository class of spring JPA to get all the data from the spring database
		List<Subject> subjects= new ArrayList<> ();
		subjectRepo.findAll().forEach(subjects::add);
		return subjects;
	}
	
	public void addSubject(Subject subject)
	{
		subjectRepo.save(subject);// this will save a new object to our database table with the name subject, thus adding the subject
	}
	
	public void updateSubject(String id,Subject subject)
	{
		subjectRepo.save(subject);// this will check whether the subject with given id is present or not in the database
								// if its absent,it will create otherwise it will update
	}
	
	public void deleteSubject(String id)
	{
		subjectRepo.deleteById(id);
	}
}
