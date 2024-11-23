package co.istad.mbanking.domain;

import jakarta.persistence.*;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Positive;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.math.BigDecimal;
import java.util.List;

@Getter
@Setter
@NoArgsConstructor
@Entity
@Table(name = "accounts")
public class Account {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Positive
    private Integer id;

    @Column(length = 100)
    private String alias;

    @Column(length = 100 , nullable = false)
    private String actName;

    @Column(length = 9 , nullable = false, unique = true)
    private String actNo;

    @Column(nullable = false)
    @Positive
    @NotNull
    private BigDecimal balance;

    @Column(nullable = false)
    @Positive
    @NotNull
    private BigDecimal transferLimit;

    private Boolean isHidden;

    // Relationship
    @ManyToOne
    private AccountType accountType;

    @OneToOne
    private Card card;

    @ManyToOne
    @JoinTable(name = "user_accounts",
        joinColumns = @JoinColumn(name = "account_id", referencedColumnName = "id"),
            inverseJoinColumns = @JoinColumn(name = "user_id", referencedColumnName = "id")
    )
    private User user;

    @OneToMany(mappedBy = "owner")
    private List<Transaction> transactions;

}
