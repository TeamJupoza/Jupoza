package gachon.jupoza.repository;

import gachon.jupoza.domain.UserAccount;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

public interface UserAccountRepository extends JpaRepository<UserAccount, String> {
   Optional<UserAccount> findByUserId(String UserId);
}
