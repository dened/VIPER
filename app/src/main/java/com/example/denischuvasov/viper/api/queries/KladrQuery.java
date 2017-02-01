package com.example.denischuvasov.viper.api.queries;


import com.google.gson.annotations.Expose;

import java.io.Serializable;
import java.util.HashMap;

public class KladrQuery extends PageQuery {

    @Expose(serialize = false, deserialize = false)
    private HashMap params;

    private KladrQuery() {

    }

    @Override
    public HashMap<String, String> getParams() {
        return params;
    }

    public static class Builder implements Serializable {

        public static final String QUERY = "q";
        public static final String FILTER = "filter";
        public static final String DETAILS = "detail";

        private String query;
        private String filter;
        private boolean detail;
        private HashMap<String, String> params;

        public Builder setQuery(String query) {
            this.query = query;
            return this;
        }

        public Builder setFilter(String filter) {
            this.filter = filter;
            return this;
        }

        public Builder setDetail(boolean detail) {
            this.detail = detail;
            return this;
        }

        public KladrQuery build() {
            KladrQuery query = new KladrQuery();
            params = new HashMap<>();
            appendParam(QUERY, this.query);
            appendParam(FILTER, filter);
            appendParam(DETAILS, detail ? "1" : "0");
            query.params = params;
            return query;
        }

        private void appendParam(String key, String param) {
            if(param != null) {
                params.put(key, param);
            }
        }
    }
}
