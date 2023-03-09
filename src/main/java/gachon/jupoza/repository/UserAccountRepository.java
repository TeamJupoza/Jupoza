package gachon.jupoza.repository;

import gachon.jupoza.domain.UserAccount;
import org.springframework.data.jpa.repository.JpaRepository;

public interface UserAccountRepository extends JpaRepository<UserAccount, String> {
//    UserAccount findByUserId(String UserId);
}
