package frt.gurgur.instagramclone.di;

import android.app.Application;

import javax.inject.Singleton;

import dagger.BindsInstance;
import dagger.Component;
import dagger.android.AndroidInjector;
import dagger.android.support.AndroidSupportInjectionModule;
import frt.gurgur.instagramclone.di.modules.ActivityBuilder;
import frt.gurgur.instagramclone.di.modules.AppModule;
import frt.gurgur.instagramclone.di.modules.FragmentBuildersModule;
import frt.gurgur.instagramclone.di.modules.NetworkModule;
import frt.gurgur.instagramclone.di.modules.ViewModelFactoryModule;
import frt.gurgur.instagramclone.util.PreferencesHelper;

@Singleton
@Component(modules = {AndroidSupportInjectionModule.class, FragmentBuildersModule.class, AppModule.class, ViewModelFactoryModule.class, NetworkModule.class, ActivityBuilder.class})
public interface AppComponent extends AndroidInjector<App> {

    @Component.Builder
    interface Builder{

        @BindsInstance
        Builder application(Application application);
        AppComponent build();
    }
    void inject(App app);

    PreferencesHelper preferencesHelper();
}

