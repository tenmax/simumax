package io.tenmax.simumax;

/**
 * Created by popcorny on 6/27/15.
 */
public class BidRequest {
    private int requestId;
    private String spaceId;
    private double bidFloor;

    public int getRequestId() {
        return requestId;
    }

    public void setRequestId(int requestId) {
        this.requestId = requestId;
    }

    public String getSpaceId() {
        return spaceId;
    }

    public void setSpaceId(String spaceId) {
        this.spaceId = spaceId;
    }

    public double getBidFloor() {
        return bidFloor;
    }

    public void setBidFloor(double bidFloor) {
        this.bidFloor = bidFloor;
    }
}
