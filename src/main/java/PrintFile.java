import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.ArrayList;

/**
 * Created by Eliza on 01/03/2018.
 */
public class PrintFile {

    public PrintFile(ArrayList<Car> allcars, String fileName) throws IOException {
        File file = new File("src/main/resources/out/" + fileName + ".txt");

        FileWriter fileWriter = new FileWriter(file);
        PrintWriter printWriter = new PrintWriter(fileWriter);

        for (Car car : allcars) {
            String toprint = buildString(car);
            printWriter.println(toprint);
        }

        printWriter.close();

    }

    private String buildString(Car car) {
        int amountOfRides = car.getRides().size();
        String toprint = "";
        toprint = toprint + amountOfRides;

        for (int ride : car.getRides()) {
            toprint += " " + ride;
        }

        return toprint;

    }
}
