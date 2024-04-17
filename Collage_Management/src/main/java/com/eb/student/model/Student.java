package com.eb.student.model;

import jakarta.persistence.*;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Size;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@Entity
@NoArgsConstructor
@AllArgsConstructor
@Table(name="TBL_USERS")
public class Student {
@Id
@GeneratedValue(strategy=GenerationType.AUTO)
	private int id;

@NotNull
@Size(min=2,max=20,message="first Name should have atleast 2 characters")
@Column(name="firstName")
	private String firstName;

@NotNull
@Size(min=2,max=20,message="Last Name should have atleast 2 characters")
	@Column(name="lastName")
	private String lastName;

@NotNull
@NotBlank(message="Email is mandatory")
	@Column(name="email")
	private String email;
@NotNull
@NotBlank(message="Password is mandatory")
	@Column(name="password")
	private String password;
@NotNull
@NotBlank(message="Gender is mandatory")
	@Column(name="gender")
	private String gender;
@NotNull
@NotBlank(message="phone_no is mandatory")
	@Column(name="phone_no")
	private String phone_no;
@NotNull
@NotBlank(message="course is mandatory")
	@Column(name="course")
	private String course;
}
