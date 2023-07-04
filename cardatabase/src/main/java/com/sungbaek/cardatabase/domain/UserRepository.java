package com.sungbaek.cardatabase.domain;

import java.util.Optional;

import org.springframework.data.repository.CrudRepository;
import org.springframework.data.rest.core.annotation.RepositoryRestResource;

// 스프링 데이터 REST는 기본적으로 모든 공용 repository에서 RESTful 웹 서비스를 생성한다.
// 유저 정보는 민감하기 때문에 @RepositoryRestResource 어노테이션의 exported 플래그를 false로 설정하여 리소스 노출이 되지 않도록 한다.
@RepositoryRestResource(exported=false)
public interface UserRepository extends CrudRepository<User, Long> {
	Optional<User> findByUsername(String username);
}
