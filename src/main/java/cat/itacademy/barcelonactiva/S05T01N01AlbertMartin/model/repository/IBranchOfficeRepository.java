package cat.itacademy.barcelonactiva.S05T01N01AlbertMartin.model.repository;

import cat.itacademy.barcelonactiva.S05T01N01AlbertMartin.model.domain.BranchOffice;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface IBranchOfficeRepository extends JpaRepository <BranchOffice, Long> {
}
