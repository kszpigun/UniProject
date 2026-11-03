import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import com.twojprojekt.model.Przedmiot;
import com.twojprojekt.repository.PrzedmiotRepository;

@Service
public class PrzedmiotService {

    private final PrzedmiotRepository przedmiotRepository;

    public PrzedmiotService(PrzedmiotRepository przedmiotRepository) {
        this.przedmiotRepository = przedmiotRepository;
    }

    @Transactional
    public Przedmiot aktualizujPrzedmiot(Long id, String nowaNazwa) {
        Przedmiot przedmiot = przedmiotRepository.findById(id)
            .orElseThrow(() -> new RuntimeException("Nie znaleziono przedmiotu"));
        
        przedmiot.setNazwa(nowaNazwa);
        return przedmiotRepository.save(przedmiot);
    }
}
