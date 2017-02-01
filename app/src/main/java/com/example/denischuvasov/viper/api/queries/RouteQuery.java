package com.example.denischuvasov.viper.api.queries;


import com.google.gson.annotations.Expose;

import java.io.Serializable;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;

public class RouteQuery extends PageQuery {

    @Expose(serialize = false, deserialize = false)
    private HashMap params;

    private RouteQuery() {

    }

    @Override
    public HashMap<String, String> getParams() {
        return params;
    }

    public static class Builder implements Serializable {

        public static final String TAB_MY = "my";
        public static final String TAB_ALL = "all";
        public static final String STATE_ACTIVE = "active";
        public static final String STATE_ARCHIVE = "archive";

        public static final String DEPARTURE = "departure";
        public static final String DESTINATION = "destination";
        public static final String ROUTE_IDS = "routeIds";
        public static final String TAB = "tab";
        public static final String STATE = "state";
        public static final String ORDER = "order";

        private String departure;
        private String destination;
        private List<Integer> routeIds;
        private String tab;
        private String state;
        private Integer order;
        private HashMap<String, String> params;

        public Builder setDeparture(String departure) {
            this.departure = departure;
            return this;
        }

        public Builder setDestination(String destination) {
            this.destination = destination;
            return this;
        }

        public Builder setRouteIds(List<Integer> routeIds) {
            this.routeIds = routeIds;
            return this;
        }

        public Builder setTab(String tab) {
            this.tab = tab;
            return this;
        }

        public String getTab() {
            return tab;
        }

        public Builder setState(String state) {
            this.state = state;
            return this;
        }

        public Builder setOrder(Integer order) {
            this.order = order;
            return this;
        }

        public Builder setParams(HashMap<String, String> params) {
            this.params = params;
            return this;
        }

        public RouteQuery build() {
            RouteQuery query = new RouteQuery();
            params = new HashMap<>();
            appendParam(DEPARTURE, departure);
            appendParam(DESTINATION, destination);
            appendParam(TAB, tab);
            appendParam(STATE, state);
            appendParam(ORDER, order);
            appendParam(ROUTE_IDS, getOrdersString());
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
            if(routeIds == null) return null;
            StringBuilder builder = new StringBuilder();
            Iterator<Integer> iterator = routeIds.iterator();
            while (iterator.hasNext()) {
                Integer id = iterator.next();
                builder.append(id.toString());
                if(iterator.hasNext()) {
                    builder.append(",");
                }
            }
            return builder.toString();
        }
    }
}
