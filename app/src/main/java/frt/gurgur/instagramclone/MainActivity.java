package frt.gurgur.instagramclone;

import android.os.Bundle;
import android.view.MenuItem;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.databinding.DataBindingUtil;
import androidx.fragment.app.Fragment;

import com.google.android.material.bottomnavigation.BottomNavigationView;
import com.trendyol.medusalib.navigator.MultipleStackNavigator;
import com.trendyol.medusalib.navigator.Navigator;
import com.trendyol.medusalib.navigator.NavigatorConfiguration;
import com.trendyol.medusalib.navigator.transaction.NavigatorTransaction;

import java.util.Arrays;
import java.util.List;

import butterknife.BindView;
import butterknife.ButterKnife;
import dagger.android.AndroidInjection;
import frt.gurgur.instagramclone.databinding.ActivityMainBinding;
import frt.gurgur.instagramclone.ui.main.MainFragment;
import kotlin.jvm.functions.Function0;

public class MainActivity extends AppCompatActivity implements Navigator.NavigatorListener{
    public MultipleStackNavigator multipleStackNavigator;
    public ActivityMainBinding binding;

    @BindView(R.id.navigation)
    public BottomNavigationView navigation;



    private List<Function0<Fragment>> rootsFragmentProvider = Arrays.asList(
            new Function0<Fragment>() {
                @Override
                public Fragment invoke() {
                    return new MainFragment();
                }
            }
    );



    @Override
    protected void onCreate(Bundle savedInstanceState) {
        AndroidInjection.inject(this);
        super.onCreate(savedInstanceState);
        binding = DataBindingUtil.setContentView(this, R.layout.activity_main);
        ButterKnife.bind(this);
        initNavMenu(savedInstanceState);
    }



    public void initNavMenu(Bundle savedInstanceState){
        multipleStackNavigator = new MultipleStackNavigator(
                getSupportFragmentManager(),
                R.id.container,
                rootsFragmentProvider,
                this,
                new NavigatorConfiguration(0, true, NavigatorTransaction.SHOW_HIDE),
                null);
        multipleStackNavigator.initialize(savedInstanceState);
        navigation.setOnNavigationItemSelectedListener(mOnNavigationItemSelectedListener);
    }

    private BottomNavigationView.OnNavigationItemSelectedListener mOnNavigationItemSelectedListener = new BottomNavigationView.OnNavigationItemSelectedListener() {
        @Override
        public boolean onNavigationItemSelected(@NonNull MenuItem menuItem) {
            switch (menuItem.getItemId()) {
                case R.id.navigation_home:

                    return true;
                case R.id.navigation_explore:

                    return true;
                case R.id.navigation_create_post:

                    return true;
                case R.id.navigation_favs:

                    return true;
                case R.id.navigation_profile:

                    return true;
            }
            return false;
        }
    };
    @Override
    public void onTabChanged(int tabIndex) {
        switch (tabIndex) {
            case 0:
                navigation.setSelectedItemId(R.id.navigation_home);
                break;
        }
    }
    @Override
    public void onBackPressed() {
        if (multipleStackNavigator.canGoBack()) {
            multipleStackNavigator.goBack();
        } else {
            super.onBackPressed();
        }
    }

}