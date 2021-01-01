package frt.gurgur.instagramclone.di.modules;

import javax.inject.Singleton;

import dagger.Module;
import dagger.Provides;
import frt.gurgur.instagramclone.util.Constants;
import retrofit2.Retrofit;
import retrofit2.adapter.rxjava2.RxJava2CallAdapterFactory;
import retrofit2.converter.gson.GsonConverterFactory;

@Module
public class NetworkModule {

    @Singleton
    @Provides
    static Retrofit provideRetrofitInstance() {

        return new Retrofit.Builder()
                .baseUrl(Constants.BASE_URL)
                .addCallAdapterFactory(RxJava2CallAdapterFactory.create())
                .addConverterFactory(GsonConverterFactory.create())
                .build();

    }

}