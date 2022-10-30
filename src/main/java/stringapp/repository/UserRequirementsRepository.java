package stringapp.repository;


import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import stringapp.domain.UserRequirements;

@Repository
public interface UserRequirementsRepository extends JpaRepository<UserRequirements, Long> {
}
