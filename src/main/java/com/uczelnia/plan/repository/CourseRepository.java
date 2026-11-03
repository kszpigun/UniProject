import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import com.twojprojekt.model.Przydzial;

@Repository
public interface PrzydzialRepository extends JpaRepository<Przydzial, Long> {
}
