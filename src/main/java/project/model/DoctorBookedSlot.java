package project.model;

import java.sql.Date;
import java.time.LocalTime;

public class DoctorBookedSlot {
	
	private int count;
	private String patientname;
	private Date bookeddate;
	private LocalTime time;
	private long mob;
	
	public long getMob() {
		return mob;
	}
	public void setMob(long mob) {
		this.mob = mob;
	}
	public int getCount() {
		return count;
	}
	public void setCount(int count) {
		this.count = count;
	}
	public String getPatientname() {
		return patientname;
	}
	public void setPatientname(String patientname) {
		this.patientname = patientname;
	}
	public Date getBookeddate() {
		return bookeddate;
	}
	public void setBookeddate(Date bookeddate) {
		this.bookeddate = bookeddate;
	}
	public LocalTime getTime() {
		return time;
	}
	public void setTime(LocalTime time) {
		this.time = time;
	}
	
	
	

}
