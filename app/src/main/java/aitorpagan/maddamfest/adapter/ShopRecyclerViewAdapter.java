package aitorpagan.maddamfest.adapter;

import android.content.Context;
import android.graphics.drawable.Drawable;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import java.util.ArrayList;

import aitorpagan.maddamfest.R;


public class ShopRecyclerViewAdapter extends RecyclerView.Adapter<ShopRecyclerViewAdapter.ViewHolder>{

    private String url;
    private Context context;
    private ArrayList<Drawable> events;

    public static class ViewHolder extends RecyclerView.ViewHolder{


        public TextView mTextView;
        public ImageView mImageView;
        public ViewHolder(View v){
            super(v);
            mImageView = (ImageView) v.findViewById(R.id.ticketImage);
           // mTextView = (TextView) v.findViewById(R.id.eventName);
        }

    }


    public ShopRecyclerViewAdapter(Context context, ArrayList<Drawable> events) {
        this.context = context;
        this.events = events;
    }

    @Override
    public ShopRecyclerViewAdapter.ViewHolder onCreateViewHolder (ViewGroup parent, int viewType){
        View v = LayoutInflater.from(parent.getContext()).inflate(R.layout.cardrow_layout_shop, parent, false);
        ViewHolder vh = new ViewHolder(v);
        return vh;
    }

    public void onBindViewHolder(final ViewHolder holder, int position){
        //holder.mTextView.setText(chatList.get(position).getProjectId());
        holder.mImageView.setImageDrawable(events.get(position).getCurrent());
    }

    @Override
    public int getItemCount(){
        return this.events.size();
    }



}