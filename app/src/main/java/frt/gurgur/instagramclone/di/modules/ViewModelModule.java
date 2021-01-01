package frt.gurgur.instagramclone.di.modules;

import androidx.lifecycle.ViewModel;

import dagger.Binds;
import dagger.Module;
import dagger.multibindings.IntoMap;
import frt.gurgur.instagramclone.di.keys.ViewModelKey;
import frt.gurgur.instagramclone.ui.main.MainViewModel;

@Module
public abstract class ViewModelModule {

    @Binds
    @IntoMap
    @ViewModelKey(MainViewModel.class)
    public abstract ViewModel bindMainViewModel(MainViewModel mainViewModel);


}
