package io.tenmax.simumax.auction;

import io.tenmax.simumax.Auction;

/**
 * Created by popcorny on 6/26/15.
 */
public class SecondPriceAuction implements Auction {
    public SecondPriceAuction() {

    }

    @Override
    public double auction(double bidPrice, double marketPrice) {
        // Win, and use the second highest price as auction price
        if (bidPrice > marketPrice) {
            return marketPrice;
        }

        // Lose
        return 0;
    }
}
