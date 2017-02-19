package aitorpagan.maddamfest.fragment;

import android.content.Intent;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v7.widget.GridLayoutManager;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import java.util.ArrayList;

import aitorpagan.maddamfest.R;
import aitorpagan.maddamfest.adapter.RecyclerItemClickListener;
import aitorpagan.maddamfest.adapter.RecyclerViewAdapter;
import aitorpagan.maddamfest.model.ShopItem;


public class ShopListFragment extends Fragment {
    private View view;
    private RecyclerView mRecyclerView;
    private RecyclerView.Adapter mAdapter;
    private RecyclerView.LayoutManager mLayoutManager;
    private ArrayList<ShopItem> shopItems;

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        view = inflater.inflate(R.layout.fragment_shop_list, container, false);

        Bundle bundle = getArguments();
        shopItems = ShopItem.getDefaultItems();
        mRecyclerView = (RecyclerView) view.findViewById(R.id.shoplist);
        //mRecyclerView.setHasFixedSize(true);
        mLayoutManager = new GridLayoutManager(getContext(),2);
        //mLayoutManager = new LinearLayoutManager(getContext());
        mRecyclerView.setLayoutManager(mLayoutManager);
        mAdapter = new RecyclerViewAdapter(this.getContext(),shopItems);
        mRecyclerView.setAdapter(mAdapter);

        mRecyclerView.addOnItemTouchListener(new RecyclerItemClickListener(getContext(), new RecyclerItemClickListener.OnItemClickListener() {
          @Override
            public void onItemClick(View view, int position) {

            }
        }));

        return view;
    }
}
