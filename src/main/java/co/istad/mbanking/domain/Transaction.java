package co.istad.mbanking.domain;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.math.BigDecimal;
import java.time.LocalDateTime;

@Getter
@Setter
@NoArgsConstructor
@Entity
@Table(name = "transactions")
public class Transaction {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;

    @Column(nullable = false, precision = 10, scale = 2)
    private BigDecimal amount;

    @Column(nullable = false)
    private LocalDateTime transactionAt;

    @Column(length = 30, nullable = false)
    private String transactionType;

    @Column(length = 200)
    private String paymentReceiver;

    @Column(columnDefinition = "TEXT")
    private String remark;


    @Column(nullable = false)
    private Boolean status;

    @Column(nullable = false)
    private Boolean isDeleted;

    // Relationship
    @ManyToOne
    private Account owner;

    @ManyToOne
    private Account receiver;
}
