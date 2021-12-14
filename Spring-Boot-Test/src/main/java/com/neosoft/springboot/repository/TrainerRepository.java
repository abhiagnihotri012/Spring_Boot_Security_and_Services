package com.neosoft.springboot.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import com.neosoft.springboot.model.Trainer;

@Repository
public interface TrainerRepository extends JpaRepository<Trainer, Long> {

	Trainer findByFirstnameAndLastname(String firstname, String lastname);
	List<Trainer> findByFirstnameOrLastname(String firstname, String lastname);
	List<Trainer> findByAgeLessThan(int age);
	List<Trainer> findByAgeLessThanEqual(int age);
	List<Trainer> findByAgeGreaterThanEqual(int age);
	List<Trainer> findByAgeBetween(int age1, int age2);
	List<Trainer> findByAgeOrderByLastnameDesc(int age);
	List<Trainer> findByFirstnameLike(String firstname);
	
	// @Query("SELECT t FROM Trainer t WHERE t.active = ?1")
	@Query("SELECT t FROM Trainer t WHERE t.active = :active_status")
	List<Trainer> findAllActiveTrainers(int active_status);
	
	//@Query("SELECT t FROM Trainer t WHERE t.active = ?1 AND t.age<= ?2")
	@Query("SELECT t FROM Trainer t WHERE t.active = :active_status AND t.age<= :age")
	List<Trainer> findAllActiveTrainersWithAge(int active_status, int age);
	
	@Transactional
	@Modifying
	@Query("UPDATE Trainer t SET t.active = :active_status WHERE t.firstname= :name ")
	int updateTrainerSetStatusForName(@Param("active_status") int active, 
			@Param("name") String firstname);	
}
