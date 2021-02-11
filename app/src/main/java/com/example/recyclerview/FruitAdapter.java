package com.example.recyclerview;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.recyclerview.widget.RecyclerView;

import java.util.List;

public class FruitAdapter extends RecyclerView.Adapter<FruitAdapter.ViewHolder>{

    private final LayoutInflater inflater;
    private final List<Fruit> fruits;

//    OnItemClickListener mItemClickListener;

    FruitAdapter(Context context, List<Fruit> fruits) {
        this.fruits = fruits;
        this.inflater = LayoutInflater.from(context);
    }
    @Override
    public FruitAdapter.ViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {

        View view = inflater.inflate(R.layout.list_item, parent, false);
        return new ViewHolder(view);
    }

    @Override
    public void onBindViewHolder(FruitAdapter.ViewHolder holder, int position) {
        Fruit fruit = fruits.get(position);
        holder.imageView.setImageResource(fruit.getImage());
        holder.nameView.setText(fruit.getName());
        holder.descriptionView.setText(fruit.getDescription());
    }

    @Override
    public int getItemCount() {
        return fruits.size();
    }

//    public void addItemClickListener(OnItemClickListener listener) {
//        mItemClickListener = listener;
//    }

    public static class ViewHolder extends RecyclerView.ViewHolder {
        final ImageView imageView;
        final TextView nameView, descriptionView;
//        final OnItemClickListener mItemClickListener;

        public ViewHolder(View view){
            super(view);
            imageView = (ImageView)view.findViewById(R.id.image);
            nameView = (TextView) view.findViewById(R.id.name);
            descriptionView = (TextView) view.findViewById(R.id.description);
//            mItemClickListener = null;
//            view.setOnClickListener(this);
        }

//        @Override
//        public void onClick(View v) {
//            if (mItemClickListener != null) {
//                mItemClickListener.onItemClick(v, getAdapterPosition());
//            }
//        }
    }

//    public interface OnItemClickListener {
//        void onItemClick(View view , int position);
//    }
//
}
