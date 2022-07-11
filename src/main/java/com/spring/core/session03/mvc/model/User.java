package com.spring.core.session03.mvc.model;

import java.util.Arrays;
import java.util.Map;
import java.util.Set;
import java.util.List;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.PropertySource;
import org.springframework.stereotype.Component;

@Component
@PropertySource("classpath:user.properties")
public class User {
	//@Value(value ="John")
	@Value("{$user.username}")
	private String username; //姓名
	
	//@Value(value = "18")
	@Value("{$user.age}")
	private String age; //年齡
	
	//@Value(value ="#{${nickname:{'foo','bar'}}}")//使用spring EL
	@Value("#{${nickname}")
	private String[] nickname; //暱稱
	
	//@Value(value ="#{${subjects:{'Java','Math'}}}")
	@Value("#{'${user.scores}'.split(',')}")
	private Set<String> subjects; //專長科目
	
	//@Value(value ="#{${scores:{100,90}}}")
	@Value("#{'${user.scores}'.split(',')}")
	private List<Integer> scores;//成績
	
	
	//@Value(value = "#{${hobbies: {'h1': 'Car', 'h2': 'Game'}}}")
	@Value("#{${user.hobbies}}")
	private Map<String, String> hobbies; //興趣
	
	
	public String getUsername() {
		return username;
	}
	public void setUsername(String username) {
		this.username = username;
	}
	public String getAge() {
		return age;
	}
	public void setAge(String age) {
		this.age = age;
	}
	public String[] getNickname() {
		return nickname;
	}
	public void setNickname(String[] nickname) {
		this.nickname = nickname;
	}
	public Set<String> getSubjects() {
		return subjects;
	}
	public void setSubjects(Set<String> subjects) {
		this.subjects = subjects;
	}
	public Map<String, String> getHobbies() {
		return hobbies;
	}
	public void setHobbies(Map<String, String> hobbies) {
		this.hobbies = hobbies;
	}
	public List<Integer> getScores() {
		return scores;
	}
	public void setScores(List<Integer> scores) {
		this.scores = scores;
	}
	@Override
	public String toString() {
		return "User [username=" + username + ", age=" + age + ", nickname=" + Arrays.toString(nickname) + ", subjects="
				+ subjects + ", hobbies=" + hobbies + "]";
	}
	
	
	
}
