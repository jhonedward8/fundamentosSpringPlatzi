package com.fundamentos.springboot.fundamentos.dto;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDate;

@AllArgsConstructor
@NoArgsConstructor
@Data
@Builder(setterPrefix = "with")
public class UserDto {

    private Long id;
    private String name;
    private LocalDate fecha;
}
