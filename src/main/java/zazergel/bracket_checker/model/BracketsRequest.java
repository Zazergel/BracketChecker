package zazergel.bracket_checker.model;

import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.Size;
import lombok.Getter;
import lombok.RequiredArgsConstructor;


@Getter
@RequiredArgsConstructor
public class BracketsRequest {
    @NotBlank(message = "Текст не должен быть пустым!")
    @Size(max = 2000, message = "Размер проверяемого текста не должен превышать 2000 символов!")
    private String text;
}
