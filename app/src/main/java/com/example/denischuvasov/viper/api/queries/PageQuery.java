package com.example.denischuvasov.viper.api.queries;

import java.util.HashMap;

public abstract class PageQuery {

    protected int offset;

    protected int limit;

    public int getOffset() {
        return offset;
    }

    public void setOffset(int offset) {
        this.offset = offset;
    }

    public int getLimit() {
        return limit;
    }

    public void setLimit(int limit) {
        this.limit = limit;
    }

    public abstract HashMap<String, String> getParams();

    public String getParam() {
        return null;
    }
}
