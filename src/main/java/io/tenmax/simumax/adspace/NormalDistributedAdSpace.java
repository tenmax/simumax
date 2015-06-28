package io.tenmax.simumax.adspace;

import io.tenmax.simumax.AdSpace;
import io.tenmax.simumax.BidRequest;
import org.apache.commons.math3.distribution.NormalDistribution;

/**
 * Created by popcorny on 6/28/15.
 */
public class NormalDistributedAdSpace extends AdSpace {
    private NormalDistribution distribution;

    public NormalDistributedAdSpace(
            String spaceId,
            double mean,
            double sd)
    {
        this(spaceId, mean, sd, 0.01, 1);
    }

    public NormalDistributedAdSpace(
            String spaceId,
            double mean,
            double sd,
            double bidFloor,
            int weight)
    {
        super(spaceId, bidFloor, weight);
        this.distribution = new NormalDistribution(mean, sd);
    }

    @Override
    protected double generateMarketPrice(BidRequest request) {
        double marketPrice = distribution.sample();
        if(marketPrice < bidFloor) {
            return bidFloor;
        }

        return marketPrice;
    }
}
