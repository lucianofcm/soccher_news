package lucianofcm.click.soccernews.ui.favorites;

import android.os.AsyncTask;

import androidx.lifecycle.LiveData;
import androidx.lifecycle.ViewModel;

import java.util.List;

import lucianofcm.click.soccernews.domain.News;
import lucianofcm.click.soccernews.repos.SoccerNewsRepo;

public class FavoritesViewModel extends ViewModel {


    public FavoritesViewModel() {

    }

    public LiveData<List<News>> loadFavoriteNews() {
        return SoccerNewsRepo.getInstance().getLocalDb().newsDao().loadFavoritesNews();
    }

    public void saveNews(News news) {
        AsyncTask.execute(() -> SoccerNewsRepo.getInstance().getLocalDb().newsDao().update(news));
    }
}