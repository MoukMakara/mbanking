package co.istad.mbanking.domain;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.time.LocalDate;

@Getter
@Setter
@NoArgsConstructor
@Entity
@Table(name = "cards")
public class Card {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;

    @Column(length = 255, nullable = false, unique = true)
    private String number;

    @Column(length = 255)
    private String holder;

    @Column(nullable = false)
    private Integer cvv;

    @Column(nullable = false)
    private LocalDate issuedAt;

    @Column(nullable = false)
    private LocalDate expiresAt;

    @Column(nullable = false)
    private Boolean isDeleted;

    @OneToOne(mappedBy = "card")
    private Account account;

    @ManyToOne
    private CardType cardType;
}
