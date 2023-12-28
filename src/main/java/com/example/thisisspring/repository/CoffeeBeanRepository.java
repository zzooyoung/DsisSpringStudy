package com.example.thisisspring.repository;

import com.example.thisisspring.domain.CoffeeBean;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

public interface CoffeeBeanRepository extends JpaRepository<CoffeeBean, Long> {
    Optional<CoffeeBean> findByName(String name);
}
