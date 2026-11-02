import jakarta.persistence.*;

@Entity
@Table(name = "GrupaStudencka")
public class GrupaStudencka {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    
    private String nazwa;

    // Wygeneruj Gettery i Settery
}
