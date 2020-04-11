package com.example.recuclerview.MyAdapter;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.example.recuclerview.Model.RowModel;
import com.example.recuclerview.R;

import java.util.List;

import de.hdodenhof.circleimageview.CircleImageView;

public class Adapter extends RecyclerView.Adapter<Adapter.MyHolder>{

    Context context;
    List<RowModel> modelList ;

    public Adapter(Context context, List<RowModel> modelList) {
        this.context = context;
        this.modelList = modelList;
    }

    @NonNull
    @Override
    public MyHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(context).inflate(R.layout.row_item , parent , false);
        return new MyHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull MyHolder holder, int position) {

        String name = modelList.get(position).getName();
        String messages  = modelList.get(position).getMessage();
        int image = modelList.get(position).getImage();

        holder.name.setText(name);
        holder.message.setText(messages);
        holder.imageView.setImageResource(R.drawable.profile);

    }

    @Override
    public int getItemCount() {
        return modelList.size();
    }

    class MyHolder extends RecyclerView.ViewHolder{

        CircleImageView imageView ;
        TextView name, message ;
        public MyHolder(@NonNull View itemView) {
            super(itemView);

            imageView = itemView.findViewById(R.id.profile_image);
            name = itemView.findViewById(R.id.name);
            message = itemView.findViewById(R.id.message);


        }
    }

}
