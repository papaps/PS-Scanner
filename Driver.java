import java.io.*;
import java.util.ArrayList;

public class Driver{

    public static void main(String[] args) throws IOException{
        Scanner scanner = new Scanner();

        InputStream is = new FileInputStream("Input.txt");
        BufferedReader br = new BufferedReader(new InputStreamReader(is));

        FileWriter fw = new FileWriter("Output.txt");
        BufferedWriter bw = new BufferedWriter(fw);

        String input;
        String text = "";
        while((input = br.readLine()) != null){
            ArrayList<Token> tokenList = scanner.process(input);
            for (Token token: tokenList) {
                text += token + " ";
            }
            text += "\n";
        }
        text = text.trim();
        bw.write(text);

        is.close();
        br.close();
        bw.close();
    }
}