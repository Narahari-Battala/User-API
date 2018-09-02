package com.Amad.group4.InClass1;

//import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface UserRepository extends JpaRepository<ApplicationUser, String> {

	ApplicationUser findByuserId(String userId);
	

}
