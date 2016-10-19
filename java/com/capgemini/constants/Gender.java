package com.capgemini.constants;

public enum Gender {
	M("M"), F("F"), O("O");

	private String gender;

	private Gender(final String gender) {
		this.gender = gender;
	}

	@Override
	public String toString() {
		return gender;
	}

	public String getGender() {
		return gender;
	}

	public void setGender(String gender) {
		this.gender = gender;
	}

}
