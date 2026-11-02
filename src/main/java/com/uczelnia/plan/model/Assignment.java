import jakarta.persistence.*;

@Entity
@Table(name = "Przydzial")
public class Przydzial {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @ManyToOne
    @JoinColumn(name = "pracownik_id")
    private Pracownik pracownik;

    @ManyToOne
    @JoinColumn(name = "grupa_studencka_id")
    private GrupaStudencka grupaStudencka;

    @ManyToOne
    @JoinColumn(name = "przedmiot_id")
    private Przedmiot przedmiot;

    // Wygeneruj Gettery i Settery
}
