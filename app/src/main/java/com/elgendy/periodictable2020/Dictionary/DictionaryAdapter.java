package com.elgendy.periodictable2020.Dictionary;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.view.animation.AnimationUtils;
import android.widget.LinearLayout;
import android.widget.TextView;
import androidx.recyclerview.widget.RecyclerView;
import java.util.ArrayList;
import java.util.List;

import com.elgendy.periodictable2020.R;

public class DictionaryAdapter extends RecyclerView.Adapter<DictionaryAdapter.Holderview> {

    private List<DictionaryHolder> DictionaryHolderList;
    private Context context;

    public DictionaryAdapter(List<DictionaryHolder> productlist, Context context) {
        this.DictionaryHolderList = productlist;
        this.context = context;
    }

    @Override
    public Holderview onCreateViewHolder(ViewGroup parent, int viewType) {
        LayoutInflater inflater = LayoutInflater.from(context);
        View view = inflater.inflate(R.layout.dictionary_design, null);
        return new Holderview(view);
    }

    @Override
    public void onBindViewHolder(Holderview holder, final int position) {
        holder.txtName.setText(DictionaryHolderList.get(position).getName());
        holder.txtDescription.setText(DictionaryHolderList.get(position).getDescription());

        //Animation code
        holder.container.setAnimation(AnimationUtils.loadAnimation(context,R.anim.fade_scale_animation));
    }

    @Override
    public int getItemCount() {
        return DictionaryHolderList.size();
    }

    public void setfilter(List<DictionaryHolder> listitem) {
        DictionaryHolderList=new ArrayList<>();
        DictionaryHolderList.addAll(listitem);
        notifyDataSetChanged();
    }

    static class Holderview extends RecyclerView.ViewHolder {

        TextView txtName, txtDescription;
        LinearLayout container;


        public Holderview(View itemView) {
            super(itemView);

            txtName = itemView.findViewById(R.id.txtDictionary);
            txtDescription = itemView.findViewById(R.id.txtDictionary2);
            container = itemView.findViewById(R.id.container);

        }
    }
}
