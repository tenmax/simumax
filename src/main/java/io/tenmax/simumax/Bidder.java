package io.tenmax.simumax;

/**
 * The Bidder is the bid strategy to bid account the BidRequest.
 */
public interface Bidder {

    double bid(BidRequest bidRequest);

    void win(WinNotice winNotice);
}
