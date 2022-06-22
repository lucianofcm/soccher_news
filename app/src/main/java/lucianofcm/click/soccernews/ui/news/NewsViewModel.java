package lucianofcm.click.soccernews.ui.news;

import androidx.lifecycle.LiveData;
import androidx.lifecycle.MutableLiveData;
import androidx.lifecycle.ViewModel;

import java.util.ArrayList;
import java.util.List;

import lucianofcm.click.soccernews.domain.News;

public class NewsViewModel extends ViewModel {

    private final MutableLiveData<List<News>> mnews;

    public NewsViewModel() {
        this.mnews = new MutableLiveData<>();
        List<News> newsList = new ArrayList<>();
        newsList.add(new News("Flamengo contrata cebolinha", "Lorem Ipsum "));
        newsList.add(new News("Flamengo contrata cebolinha", "Lorem Ipsum "));
        newsList.add(new News("Flamengo contrata cebolinha", "Lorem Ipsum "));
        this.mnews.setValue(newsList);
    }

    public LiveData<List<News>> getNews() {
        return mnews;
    }
}