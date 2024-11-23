package co.istad.mbanking.domain;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.math.BigDecimal;
import java.util.List;

@Getter
@Setter
@NoArgsConstructor
@Entity
@Table(name = "users")
public class User {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;

    @Column(unique = true, nullable = false)
    private String uuid;

    @Column(length = 50, nullable = false)
    private String name;

    @Column(length = 50, nullable = false)
    private String password;

    @Column(length = 10, nullable = false, unique = true)
    private String phoneNumber;

    @Column(length = 4, nullable = false)
    private String pin;

    @Column(length = 7, nullable = false)
    private String gender;


    @Column(name = "monthly_income_range", precision = 38, scale = 2)
    private BigDecimal monthlyIncomeRange;

    @Column(name = "student_card_id",length = 20, nullable = false, unique = true)
    private String studentCardId;

    @Column(name = "national_card_id",length = 20, nullable = false, unique = true)
    private String nationalCardId;

    @Column()
    private String village;
    @Column()
    private String street;
    @Column(name = "sangkat_or_commune")
    private String sangkatOrCommune;
    @Column(name = "profile_image")
    private String profileImage;
    @Column()
    private String position;
    @Column(name = "main_source_of_income")
    private String mainSourceOfIncome;
    @Column(name = "khan_or_district")
    private String khanOrDistrict;
    @Column(name = "employee_type")
    private String employeeType;
    @Column(name = "company_name")
    private String companyName;
    @Column(name = "city_or_province")
    private String cityOrProvince;



    @Column(nullable = false)
    private Boolean isDeleted;
    @Column(nullable = false)
    private Boolean isBlocked;

    // Relationship
    @OneToMany(mappedBy = "user")
    private List<Account> accounts;
}
