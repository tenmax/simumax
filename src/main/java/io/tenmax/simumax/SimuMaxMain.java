package io.tenmax.simumax;

import io.tenmax.simumax.adspace.NormalDistributedAdSpace;
import io.tenmax.simumax.auction.SecondPriceAuction;
import io.tenmax.simumax.bidder.FlatPriceBidder;
import io.tenmax.simumax.logger.ConsoleLogger;
import org.apache.commons.cli.*;

/**
 * The entry of the SimuMax
 */
public class SimuMaxMain {

    public static void main(String[] args) {
        Options options = new Options();
        options.addOption("f", false, "Configuration File");

        CommandLine commandLine = null;
        try {
            commandLine = new DefaultParser().parse(options, args);
        } catch(ParseException e) {
            System.out.println("Can't parse arguments: " + e.getMessage());
            System.out.println(options.getOptions());
            System.exit(1);
        }

        int auctionCount = 1000;
        String[] remaining = commandLine.getArgs();
        if(remaining.length > 0) {
            auctionCount = Integer.parseInt(remaining[0]);
        }

        // Create the ad exchange
        AdExchange.Builder builder = AdExchange.builder();
        defaultAdExchange(builder);
        AdExchange adExchange = builder.build();

        adExchange.run(auctionCount);
    }

    public static void defaultAdExchange(AdExchange.Builder builder) {
        builder.addAdSpace(new NormalDistributedAdSpace("A", 0.2, 0.05, 0.01, 2))
               .addAdSpace(new NormalDistributedAdSpace("B", 0.5, 0.15, 0.01, 1))
               .addAdSpace(new NormalDistributedAdSpace("C", 0.3, 0.25, 0.01, 1))
               .withAuction(new SecondPriceAuction())
               .withBidder(new FlatPriceBidder(0.3))
               .withLogger(new ConsoleLogger());
    }
}
