package com.Entity;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToMany;
import javax.validation.constraints.Email;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Past;
import javax.validation.constraints.Pattern;
import javax.validation.constraints.Size;

import com.fasterxml.jackson.annotation.JsonIgnore;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;



@AllArgsConstructor
@NoArgsConstructor
@Data
@Entity
public class User {
	
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private Integer user_id;
	
	@Email(message ="Enter Email in correct format.")
	@Column(unique = true)
	private String emailId;
	
	@NotNull(message = "FirstName should not null")
    @Pattern(regexp = "^[a-zA-Z]*$")
	private String firstName;
	
	@NotNull(message = "not null")
    @Pattern(regexp = "^[a-zA-Z]*$")
	private String lastName;
    
    @Size(min = 10,max = 10,message = "Mobile number should contain 10 digits.")
	private String mobileNumber;
    
    @Past(message = "Date input is invalid for a birth date.")
    private LocalDate dateOfBirth;
    
    @JsonIgnore
	@ManyToMany(cascade = CascadeType.ALL)
    private List<Event> event=new ArrayList<>();

}
