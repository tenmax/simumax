package io.tenmax.simumax;

import java.util.ArrayList;
import java.util.Random;

public class AdExchange {
    private ArrayList<AdSpace> adSpaces = new ArrayList<>();
    private Auction auction;
    private Bidder bidder;
    private Logger logger;
    private int weightTotal = 0;

    AdExchange() {

    }

    public void run(int auctionCount) {
        Random rand = new Random();
        for(int i=0; i<auctionCount; i++) {

            // Select a space
            int v = rand.nextInt(weightTotal);
            int weight = 0;
            AdSpace spaceSelcted = null;
            for(AdSpace space : adSpaces) {
                if(v < weight + space.getWeight()) {
                    spaceSelcted = space;
                    break;
                }
                weight += space.getWeight();
            }

            // prepare the bid request
            BidRequest bidRequest = new BidRequest();
            bidRequest.setRequestId(i);
            spaceSelcted.fillBidRequest(bidRequest);

            // Check the bid response and tell if win
            double bidPrice = bidder.bid(bidRequest);
            double marketPrice = spaceSelcted.generateMarketPrice(bidRequest);
            double winPrice = auction.auction(bidPrice, marketPrice);
            if(winPrice > 0) {
                WinNotice winNotice = new WinNotice(i, winPrice);
                bidder.win(winNotice);
            }

            logger.log(bidRequest, bidPrice, winPrice, marketPrice);
        }
    }

    public static AdExchange.Builder builder() {
        return new Builder();
    }


    public static class Builder {
        private AdExchange adExchange;

        Builder() {
            adExchange = new AdExchange();
        }

        public Builder addAdSpace(AdSpace adSpace) {
            adExchange.adSpaces.add(adSpace);
            adExchange.weightTotal += adSpace.getWeight();
            return this;
        }

        public Builder withAuction(Auction auction) {
            adExchange.auction = auction;
            return this;
        }

        public Builder withBidder(Bidder bidder) {
            adExchange.bidder = bidder;
            return this;
        }

        public Builder withLogger(Logger logger) {
            adExchange.logger = logger;
            return this;
        }

        public AdExchange build() {
            if (adExchange.adSpaces.size() == 0 ||
               adExchange.auction == null ||
               adExchange.bidder == null) {
                throw new RuntimeException("No enough settings for AdExchange");
            }

            return adExchange;
        }
    }


}
