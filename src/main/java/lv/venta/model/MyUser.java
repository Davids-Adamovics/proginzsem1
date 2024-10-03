package lv.venta.model;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.FetchType;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToMany;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.OneToMany;
import jakarta.persistence.Table;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Pattern;
import jakarta.validation.constraints.Size;
import lombok.AccessLevel;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;

@Getter
@Setter
@NoArgsConstructor
@ToString
//@AllArgsConstructor
@Table(name = "UserTable")
@Entity
public class MyUser 
{

	@Setter(value = AccessLevel.NONE)
	@Column(name = "UserId")
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)//autoincrement
	private int userId;

//	@Size(min = 3, max = 50)
	@Column(name = "Username")
	private String username;

	@Column(name = "Password")
	private String password;
	
	@ManyToOne(fetch = FetchType.EAGER)
	@JoinColumn(name = "AuthorityID")
	private MYAuthority authority;
	
	
	public MyUser(String username, String password, MYAuthority authority) 
	{
		setUsername(username);
		setPassword(password);
		setAuthority(authority);
	}
}
