/**
 * Created by Eliza on 01/03/2018.
 */
public class Ride {
    public int no;
    public int costOfRide;
    public int[] startPos = new int[2];
    public int[] endPos = new int[2];
    public int startTime;
    public int endTime;

    public Ride(int no, int[] startPos, int[] endPos, int startTime, int endTime){
        this.no = no;
        this.startPos = startPos;
        this.endPos = endPos;
        this.startTime = startTime;
        this.endTime = endTime;
        costOfRide = calculateCost(startPos, endPos);
    }


    public int calculateCost(int[] startPos, int[] endPos){
        int val;
        val = Math.abs(startPos[0] - endPos[0]) + Math.abs(startPos[1] - endPos[1]);
        return val;
    }

}
