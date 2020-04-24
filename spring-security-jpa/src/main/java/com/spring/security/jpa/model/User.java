package com.spring.security.jpa.model;

import java.util.Set;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
import javax.persistence.OneToMany;
import javax.validation.constraints.Size;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.Getter;
import lombok.Setter;


@ApiModel(description = "This model is to create a user")
@Entity
@Getter
@Setter
public class User {
	
	@ApiModelProperty(notes = " Auto generated unique id ", required = true,position = 1)
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private int user_id;
	
	@ApiModelProperty(notes = "username should be flname", example = "Sprasad",required = false, position = 2)
	@Size(min = 3, max = 50)
	private String username;
	
	private String password;
	
	@Size(min = 3, max = 50)
	private String email;
	
	@Size(min = 3, max = 15)
	private int mobile_no;
	
	@OneToMany(cascade = CascadeType.ALL,fetch = FetchType.EAGER)
	@JoinTable(name="user_role",joinColumns = @JoinColumn(name="user_id"),inverseJoinColumns = @JoinColumn(name="role_id"))
	private Set<Role> roles;
}
