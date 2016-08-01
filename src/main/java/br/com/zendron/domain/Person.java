package br.com.zendron.domain;

import java.io.Serializable;

public class Person implements Serializable {
	
	/**
	 * Generated for the v.1.0
	 */
	private static final long serialVersionUID = -2248463344107876819L;

	private String name;
	
	private String lastName;
	
	private Person parent;
	
	private Gender gender;
	
	
	public Person(String name, String lastName, Gender g) {
		this.name = name;
		this.lastName = lastName;
		this.gender = g;
	}


	public String getName() {
		return this.name;
	}


	public void setName(final String name) {
		this.name = name;
	}


	public String getLastName() {
		return this.lastName;
	}


	public void setLastName(final String lastName) {
		this.lastName = lastName;
	}


	public Person getParent() {
		return this.parent;
	}


	public void setParent(final Person parent) {
		this.parent = parent;
	}


	public Gender getGender() {
		return this.gender;
	}


	public void setGender(Gender gender) {
		this.gender = gender;
	}


	@Override
	public String toString() {
		return "Person [name=" + name + ", lastName=" + lastName + " Gender=" + (gender!=null ? gender.name() : null) +"]";
	}

}
