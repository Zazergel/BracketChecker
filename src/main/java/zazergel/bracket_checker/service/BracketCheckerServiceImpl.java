package zazergel.bracket_checker.service;

import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import zazergel.bracket_checker.model.BracketsResponse;

import java.util.ArrayDeque;
import java.util.Deque;

@Service
@RequiredArgsConstructor
public class BracketCheckerServiceImpl implements BracketCheckerService {

    public ResponseEntity<BracketsResponse> checkBrackets(String text) {
        if (!isValidBracketPlacement(text)) {
            return ResponseEntity.ok(new BracketsResponse(false));
        }
        return ResponseEntity.ok(new BracketsResponse(true));
    }

    /*Данный метод производит перебор текста по символам. Возвращает true, если все в порядке и false,
    если во время проверки будет найдено несоответствие условию задачи */
    public boolean isValidBracketPlacement(String text) {
        Deque<Character> stack = new ArrayDeque<>();
        for (int i = 0; i < text.length(); i++) {
            char c = text.charAt(i);
            if (c == '(') {
                stack.push(c);
                StringBuilder stringInBrackets = new StringBuilder();
                for (int j = i + 1; j < text.length(); j++) {
                    stringInBrackets.append(text.charAt(j));
                    if (text.charAt(j) == ')' && stringInBrackets.toString().length() == 1) {
                        return false;
                    } else if (text.charAt(j) == ')') {
                        break;
                    }
                }
                if (stringInBrackets.toString().trim().length() == 1) {
                    return false;
                }
            } else if (c == ')' && (stack.isEmpty() || stack.pop() != '(')) {
                return false;
            }
        }
        return stack.isEmpty();
    }
}

