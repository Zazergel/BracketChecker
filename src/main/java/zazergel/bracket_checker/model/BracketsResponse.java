package zazergel.bracket_checker.model;

public class BracketsResponse {

    private boolean isCorrect;

    public BracketsResponse(boolean isCorrect) {
        this.isCorrect = isCorrect;
    }

    public boolean getIsCorrect() {
        return isCorrect;
    }

    public void setIsCorrect(boolean isCorrect) {
        this.isCorrect = isCorrect;
    }

}
