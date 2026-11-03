import org.springframework.stereotype.Service;
import java.util.ArrayList;
import java.util.List;

@Service
public class PrzydzialService {

    private final PrzydzialRepository przydzialRepository;

    public PrzydzialService(PrzydzialRepository przydzialRepository) {
        this.przydzialRepository = przydzialRepository;
    }

    public Przydzial zapiszPrzydzial(Przydzial przydzial) {
        List<String> bledy = walidujPrzydzial(przydzial);

        if (!bledy.isEmpty()) {
            przydzial.setZBledami(true);
            przydzial.setKomunikatyBledow(String.join("; ", bledy));
        } else {
            przydzial.setZBledami(false);
            przydzial.setKomunikatyBledow(null);
        }

        // Zapis odbywa się zawsze, niezależnie od wyniku walidacji
        return przydzialRepository.save(przydzial);
    }

    private List<String> walidujPrzydzial(Przydzial przydzial) {
        List<String> b = new ArrayList<>();
        
        // Przykładowa reguła biznesowa (do rozbudowy)
        if (przydzial.getPracownik() == null) {
            b.add("Brak przypisanego pracownika");
        }
        
        return b;
    }
}
