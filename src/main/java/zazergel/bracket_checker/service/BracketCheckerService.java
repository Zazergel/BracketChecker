package zazergel.bracket_checker.service;

import org.springframework.http.ResponseEntity;
import zazergel.bracket_checker.model.BracketsResponse;

public interface BracketCheckerService {
    ResponseEntity<BracketsResponse> checkBrackets(String text);

    boolean isValidBracketPlacement(String text);
}
