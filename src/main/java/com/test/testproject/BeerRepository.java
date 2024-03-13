package com.test.testproject;

import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;
import java.util.Optional;

public interface BeerRepository extends JpaRepository<Beer,Long> {

    List<Beer> findByProposedBy(String nickName);
}
