package com.example.denischuvasov.viper.utils;

import android.content.Context;

import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.Mock;
import org.robolectric.RobolectricTestRunner;

import static org.junit.Assert.*;

/**
 * Created by denischuvasov on 24.01.17.
 */
@RunWith(RobolectricTestRunner.class)
public class PreferenceUtilsTest {
    @Mock
    Context mMockContext;

    PreferenceUtils preferenceUtils;

    @Before
    public void setUp() throws Exception {
        preferenceUtils = new PreferenceUtils(mMockContext);
        preferenceUtils.clear();
    }

    @Test
    public void verify_token_saved() throws Exception {
        String token = "token";
        preferenceUtils.putToken(token);
        String savedToken = preferenceUtils.getToken();
        assertEquals("Token saved", token, savedToken);
    }


    @Test
    public void putToken() throws Exception {

    }

}