import com.twojprojekt.model.Przedmiot;
import com.twojprojekt.repository.PrzedmiotRepository;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.orm.ObjectOptimisticLockingFailureException;

import static org.junit.jupiter.api.Assertions.assertThrows;

@SpringBootTest
public class PrzedmiotWspolbieznoscTest {

    @Autowired
    private PrzedmiotRepository przedmiotRepository;

    @Test
    public void testBlokowaniaOptymistycznego() {
        // 1. Przygotowanie przedmiotu w bazie
        Przedmiot p = new Przedmiot();
        p.setNazwa("Bazy Danych");
        Przedmiot zapisany = przedmiotRepository.save(p);

        // 2. Symulacja: dwóch użytkowników pobiera ten sam rekord
        Przedmiot uzytkownik1 = przedmiotRepository.findById(zapisany.getId()).get();
        Przedmiot uzytkownik2 = przedmiotRepository.findById(zapisany.getId()).get();

        // 3. Użytkownik 1 modyfikuje i zapisuje (sukces, wersja w bazie = 1)
        uzytkownik1.setNazwa("Bazy Danych - Zaawansowane");
        przedmiotRepository.save(uzytkownik1);

        // 4. Użytkownik 2 próbuje zapisać swoją zmianę na nieaktualnych danych (wersja 0)
        uzytkownik2.setNazwa("Bazy Danych - Podstawy");
        
        // Spodziewamy się wyjątku blokowania optymistycznego
        assertThrows(ObjectOptimisticLockingFailureException.class, () -> {
            przedmiotRepository.save(uzytkownik2);
        });
    }
}
