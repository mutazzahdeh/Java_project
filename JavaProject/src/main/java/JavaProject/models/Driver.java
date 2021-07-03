package JavaProject.models;

import java.util.Date;
import java.util.List;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
import javax.persistence.ManyToMany;
import javax.persistence.ManyToOne;
import javax.persistence.PrePersist;
import javax.persistence.PreUpdate;
import javax.persistence.Table;
import javax.persistence.Transient;
import javax.validation.constraints.Email;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;

import org.springframework.format.annotation.DateTimeFormat;

@Entity
@Table(name ="driver")
public class Driver {
	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	private Long id;
	private String name;
	@NotNull
	@Email(message = "Email must be valid")
	private String email;
	private String phonenum;
	@Size(min = 8, message = "Password must be greater than 5 characters")
	private String password;
	@Transient
	private String passwordConfirmation;
	private String car;
	private int Model;
	@ManyToOne(fetch = FetchType.LAZY)
	@JoinColumn(name = "city_id")
	private City city;
	@Column(updatable = false)
	@DateTimeFormat(pattern = "yyyy-MM-dd")
	private Date createdAt;
	@DateTimeFormat(pattern = "yyyy-MM-dd")
	private Date updatedAt;
	@ManyToMany(fetch = FetchType.LAZY)
	@JoinTable(name = "driver_trip",
	joinColumns = @JoinColumn(name = "driver_id"), 
	inverseJoinColumns = @JoinColumn(name = "trip_id"))
	private List<Trip> trip;
	
	public Driver() {
		super();
	}

	@PrePersist
	protected void onCreate() {
		this.createdAt = new Date();
	}

	@PreUpdate
	protected void onUpdate() {
		this.updatedAt = new Date();
	}
	
}
