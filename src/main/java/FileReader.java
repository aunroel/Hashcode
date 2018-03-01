import java.io.BufferedReader;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

public class FileReader {

    List<String> data = new ArrayList<String>();

    public void readFile(String filename) {
        try {
            BufferedReader bufferedReade = Files.newBufferedReader(Paths.get(filename));
            data = bufferedReade.lines().collect(Collectors.toList());
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public void parseData() {
        if (data.isEmpty())
            return;

        for (int i = 0; i < data.size(); i++) {
            String[] lineAsArray = data.get(i).split(" ");
                        
        }
    }
}
