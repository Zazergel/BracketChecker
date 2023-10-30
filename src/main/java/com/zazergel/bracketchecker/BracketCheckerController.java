package com.zazergel.bracketchecker;

import com.zazergel.bracketchecker.model.BracketsRequest;
import com.zazergel.bracketchecker.model.BracketsResponse;
import com.zazergel.bracketchecker.service.BracketCheckerService;
import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api")
@Slf4j
@RequiredArgsConstructor
public class BracketCheckerController {
    @Autowired
    BracketCheckerService bracketCheckerService;

    @PostMapping("/checkBrackets")
    public ResponseEntity<BracketsResponse> checkBrackets(@Valid @RequestBody BracketsRequest request) {
        log.info("Получен запрос на проверку текста длиной в  " + request.getText().length() + " символов.");
        return bracketCheckerService.checkBrackets(request.getText());
    }

}

