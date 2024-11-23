package co.istad.mbanking.init;

import co.istad.mbanking.domain.User;
import co.istad.mbanking.feature.user.UserRepository;
import jakarta.annotation.PostConstruct;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Component;

import java.math.BigDecimal;
import java.util.List;
import java.util.UUID;

@Component
@RequiredArgsConstructor
public class DataInit {

    private final UserRepository userRepository;

    @PostConstruct
    public void init() {
        User user1 = new User();
        user1.setId(1);
        user1.setUuid(UUID.randomUUID().toString());
        user1.setName("Mouk Makara");
        user1.setPhoneNumber("0975494981");
        user1.setPassword("qwer");
        user1.setPin("1234");
        user1.setGender("Male");
        user1.setStudentCardId("ISTAD-001");
        user1.setNationalCardId("CARD-001");
        user1.setMonthlyIncomeRange(BigDecimal.valueOf(1200.00));

        user1.setIsDeleted(false);
        user1.setIsBlocked(false);

        User user2 = new User();
        user2.setId(2);
        user2.setUuid(UUID.randomUUID().toString());
        user2.setName("Pon Channarith");
        user2.setPhoneNumber("0975494982");
        user2.setPassword("qwer");
        user2.setPin("1234");
        user2.setGender("Male");
        user2.setStudentCardId("ISTAD-002");
        user2.setNationalCardId("CARD-002");
        user2.setMonthlyIncomeRange(BigDecimal.valueOf(1500.00));

        user2.setIsDeleted(false);
        user2.setIsBlocked(false);

//        userRepository.save(user1);
//        userRepository.save(user2);
        userRepository.saveAll(List.of(user1, user2));
    }
}
