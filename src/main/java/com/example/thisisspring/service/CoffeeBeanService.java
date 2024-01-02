package com.example.thisisspring.service;

import com.example.thisisspring.domain.CoffeeBean;
import com.example.thisisspring.dto.CoffeeBeanDto;
import com.example.thisisspring.exception.CustomException;
import com.example.thisisspring.exception.ErrorCode;
import com.example.thisisspring.repository.CoffeeBeanRepository;
import jakarta.annotation.PostConstruct;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class CoffeeBeanService {
    private final CoffeeBeanRepository coffeeBeanRepository;

    // 스프링 프레임워크 4.3 이후에 단일 생성자 클래스에 @Autowired 생략 가능함
    public CoffeeBeanService(CoffeeBeanRepository coffeeBeanRepository) {
        this.coffeeBeanRepository = coffeeBeanRepository;
    }

    @PostConstruct
    public void saveTenCoffeeBeansEfficient() {
        List<CoffeeBean> coffeeBeans = new ArrayList<>();

        for (int i = 1; i <= 10; i++) {
            String coffeeName = "커피 이름" + 1;
            int quantity = 100;
            CoffeeBean coffeeBean = new CoffeeBean(coffeeName, quantity);
            coffeeBeans.add(coffeeBean);
        }

        coffeeBeanRepository.saveAll(coffeeBeans);
    }

    public List<CoffeeBeanDto> getAllCoffeeBeansDto() {
        List<CoffeeBean> coffeeBeans = coffeeBeanRepository.findAll();

        if (coffeeBeans.isEmpty()) {
            throw new CustomException(ErrorCode.COFFEE_BEAN_DATA_NOT_FOUND);
        }
        // CoffeeBean을 CoffeeBeanDto로 변환하여 리스트로 반환
        return coffeeBeans.stream()
                .map(coffeeBean -> new CoffeeBeanDto(coffeeBean.getId(), coffeeBean.getName(), coffeeBean.getQuantity()))
                .toList();
    }

    public void deleteByCoffeeBeanId(Long id) {
        coffeeBeanRepository.deleteById(id);
    }
}
