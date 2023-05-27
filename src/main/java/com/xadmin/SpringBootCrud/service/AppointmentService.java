package com.xadmin.SpringBootCrud.service;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.xadmin.SpringBootCrud.bean.Appointment;
import com.xadmin.SpringBootCrud.repository.AppointmentRepository;

@Service
public class AppointmentService {
	@Autowired

	public AppointmentRepository appointmentRepo;// this is a reference variable not a object as we cannot create object
													// of interfaces

	public List<Appointment> getAllAppointments() {
		// now we call repository class of spring JPA to get all the data from the
		// spring database
		List<Appointment> appointments = new ArrayList<>();
		appointmentRepo.findAll().forEach(appointments::add);
		return appointments;
	}

	public void addAppointment(Appointment appointment) {
		appointmentRepo.save(appointment);// this will save a new object to our database table with the name
											// appointment, thus adding the appointment
	}

	public void updateAppointment(String time, Appointment appointment) {
		appointmentRepo.save(appointment);// this will check whether the appointment with given id is present or not in
											// the database
		// if its absent,it will create otherwise it will update
	}

	public void deleteAppointment(String time) {
		appointmentRepo.deleteById(time);
	}
}
