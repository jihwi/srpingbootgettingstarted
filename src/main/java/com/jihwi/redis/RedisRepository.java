package com.jihwi.redis;

import org.springframework.data.repository.CrudRepository;

public interface RedisRepository extends CrudRepository<Redis, String> {
}
