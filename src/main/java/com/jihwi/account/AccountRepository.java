package com.jihwi.account;

import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

/**
 * jpaRepository 를 상속받으면 기본적인 save / findById등 구현
 * @Repository 불필요
 */
public interface AccountRepository extends JpaRepository<Account, Long> {
    //쿼리도 따로 적어줄 필요 없이 메소드만 등록해줘도 메소드명을 보고 만들어준다.
    //쿼리 필요시 @Query(jpql) 혹은 @Query(nativeQuery=true, value="select * from account where username = '{0}'")
    Optional<Account> findByUsername(String username);
}
