package beans;

import jakarta.persistence.*;
import org.hibernate.annotations.CreationTimestamp;
import org.hibernate.annotations.UpdateTimestamp;
import org.springframework.format.annotation.DateTimeFormat;

import java.time.LocalDate;

@Entity

public class User {
	public LocalDate getDOB() {
		return DOB;
	}

	public void setDOB(LocalDate DOB) {
		this.DOB = DOB;
	}

	@Id
	@GeneratedValue
	private Integer sno;

	private String name;

	private String email;

	private Long mobilenumber;

	private String gender;

	@DateTimeFormat(pattern = "yyyy-mm-dd")
	private LocalDate DOB;

	private Integer ssn;

	private String actionSW = "Y";
	@CreationTimestamp
	@Column(updatable = false)
	private LocalDate currentDate;
	@UpdateTimestamp
	@Column(insertable = false)
	private LocalDate updateDate;

	public Integer getSno() {
		return sno;
	}

	public void setSno(Integer sno) {
		this.sno = sno;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public Long getMobilenumber() {
		return mobilenumber;
	}

	public void setMobilenumber(Long mobilenumber) {
		this.mobilenumber = mobilenumber;
	}

	public String getGender() {
		return gender;
	}

	public void setGender(String gender) {
		this.gender = gender;
	}

	public Integer getSsn() {
		return ssn;
	}

	public void setSsn(Integer ssn) {
		this.ssn = ssn;
	}

	public String getActions() {
		return actionSW;
	}

	public void setActions(String actions) {
		this.actionSW = actions;
	}
}
