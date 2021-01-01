package frt.gurgur.instagramclone.di.modules;

import androidx.lifecycle.ViewModelProvider;

import dagger.Binds;
import dagger.Module;
import frt.gurgur.instagramclone.di.ViewModelFactory;

@Module
public abstract class ViewModelFactoryModule {

    @Binds
    public abstract ViewModelProvider.Factory bindViewModelFactory(ViewModelFactory modelProvider);


}

