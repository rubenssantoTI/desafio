package desafio.concrete.model;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.NamedQuery;
import javax.persistence.OneToMany;
import javax.persistence.OrderBy;

import org.hibernate.annotations.Fetch;
import org.hibernate.annotations.FetchMode;
import org.springframework.format.annotation.DateTimeFormat;

@NamedQuery(name="findUserByEmail", 
query=" select user from User user left join fetch user.telefones where user.email = :email")

@Entity
public class User implements Serializable {
	
	private static final long serialVersionUID = 5838365707225692545L;

	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private long id;

	@Column
	private String name;
	
	@Column(unique=true)
	private String email;
	
	@Column
	private String password;
	
	@Column
	private String token;
	
	@DateTimeFormat(pattern="MM/dd/yyyy")
	@Column(columnDefinition = "DATE DEFAULT CURRENT_DATE")
	private Date dtCreated = new Date();
	
	@DateTimeFormat(pattern="MM/dd/yyyy")
	@Column(columnDefinition = "DATE DEFAULT CURRENT_DATE")
	private Date dtLastLogin = new Date();
	
	@DateTimeFormat(pattern="MM/dd/yyyy")
	@Column(columnDefinition = "DATE DEFAULT CURRENT_DATE")
	private Date dtLastModified = new Date();

	@OneToMany(mappedBy = "user", fetch = FetchType.EAGER, cascade = CascadeType.ALL)
	@OrderBy(" number ASC")
	@Fetch(FetchMode.SUBSELECT) 
	List<Phone> telefones = new ArrayList<Phone>();

	public long getId() {
		return id;
	}

	public void setId(long id) {
		this.id = id;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	public String getToken() {
		return token;
	}

	public void setToken(String token) {
		this.token = token;
	}

	public Date getDtCreated() {
		return dtCreated;
	}

	public void setDtCreated(Date dtCreated) {
		this.dtCreated = dtCreated;
	}

	public Date getDtLastLogin() {
		return dtLastLogin;
	}

	public void setDtLastLogin(Date dtLastLogin) {
		this.dtLastLogin = dtLastLogin;
	}

	public Date getDtLastModified() {
		return dtLastModified;
	}

	public void setDtLastModified(Date dtLastModified) {
		this.dtLastModified = dtLastModified;
	}

	public List<Phone> getTelefones() {
		return telefones;
	}

	public void setTelefones(List<Phone> telefones) {
		this.telefones = telefones;
	}

	
}
