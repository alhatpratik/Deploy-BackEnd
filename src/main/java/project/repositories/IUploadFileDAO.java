package project.repositories;

import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import project.Entity.UploadFile;



@Repository
public interface IUploadFileDAO extends JpaRepository<UploadFile, Long> {
	
	public Optional<UploadFile> findByDoctorID(long id);

}
