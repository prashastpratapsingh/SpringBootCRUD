package com.xadmin.SpringBootCrud.controller;

import java.time.Duration;
import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
//import org.openqa.selenium.By;
//import org.openqa.selenium.WebDriver;
//import org.openqa.selenium.WebElement;
//import org.openqa.selenium.chrome.ChromeDriver;
//import org.openqa.selenium.support.ui.ExpectedConditions;
//import org.openqa.selenium.support.ui.WebDriverWait;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.xadmin.SpringBootCrud.bean.Appointment;
import com.xadmin.SpringBootCrud.service.AppointmentService;

@RestController
public class AppointmentController {
	@Autowired
	private AppointmentService appointmentService;// this is a reference variable

	// now we will create a method to get the appointment from the database
	// i.e to add or delete or update appointment to the database

	// method to get all appointments from the database
	@RequestMapping("/appointments")
	public List<Appointment> getAllAppointments() {
		return appointmentService.getAllAppointments();
	}

	// now we will create a new method that will help us to add new appointments in
	// the database
	@RequestMapping(method = RequestMethod.POST, value = "/appointments") // since we are adding data we have to use
																			// POST method
	public void addAppointment(@RequestBody Appointment appointment) {
		appointmentService.addAppointment(appointment);// since there is no automatic/already made add method present in
														// service class, we have to code it

		System.setProperty("webdriver.chrome.driver", "C:\\Users\\hp\\Desktop\\chromewebdriver_113\\chromedriver.exe");
		System.setProperty("webdriver.http.factory", "jdk-http-client");
		WebDriver driver = new ChromeDriver();
		driver.manage().window().maximize();
		driver.get("https://www.google.com/");
		WebElement el1 = driver.findElement(By.name("q"));
		el1.sendKeys(appointment.getName());
		WebElement myDynamicElement = new WebDriverWait(driver, Duration.ofSeconds(5))
				.until(ExpectedConditions.visibilityOfElementLocated((By.xpath(
						"/html[1]/body[1]/div[1]/div[3]/form[1]/div[1]/div[1]/div[2]/div[2]/div[2]/div[1]/div[1]/ul[1]/li[4]/div[1]/div[2]/div[1]/div[1]/span[1]"))));
		System.out.println("the third search is : " + driver.findElement(By.xpath(
				"/html[1]/body[1]/div[1]/div[3]/form[1]/div[1]/div[1]/div[2]/div[2]/div[2]/div[1]/div[1]/ul[1]/li[4]/div[1]/div[2]/div[1]/div[1]/span[1]"))
				.getText());
		myDynamicElement.click();

	}

	// now we will create a method to update any appointment of our database
	@RequestMapping(method = RequestMethod.PUT, value = "/appointments/{id}") // id is also passed as the appointment
																				// with the given id will be updated
	public void updateAppointment(@PathVariable String id, @RequestBody Appointment appointment)// to capture id from
																								// the url we have to
																								// use path variable
																								// annotation
	{
		appointmentService.updateAppointment(id, appointment);
	}

	@RequestMapping(method = RequestMethod.DELETE, value = "/appointments/{id}") // id is also passed as the appointment
																					// with the given id will be updated
	public void deleteAppointment(@PathVariable String id)// to capture id from the url we have to use path variable
															// annotation
	{
		appointmentService.deleteAppointment(id);
	}

}
