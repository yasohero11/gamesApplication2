package com.example.youssef.gamesapplication.adaptor;

import android.content.Context;
import android.content.Intent;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.bumptech.glide.Glide;
import com.example.youssef.gamesapplication.Activity.EditGameActivity;
import com.example.youssef.gamesapplication.DataModel.GamesOld;
import com.example.youssef.gamesapplication.R;

import java.util.List;

public class Adapter extends RecyclerView.Adapter<Adapter.ViewHolder> {
    private Context mContext;
    private List<GamesOld.Game> arrayList;

    public class ViewHolder extends RecyclerView.ViewHolder {
        private ImageView imageView;
        private TextView textGameName, textGamePrice;
        private Button edit, delete;

        public ViewHolder(@NonNull View itemView) {
            super(itemView);
            imageView = itemView.findViewById(R.id.gameImage);
            textGameName = itemView.findViewById(R.id.gameName);
            textGamePrice = itemView.findViewById(R.id.gamePrice);
            edit = itemView.findViewById(R.id.editGame);
            delete = itemView.findViewById(R.id.deleteGame);
        }
    }

    public void setList(List<GamesOld.Game> list) {
        this.arrayList = list;
        notifyDataSetChanged();
    }

    public Adapter(Context context, List<GamesOld.Game> arrayList) {
        this.mContext = context;
        this.arrayList = arrayList;
    }

    @NonNull
    @Override
    public ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.game_infelator, parent, false);
        ViewHolder ViewHolder = new ViewHolder(view);
        return ViewHolder;
    }

    @Override
    public void onBindViewHolder(@NonNull ViewHolder holder, final int position) {
        GamesOld.Game game = arrayList.get(position);
        System.out.println(game.getName());
        holder.textGameName.setText("apex");
        holder.textGamePrice.setText("11");

        holder.textGameName.setText(game.getName());
        holder.textGamePrice.setText(Double.toString(game.getPrice()));
        Glide.with(mContext)
                .load(game.getImage())
                .placeholder(R.drawable.game_placeholder)
                .into(holder.imageView);


        holder.edit.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent in = new Intent(mContext, EditGameActivity.class);
                GamesOld.setModifiableGame(game);
                mContext.startActivity(in);
            }
        });

        holder.delete.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                //do your DB delete magic here

            }
        });



    }

    @Override
    public int getItemCount() {
        return arrayList.size();
    }


}