import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import com.twojprojekt.model.Pracownik;

@Repository
public interface PracownikRepository extends JpaRepository<Pracownik, Long> {
}// Repozytorium pracownika
