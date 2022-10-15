package project.RestController;

import java.io.File;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.Base64;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.autoconfigure.kafka.KafkaProperties.Producer;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.multipart.MultipartFile;

import antlr.StringUtils;
import project.Entity.Clinic_info;
import project.Entity.Doctor_info;
import project.EntityDAO.Doctor_info_DAO;
import project.model.ImageUpload;

@CrossOrigin
@RestController
@RequestMapping(path = "/wecare")
public class Doctor_Controller {

	@Autowired
	Doctor_info_DAO dao;
	
	@GetMapping("/getalldoctor")
	public List<Doctor_info> getAllDoctors()
	{
		return dao.getAllDoctor();
	}
	
	@DeleteMapping("/delete/{id}")
	public String deleteDoctor(@PathVariable int id)
	{
		
		return dao.DeleteDoctor(id);
	}
	
	@PostMapping("/addNewDoctor")
	public Doctor_info AddNewDoctor(@RequestBody Doctor_info doc)
	{
		Clinic_info clinic=doc.getClinic();
		//String ImagePath=uploadImage(file);
		//doc.setImage(ImagePath);
		return dao.addNewDoctor1(doc, clinic);
	}
	
	@PutMapping("/updateDoctor")
	public String updateDoctor(@RequestBody Doctor_info doc)
	{
		return dao.updateDoctor(doc);
	}
	/*
	public String uploadImage(MultipartFile file)
	{
		String str=System.getProperty("user.dir")+"/image/";
		File directory=new File(str);
		if(!directory.exists())
		{
			directory.mkdir();
		}
		
		String fileName=file.getOriginalFilename();
		Path fileNamePach=Paths.get(str,fileName);
		try {
			Files.write(fileNamePach,file.getBytes());
			str=str+fileName;
		}catch(IOException ex)
		{
			str= "Image Not Uploaded";
		}
		
		return str;
	}
	
	
	@RequestMapping(value = "/addNewDoctor1/{doctor}",method = RequestMethod.POST) 
	public String AddNewDoctor1(@RequestParam("file") MultipartFile file,@PathVariable("doctor") Doctor_info doc)
	{
		Clinic_info clinic=doc.getClinic();
		String fileName=org.springframework.util.StringUtils.cleanPath(file.getOriginalFilename());
		
		try {
			doc.setImage(Base64.getEncoder().encodeToString(file.getBytes()));
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return dao.addNewDoctor1(doc, clinic);
	}
	
	@PostMapping("/upload")
	public String uploadImage1(@RequestParam("file") MultipartFile file,@RequestParam("id") int id)
	{
		Doctor_info doc=dao.getDoctorById(id);
		doc.setImage(uploadImage(file));
		dao.addNewDoctor1(doc, doc.getClinic());
		return "Image Uploaded";
	}
	*/
	
}
