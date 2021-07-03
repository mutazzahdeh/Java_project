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
import javax.persistence.PrePersist;
import javax.persistence.PreUpdate;
import javax.persistence.Table;
import javax.persistence.Transient;
import javax.validation.constraints.Email;
import javax.validation.constraints.Size;

import org.springframework.format.annotation.DateTimeFormat;

import com.sun.istack.NotNull;

@Entity
@Table(name ="trip")
public class Trip {
	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	private Long id;
	
	private String postion;
	@NotNull
	private String direction;
	private int cost;
	private int time;
	

	@Column(updatable = false)
	@DateTimeFormat(pattern = "yyyy-MM-dd")
	private Date createdAt;
	@DateTimeFormat(pattern = "yyyy-MM-dd")
	private Date updatedAt;
	
	@ManyToMany(fetch = FetchType.LAZY)
	@JoinTable(name = "driver_trip",
	joinColumns = @JoinColumn(name = "trip_id"), 
	inverseJoinColumns = @JoinColumn(name = "driver_id"))
	private List<Driver> driver;
	
	

	@ManyToMany(fetch = FetchType.LAZY)
	@JoinTable(name = "users_trip",
	joinColumns = @JoinColumn(name = "trip_id"), 
	inverseJoinColumns = @JoinColumn(name = "user_id"))
	private List<Users> user;



	public Trip() {
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
