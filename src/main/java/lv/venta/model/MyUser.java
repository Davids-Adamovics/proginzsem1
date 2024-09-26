package lv.venta.model;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
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
@Table(name = "ProductTable")
@Entity
public class MyUser 
{

	@Setter(value = AccessLevel.NONE)
	@Column(name = "UserId")
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)//autoincrement
	private int userId;
	
	@NotNull
	@Size(min = 3, max = 50)
	@Pattern(regexp = "[A-ZĒŪĪĻĶĢŠĀŽČŅa-zēūīļķģšāžčņ ]+")
	@Column(name = "Username")
	private String username;
	
	@NotNull
	@Size(min = 8, max = 50)
	@Column(name = "Password")
	private String password;
	
	
	public MyUser(String username, String password) 
	{
		setUsername(username);
		setPassword(password);
	}
}
