package io.tenmax.simumax;

/**
 * The interface define the auction pricing model.
 */
public interface Auction {

    /**
     * Second Price Auction
     * @param bidPrice
     * @param marketPrice
     * @return win price
     */
    double auction(double bidPrice, double marketPrice);
}
