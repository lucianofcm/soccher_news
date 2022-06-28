package lucianofcm.click.soccernews.data;

import java.util.List;

import lucianofcm.click.soccernews.domain.News;
import retrofit2.Call;
import retrofit2.http.GET;
import retrofit2.http.Path;

public interface ApiNews {
  @GET("news/")
  Call<List<News>> listRepos();
}