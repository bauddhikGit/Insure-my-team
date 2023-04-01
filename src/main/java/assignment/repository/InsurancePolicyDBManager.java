package assignment.repository;

import assignment.model.InsurancePolicy;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Component;

import java.util.List;

@Component
public interface InsurancePolicyDBManager extends JpaRepository<InsurancePolicy, Integer> {

    List<InsurancePolicy> findByTech(String tech);

    @Query("FROM InsurancePolicy WHERE tech = ?1 ORDER BY name DESC")
    List<InsurancePolicy> findByTechSorted(String tech);

    @Modifying
    @Query("DELETE FROM InsurancePolicy WHERE id = ?1")
    void deleteUserById(int id);
}
