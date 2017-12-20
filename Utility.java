import java.io.BufferedWriter;
import java.io.FileWriter;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.List;

public class Utility {
    public static void main(String[] args) {

        if(Files.exists(Paths.get(args[0]))){

            List<String> fileArr = null;
            try {
                fileArr = Files.readAllLines(Paths.get(args[0]));
            } catch (IOException e) {
                e.printStackTrace();
            }
            try (BufferedWriter bufferedWriter = new BufferedWriter(new FileWriter(args[0]))){

                for(String s: fileArr){
                    if(s.contains("WITH_WEBSOCKETS:=")){
                        s = s.replace("no", "yes");
                    }
                    bufferedWriter.write(s);
                    bufferedWriter.newLine();
                }
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
    }
}

