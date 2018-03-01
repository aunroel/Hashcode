import java.util.ArrayList;

/**
 * Created by Eliza on 01/03/2018.
 */
public class CarHandler {

    ArrayList<Car> all_cars;

    public CarHandler(ArrayList<Car> cars) {
        all_cars = cars;
    }

    public ArrayList<Car> getFreeCars(int current_time) {
        ArrayList<Car> freeCars = new ArrayList<>();

        for (Car car: all_cars) {
            if (car.getTimeTillFinish() >= current_time) {
                freeCars.add(car);
            }

        }

        return freeCars;
    }


}
