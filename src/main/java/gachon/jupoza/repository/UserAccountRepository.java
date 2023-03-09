package gachon.jupoza.repository;

import gachon.jupoza.domain.UserAccount;
import org.springframework.data.jpa.repository.JpaRepository;

public interface UserAccountRepository extends JpaRepository<UserAccount, Long> {
    UserAccount findByUserId(String UserId);
}
