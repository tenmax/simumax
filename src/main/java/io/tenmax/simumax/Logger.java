package io.tenmax.simumax;

import java.net.Socket;

/**
 * The interface to log the bid result.
 */
public interface Logger {

    public void log(
            BidRequest request,
            double bidPrice,
            double winPrice,
            double marketPrice);
}
