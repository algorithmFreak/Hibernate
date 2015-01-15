package com.acc.rahul.dto;

import java.util.ArrayList;
import java.util.Collection;
import java.util.Date;
import java.util.Set;

import javax.persistence.AttributeOverride;
import javax.persistence.AttributeOverrides;
import javax.persistence.Column;
import javax.persistence.ElementCollection;
import javax.persistence.Embedded;
import javax.persistence.EmbeddedId;
import javax.persistence.Entity;
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
import javax.persistence.Lob;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

import org.hibernate.annotations.CollectionId;
import org.hibernate.annotations.GenericGenerator;
import org.hibernate.annotations.Type;

@Entity(name="userEntity")
@Table (name="USER_DETAILS")
public class UserDetails{

	//@Id 
	//@GeneratedValue(strategy=GenerationType.AUTO)
	@Column(name="user_id")
	private int userId;
	
	@EmbeddedId
	/*@AttributeOverrides({
		@AttributeOverride(name="userIdentification", column=@Column(name="USER_IDENTITY")),
		@AttributeOverride(name="password", column=@Column(name="PASSWORD"))})*/
	private LoginDetails login; 
	
/**
	 * @return the login
	 */
	public LoginDetails getLogin() {
		return login;
	}
	/**
	 * @param login the login to set
	 */
	public void setLogin(LoginDetails login) {
		this.login = login;
	}
	//	@Transient
	@Column(name="user_name")
	//private String userName;
	private static String userName;
	
	@Temporal(TemporalType.DATE)
	@Column(name="user_joiningdate")
	private Date joiningDate;
	
	@Embedded //optional
	@AttributeOverrides({
	@AttributeOverride(name="streetName", column=@Column(name="HOME_STREET_NAME")),
	@AttributeOverride(name="city", column=@Column(name="HOME_CITY_NAME")),
	@AttributeOverride(name="state", column=@Column(name="HOME_STATE_NAME")),
	@AttributeOverride(name="pincode", column=@Column(name="HOME_PIN_CODE"))})
	private Address homeAddress;
	
	@Embedded
	@AttributeOverrides({
	@AttributeOverride(name="streetName", column=@Column(name="OFFICE_STREET_NAME")),
	@AttributeOverride(name="city", column=@Column(name="OFFICE_CITY_NAME")),
	@AttributeOverride(name="state", column=@Column(name="OFFICE_STATE_NAME")),
	@AttributeOverride(name="pincode", column=@Column(name="OFFICE_PIN_CODE"))})
	private Address officeAddress;
	
	@Lob
	@Column(name="user_description")
	private String description;
	
	@ElementCollection
	@JoinTable(name="ADDRESS_DETAILS",joinColumns={
		@JoinColumn(name="USER_IDENTIFICATION",referencedColumnName="userIdentification" ),
		@JoinColumn(name="USER_PASSWORD",referencedColumnName="password" ),
		})
	@GenericGenerator(name="hilo-gen", strategy="hilo")
	@CollectionId(columns = { @Column(name="ADDRESS_ID") }, generator = "hilo-gen", type = @Type(type="long"))
	private Collection<Address> addressSet = new ArrayList<Address>();
	
	/**
	 * @return the addressSet
	 */
	public Collection<Address> getAddressSet() {
		return addressSet;
	}
	/**
	 * @param addressSet the addressSet to set
	 */
	public void setAddressSet(Collection<Address> addressSet) {
		this.addressSet = addressSet;
	}
	/**
	 * @return the userId
	 */
	public int getUserId() {
		return userId;
	}
	/**
	 * @param userId the userId to set
	 */
	public void setUserId(int userId) {
		this.userId = userId;
	}
	/**
	 * @return the userName
	 */
	public String getUserName() {
		return userName;
	}
	/**
	 * @param userName the userName to set
	 */
	public void setUserName(String userName) {
		this.userName = userName;
	}
	/**
	 * @return the joiningDate
	 */
	public Date getJoiningDate() {
		return joiningDate;
	}
	/**
	 * @param joiningDate the joiningDate to set
	 */
	public void setJoiningDate(Date joiningDate) {
		this.joiningDate = joiningDate;
	}
	
	/**
	 * @return the description
	 */
	public String getDescription() {
		return description;
	}
	/**
	 * @param description the description to set
	 */
	public void setDescription(String description) {
		this.description = description;
	}
	/**
	 * @return the homeAddress
	 */
	public Address getHomeAddress() {
		return homeAddress;
	}
	/**
	 * @param homeAddress the homeAddress to set
	 */
	public void setHomeAddress(Address homeAddress) {
		this.homeAddress = homeAddress;
	}
	/**
	 * @return the officeAddress
	 */
	public Address getOfficeAddress() {
		return officeAddress;
	}
	/**
	 * @param officeAddress the officeAddress to set
	 */
	public void setOfficeAddress(Address officeAddress) {
		this.officeAddress = officeAddress;
	}
	
	
	
}
