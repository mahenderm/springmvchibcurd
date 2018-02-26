package com.st.relations.M2M;

import java.util.Collection;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
import javax.persistence.ManyToMany;
import javax.persistence.Table;

import org.hibernate.annotations.ManyToAny;

@Entity
@Table(name="authorities")
public class AuthorityImpl {
	
	
	private Integer id;
	private String authority;
	
	
	private Collection<UserDetailsImpl> userDetail;
	
	@ManyToMany
	@JoinTable(name="user_authorities",
			joinColumns={@JoinColumn(name="aid")},
			inverseJoinColumns={@JoinColumn(name="uid")}
						
			)
	public Collection<UserDetailsImpl> getUserDetail() {
		return userDetail;
	}

	public void setUserDetail(Collection<UserDetailsImpl> userDetail) {
		this.userDetail = userDetail;
	}
	@Id
	@GeneratedValue
	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	
	
	

	public String getAuthority() {
		return authority;
	}

	public void setAuthority(String authority) {
		this.authority = authority;
	}
	

}
