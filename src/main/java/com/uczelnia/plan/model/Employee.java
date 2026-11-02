import jakarta.persistence.*;

@Entity
@Table(name = "Pracownik")
public class Pracownik {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    
    private String imie;
    private String nazwisko;

    // Wygeneruj Gettery i Settery w swoim IDE
}// Model encji Pracownik
