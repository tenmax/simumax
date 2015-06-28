package io.tenmax.simumax.auction;

import io.tenmax.simumax.Auction;

/**
 * Created by popcorny on 6/28/15.
 */
public class FirstPriceAuction implements Auction {

    @Override
    public double auction(double bidPrice, double marketPrice) {
        // Win, and use the highest price as auction price
        if (bidPrice > marketPrice) {
            return bidPrice;
        }

        // Lose
        return 0;
    }
}
