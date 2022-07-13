package lucianofcm.click.soccernews.repos;

import android.app.Application;

import androidx.room.Room;

import lucianofcm.click.soccernews.App;
import lucianofcm.click.soccernews.data.ApiNews;
import lucianofcm.click.soccernews.data.datalocal.AppDatabase;
import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;

public class SoccerNewsRepo extends Application {

    private static final String REMOTE_API_URL = "https://lucapi.herokuapp.com/lucapi/";
    private static final String LOCAL_DB_NAME = "newsdb";

    private final ApiNews remoteApi;
    private final AppDatabase localDb;
    private SoccerNewsRepo instance;

    public ApiNews getRemoteApi() {
        return remoteApi;
    }

    public  AppDatabase getLocalDb() {
        return localDb;
    }
    private SoccerNewsRepo () {
        remoteApi = new Retrofit.Builder()
                .baseUrl(REMOTE_API_URL)
                .addConverterFactory(GsonConverterFactory.create())
                .build()
                .create(ApiNews.class);
        localDb = Room.databaseBuilder(App.getInstance(), AppDatabase.class, LOCAL_DB_NAME).build();
    }
    public static SoccerNewsRepo getInstance() {
        return LazyHolder.INSTANCE;
    }

    private static class LazyHolder {
        private static final SoccerNewsRepo INSTANCE = new SoccerNewsRepo();
    }

    @Override
    public void onCreate() {
        super.onCreate();
         instance = getInstance();
    }
}
