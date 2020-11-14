import java.io.*;
public class Driver{

    public static void main(String[] args) throws IOException{
        InputStream is = new FileInputStream("Input.txt");
        BufferedReader br = new BufferedReader(new InputStreamReader(is));

        String input;
        while((input = br.readLine()) != null){
            System.out.println(input);
        }

        // Scanner scanner = new Scanner();
    }
}