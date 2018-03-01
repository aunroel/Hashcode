import java.util.ArrayList;

/**
 * Created by Eliza on 01/03/2018.
 */
public class Car {
    public int[] currentPosition = {0, 0};
    public int timeTillFinish = 0;
    public ArrayList<Integer> rides = new ArrayList<>();

    public int[] getCurrentPosition() {
        return currentPosition;
    }

    public void setCurrentPosition(int[] currentPosition) {
        this.currentPosition = currentPosition;
    }

    public int getTimeTillFinish() {
        return timeTillFinish;
    }

    public void setTimeTillFinish(int timeTillFinish) {
        this.timeTillFinish = timeTillFinish;
    }

    public ArrayList<Integer> getRides() {
        return rides;
    }

    public void setRides(ArrayList<Integer> rides) {
        this.rides = rides;
    }
}
