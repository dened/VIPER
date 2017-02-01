package com.example.denischuvasov.viper.ui.activities;

import android.content.Intent;
import android.os.Bundle;
import android.support.design.widget.FloatingActionButton;
import android.support.v7.widget.Toolbar;
import android.text.TextUtils;
import android.util.Log;
import android.view.View;
import android.view.Menu;
import android.view.MenuItem;
import android.widget.Toast;

import com.arellomobile.mvp.presenter.InjectPresenter;
import com.example.denischuvasov.viper.App;
import com.example.denischuvasov.viper.R;
import com.example.denischuvasov.viper.ui.common.BaseActivity;
import com.example.denischuvasov.viper.presentation.presenter.MainPresenter;
import com.example.denischuvasov.viper.presentation.view.MainView;
import com.example.denischuvasov.viper.ui.fragments.OrderListFragment;
import com.example.denischuvasov.viper.utils.PreferenceUtils;

import javax.inject.Inject;

import ru.terrakok.cicerone.Navigator;
import ru.terrakok.cicerone.NavigatorHolder;
import ru.terrakok.cicerone.commands.Command;
import ru.terrakok.cicerone.commands.Forward;

public class MainActivity extends BaseActivity implements MainView {
    private static final String TAG = "MainActivity";
    public static final String DETAILS_SCREEN = "details_screen";

    @InjectPresenter
    MainPresenter mainPresenter;

    @Inject
    PreferenceUtils preferenceUtils;

    @Inject
    NavigatorHolder navigatorHolder;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        ((App) getApplication()).getComponent().inject(this);
        if(!checkLogin()) {
            finish();
            return;
        }
        setContentView(R.layout.activity_main);
        Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);


        if(savedInstanceState == null) {
            getSupportFragmentManager().beginTransaction()
                    .replace(R.id.rootContent, OrderListFragment.newInstance())
                    .commitAllowingStateLoss();
        }

        FloatingActionButton fab = (FloatingActionButton) findViewById(R.id.fab);
        fab.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                startActivity(new Intent(MainActivity.this, AuthActivity.class));
            }
        });

    }

    private Navigator navigator = new Navigator() {
        @Override
        public void applyCommand(Command command) {
            if(command instanceof Forward) {
                forward((Forward) command);
            }
        }

        private void forward(Forward command) {
            switch (command.getScreenKey()) {
                case DETAILS_SCREEN:
                    startActivity(DetailActivity.getIntent(MainActivity.this, (Integer) command.getTransitionData()));
                    break;

                default:
                    Log.e(TAG, "Unknown screen: " + command.getScreenKey());
            }
        }
    };

    private boolean checkLogin() {
        if(TextUtils.isEmpty(preferenceUtils.getToken())) {
            startActivity(new Intent(this, AuthActivity.class));
            return false;
        }
        return true;
    }

    private void showMessage(int launchAppCount) {
        Toast.makeText(this, "Приложение запущено: " + launchAppCount, Toast.LENGTH_SHORT).show();
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.menu_main, menu);
        return true;
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

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        // Handle action bar item clicks here. The action bar will
        // automatically handle clicks on the Home/Up button, so long
        // as you specify a parent activity in AndroidManifest.xml.
        int id = item.getItemId();

        //noinspection SimplifiableIfStatement
        if (id == R.id.action_settings) {
            return true;
        }

        return super.onOptionsItemSelected(item);
    }
}
