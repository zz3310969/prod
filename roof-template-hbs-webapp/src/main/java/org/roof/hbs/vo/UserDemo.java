package org.roof.hbs.vo;

import java.io.Serializable;

public class UserDemo implements Serializable {

	private static final long serialVersionUID = 2706094777671518330L;
	private String name;
	private int age;

	
	public UserDemo() {
		super();
	}

	public UserDemo(String name, int age) {
		super();
		this.name = name;
		this.age = age;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public int getAge() {
		return age;
	}

	public void setAge(int age) {
		this.age = age;
	}

}
