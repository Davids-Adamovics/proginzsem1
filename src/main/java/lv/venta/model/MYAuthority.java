package lv.venta.model;


import java.util.Collection;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
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
public class MYAuthority 
{


	@Setter(value = AccessLevel.NONE)
	@Column(name = "UserId")
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)//autoincrement
	private int AuthorityID;
	
	@Size(min = 3, max = 50)
	@Pattern(regexp = "[A-Z]*")
	@Column(name = "title")
	private String title;
	
	@OneToMany(mappedBy = "authority")
	@ToString.Exclude
	private Collection<MyUser> users;

	public MYAuthority(@Pattern(regexp = "[A-Z]{4,7}") String title) {
		this.title = title;
	}
	
}
