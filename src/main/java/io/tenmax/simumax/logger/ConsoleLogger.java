package io.tenmax.simumax.logger;

import io.tenmax.simumax.BidRequest;
import io.tenmax.simumax.Logger;

/**
 * Created by popcorny on 6/28/15.
 */
public class ConsoleLogger implements Logger {
    private boolean firstLine = true;

    @Override
    public void log(
            BidRequest request,
            double bidPrice,
            double winPrice,
            double marketPrice)
    {
        if (firstLine) {
            System.out.println("space, bidFloor, bidPrice, winPrice, marketPrice");
            firstLine = false;
        }

        System.out.printf("%s, %f, %f, %f, %f\n",
                request.getSpaceId(),
                request.getBidFloor(),
                bidPrice,
                winPrice,
                marketPrice);
    }
}
