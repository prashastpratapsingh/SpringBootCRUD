package com.xadmin.SpringBootCrud.repository;

import org.springframework.data.repository.CrudRepository;

import com.xadmin.SpringBootCrud.bean.Subject;

//inside CrudRepository class we have all methods such as save,delete update etc
public interface SubjectRepository extends CrudRepository<Subject,String> {

}
