import java.io.*;

public class Scanner{
    ArrayList<Token> process (String input) {
        String[] words = input.split(" ");
        ArrayList<Token> tokenList = new ArrayList<TokenList>();
        for (String w : words) {
            Token t = new Token(w);
            tokenList.add(t);
        }

        return tokenList;
    }
}