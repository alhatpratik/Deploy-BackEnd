package project.EntityDAO;

import java.io.IOException;
import java.util.List;
import java.util.Optional;
import java.util.UUID;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

import project.Entity.UploadFile;
import project.repositories.IUploadFileDAO;



@Service
public class UploadFileImpl implements IUploadFileService{

	@Autowired
	IUploadFileDAO upload;
	
	
	@Override
	public UploadFile uploadImage(MultipartFile file,long id) {
		
		String filename = file.getOriginalFilename();
		UploadFile filedb = null ;
		try {
			
			filedb = new UploadFile(filename,file.getContentType(),file.getBytes(),id);
		
		
		} catch (IOException e) {
			e.printStackTrace();
		}
		
		return upload.save(filedb);
		
	}

	@Override
	public UploadFile getImage(long id) {
		Optional<UploadFile> fileOptional = upload.findByDoctorID(id);
		if(fileOptional.isPresent())
		{
			return fileOptional.get();
		}
		
		return null;
	}

	@Override
	public List<UploadFile> getAllImages() {
		return upload.findAll();
	}

	@Override
	public String deleteImage(long id) {
		
		upload.deleteById(id);;
		return "image deleted";
	}

	@Override
	public UploadFile updateImage(MultipartFile file, long id) {

		String filename = file.getOriginalFilename();
		UploadFile filedb = null ;
		try {
			
			filedb = new UploadFile(filename,file.getContentType(),file.getBytes(),id);
		
		
		} catch (IOException e) {
			e.printStackTrace();
		}
		
		return upload.save(filedb);
	}

	
}
