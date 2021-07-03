package JavaProject.models;

import java.util.List;

import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.Table;

@Entity
@Table(name="city")
public class City {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;
	private String name;
	@OneToMany(mappedBy = "city", fetch = FetchType.LAZY)
	private List<Users> user;
	@OneToMany(mappedBy = "city", fetch = FetchType.LAZY)
	private List<Driver> driver;
	
	public City() {
		super();
	}
	
	

}
