package com.zazergel.bracketchecker.service;

import com.zazergel.bracketchecker.model.BracketsResponse;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

@Slf4j
@Service
public class BracketCheckerServiceImpl implements BracketCheckerService {

    public ResponseEntity<BracketsResponse> checkBrackets(String text) {
        if (!isValidBracketPlacement(text)) {
            log.info("Скобки в тексте расставлены НЕ корректно!");
            return ResponseEntity.ok(new BracketsResponse(false));
        }
        log.info("Текст корректный!");
        return ResponseEntity.ok(new BracketsResponse(true));
    }

    /*Данный метод удаляет все содержимое скобок и проверяет наличие пустых.
    Затем проверяет сбалансированность открывающих и закрывающих скобок.
    Возвращает true, если все в порядке и false, если во время проверки будет найдено несоответствие условию задачи */
    public boolean isValidBracketPlacement(String text) {
        Pattern emptyPatterns = Pattern.compile("\\(\\s*\\)");
        Matcher emptyMatcher = emptyPatterns.matcher(text);
        if (emptyMatcher.find()) {
            return false;
        }
        int balance = 0;
        for (int i = 0; i < text.length(); i++) {
            char ch = text.charAt(i);
            if (ch == '(') {
                balance++;
            } else if (ch == ')') {
                balance--;
                if (balance < 0) {
                    return false;
                }
            }
        }
        return balance == 0;
    }
}

