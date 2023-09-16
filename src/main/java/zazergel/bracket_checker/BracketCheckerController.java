package zazergel.bracket_checker;

import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import zazergel.bracket_checker.model.BracketsRequest;
import zazergel.bracket_checker.model.BracketsResponse;
import zazergel.bracket_checker.service.BracketCheckerService;
import zazergel.bracket_checker.service.BracketCheckerServiceImpl;

@RestController
@RequestMapping("/api")
@RequiredArgsConstructor
public class BracketCheckerController {

    BracketCheckerService bracketCheckerService = new BracketCheckerServiceImpl();

    @PostMapping("/checkBrackets")
    public ResponseEntity<BracketsResponse> checkBrackets(@RequestBody @Valid BracketsRequest request) {
        return bracketCheckerService.checkBrackets(request.getText());
    }

}

