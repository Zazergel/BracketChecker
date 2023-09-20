package com.zazergel.bracketchecker.service;

import org.springframework.http.ResponseEntity;
import com.zazergel.bracketchecker.model.BracketsResponse;

public interface BracketCheckerService {
    ResponseEntity<BracketsResponse> checkBrackets(String text);

    boolean isValidBracketPlacement(String text);
}
