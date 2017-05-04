package com.ib.beans;

public class BeanUser {
	
	private int	person_id;
	private String person_external_id;	
	private String person_firstname;
	private String person_lastnam;
	private String person_email;
	private String person_password;
	private String person_dob;
	private String person_token;
	private String person_phone_number;
	private String  person_created_At;
	private String person_updated_at;
	private int person_advisor_id;
	private int person_is_advisor;
	
	public BeanUser(){
		
	}

	public int getPerson_id() {
		return person_id;
	}

	public void setPerson_id(int person_id) {
		this.person_id = person_id;
	}

	public String getPerson_external_id() {
		return person_external_id;
	}

	public void setPerson_external_id(String person_external_id) {
		this.person_external_id = person_external_id;
	}

	public String getPerson_firstname() {
		return person_firstname;
	}

	public void setPerson_firstname(String person_firstname) {
		this.person_firstname = person_firstname;
	}

	public String getPerson_lastnam() {
		return person_lastnam;
	}

	public void setPerson_lastnam(String person_lastnam) {
		this.person_lastnam = person_lastnam;
	}

	public String getPerson_email() {
		return person_email;
	}

	public void setPerson_email(String person_email) {
		this.person_email = person_email;
	}

	public String getPerson_password() {
		return person_password;
	}

	public void setPerson_password(String person_password) {
		this.person_password = person_password;
	}

	public String getPerson_dob() {
		return person_dob;
	}

	public void setPerson_dob(String person_dob) {
		this.person_dob = person_dob;
	}

	public String getPerson_token() {
		return person_token;
	}

	public void setPerson_token(String person_token) {
		this.person_token = person_token;
	}

	public String getPerson_phone_number() {
		return person_phone_number;
	}

	public void setPerson_phone_number(String person_phone_number) {
		this.person_phone_number = person_phone_number;
	}

	public String getPerson_created_At() {
		return person_created_At;
	}

	public void setPerson_created_At(String person_created_At) {
		this.person_created_At = person_created_At;
	}

	public String getPerson_updated_at() {
		return person_updated_at;
	}

	public void setPerson_updated_at(String person_updated_at) {
		this.person_updated_at = person_updated_at;
	}

	public int getPerson_advisor_id() {
		return person_advisor_id;
	}

	public void setPerson_advisor_id(int person_advisor_id) {
		this.person_advisor_id = person_advisor_id;
	}

	public int getPerson_is_advisor() {
		return person_is_advisor;
	}

	public void setPerson_is_advisor(int person_is_advisor) {
		this.person_is_advisor = person_is_advisor;
	}
	
	

}
