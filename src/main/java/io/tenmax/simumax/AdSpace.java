package io.tenmax.simumax;

import org.apache.commons.math3.distribution.NormalDistribution;

/**
 * The ad space definition. There would be a hidden pricing fact inside
 * the space. For example, the price is normal distributed.
 */
public abstract class AdSpace {
    /**
     * The identifier/name of a space.
     */
    protected String spaceId;

    /**
     * The bid floor allowed for this space.
     */
    protected double bidFloor;

    /**
     * The weight that the space appear in the ad exchange.
     */
    protected int weight;

    public AdSpace(String spaceId)
    {
        this.spaceId = spaceId;
    }

    public AdSpace(String spaceId,
                   double bidFloor,
                   int weight)
    {
        this.spaceId = spaceId;
        this.bidFloor = bidFloor;
        this.weight = weight;
    }

    public String getSpaceId() {
        return spaceId;
    }

    public double getBidFloor() {
        return bidFloor;
    }

    public void setBidFloor(double bidFloor) {
        this.bidFloor = bidFloor;
    }

    public int getWeight() {
        return weight;
    }

    public void setWeight(int weight) {
        this.weight = weight;
    }

    /**
     * Simulate the send bid request phase. The space should fill in
     * the information of this bid request.
     *
     * @return the bid request.
     */
    protected void fillBidRequest(BidRequest request) {
        request.setSpaceId(spaceId);
        request.setBidFloor(bidFloor);
    }

    /**
     * Simulate the highest price among other DSPs.
     *
     * @param request the bid request.
     * @return the highest price among other DSPs. We call it market price.
     *
     */
    abstract protected double generateMarketPrice(
            BidRequest request);
}
