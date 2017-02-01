package com.example.denischuvasov.viper.api.responses;

import com.example.denischuvasov.viper.api.dto.ApiInfo;

import java.util.List;

/**
 * Created by denischuvasov on 16.01.17.
 */

public class BaseResponse<T> {
    protected List<ApiInfo> errors;
    protected List<ApiInfo> notice;
    protected T data;

    public List<ApiInfo> getErrors() {
        return errors;
    }

    public List<ApiInfo> getNotice() {
        return notice;
    }

    public T getData() {
        return data;
    }

    public boolean isSuccess() {
        return data != null || (notice != null && notice.size() > 0);
    }

    @Override
    public String toString() {
        return "BaseResponse{" +
                "errors=" + errors +
                ", notice=" + notice +
                ", data=" + data +
                '}';
    }
}
