package lucianofcm.click.soccernews.domain;

import androidx.room.Entity;
import androidx.room.PrimaryKey;

@Entity
public class News {

    @PrimaryKey
    public int uid;
    public String titulo;
    public String descricao;
    public String urlImagem;
    public String url;
    public Boolean favorito = false;
}
