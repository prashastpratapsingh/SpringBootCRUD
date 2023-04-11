package com.xadmin.SpringBootCrud.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.xadmin.SpringBootCrud.bean.Subject;
import com.xadmin.SpringBootCrud.service.SubjectService;

@RestController
public class SubjectController {
	@Autowired
	private SubjectService subjectService;// this is a reference variable
	
	
	
	//now we will create a method to get the subject from the database
	//i.e to add or delete or update subject to the database
	
	//method to get all subjects from the database
	@RequestMapping("/subjects")
	public List<Subject> getAllSubjects()
	{
		return subjectService.getAllSubjects();
	}
	
	
	//now we will create a new method that will help us to add new subjects in the database
	@RequestMapping(method=RequestMethod.POST,value="/subjects")//since we are adding data we have to use POST method
	public void addSubject(@RequestBody Subject subject)
	{
		subjectService.addSubject(subject);// since there is no automatic/already made add method present in service class, we have to code it
		
	}
	
	//now we will create a method to update any subject of our database
	@RequestMapping(method=RequestMethod.PUT,value="/subjects/{id}")//id is also passed as the subject with the given id will be updated
	public void updateSubject(@PathVariable String id,@RequestBody Subject subject)// to capture id from the url we have to use path variable annotation
	{
		subjectService.updateSubject(id,subject);
	}
	
	@RequestMapping(method=RequestMethod.DELETE,value="/subjects/{id}")//id is also passed as the subject with the given id will be updated
	public void deleteSubject(@PathVariable String id)// to capture id from the url we have to use path variable annotation
	{
		subjectService.deleteSubject(id);
	}
	
}



