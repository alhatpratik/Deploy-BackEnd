package project.EntityDAO;

import java.util.List;

import org.springframework.web.multipart.MultipartFile;

import project.Entity.UploadFile;



public interface IUploadFileService {
	
	
	public UploadFile uploadImage(MultipartFile file,long id);
	public UploadFile getImage(long id); 
	public List<UploadFile> getAllImages();
	public String deleteImage(long id);
	public UploadFile updateImage(MultipartFile file,long id );

	
	
	
}
