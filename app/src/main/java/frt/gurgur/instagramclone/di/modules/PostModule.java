package frt.gurgur.instagramclone.di.modules;

import javax.inject.Singleton;

import dagger.Module;
import dagger.Provides;
import frt.gurgur.instagramclone.data.remote.APIService;
import frt.gurgur.instagramclone.data.remote.repo.MainRepo;

@Module
public class PostModule {


    @Singleton
    @Provides
    static MainRepo provideMainRepo(APIService api){
        return new MainRepo(api);
    }

}
