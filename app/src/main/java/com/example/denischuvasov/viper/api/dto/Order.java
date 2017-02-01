package com.example.denischuvasov.viper.api.dto;

import android.support.annotation.IntDef;

import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.text.NumberFormat;
import java.util.Locale;

public class Order {

    public static final String DEFAULT_VALUE = "---";

    @Retention(RetentionPolicy.SOURCE)
    @IntDef({PAYMENT_CASH, PAYMENT_CASHLESS})
    public @interface CashType {}
    public static final int PAYMENT_CASH = 1;
    public static final int PAYMENT_CASHLESS = 2;

    private boolean empty;

    private int id;
    private int biddingId;
    private int statusId;
    private @CashType int paymentTypeId;
    private int serialNumber;
    private boolean withVAT;
    private String loadingTime;
    private String unloadingTime;
    private int truckTypeId;
    private int cargoTypeId;
    private double cargoWeight;
    private int cubicCapacityValue;
    private int loadingTypeId;
    private String comment;
    private Integer externalId;
    private int bidsCount;
    private boolean isFavorite;
    private Bidding bidding;
    private Point departurePoint;
    private Point destinationPoint;
    private Bid betterBid;
    private Bid lastClientBid;
    private Auction auction;
    private ExpressTender expressTender;
    private boolean isWinnerChosen;
    private boolean isWonByMe;

    public Order() {

    }

    public Order(int id) {
        this.id = id;
        this.empty = true;
    }

    public boolean isEmpty() {
        return empty;
    }

    public int getId() {
        return id;
    }

    public int getBiddingId() {
        return biddingId;
    }

    public int getStatusId() {
        return statusId;
    }

    public @CashType int getPaymentTypeId() {
        return paymentTypeId;
    }

    public int getSerialNumber() {
        return serialNumber;
    }

    public boolean withVAT() {
        return withVAT;
    }

    public String getLoadingTime() {
        return loadingTime;
    }

    public String getUnloadingTime() {
        return unloadingTime;
    }

    public int getTruckTypeId() {
        return truckTypeId;
    }

    public int getCargoTypeId() {
        return cargoTypeId;
    }

    public double getCargoWeight() {
        return cargoWeight;
    }

    public int getCubicCapacityValue() {
        return cubicCapacityValue;
    }

    public int getLoadingTypeId() {
        return loadingTypeId;
    }

    public String getComment() {
        return comment;
    }

    public Integer getExternalId() {
        return externalId;
    }

    public int getBidsCount() {
        return bidsCount;
    }

    public Bidding getBidding() {
        return bidding;
    }

    public Point getDeparturePoint() {
        return departurePoint;
    }

    public Point getDestinationPoint() {
        return destinationPoint;
    }

    public Bid getBetterBid() {
        return betterBid;
    }

    public Auction getAuction() {
        return auction;
    }

    public ExpressTender getExpressTender() {
        return expressTender;
    }

    public Bid getCurrentClientBid() {
        return lastClientBid;
    }

    public boolean isAuction() {
        return  bidding != null && bidding.getBiddingTypeId() == Bidding.TYPE_AUCTION;
    }

    public boolean isExpress() {
        return  bidding != null && bidding.getBiddingTypeId() == Bidding.TYPE_EXPRESS;
    }

    public boolean isFavorite() {
        return isFavorite;
    }

    public void setFavorite(boolean favorite) {
        this.isFavorite = favorite;
    }

    public String getOrderNumberString() {
        return String.format("%03d/%03d", biddingId, serialNumber);
    }

    public int getCostValue() {
        if(betterBid != null) {
            return betterBid.getBidValue();
        } else if(auction != null) {
            return (int) auction.getOpeningBid();
        } else if(expressTender != null) {
            return (int) expressTender.getCostValue();
        }
        return -1;
    }

    public String getCost() {
        int costValue = getCostValue();
        if (costValue >= 0) {
            NumberFormat format = NumberFormat.getCurrencyInstance(new Locale("ru","RU"));
            return format.format(costValue);
        }
        return DEFAULT_VALUE;
    }

    public boolean isCurrentBidMine() {
        return lastClientBid != null && betterBid != null && lastClientBid.getId() == betterBid.getId();
    }

    public boolean isWinnerChosen() {
        return isWinnerChosen;
    }

    public boolean winOrder() {
        return isWonByMe;
    }

}
