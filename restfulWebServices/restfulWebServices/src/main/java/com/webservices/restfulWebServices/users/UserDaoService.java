package com.webservices.restfulWebServices.users;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.Date;
import java.util.List;

import org.springframework.stereotype.Component;
import org.springframework.stereotype.Repository;

@Repository
public class UserDaoService {
	private static List<User> users =new ArrayList<>();
	static int UserCount=3;
	
	static {
		users.add(new User(2,"eve",20));
		users.add(new User(3,"jack",30));
		users.add(new User(1,"Adam",21));

	}
	//Find User
	public List<User> findAll(){
		for(User user:users) {
			if(user==null) {
				return null;
			}
		}
		return users;
	}
	
	
	//Save User
	
	public User save(User user) {
		if(user.getId()==0) {
			user.setId(++UserCount);
		}
		users.add(user);
		return user;
	}
	
	//findOne
	
	public User findone(int Id) {
		for(User user:users) {
			if(user.getId()==Id){
				return user;
			}			
		}
		return null;
		
	}
	
	//OrderRetrieve
	public List<User> Ordered(){
		Collections.sort(users, Comparator.comparingLong(User::getId));
		return users;
	}
	
	//DeleteUser
	public List<User> DeleteUser(int id){
		users.removeIf(e -> e.getId()==(id));
		return users;
	}
	

}
