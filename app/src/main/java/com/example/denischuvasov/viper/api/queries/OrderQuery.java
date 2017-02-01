package com.example.denischuvasov.viper.api.queries;


import com.google.gson.annotations.Expose;

import java.io.Serializable;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;

public class OrderQuery extends PageQuery {

    @Expose(serialize = false, deserialize = false)
    private HashMap params;

    private OrderQuery() {

    }

    @Override
    public HashMap<String, String> getParams() {
        return params;
    }

    public static class Builder implements Serializable {

        public static final String BIDDING_TYPE = "biddingType";
        public static final String DEPARTURE = "departure";
        public static final String DEPARTURE_RADIUS = "departureRadius";
        public static final String DESTINATION = "destination";
        public static final String DESTINATION_RADIUS = "destinationRadius";
        public static final String DEPARTURE_FROM = "departureFrom";
        public static final String DEPARTURE_TO = "departureTo";
        public static final String TRUCK_TYPE = "truckType";
        public static final String WEIGHT = "weight";
        public static final String FAVORITE = "favorite";
        public static final String ORDER_IDS = "orderIds";
        public static final String WON_BY_ME = "isWonByMe";
        public static final String STATE = "state";

        private Integer type;
        private String departure;
        private Integer departureRadius;
        private String destination;
        private Integer destinationRadius;
        private String departureFrom;
        private String departureTo;
        private Integer truckType;
        private Integer weight;
        private Boolean favorite;
        private Boolean wonByMe;
        private List<Integer> orderIds;
        private HashMap<String, String> params;
        private boolean archived;

        public Builder() {
        }

        public Builder(Builder builder) {
            this.type = builder.type;
            this.departure = builder.departure;
            this.departureRadius = builder.departureRadius;
            this.destination = builder.destination;
            this.destinationRadius = builder.destinationRadius;
            this.departureFrom = builder.departureFrom;
            this.departureTo = builder.departureTo;
            this.truckType = builder.truckType;
            this.weight = builder.weight;
            this.favorite = builder.favorite;
            this.wonByMe = builder.wonByMe;
            this.orderIds = builder.orderIds;
            this.params = builder.params;
        }

        public Builder setType(Integer type) {
            this.type = type;
            return this;
        }

        public Builder setDeparture(String departure) {
            this.departure = departure;
            return this;
        }

        public Builder setDepartureRadius(Integer departureRadius) {
            this.departureRadius = departureRadius;
            return this;
        }

        public Builder setDestination(String destination) {
            this.destination = destination;
            return this;
        }

        public Builder setDestinationRadius(Integer destinationRadius) {
            this.destinationRadius = destinationRadius;
            return this;
        }

        public Builder setDepartureFrom(String departureFrom) {
            this.departureFrom = departureFrom;
            return this;
        }

        public Builder setDepartureTo(String departureTo) {
            this.departureTo = departureTo;
            return this;
        }

        public Builder setTruckType(Integer truckType) {
            this.truckType = truckType;
            return this;
        }

        public Builder setWeight(Integer weight) {
            this.weight = weight;
            return this;
        }

        public Builder setFavorite(boolean favorite) {
            this.favorite = favorite;
            return this;
        }

        public Builder setWonByMe(Boolean wonByMe) {
            this.wonByMe = wonByMe;
            return this;
        }

        public Builder setOrderIds(List<Integer> orderIds) {
            this.orderIds = orderIds;
            return this;
        }

        public Builder setArchived(boolean archived) {
            this.archived = archived;
            return this;
        }

        public OrderQuery build() {
            OrderQuery query = new OrderQuery();
            params = new HashMap<>();
            appendParam(BIDDING_TYPE, type);
            appendParam(DEPARTURE, departure);
            appendParam(DEPARTURE_RADIUS, departureRadius);
            appendParam(DESTINATION, destination);
            appendParam(DESTINATION_RADIUS, destinationRadius);
            appendParam(DEPARTURE_FROM, departureFrom);
            appendParam(DEPARTURE_TO, departureTo);
            appendParam(TRUCK_TYPE, truckType);
            appendParam(WEIGHT, weight);
            if(favorite != null) {
                appendParam(FAVORITE, favorite ? "1" : "0");
            }
            if(wonByMe != null) {
                appendParam(WON_BY_ME, wonByMe ? "1" : "0");
            }
            if(archived) {
                appendParam(STATE, "archive");
            }
            appendParam(ORDER_IDS, getOrdersString());
            query.params = params;
            return query;
        }

        private void appendParam(String key, Integer param) {
            if(param != null) {
                appendParam(key, param.toString());
            }
        }

        private void appendParam(String key, String param) {
            if(param != null) {
                params.put(key, param);
            }
        }

        private String getOrdersString() {
            if(orderIds == null) return null;
            StringBuilder builder = new StringBuilder();
            Iterator<Integer> iterator = orderIds.iterator();
            while (iterator.hasNext()) {
                Integer id = iterator.next();
                builder.append(id.toString());
                if(iterator.hasNext()) {
                    builder.append(",");
                }
            }
            return builder.toString();
        }

        public Builder makeCopy() {
           return new Builder(this);
        }
    }
}
