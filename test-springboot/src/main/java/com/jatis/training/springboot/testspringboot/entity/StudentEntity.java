package com.jatis.training.springboot.testspringboot.entity;

import java.time.LocalDate;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "MST_STUDENT")
public class StudentEntity {

	@Id
	@Column(length = 50)
	private String studentNo;
	
	@Column(length = 100)
	private String name;
	
	private LocalDate dateOfBirth;

	public String getStudentNo() {
		return studentNo;
	}

	public void setStudentNo(String studentNo) {
		this.studentNo = studentNo;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public LocalDate getDateOfBirth() {
		return dateOfBirth;
	}

	public void setDateOfBirth(LocalDate dateOfBirth) {
		this.dateOfBirth = dateOfBirth;
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((studentNo == null) ? 0 : studentNo.hashCode());
		return result;
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		StudentEntity other = (StudentEntity) obj;
		if (studentNo == null) {
			if (other.studentNo != null)
				return false;
		} else if (!studentNo.equals(other.studentNo))
			return false;
		return true;
	}
	
	
}
