package project.RestController;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.multipart.MultipartFile;

import project.Entity.UploadFile;
import project.EntityDAO.UploadFileImpl;


@CrossOrigin()
@RestController
public class UploadFileController {

	@Autowired
	UploadFileImpl fileImpl;
	
	@PostMapping("/uploadimg/{id}")
	public UploadFile uploadFile(@PathVariable String id,@RequestParam("file") MultipartFile file)
	{
		return fileImpl.uploadImage(file,Long.parseLong(id));
		
	}
	/*
	@GetMapping("/get_img/{id}")
	public UploadFile getFile(@PathVariable String id)
	{
		return fileImpl.getImage(Long.parseLong(id));
	}
	*/
	@GetMapping("/get_all_imgs")
	public List<UploadFile> getAllFiles()
	{
		return fileImpl.getAllImages();
	}
	
	@DeleteMapping("/delete/image/{id}")
	public String deleteImage(@PathVariable String id)
	{
		return fileImpl.deleteImage(Long.parseLong(id));
	}
	
	@PostMapping("/update_img/{id}")
	public UploadFile updateFile(@RequestParam("file") MultipartFile file,@PathVariable String id)
	{
		return fileImpl.updateImage(file,Long.parseLong(id));
		
	}
	
	@GetMapping("/getimg/{id}")
	public UploadFile getDoctorFile(@PathVariable String id)
	{
		return fileImpl.getImage(Long.parseLong(id));
	}
	
}