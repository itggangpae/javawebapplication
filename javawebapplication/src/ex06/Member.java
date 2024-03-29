package ex06;

import java.io.Serializable;
import java.util.Date;
public class Member implements Serializable, Cloneable, Comparable<Member> {
	private static final long serialVersionUID = 1L;
	private String id;
	private String password;
	private String name;
	private String address;
	private Date registerDate;
	private String email;
	public Member() {
		super();
	}
	public Member(String id, String password, String name, String address,
			Date registerDate, String email) {
		super();
		this.id = id;
		this.password = password;
		this.name = name;
		this.address = address;
		this.registerDate = registerDate;
		this.email = email;
	}
	
	public String getId() {
		return id;
	}

	public void setId(String id) {
		this.id = id;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}
	public String getName() {
		return name;
	}
	public void setName(String val) {
		this.name = val;
	}
	public String getAddress() {
		return address;
	}
	public void setAddress(String val) {
		this.address = val;
	}
	public Date getRegisterDate() {
		return registerDate;
	}
	public void setRegisterDate(Date val) {
		this.registerDate = val;
	}
	public String getEmail() {
		return email;
	}
	public void setEmail(String val) {
		this.email = val;
	}

	@Override
	public int compareTo(Member o) {
		return id.compareTo(o.id);
	}
	@Override
	public String toString() {
		return "MemberInfo [password=" + password + ", name=" + name
				+ ", address=" + address + ", registerDate=" + registerDate
				+ ", email=" + email + "]";
	}
	public Member clone(){
		Member obj = new Member(id, password, name, address, registerDate, email);
		return obj;
	}
	public boolean equals(Member obj){
		if(id.equals(obj.id))
			return true;
		else
			return false;
	}
}
