package aitorpagan.maddamfest.adapter;

import android.content.Context;
import android.graphics.Color;
import android.graphics.drawable.Drawable;
import android.os.Environment;
import android.support.v4.util.CircularArray;
import android.support.v7.widget.CardView;
import android.support.v7.widget.RecyclerView;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import java.io.File;
import java.lang.reflect.Array;
import java.util.ArrayList;

import aitorpagan.maddamfest.R;
import aitorpagan.maddamfest.model.ShopItem;


public class RecyclerViewAdapter extends RecyclerView.Adapter<RecyclerViewAdapter.ViewHolder>{

    private String url;
    private Context context;
    private ArrayList<ShopItem> shopItems;

    public static class ViewHolder extends RecyclerView.ViewHolder{

        public TextView mTextView;
        public TextView mDescView;
        public ImageView mImageView;
        public TextView mPriceView;
        public CardView cardView;
        public int[] colors;


        public ViewHolder(View v){
            super(v);

            mTextView = (TextView) v.findViewById(R.id.itemName);
            mDescView = (TextView) v.findViewById(R.id.itemDescription);
            mPriceView = (TextView) v.findViewById(R.id.itemPrice);
            mImageView = (ImageView) v.findViewById(R.id.itemImage);
            cardView = (CardView) v.findViewById(R.id.card_view);
            colors = new int[4];
            colors[0] = R.color.urbanColor;
            colors[1] = R.color.cosmosColor;
            colors[2] = R.color.sinkColor;
            colors[3] = R.color.fourthColor;
        }

    }


    public RecyclerViewAdapter(Context context, ArrayList<ShopItem> shopItems) {
        this.context = context;
        this.shopItems = shopItems;
    }

    @Override
    public RecyclerViewAdapter.ViewHolder onCreateViewHolder (ViewGroup parent, int viewType){
        View v = LayoutInflater.from(parent.getContext()).inflate(R.layout.cardrow_layout, parent, false);
        ViewHolder vh = new ViewHolder(v);
        return vh;
    }

    public void onBindViewHolder(final ViewHolder holder, int position){
        //holder.mTextView.setText(chatList.get(position).getProjectId());
        holder.cardView.setCardBackgroundColor(context.getResources().getColor(holder.colors[position%4]));
        holder.mImageView.setImageResource(shopItems.get(position).getPhoto());
        holder.mPriceView.setText(shopItems.get(position).getPrice());
        holder.mDescView.setText(shopItems.get(position).getDescription());
        holder.mTextView.setText(shopItems.get(position).getName());
    }

    @Override
    public int getItemCount(){
        return this.shopItems.size();
    }



}