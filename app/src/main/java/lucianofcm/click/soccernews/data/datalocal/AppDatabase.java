package lucianofcm.click.soccernews.data.datalocal;


import androidx.room.Database;
import androidx.room.RoomDatabase;

import lucianofcm.click.soccernews.domain.News;

@Database(entities = {News.class}, version = 1)
public abstract class AppDatabase extends RoomDatabase {
    public abstract NewsDao newsDao();
}