package co.istad.mbanking.domain;

import jakarta.persistence.*;
import jakarta.validation.constraints.Positive;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.util.List;

@Getter
@Setter
@NoArgsConstructor
@Entity
@Table(name = "card_types")
public class CardType {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Positive
    private Integer id;

    @Column(length = 100, nullable = false, unique = true)
    private String name;

    @Column(nullable = false)
    private Boolean isDelete;

    // Relationship
    @OneToMany(mappedBy = "cardType")
    private List<Card> cards;
}
