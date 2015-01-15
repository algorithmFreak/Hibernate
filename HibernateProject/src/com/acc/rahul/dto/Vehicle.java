package com.acc.rahul.dto;

import java.util.Collection;

import javax.persistence.Column;
import javax.persistence.DiscriminatorColumn;
import javax.persistence.DiscriminatorType;
import javax.persistence.DiscriminatorValue;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Inheritance;
import javax.persistence.InheritanceType;
import javax.persistence.ManyToOne;
import javax.persistence.NamedNativeQuery;
import javax.persistence.NamedQuery;
import javax.persistence.Table;

import org.hibernate.annotations.NotFound;
import org.hibernate.annotations.NotFoundAction;

@Entity(name="vehicle")
@NamedQuery(name="vehicle.byId", query="from vehicle where vehicleId=?")
@NamedNativeQuery(name="vehicle.byVehicleId",query="select * from VEHICLE where VEHICLE_ID=?",resultClass=Vehicle.class)
@org.hibernate.annotations.Entity(selectBeforeUpdate=true)
@Table(name="VEHICLE")
@Inheritance(strategy=InheritanceType.JOINED)
public class Vehicle {

	@Id @GeneratedValue(strategy=GenerationType.AUTO)
	@Column(name="VEHICLE_ID")
	private int vehicleId;
	
	@Column(name="VEHICLE_NAME")
	private String vehicleName;

/*	@ManyToOne
	@NotFound(action=NotFoundAction.IGNORE)
	private Student student;
	
	

	*//**
	 * @return the student
	 *//*
	public Student getStudent() {
		return student;
	}

	*//**
	 * @param student the student to set
	 *//*
	public void setStudent(Student student) {
		this.student = student;
	}
*/
	/**
	 * @return the vehicleId
	 */
	public int getVehicleId() {
		return vehicleId;
	}

	/**
	 * @param vehicleId the vehicleId to set
	 */
	public void setVehicleId(int vehicleId) {
		this.vehicleId = vehicleId;
	}

	/**
	 * @return the vehicleName
	 */
	public String getVehicleName() {
		return vehicleName;
	}

	/**
	 * @param vehicleName the vehicleName to set
	 */
	public void setVehicleName(String vehicleName) {
		this.vehicleName = vehicleName;
	}

}
