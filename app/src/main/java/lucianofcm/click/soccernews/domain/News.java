package lucianofcm.click.soccernews.domain;

import com.google.gson.annotations.SerializedName;

public class News {

    private String titulo;
    private String descricao;
    @SerializedName("urlImagem")
    private String urlImagem;
    private String url;

    public News(String title, String description) {
        this.titulo = title;
        this.descricao = description;
    }

    public String getTitulo() {
        return titulo;
    }

    public void setTitulo(String titulo) {
        this.titulo = titulo;
    }

    public String getDescricao() {
        return descricao;
    }

    public void setDescricao(String descricao) {
        this.descricao = descricao;
    }

    public String getUrlImagem() {
        return urlImagem;
    }

    public void setUrlImagem(String urlImagem) {
        this.urlImagem = urlImagem;
    }

    public String getUrl() {
        return url;
    }

    public void setUrl(String url) {
        this.url = url;
    }

}
