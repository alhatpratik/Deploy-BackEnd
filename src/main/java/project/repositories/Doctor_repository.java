package project.repositories;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import project.Entity.CreatedSubSlotSaver;
import project.Entity.Doctor_info;

public interface Doctor_repository extends JpaRepository<Doctor_info,Long>{
	
	@Query(value = "from project.Entity.Doctor_info p where p.mob_number= :mob")
	public abstract Doctor_info finddoctor(@Param("mob") long mob);

}
