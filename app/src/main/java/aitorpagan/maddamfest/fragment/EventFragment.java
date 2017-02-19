package aitorpagan.maddamfest.fragment;

import android.graphics.drawable.Drawable;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;

import com.google.android.gms.maps.CameraUpdate;
import com.google.android.gms.maps.CameraUpdateFactory;
import com.google.android.gms.maps.GoogleMap;
import com.google.android.gms.maps.OnMapReadyCallback;
import com.google.android.gms.maps.SupportMapFragment;
import com.google.android.gms.maps.model.LatLng;
import com.google.android.gms.maps.model.MarkerOptions;

import aitorpagan.maddamfest.R;



public class EventFragment extends Fragment implements OnMapReadyCallback {
    // TODO: Rename parameter arguments, choose names that match
    // the fragment initialization parameters, e.g. ARG_ITEM_NUMBER
    private static final String ARG_PARAM1 = "param1";
    private static final String ARG_PARAM2 = "param2";

    private GoogleMap mMap;
    private LatLng latLng;

    // TODO: Rename and change types of parameters
    private String mParam1;
    private String mParam2;

    public EventFragment() {
        // Required empty public constructor
    }

    private View view;
    private Drawable image;
    private String fechaevento;
    private String lugarevento;
    private String artistasevento;

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment

        view = inflater.inflate(R.layout.fragment_event, container, false);

        Bundle bundle = getArguments();
        mParam1 = bundle.getString("selectedEvent");
        switch (mParam1){
            case "Cosmos":
                chargeCosmosEvent();
                view.setBackgroundColor(getResources().getColor(R.color.cosmosColor));
                break;
            case "Urban":
                chargeUrbanEvent();
                view.setBackgroundColor(getResources().getColor(R.color.urbanColor));
                break;
            case "Sink":
                chargeSinkEvent();
                view.setBackgroundColor(getResources().getColor(R.color.sinkColor));
                break;

        }

        TextView fechatextView = (TextView) view.findViewById(R.id.fechaevento);
        fechatextView.setText(fechaevento);
        TextView lugartextView = (TextView) view.findViewById(R.id.lugarevento);
        lugartextView.setText(lugarevento);
        ImageView imageView = (ImageView) view.findViewById(R.id.eventFragmentImage);
        imageView.setImageDrawable(image);
        TextView artistastextView = (TextView) view.findViewById(R.id.artistsText);
        artistastextView.setText(artistasevento);
        SupportMapFragment mapFragment = (SupportMapFragment) getChildFragmentManager().findFragmentById(R.id.map);// view.findViewById(R.id.map);
        mapFragment.getMapAsync(this);
        return view;
    }

    private void chargeSinkEvent() {
        artistasevento = "FANGORIA, THE 5,6,7,8'S, \n PUSSY RIOT";
        lugarevento = "Teatro Barceló";
        fechaevento = "30/07/2016";
        image = getActivity().getDrawable(R.drawable.maddam_sink);
        latLng = new LatLng(40.426929,-3.7020107);

    }

    private void chargeUrbanEvent() {
        artistasevento = "SHE & HIM, THE XX, \n DAUGHTER";
        lugarevento = "Sala Riviera";
        fechaevento = "30/07/2016";
        image = getActivity().getDrawable(R.drawable.maddam_urban);
        latLng = new LatLng(40.4130448,-3.724367);
    }

    private void chargeCosmosEvent() {
        artistasevento = "BJÖRK, M.I.A, \n YEAH YEAH YEAHS";
        lugarevento = "Sala Joy Eslava";
        fechaevento = "30/07/2016";
        image = getActivity().getDrawable(R.drawable.maddam_cosmo);
        latLng = new LatLng(40.4172949,-3.7076513);
    }


    @Override
    public void onMapReady(GoogleMap googleMap) {
        mMap = googleMap;
        LatLng placePosition = latLng;
        mMap.addMarker(new MarkerOptions().position(placePosition).title(lugarevento));
        CameraUpdate cameraUpdate = CameraUpdateFactory.newLatLngZoom(placePosition, 15);
        mMap.animateCamera(cameraUpdate);
        mMap.getUiSettings().setZoomControlsEnabled(true);
        mMap.getUiSettings().setZoomGesturesEnabled(false);
        mMap.getUiSettings().setMapToolbarEnabled(true);
    }
}
