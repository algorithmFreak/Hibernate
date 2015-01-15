package com.acc.rahul.dto;

import javax.persistence.DiscriminatorValue;
import javax.persistence.Entity;

@Entity
public class FourWheeler extends Vehicle {

	private String steeringwheel;

	/**
	 * @return the steeringwheel
	 */
	public String getSteeringwheel() {
		return steeringwheel;
	}

	/**
	 * @param steeringwheel the steeringwheel to set
	 */
	public void setSteeringwheel(String steeringwheel) {
		this.steeringwheel = steeringwheel;
	}
	
}
