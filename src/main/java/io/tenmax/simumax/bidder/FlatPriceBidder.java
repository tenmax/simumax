package io.tenmax.simumax.bidder;

import io.tenmax.simumax.BidRequest;
import io.tenmax.simumax.Bidder;
import io.tenmax.simumax.WinNotice;

/**
 * Created by popcorny on 6/28/15.
 */
public class FlatPriceBidder implements Bidder {
    private double price;
    public FlatPriceBidder(double price) {
        this.price = price;
    }

    @Override
    public double bid(BidRequest bidRequest) {
        return price;
    }

    @Override
    public void win(WinNotice winNotice) {

    }
}
