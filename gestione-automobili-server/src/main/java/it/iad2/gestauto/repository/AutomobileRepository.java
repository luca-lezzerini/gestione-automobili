package it.iad2.gestauto.repository;

import it.iad2.gestauto.model.Automobile;
import java.util.List;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface AutomobileRepository extends JpaRepository<Automobile, Long> {

    List<Automobile> findByTargaContainsOrModelloContains(String t, String m);
}
