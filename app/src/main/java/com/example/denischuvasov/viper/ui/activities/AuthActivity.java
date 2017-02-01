package com.example.denischuvasov.viper.ui.activities;

import android.content.Intent;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.util.Log;
import android.widget.Toast;

import com.example.denischuvasov.viper.App;
import com.example.denischuvasov.viper.R;
import com.example.denischuvasov.viper.ui.common.BaseActivity;
import com.example.denischuvasov.viper.ui.fragments.SignInFragment;
import com.example.denischuvasov.viper.ui.fragments.SignUpFragment;
import com.example.denischuvasov.viper.ui.fragments.StartPageFragment;

import javax.inject.Inject;

import butterknife.ButterKnife;
import ru.terrakok.cicerone.Navigator;
import ru.terrakok.cicerone.NavigatorHolder;
import ru.terrakok.cicerone.android.SupportFragmentNavigator;
import ru.terrakok.cicerone.commands.Replace;

/**
 * A login screen that offers login via email/password.
 */
public class AuthActivity extends BaseActivity {
    private static final String TAG = "AuthActivity";
    public static final String SIGN_IN_SCREEN = "sign_in_screen";
    public static final String SIGN_UP_SCREEN = "sign_up_screen";
    public static final String START_SCREEN = "start_screen";
    public static final String MAIN_SCREEN = "main_screen";

    @Inject
    NavigatorHolder navigatorHolder;

    private Navigator navigator = new SupportFragmentNavigator(getSupportFragmentManager(), R.id.container) {
        @Override
        protected Fragment createFragment(String screenKey, Object data) {
            switch (screenKey) {
                case SIGN_IN_SCREEN:
                    return SignInFragment.newInstance();
                case SIGN_UP_SCREEN:
                    return SignUpFragment.newInstance();
                case START_SCREEN:
                    return StartPageFragment.newInstance();
                default:
                    Log.e(TAG, screenKey + " not found");
            }
            return null;
        }


        @Override
        protected void showSystemMessage(String message) {
            Toast.makeText(AuthActivity.this, message, Toast.LENGTH_SHORT).show();
        }

        @Override
        protected void exit() {
            finish();
        }

        @Override
        protected void backToUnexisting() {
            startActivity(new Intent(AuthActivity.this, MainActivity.class));
            finish();
        }
    };

    @Override
    protected void onActivityResult(int requestCode, int resultCode, Intent data) {
        super.onActivityResult(requestCode, resultCode, data);
    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        ((App) getApplication()).getComponent().inject(this);
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login);
        ButterKnife.bind(this);
        if(savedInstanceState == null) {
            navigator.applyCommand(new Replace(START_SCREEN, null));
        }
    }

    @Override
    protected void onResume() {
        super.onResume();
        navigatorHolder.setNavigator(navigator);
    }

    @Override
    protected void onPause() {
        super.onPause();
        navigatorHolder.removeNavigator();
    }
}

