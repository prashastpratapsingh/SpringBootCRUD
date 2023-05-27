package com.xadmin.SpringBootCrud.repository;

import org.springframework.data.repository.CrudRepository;

import com.xadmin.SpringBootCrud.bean.Appointment;

//inside CrudRepository class we have all methods such as save,delete update etc
public interface AppointmentRepository extends CrudRepository<Appointment, String> {

}
