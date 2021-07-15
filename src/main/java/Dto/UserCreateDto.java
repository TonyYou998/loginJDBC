package Dto;

import javax.management.relation.Role;

public class UserCreateDto {
	private int id;
	private int roleId;
	private String email;
	private String password;
	private String name;
	private String address;
	private String phone;
	private  Role role;
	
	public UserCreateDto(String roleId) {
		
	}

	
}
