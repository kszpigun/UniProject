import jakarta.persistence.*;

@Entity
@Table(name = "Przedmiot")
public class Przedmiot {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    
    private String nazwa;

    @Version
    private Long wersja;

    // Wygeneruj Gettery i Settery
}// Model encji Przedmiot
