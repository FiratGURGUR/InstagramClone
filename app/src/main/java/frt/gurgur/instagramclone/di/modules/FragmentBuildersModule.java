package frt.gurgur.instagramclone.di.modules;

import dagger.Module;
import dagger.android.ContributesAndroidInjector;
import frt.gurgur.instagramclone.ui.main.MainFragment;


@Module(includes = {PostModule.class})
public abstract class FragmentBuildersModule {

    @ContributesAndroidInjector(modules = {ViewModelModule.class})
    abstract MainFragment mainFragment();



}