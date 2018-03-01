import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;

/**
 * Created by Eliza on 01/03/2018.
 */
public class Algorithm {

    CarHandler ch;
    int steps;
    int bonus;
    ArrayList<Ride> rides;



    public Algorithm() {

        FileReader fr = new FileReader();
        fr.readFile("a_example.in");
        //fr.readFile("");
        fr.parseData();
        ch = new CarHandler(fr.getVehicles());
        steps = fr.getSteps();
        bonus = fr.getBonus();
        rides = fr.getRides();

        run();
    }

    private void run() {

        for (int i = 0; i < steps; i++) {
            ArrayList<Car> freeCars = ch.getFreeCars(i);

            //Get rides to assign

            //Assign rides
        }

    }

    private void assignRides(ArrayList<Car> free_cars, ArrayList<Ride> rides) {

        for (Ride ride : rides) {



            for (Car car: free_cars) {

            }
        }
    }

    public void sortRidesByStartTime() {
        Collections.sort(rides, new SortByStartTime());
    }

    class SortByStartTime implements Comparator<Ride> {

        @Override
        public int compare(Ride r1, Ride r2) {
            return r1.startTime - r2.startTime;
        }

    }
}
