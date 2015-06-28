package io.tenmax.simumax;

public class WinNotice {
    private int requestId;
    private double winPrice;

    public WinNotice(int requestId, double winPrice) {
        this.requestId = requestId;
        this.winPrice = winPrice;
    }

    public int getRequestId() {
        return requestId;
    }

    public double getWinPrice() {
        return winPrice;
    }
}
