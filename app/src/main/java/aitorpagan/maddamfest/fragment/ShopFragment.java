package aitorpagan.maddamfest.fragment;

import android.graphics.drawable.Drawable;
import android.os.Bundle;
import android.support.design.widget.NavigationView;
import android.support.v4.app.Fragment;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import java.util.ArrayList;

import aitorpagan.maddamfest.R;
import aitorpagan.maddamfest.adapter.MainRecyclerViewAdapter;
import aitorpagan.maddamfest.adapter.RecyclerItemClickListener;
import aitorpagan.maddamfest.adapter.ShopRecyclerViewAdapter;


public class ShopFragment extends Fragment {
    private View view;
    private RecyclerView mRecyclerView;
    private RecyclerView.Adapter mAdapter;
    private RecyclerView.LayoutManager mLayoutManager;
    private ArrayList<Drawable> events;

    public ShopFragment(){}

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        view = inflater.inflate(R.layout.fragment_shop, container, false);

        final Bundle bundle = getArguments();
        events = new ArrayList<>();
        events.add(getActivity().getDrawable(R.drawable.ticket_maddam_urban));
        events.add(getActivity().getDrawable(R.drawable.ticket_maddam_cosmo));
        events.add(getActivity().getDrawable(R.drawable.ticket_maddam_sink));
        events.add(getActivity().getDrawable(R.drawable.ticket_maddam_bono));



        mRecyclerView = (RecyclerView) view.findViewById(R.id.shopfragment);
        mRecyclerView.setHasFixedSize(false);
        mLayoutManager = new LinearLayoutManager(getContext());
        mRecyclerView.setLayoutManager(mLayoutManager);
        mAdapter = new ShopRecyclerViewAdapter(this.getContext(),events);
        mRecyclerView.setAdapter(mAdapter);

        mRecyclerView.addOnItemTouchListener(new RecyclerItemClickListener(getContext(), new RecyclerItemClickListener.OnItemClickListener() {
            @Override
            public void onItemClick(View view, int position) {

            }
        }));

        return view;
    }
}
