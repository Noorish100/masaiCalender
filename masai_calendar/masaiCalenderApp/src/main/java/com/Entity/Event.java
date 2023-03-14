package com.Entity;

import java.time.LocalDate;
import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToMany;

import com.fasterxml.jackson.annotation.JsonIgnore;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;



@AllArgsConstructor
@NoArgsConstructor
@Data
@Entity
public class Event {

	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private Integer event_id;

	private String title;

	private LocalDate start_date;

	private LocalDate end_date;

	 @JsonIgnore
		@ManyToMany(cascade = CascadeType.ALL)
	private List<User> user;

}
