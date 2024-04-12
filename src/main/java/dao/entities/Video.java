package dao.entities;
import jakarta.persistence.*;
import lombok.*;

@Entity
//@Table(name = "videos")
@Getter
@Setter
@ToString
@NoArgsConstructor
@AllArgsConstructor
public class Video {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;
    private String name;
    private String url;
    private String description;
    private String datePublication;

    @ManyToOne
    @JoinColumn(name = "creator_id")
    private Creator creator;
}
