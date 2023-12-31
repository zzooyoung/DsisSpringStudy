package com.example.thisisspring.dto;

import io.swagger.v3.oas.annotations.media.Schema;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Schema(description = "커피 원두 업데이트 DTO")
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class UpdateCoffeeBeanDto {
    @Schema(description = "커피 이름", example = "산토스")
    private String name;
    @Schema(description = "추가 수량", example = "100")
    private int quantity;
}
