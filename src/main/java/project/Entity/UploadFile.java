package project.Entity;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Lob;

import org.springframework.stereotype.Component;

@Entity
@Component
public class UploadFile {
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private long id;
	private String fileName;
	
	private String type;
	private long doctorID;
	
	@Lob
	private byte[] data;

	public UploadFile() {
		super();
		// TODO Auto-generated constructor stub
	}

	public UploadFile(String fileName, String type, byte[] data,long id) {
		super();
		this.fileName = fileName;
		this.type = type;
		this.data = data;
		this.doctorID = id;
	}

	public long getId() {
		return id;
	}

	public void setId(long id) {
		this.id = id;
	}

	public String getFileName() {
		return fileName;
	}

	public void setFileName(String fileName) {
		this.fileName = fileName;
	}

	public String getType() {
		return type;
	}

	public void setType(String type) {
		this.type = type;
	}

	public byte[] getData() {
		return data;
	}

	public void setData(byte[] data) {
		this.data = data;
	}

	public long getDoctorID() {
		return doctorID;
	}

	public void setDoctorID(long doctorID) {
		this.doctorID = doctorID;
	}
	
}
