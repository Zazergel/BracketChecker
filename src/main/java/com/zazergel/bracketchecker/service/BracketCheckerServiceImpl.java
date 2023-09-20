package com.zazergel.bracketchecker.service;

import lombok.extern.slf4j.Slf4j;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import com.zazergel.bracketchecker.model.BracketsResponse;

import java.util.ArrayDeque;
import java.util.Deque;

@Slf4j
@Service
public class BracketCheckerServiceImpl implements BracketCheckerService {

    public ResponseEntity<BracketsResponse> checkBrackets(String text) {
        if (!isValidBracketPlacement(text)) {
            log.info("Скобки расставлены НЕ корректно!");
            return ResponseEntity.ok(new BracketsResponse(false));
        }
        log.info("Скобки расставлены корректно!");
        return ResponseEntity.ok(new BracketsResponse(true));
    }

    /*Данный метод удаляет все пробелы из текста, затем производит перебор по символам.
    Возвращает true, если все в порядке и false, если во время проверки будет найдено несоответствие условию задачи */
    public boolean isValidBracketPlacement(String text) {
        String textWithoutSpaces = removeSpaceFromString(text);
        Deque<Character> stack = new ArrayDeque<>();
        for (int i = 0; i < textWithoutSpaces.length(); i++) {
            char c = textWithoutSpaces.charAt(i);
            if (c == '(') {
                if (textWithoutSpaces.charAt(i + 1) == ')') {
                    log.info("Обнаружены пустые скобки в тексте!");
                    return false;
                }
                stack.push(c);
            } else if (c == ')' && (stack.isEmpty() || stack.pop() != '(')) {
                log.info("Обнаружены не закрытые скобки в тексте!");
                return false;
            }
        }
        return stack.isEmpty();
    }

    public String removeSpaceFromString(String text) {
        log.info("Удаление пробелов из текста.");
        return text.replaceAll("\\s+", "");
    }
}

