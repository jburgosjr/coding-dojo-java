package com.JairoBurgos.Courses.models;

import java.util.Date;
import java.util.List;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
import javax.persistence.ManyToMany;
import javax.persistence.OneToMany;
import javax.persistence.PrePersist;
import javax.persistence.PreUpdate;
import javax.persistence.Table;
import javax.persistence.Transient;
import javax.validation.constraints.Email;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.Size;

@Entity
@Table(name="users")
public class User {
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;
	
	@NotBlank(message="• First Name field must not be blank")
	@Size(min=2, message="• First name must be 2 characters or more")
	private String firstName;
	
	@NotBlank(message="• Last Name field must not be blank")
	@Size(min=2, message="• Last name must be 2 characters or more")
	private String lastName;
	
	@NotBlank(message="• Email field must not be blank")
	@Email(message=" • Email is in an invalid format. proper format: name@host.com")
	private String email;
	
	@NotBlank(message="• Password field must not be blank")
	@Size(min=5,message="• Password must be 5 characters or more")
	private String password;
	
	@NotBlank(message="• Password Confirmation field must not be blank")
    @Transient
    private String passwordConfirmation;
	
	@ManyToMany(fetch = FetchType.LAZY)
	@JoinTable(
			name = "joined_courses",
			joinColumns = @JoinColumn(name="user_id"),
			inverseJoinColumns = @JoinColumn(name="course_id")
			)
	private List<Course>joinedCourses;
	
	@Column(updatable=false)
	private Date createdAt;
	    
	private Date updatedAt;
	
	@OneToMany(mappedBy="user",fetch = FetchType.LAZY)
	private List<Course> courses;
	
	public User() {
		
	}
	
	
	@PrePersist
	protected void onCreate() {
		this.createdAt = new Date();
	}
	
	@PreUpdate
	protected void onUpdate() {
		this.updatedAt = new Date();
	}


	public Long getId() {
		return id;
	}


	public void setId(Long id) {
		this.id = id;
	}


	public String getFirstName() {
		return firstName;
	}


	public void setFirstName(String firstName) {
		this.firstName = firstName;
	}


	public String getLastName() {
		return lastName;
	}


	public void setLastName(String lastName) {
		this.lastName = lastName;
	}


	public String getEmail() {
		return email;
	}


	public void setEmail(String email) {
		this.email = email;
	}


	public String getPassword() {
		return password;
	}


	public void setPassword(String password) {
		this.password = password;
	}


	public String getPasswordConfirmation() {
		return passwordConfirmation;
	}


	public void setPasswordConfirmation(String passwordConfirmation) {
		this.passwordConfirmation = passwordConfirmation;
	}


	public List<Course> getJoinedCourses() {
		return joinedCourses;
	}


	public void setJoinedCourses(List<Course> joinedCourses) {
		this.joinedCourses = joinedCourses;
	}


	public Date getCreatedAt() {
		return createdAt;
	}


	public void setCreatedAt(Date createdAt) {
		this.createdAt = createdAt;
	}


	public Date getUpdatedAt() {
		return updatedAt;
	}


	public void setUpdatedAt(Date updatedAt) {
		this.updatedAt = updatedAt;
	}


	public List<Course> getCourses() {
		return courses;
	}


	public void setCourses(List<Course> courses) {
		this.courses = courses;
	}



	

}
