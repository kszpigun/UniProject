import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import com.twojprojekt.model.Przedmiot;

@Repository
public interface PrzedmiotRepository extends JpaRepository<Przedmiot, Long> {
}
