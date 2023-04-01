package assignment.repository;

import assignment.model.Client;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Component;

import java.util.List;

@Component
public interface ClientDBManager extends JpaRepository<Client, Integer> {

    List<Client> findByTech(String tech);

    @Query("FROM Client WHERE tech = ?1 ORDER BY name DESC")
    List<Client> findByTechSorted(String tech);

    @Modifying
    @Query("DELETE FROM Client WHERE id = ?1")
    void deleteUserById(int id);
}
