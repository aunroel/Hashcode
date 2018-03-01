import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;

public class UberMain {
    
    static ArrayList<Car> cars;
    static ArrayList<Ride> rides;
    static int bonus;
    static int steps;

    public static void main(String[] args) {
        FileReader fr = new FileReader();

        fr.readFile("a_example.in");
//        fr.readFile("b_should_be_easy.in");
        fr.parseData();
        
        cars = fr.vehicles;
        rides = fr.rides;
        bonus = fr.bonus;
        steps = fr.steps;

       sortRidesByStartTime();
    }

    public static void sortRidesByStartTime() {
        Collections.sort(rides, new SortByStartTime());
    }

    static class SortByStartTime implements Comparator<Ride> {

        @Override
        public int compare(Ride r1, Ride r2) {
            return r1.startTime - r2.startTime;
        }

    }
}
