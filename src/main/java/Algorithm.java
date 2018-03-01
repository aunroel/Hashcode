import java.io.IOException;
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



    public Algorithm(int file, String fileName) {

        FileReader fr = new FileReader();

        switch (file) {
            case 1: fr.readFile("in/a_example.in");
            break;
            case 2: fr.readFile("in/b_should_be_easy.in");
            break;
            case 3: fr.readFile("in/c_no_hurry.in");
                break;
            case 4: fr.readFile("in/d_metropolis.in");
                break;
            case 5: fr.readFile("in/e_high_bonus.in");
                break;
        }
        fr.parseData();
        ch = new CarHandler(fr.getVehicles());
        steps = fr.getSteps();
        bonus = fr.getBonus();
        rides = fr.getRides();

        run(fileName);
    }

    private void run(String fileName) {

        for (int i = 0; i < steps; i++) {
            ArrayList<Car> freeCars = ch.getFreeCars(i);

            sortRidesByStartTime();

            assignRides(freeCars, rides, i);

        }
        try {
            PrintFile pf = new PrintFile(ch.all_cars, fileName);
        } catch (IOException e) {
            e.printStackTrace();
        }


    }

    private void assignRides(ArrayList<Car> free_cars, ArrayList<Ride> rides, int current_step) {

        ArrayList<Ride> assignedRides = new ArrayList<>();

        for (Ride ride : rides) {

            if (current_step >= ride.endTime - ride.costOfRide) continue;

            if(free_cars.size() == 0) break;

            Car temptative = free_cars.get(0);
            int temptative_cost = calculateCost(ride, temptative);
            for (Car car: free_cars) {
                int considering = calculateCost(ride, car);

                int time_check = current_step + considering;

                if (time_check >= ride.startTime) {
                    if (considering < temptative_cost) {
                        temptative = car;
                        temptative_cost =  considering;
                    }

                }
            }


            temptative.addRide(ride);
            temptative.setCurrentPosition(ride.endPos);
            temptative.setTimeTillFinish(current_step + temptative_cost + ride.costOfRide);
            free_cars.remove(temptative);
            assignedRides.add(ride);
        }

        for (Ride ride :
                assignedRides) {
            rides.remove(ride);
        }

    }

    private int calculateCost(Ride ride, Car car) {
        int cost = ride.calculateCost(car.currentPosition, ride.startPos);
        return cost;
    }

    public void sortRidesByStartTime() {
        Collections.sort(rides, new SortByStartTime());
    }

    class SortByStartTime implements Comparator<Ride> {

        @Override
        public int compare(Ride r1, Ride r2) {
            int com = r1.startTime - r2.startTime;

            if(com != 0) {
                return com;
            } else {
                return r2.costOfRide - r1.costOfRide;
            }
        }

    }
}
