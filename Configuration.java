import java.io.BufferedWriter;
import java.io.FileWriter;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.List;

public class Configuration {
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
                    if(s.contains("#port 1883")){
                        s = s.replace("#", "");
                        s = s +"\n" + "listener 1884\n" + "protocol websockets\n";
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
