package yak.shop.model;

import javax.xml.bind.annotation.XmlAttribute;


 
public class YakEntity {

	private String name;
	private double age;
	public YakEntity() {
		super();
	}
	private String sex;
	
	@XmlAttribute   
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	
	public YakEntity(String name, double age, String sex) {
		super();
		this.name = name;
		this.age = age;
		this.sex = sex;
	}
	
	@XmlAttribute    
	public double getAge() {
		return age;
	}
	public void setAge(double age) {
		this.age = age;
	}
	
	@XmlAttribute  
	public String getSex() {
		return sex;
	}
	public void setSex(String sex) {
		this.sex = sex;
	}
	
}
