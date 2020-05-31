package com.example.recuclerview.MyAdapter;

import android.content.Context;
import android.content.Intent;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Filter;
import android.widget.Filterable;
import android.widget.TextView;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.example.recuclerview.HomeActivity;
import com.example.recuclerview.Model.RowModel;
import com.example.recuclerview.R;

import java.util.ArrayList;
import java.util.List;

import de.hdodenhof.circleimageview.CircleImageView;

public class Adapter extends RecyclerView.Adapter<Adapter.MyHolder> implements Filterable {

    Context context;
    List<RowModel> modelList ;
    List<RowModel> modelListFilter ;

    public Adapter(Context context, List<RowModel> modelList) {
        this.context = context;
        this.modelList = modelList;
        this.modelListFilter = modelList ;
    }

    @NonNull
    @Override
    public MyHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(context).inflate(R.layout.row_item , parent , false);
        return new MyHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull MyHolder holder, int position) {

        String name = modelListFilter.get(position).getName();
        String messages  = modelListFilter.get(position).getMessage();
        int image = modelListFilter.get(position).getImage();

        holder.name.setText(name);
        holder.message.setText(messages);
        holder.imageView.setImageResource(R.drawable.profile);

    }

    @Override
    public int getItemCount() {
        return modelListFilter.size();
    }

    @Override
    public Filter getFilter() {
        return new Filter() {
            @Override
            protected FilterResults performFiltering(CharSequence constraint) {
                String charcater = constraint.toString();
                if (charcater.isEmpty()){
                    modelListFilter = modelList ;
                }else {
                    List<RowModel> filterList = new ArrayList<>();
                    for (RowModel row: modelList){
                        if (row.getName().toLowerCase().contains(charcater.toLowerCase())){
                            filterList.add(row);
                        }
                    }

                    modelListFilter = filterList ;
                }
                FilterResults filterResults = new FilterResults();
                filterResults.values = modelListFilter;
                return filterResults;
            }

            @Override
            protected void publishResults(CharSequence constraint, FilterResults results) {
                modelListFilter = (ArrayList<RowModel>) results.values ;
                notifyDataSetChanged();
            }
        };
    }


    class MyHolder extends RecyclerView.ViewHolder  implements  View.OnClickListener{

        CircleImageView imageView ;
        TextView name, message ;
        public MyHolder(@NonNull View itemView) {
            super(itemView);

            imageView = itemView.findViewById(R.id.profile_image);
            name = itemView.findViewById(R.id.name);
            message = itemView.findViewById(R.id.message);
            itemView.setOnClickListener(this);
        }

        @Override
        public void onClick(View v) {
            int postion = getAdapterPosition();
            Toast.makeText(context, "postion"+postion, Toast.LENGTH_SHORT).show();
            Intent intent = new Intent(context , HomeActivity.class);
            intent.putExtra("name" , modelListFilter.get(postion).getName());
            context.startActivity(intent);

        }
    }

}
