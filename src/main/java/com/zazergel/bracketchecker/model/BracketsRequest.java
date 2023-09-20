package com.zazergel.bracketchecker.model;

import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.Size;
import lombok.Getter;
import lombok.RequiredArgsConstructor;
import lombok.Setter;


@Getter
@Setter
@RequiredArgsConstructor
public class BracketsRequest {
    @NotBlank(message = "Текст не должен быть пустым!")
    @Size(max = 500, message = "Размер проверяемого текста не должен превышать 500 символов!")
    private String text;
}
