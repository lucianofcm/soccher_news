package lucianofcm.click.soccernews.ui.news;

import androidx.lifecycle.LiveData;
import androidx.lifecycle.MutableLiveData;
import androidx.lifecycle.ViewModel;

import java.util.ArrayList;
import java.util.List;

import lucianofcm.click.soccernews.data.ApiNews;
import lucianofcm.click.soccernews.domain.News;
import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;
import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;

public class NewsViewModel extends ViewModel {

    private final MutableLiveData<List<News>> mnews = new MutableLiveData<>();
    private final ApiNews api;

    public NewsViewModel() {
        Retrofit retrofit = new Retrofit.Builder()
                .baseUrl("https://lucapi.herokuapp.com/lucapi/")
                .addConverterFactory(GsonConverterFactory.create())
                .build();
        api = retrofit.create(ApiNews.class);
        this.findNews();
    }

    private void findNews() {
        Call<List<News>> repos = api.listRepos();

        repos.enqueue(new Callback<List<News>>() {
            @Override
            public void onResponse(Call<List<News>> call, Response<List<News>> response) {
                if (response.isSuccessful()) {
                    mnews.setValue(response.body());
                } else {
                    //TODO Pensar em um estratégia de erro.
                }
            }

            @Override
            public void onFailure(Call<List<News>> call, Throwable t) {
                System.out.println("Erro");
            }
        });
    }

    public LiveData<List<News>> getNews() {
        return mnews;
    }
}