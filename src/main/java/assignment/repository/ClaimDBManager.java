package assignment.repository;

import assignment.model.Claim;
import assignment.model.Client;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Component;

import java.util.List;

@Component
public interface ClaimDBManager extends JpaRepository<Claim, Integer> {

    List<Client> findByTech(String tech);

    @Query("FROM Claim WHERE tech = ?1 ORDER BY name DESC")
    List<Claim> findByTechSorted(String tech);

    @Modifying
    @Query("DELETE FROM Claim WHERE id = ?1")
    void deleteUserById(int id);
}
