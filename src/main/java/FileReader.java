import java.io.File;
import java.io.IOException;
import java.nio.file.Files;
import java.util.ArrayList;

public class FileReader {

    ArrayList<Car> vehicles = new ArrayList<>();
    ArrayList<Ride> rides = new ArrayList<>();
    String[] data;
    int bonus;
    int steps;
    int ridesAmount;

    public void readFile(String filename) {
        File file;

        try {
            ClassLoader classLoader = getClass().getClassLoader();
            file = new File(classLoader.getResource(filename).getFile());

            String fileAsString = new String(Files.readAllBytes(file.toPath()));

            data = fileAsString.split("\n");

        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public void parseData() {
        if (data.length == 0)
            return;

        for (int i = 0; i < data.length; i++) {
            String[] lineAsArray = data[i].split(" ");

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
                            new int[]{Integer.parseInt(lineAsArray[0]), Integer.parseInt(lineAsArray[1])},
                            new int[]{Integer.parseInt(lineAsArray[2]), Integer.parseInt(lineAsArray[3])},
                            Integer.parseInt(lineAsArray[4]),
                            Integer.parseInt(lineAsArray[5])

                    ));
                }
            }


        }
    }
}
