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

import org.springframework.format.annotation.DateTimeFormat;

import com.sun.istack.NotNull;

@Entity
@Table(name ="trip")
public class Trip {
	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	private Long id;
	
	@NotNull
	private String tripName;
	
	@NotNull
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


	


	public Long getId() {
		return id;
	}





	public void setId(Long id) {
		this.id = id;
	}





	public String getTripName() {
		return tripName;
	}





	public void setTripName(String tripName) {
		this.tripName = tripName;
	}





	public String getPostion() {
		return postion;
	}





	public void setPostion(String postion) {
		this.postion = postion;
	}





	public String getDirection() {
		return direction;
	}





	public void setDirection(String direction) {
		this.direction = direction;
	}





	public int getCost() {
		return cost;
	}





	public void setCost(int cost) {
		this.cost = cost;
	}





	public int getTime() {
		return time;
	}





	public void setTime(int time) {
		this.time = time;
	}





	public Date getCreatedAt() {
		return createdAt;
	}





	public void setCreatedAt(Date createdAt) {
		this.createdAt = createdAt;
	}





	public Date getUpdatedAt() {
		return updatedAt;
	}





	public void setUpdatedAt(Date updatedAt) {
		this.updatedAt = updatedAt;
	}





	public List<Driver> getDriver() {
		return driver;
	}





	public void setDriver(List<Driver> driver) {
		this.driver = driver;
	}





	public List<Users> getUser() {
		return user;
	}





	public void setUser(List<Users> user) {
		this.user = user;
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
