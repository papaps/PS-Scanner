public class Token{
    public enum TokenType{
        KEYWORD,
        GPR,
        FPR,
        ERROR
    }

    public TokenType tokenType;
    public String lexeme;

    public Token (String word) {
        this.lexeme = word;
        this.tokenType = identifyToken(word);
    }

    public static TokenType identifyToken(String word){
        return Token.TokenType.ERROR;
    }
}