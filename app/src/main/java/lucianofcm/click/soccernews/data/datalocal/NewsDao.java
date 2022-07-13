package lucianofcm.click.soccernews.data.datalocal;

import androidx.lifecycle.LiveData;
import androidx.room.Dao;
import androidx.room.Delete;
import androidx.room.Insert;
import androidx.room.OnConflictStrategy;
import androidx.room.Query;

import java.util.List;

import lucianofcm.click.soccernews.domain.News;

@Dao
public interface NewsDao {
    @Query("SELECT * FROM news")
    List<News> getAll();

    @Query("SELECT * FROM news")
    LiveData<List<News>> loadFavoritesNews();

    @Query("SELECT * FROM news WHERE uid IN (:userIds)")
    List<News> loadAllByIds(int[] userIds);

    @Query("SELECT * FROM news WHERE titulo LIKE :first LIMIT 1")
    News findByName(String first);

    @Insert(onConflict = OnConflictStrategy.REPLACE)
    void insertAll(List<News> news);

    @Insert(onConflict = OnConflictStrategy.REPLACE)
    void update(News news);

    @Delete
    void delete(News news);
}
