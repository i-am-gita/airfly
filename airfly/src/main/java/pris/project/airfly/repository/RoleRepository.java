package pris.project.airfly.repository;
import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;

import pris.project.airfly.entity.ERole;
import pris.project.airfly.entity.Role;

public interface RoleRepository extends JpaRepository<Role, Integer>{
	
	Optional<Role> findByDescription(ERole description);
}
