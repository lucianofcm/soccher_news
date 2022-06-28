package lucianofcm.click.soccernews.ui.adapter;

import android.view.LayoutInflater;
import android.view.ViewGroup;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.squareup.picasso.Picasso;

import java.util.List;

import lucianofcm.click.soccernews.databinding.NewsItemBinding;
import lucianofcm.click.soccernews.domain.News;

public class NewsAdapter extends RecyclerView.Adapter<NewsAdapter.ViewHolder> {

    public NewsAdapter(List<News> listNews) {
        this.listNews = listNews;
    }

    private List<News> listNews;

    @NonNull
    @Override
    public NewsAdapter.ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        LayoutInflater layoutInflater = LayoutInflater.from(parent.getContext());
        NewsItemBinding binding = NewsItemBinding.inflate(layoutInflater, parent, false);
        return new ViewHolder(binding);
    }

    @Override
    public void onBindViewHolder(@NonNull NewsAdapter.ViewHolder holder, int position) {
        News news = this.listNews.get(position);
        holder.binding.tvTitulo.setText(news.getTitulo());
        holder.binding.tvDescricao.setText(news.getDescricao());
        Picasso.get().load(news.getUrlImagem())
                .fit()
                .centerCrop()
                .into(holder.binding.ivThumbMail);
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
}
