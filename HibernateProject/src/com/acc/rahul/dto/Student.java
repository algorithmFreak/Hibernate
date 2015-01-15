package com.acc.rahul.dto;

import java.util.ArrayList;
import java.util.Collection;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
import javax.persistence.ManyToMany;
import javax.persistence.OneToMany;
import javax.persistence.Table;

@Entity(name="student")
@Table(name="STUDENT")
public class Student {
	

	@Id
	@GeneratedValue(strategy=GenerationType.AUTO)
	@Column(name="REG_NO")
	private int regNo;
	
	@Column(name="STUDENT_NAME")
	private String sName;
			
/*	@ElementCollection(fetch=FetchType.LAZY)
	@JoinTable(name="STUDENT_ADDRESS",joinColumns=@JoinColumn(name="REG_NUMBER"))
	@GenericGenerator(name="hilo-gen",strategy="hilo")
	@CollectionId(type=@Type(type="int"), columns = { @Column(name="ADDRESS_ID") }, generator = "hilo-gen")
	private Collection<Address> listOfAddresses = new ArrayList<Address>();
	*/
	/*@OneToOne
	@JoinColumn(name="VEHICLE_ID")
	private Vehicle vehicle;
	*/
	
	@OneToMany(cascade=CascadeType.ALL)
	/*@JoinTable(name = "STUDENT_VEHICLE_REL", 
			   joinColumns=@JoinColumn(name="STUDENT_ID"),
			   inverseJoinColumns=@JoinColumn(name="VEHICLE_ID"))*/
	private Collection<Vehicle> vehicles = new ArrayList<Vehicle>();
	
	/**
	 * @return the vehicles
	 */
	public Collection<Vehicle> getVehicles() {
		return vehicles;
	}
	/**
	 * @param vehicles the vehicles to set
	 */
	public void setVehicles(Collection<Vehicle> vehicles) {
		this.vehicles = vehicles;
	}
	/**
	 * @return the sName
	 */
	public String getsName() {
		return sName;
	}
	/**
	 * @param sName the sName to set
	 */
	public void setsName(String sName) {
		this.sName = sName;
	}
	
	/**
	 * @return the regNo
	 */

	public int getRegNo() {
		return regNo;
	}
	/**
	 * @param regNo the regNo to set
	 */
	public void setRegNo(int regNo) {
		this.regNo = regNo;
	}
	/**
	 * @return the listOfAddresses
	 */
	/*public Collection<Address> getListOfAddresses() {
		return listOfAddresses;
	}
	*//**
	 * @param listOfAddresses the listOfAddresses to set
	 *//*
	public void setListOfAddresses(Collection<Address> listOfAddresses) {
		this.listOfAddresses = listOfAddresses;
		
	}*/

	
}
