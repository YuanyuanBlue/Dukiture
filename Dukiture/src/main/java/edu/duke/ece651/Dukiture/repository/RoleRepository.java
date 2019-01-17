package edu.duke.ece651.Dukiture.repository;
import edu.duke.ece651.Dukiture.model.Role;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface RoleRepository extends JpaRepository<Role, Long>{
}
