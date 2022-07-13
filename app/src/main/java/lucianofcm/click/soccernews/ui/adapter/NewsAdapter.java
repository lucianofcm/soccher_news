package lucianofcm.click.soccernews.ui.adapter;

import android.content.Context;
import android.content.Intent;
import android.net.Uri;
import android.view.LayoutInflater;
import android.view.ViewGroup;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.squareup.picasso.Picasso;

import java.util.List;

import lucianofcm.click.soccernews.R;
import lucianofcm.click.soccernews.databinding.NewsItemBinding;
import lucianofcm.click.soccernews.domain.News;

public class NewsAdapter extends RecyclerView.Adapter<NewsAdapter.ViewHolder> {
    private final FavoriteListener favoritesListener;
    private final List<News> listNews;

    public NewsAdapter(List<News> listNews, FavoriteListener favoritesListener) {
        this.listNews = listNews;
        this.favoritesListener = favoritesListener;
    }


    @NonNull
    @Override
    public NewsAdapter.ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        LayoutInflater layoutInflater = LayoutInflater.from(parent.getContext());
        NewsItemBinding binding = NewsItemBinding.inflate(layoutInflater, parent, false);
        return new ViewHolder(binding);
    }

    @Override
    public void onBindViewHolder(@NonNull NewsAdapter.ViewHolder holder, int position) {
        Context context = holder.itemView.getContext();
        News news = this.listNews.get(position);
        holder.binding.tvTitulo.setText(news.titulo);
        holder.binding.tvDescricao.setText(news.descricao);
        Picasso.get().load(news.urlImagem)
                .fit()
                .centerCrop()
                .into(holder.binding.ivThumbMail);
        holder.binding.btnOpenLink.setOnClickListener(view -> {
            holder.itemView.getContext().startActivity(new Intent(Intent.ACTION_VIEW,
                    Uri.parse(news.url)));
        });

        holder.binding.ivFavorites.setOnClickListener(view -> {
            news.favorito = !news.favorito;
            this.favoritesListener.onFavorite(news);
            notifyItemChanged(position);
        });

        holder.binding.ivShare.setOnClickListener(view -> {
            Intent sendIntent = new Intent(Intent.ACTION_SEND);
            sendIntent.putExtra(Intent.EXTRA_TEXT, news.url);
            sendIntent.setType("text/plain");
            holder.itemView.getContext().startActivity(Intent.createChooser(sendIntent,  "Compartilhando via"));
        });

        if (news.favorito) {
            holder.binding.ivFavorites.setColorFilter(context.getResources().getColor(R.color.red));
        } else {
            holder.binding.ivFavorites.setColorFilter(context.getResources().getColor(R.color.black));
        }
    }

    @Override
    public int getItemCount() {
        return this.listNews.size();
    }

    public static class ViewHolder extends RecyclerView.ViewHolder {

        private final NewsItemBinding binding;

        public ViewHolder(NewsItemBinding binding) {
            super(binding.getRoot());
            this.binding = binding;
        }
    }

    public interface FavoriteListener {
        void onFavorite(News news);
    }
}
