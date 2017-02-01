package com.example.denischuvasov.viper.utils;

import android.content.Context;
import android.content.SharedPreferences;

/**
 * Created by denischuvasov on 18.01.17.
 */

public class PreferenceUtils {
    private static final String SHARED_PREF = "shared_preferences";
    private static final String TOKEN_KEY = "token_key";
    private SharedPreferences sharedPreferences;
    public PreferenceUtils(Context context) {
        sharedPreferences = context.getSharedPreferences(SHARED_PREF, Context.MODE_PRIVATE);
    }

    public String getToken() {
        return sharedPreferences.getString(TOKEN_KEY, "");
    }

    public void putToken(String token) {
        sharedPreferences.edit().putString(TOKEN_KEY, token).commit();
    }

    public void clear() {
        sharedPreferences.edit().clear().commit();
    }
}
