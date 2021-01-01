package frt.gurgur.instagramclone.di.modules;

import dagger.Module;
import dagger.android.ContributesAndroidInjector;
import frt.gurgur.instagramclone.MainActivity;

@Module
public abstract class ActivityBuilder {

    @ContributesAndroidInjector()
    abstract MainActivity bindMainActivity();

}