package com.elgendy.periodictable2020.Search;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.view.animation.AnimationUtils;
import android.widget.AdapterView;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;
import android.widget.Toast;

import androidx.cardview.widget.CardView;
import androidx.recyclerview.widget.RecyclerView;

import java.util.ArrayList;
import java.util.List;

import com.elgendy.periodictable2020.Dictionary.DictionaryHolder;
import com.elgendy.periodictable2020.R;


public class SearchAdapter extends RecyclerView.Adapter<SearchAdapter.HolderView> implements View.OnClickListener {

private List<SearchHolder> SearchHolderList;
private Context context;

    public SearchAdapter(List<SearchHolder> productlist, Context context) {
            this.SearchHolderList= productlist;
            this.context = context;
    }

    @Override
    public HolderView onCreateViewHolder(ViewGroup parent, int viewType) {
            LayoutInflater inflater = LayoutInflater.from(context);
            View view = inflater.inflate(R.layout.search_design, null);
            return new HolderView(view);
    }

    @Override
    public void onBindViewHolder(HolderView holder, final int position) {
            holder.listName.setText(SearchHolderList.get(position).getName());
            holder.listCategory.setText(SearchHolderList.get(position).getCategory());
            holder.listAtomic.setText(SearchHolderList.get(position).getAtomic());
            holder.listImage.setImageResource(SearchHolderList.get(position).getImage());
            holder.listBackground.setBackgroundResource(SearchHolderList.get(position).getBack());

                //Animation code
            holder.listImage.setAnimation(AnimationUtils.loadAnimation(context,R.anim.fade_transition_animation));
            holder.container2.setAnimation(AnimationUtils.loadAnimation(context,R.anim.fade_scale_animation));

    }

    @Override
    public int getItemCount() {
            return SearchHolderList.size();
    }

    public void setFilter(List<SearchHolder> listitem) {
            SearchHolderList=new ArrayList<>();
            SearchHolderList.addAll(listitem);
            notifyDataSetChanged();
    }

    @Override
    public void onClick(View view) {

    }

    static class HolderView extends RecyclerView.ViewHolder {

        TextView listName, listCategory, listAtomic;
        ImageView listImage;
        LinearLayout container2;
        CardView listBackground;

        public HolderView(View itemView) {
            super(itemView);

            listImage = itemView.findViewById(R.id.list_imageView);

            listAtomic = itemView.findViewById(R.id.list_atomic);
            listName = itemView.findViewById(R.id.list_name);
            listCategory = itemView.findViewById(R.id.list_category);
            container2 = itemView.findViewById(R.id.container2);
            listBackground =  itemView.findViewById(R.id.list_background);

        }
    }
}
