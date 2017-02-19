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


public class MainFragment extends Fragment {
    private View view;
    private RecyclerView mRecyclerView;
    private RecyclerView.Adapter mAdapter;
    private RecyclerView.LayoutManager mLayoutManager;
    private ArrayList<Drawable> events;

    public MainFragment(){}

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        view = inflater.inflate(R.layout.fragment_main, container, false);

        final Bundle bundle = getArguments();
        events = new ArrayList<>();
        events.add(getActivity().getDrawable(R.drawable.mainurban));
        events.add(getActivity().getDrawable(R.drawable.maincosmos));
        events.add(getActivity().getDrawable(R.drawable.mainsink));


        mRecyclerView = (RecyclerView) view.findViewById(R.id.mainfragment);
        mRecyclerView.setHasFixedSize(true);
        mLayoutManager = new LinearLayoutManager(getContext());
        mRecyclerView.setLayoutManager(mLayoutManager);
        mAdapter = new MainRecyclerViewAdapter(this.getContext(),events);
        mRecyclerView.setAdapter(mAdapter);

        mRecyclerView.addOnItemTouchListener(new RecyclerItemClickListener(getContext(), new RecyclerItemClickListener.OnItemClickListener() {
            @Override
            public void onItemClick(View view, int position) {
                NavigationView nav = (NavigationView) getActivity().findViewById(R.id.nav_view);
                EventFragment eventFragment;
                Bundle bundle1;
                switch (position) {
                    case 0:
                        nav.getMenu().getItem(0).setChecked(true);
                        eventFragment = new EventFragment();
                        bundle1 = new Bundle();
                        bundle1.putString("selectedEvent", "Urban");
                        eventFragment.setArguments(bundle1);
                        getActivity().getSupportFragmentManager().beginTransaction().replace(R.id.mainFrame, eventFragment).commit();
                        break;
                    case 1:
                        nav.getMenu().getItem(1).setChecked(true);
                        eventFragment = new EventFragment();
                        bundle1 = new Bundle();
                        bundle1.putString("selectedEvent", "Cosmos");
                        eventFragment.setArguments(bundle1);
                        getActivity().getSupportFragmentManager().beginTransaction().replace(R.id.mainFrame, eventFragment).commit();
                        break;
                    case 2:
                        nav.getMenu().getItem(2).setChecked(true);
                        eventFragment = new EventFragment();
                        bundle1 = new Bundle();
                        bundle1.putString("selectedEvent", "Sink");
                        eventFragment.setArguments(bundle1);
                        getActivity().getSupportFragmentManager().beginTransaction().replace(R.id.mainFrame, eventFragment).commit();
                        break;
                }
            }
        }));

        return view;
    }
}
