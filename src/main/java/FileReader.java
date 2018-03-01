import java.io.BufferedReader;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

public class FileReader {

    ArrayList<Car> vehicles = new ArrayList<>();
    ArrayList<Ride> rides = new ArrayList<>();
    List<String> data = new ArrayList<>();
    int bonus;
    int steps;
    int ridesAmount;

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

            if (i == 0) {
                // hardcode, maybe change later TODO
                int[][] cityMap = new int[Integer.parseInt(lineAsArray[0])][Integer.parseInt(lineAsArray[1])];

                for (int j = 0; j < Integer.parseInt(lineAsArray[2]); j++)
                    vehicles.add(new Car());

                ridesAmount = Integer.parseInt(lineAsArray[3]);

                bonus = Integer.parseInt(lineAsArray[4]);

                steps = Integer.parseInt(lineAsArray[5]);
            } else {
                if (rides.size() <= ridesAmount) {
                    rides.add(new Ride(
                            i - 1,
                            new int[]{Integer.parseInt(lineAsArray[0], Integer.parseInt(lineAsArray[1]))},
                            new int[]{Integer.parseInt(lineAsArray[2]), Integer.parseInt(lineAsArray[3])},
                            Integer.parseInt(lineAsArray[4]),
                            Integer.parseInt(lineAsArray[5])

                    ));
                }
            }


        }
    }
}
