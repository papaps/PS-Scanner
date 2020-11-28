public class Token{
    public enum TokenType{
        KEYWORD,
        GPR,
        FPR,
        ERROR
    }

    public TokenType tokenType;
    public String lexeme;

    private static final int q0 = 0;
    private static final int q1 = 1;
    private static final int q2 = 2;
    private static final int q3 = 3;
    private static final int q4 = 4;
    private static final int q5 = 5;
    private static final int q6 = 6;
    private static final int q7 = 7;
    private static final int q8 = 8;
    private static final int q9 = 9;
    private static final int q10 = 10;
    private static final int q11 = 11;
    private static final int q12 = 12;
    private static final int q13 = 13;
    private static final int q14 = 14;
    private static final int q15 = 15;
    private static final int q16 = 16;
    private static final int q17 = 17;
    private static final int q18 = 18;
    private static final int q19 = 19;
    private static final int qdead = -1;

    private int state;

    public Token (String word) {
        this.lexeme = word;
        this.tokenType = identifyToken(word);
    }

    static private int transitions (int s, char c) {
        switch (s) {
            case q0: switch (c) {
                case 'F': return q1;
                case '$': return q5;
                case 'R': return q6;
                case 'D': return q10;
                default: return qdead;
            }
            case q1: switch (c) {
                case '1': case '2': return q3;
                case '3': return q2;
                case '0': case '4': case '5': case '6': case '7': case '8': case '9': return q4;
                default: return qdead;
            }
            case q2: switch (c) {
                case '0': case '1': return q4;
                default: return qdead;
            }
            case q3: switch (c) {
                case '0': case '1': case '2': case '3': case '4': case '5': case '6': case '7': case '8': case '9': return q4;
                default: return qdead;
            }
            case q4: switch (c) {
                default: return qdead;
            }
            case q5: switch (c) {
                case 'F': return q1;
                case '0': case '4': case '5': case '6': case '7': case '8': case '9': return q9;
                case '1': case '2': return q7;
                case '3': return q8;
                default: return qdead;
            }
            case q6: switch (c) {
                case '0': case '4': case '5': case '6': case '7': case '8': case '9': return q9;
                case '1': case '2': return q7;
                case '3': return q8;
                default: return qdead;
            }
            case q7: switch (c) {
                case '0': case '1': case '2': case '3': case '4': case '5': case '6': case '7': case '8': case '9': return q9;
                default: return qdead;
            }
            case q8: switch (c) {
                case '0': case '1': return q9;
                default: return qdead;
            }
            case q9: switch (c) {
                default: return qdead;
            }
            case q10: switch (c) {
                case 'A': return q11;
                case 'M': return q15;
                default: return qdead;
            }
            case q11: switch (c) {
                case 'D': return q12;
                default: return qdead;
            }
            case q12: switch (c) {
                case 'D': return q13;
                default: return qdead;
            }
            case q13: switch (c) {
                case 'I': return q14;
                case 'U': return q19;
                default: return qdead;
            }
            case q14: switch (c) {
                case 'U': return q19;
                default: return qdead;
            }
            case q15: switch (c) {
                case 'U': return q16;
                default: return qdead;
            }
            case q16: switch (c) {
                case 'L': return q17;
                default: return qdead;
            }
            case q17: switch (c) {
                case 'T': return q18;
                default: return qdead;
            }
            case q18: switch (c) {
                case 'U': return q19;
                default: return qdead;
            }
            case q19: switch (c) {
                default: return qdead;
            }
            default: return qdead;
        }
    }

    public TokenType identifyToken(String word){
        for (int i = 0; i < word.length(); i++) {
            char c = word.charAt(i);
            state = transitions(state, c);
        }
        if (state == 2 || state == 3 || state == 4)
            return Token.TokenType.FPR;
        else if (state == 7 || state == 8 || state == 9)
            return Token.TokenType.GPR;
        else if (state == 18 || state == 19)
            return Token.TokenType.KEYWORD;
        else
            return Token.TokenType.ERROR;
    }

    @Override
    public String toString(){
        return this.tokenType.toString();
    }
}