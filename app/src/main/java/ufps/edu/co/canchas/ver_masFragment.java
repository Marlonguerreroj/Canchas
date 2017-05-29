package ufps.edu.co.canchas;

import android.content.Context;

import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.app.Fragment;
import android.support.v7.widget.AppCompatButton;
import android.support.v7.widget.AppCompatImageButton;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.view.animation.Animation;
import android.view.animation.AnimationUtils;
import android.widget.ImageSwitcher;
import android.widget.ImageView;
import android.widget.ViewSwitcher;

/**
 * A simple {@link Fragment} subclass.
 * Activities that contain this fragment must implement the
 * {@link ver_masFragment.OnFragmentInteractionListener} interface
 * to handle interaction events.
 * Use the {@link ver_masFragment#newInstance} factory method to
 * create an instance of this fragment.
 */
public class ver_masFragment extends Fragment {
    // TODO: Rename parameter arguments, choose names that match
    // the fragment initialization parameters, e.g. ARG_ITEM_NUMBER
    private static final String ARG_PARAM1 = "param1";
    private static final String ARG_PARAM2 = "param2";


    // TODO: Rename and change types of parameters
    private String mParam1;
    private String mParam2;

    private Integer[] images = {R.drawable.image1, R.drawable.image2, R.drawable.image3};
    private ImageSwitcher imageSwitcher;
    private AppCompatImageButton back;
    private AppCompatImageButton mapa;
    private AppCompatImageButton next;
    private AppCompatButton volver;
    private AppCompatButton apartar;
    private int i = 0;

    private OnFragmentInteractionListener mListener;

    public ver_masFragment() {
        // Required empty public constructor
    }

    /**
     * Use this factory method to create a new instance of
     * this fragment using the provided parameters.
     *
     * @param param1 Parameter 1.
     * @param param2 Parameter 2.
     * @return A new instance of fragment ver_masFragment.
     */
    // TODO: Rename and change types and number of parameters
    public static ver_masFragment newInstance(String param1, String param2) {
        ver_masFragment fragment = new ver_masFragment();
        Bundle args = new Bundle();
        args.putString(ARG_PARAM1, param1);
        args.putString(ARG_PARAM2, param2);
        fragment.setArguments(args);
        return fragment;
    }

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        if (getArguments() != null) {
            mParam1 = getArguments().getString(ARG_PARAM1);
            mParam2 = getArguments().getString(ARG_PARAM2);
        }
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View v = inflater.inflate(R.layout.fragment_ver_mas, container, false);
        imageSwitcher = (ImageSwitcher) v.findViewById(R.id.imageSwicher);
        back = (AppCompatImageButton) v.findViewById(R.id.back);
        next = (AppCompatImageButton) v.findViewById(R.id.next);
        mapa = (AppCompatImageButton) v.findViewById(R.id.mapa);
        mapa.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(getActivity(), Map_Activity.class);
                startActivity(intent);
            }
        });
        volver = (AppCompatButton)v.findViewById(R.id.volver);
        apartar = (AppCompatButton)v.findViewById(R.id.apartar);
        volver.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Fragment newFragment = new homeFragment();
                android.app.FragmentTransaction ft = getFragmentManager().beginTransaction();
                ft.replace(R.id.content_main, newFragment);
                ft.commit();
            }
        });
        apartar.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Fragment newFragment = new ApartadoFragment();
                android.app.FragmentTransaction ft = getFragmentManager().beginTransaction();
                ft.replace(R.id.content_main, newFragment);
                ft.commit();
            }
        });

        imageSwitcher.setFactory(new ViewSwitcher.ViewFactory() {
            @Override
            public View makeView() {
                ImageView imageView = new ImageView(getActivity().getApplicationContext());
                imageView.setScaleType(ImageView.ScaleType.CENTER_INSIDE);
                imageView.setLayoutParams(new ImageSwitcher.LayoutParams(ViewGroup.LayoutParams.MATCH_PARENT, ViewGroup.LayoutParams.MATCH_PARENT));
                return imageView;

            }
        });

        Animation in = AnimationUtils.loadAnimation(getActivity().getApplicationContext(), R.anim.in);
        Animation out = AnimationUtils.loadAnimation(getActivity().getApplicationContext(), R.anim.out);

        imageSwitcher.setImageResource(images[0]);

        back.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Animation in = AnimationUtils.loadAnimation(getActivity().getApplicationContext(), R.anim.in);
                Animation out = AnimationUtils.loadAnimation(getActivity().getApplicationContext(), R.anim.out);
                imageSwitcher.setInAnimation(in);
                imageSwitcher.setOutAnimation(out);
                i--;
                if (i < 0) {
                    i = images.length - 1;
                }

                imageSwitcher.setImageResource(images[i]);


            }
        });

        next.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Animation in = AnimationUtils.loadAnimation(getActivity().getApplicationContext(), R.anim.in2);
                Animation out = AnimationUtils.loadAnimation(getActivity().getApplicationContext(), R.anim.out2);
                imageSwitcher.setInAnimation(in);
                imageSwitcher.setOutAnimation(out);
                i++;
                if(i== images.length){
                    i= 0;
                }
                imageSwitcher.setImageResource(images[i]);

            }
        });


        return v;
    }


    // TODO: Rename method, update argument and hook method into UI event
    public void onButtonPressed(Uri uri) {
        if (mListener != null) {
            mListener.onFragmentInteraction(uri);
        }
    }

    @Override
    public void onAttach(Context context) {
        super.onAttach(context);
        if (context instanceof OnFragmentInteractionListener) {
            mListener = (OnFragmentInteractionListener) context;
        } else {
            throw new RuntimeException(context.toString()
                    + " must implement OnFragmentInteractionListener");
        }
    }

    @Override
    public void onDetach() {
        super.onDetach();
        mListener = null;
    }

    @Override
    public void onViewCreated(View view, Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);

        //MapFragment mapFragment = (MapFragment) getChildFragmentManager().findFragmentById(R.id.map);
        //mapFragment.getMapAsync(this);

    }

    //@Override
    //public void onMapReady(GoogleMap googleMap) {
    /**mMap = googleMap;
     LatLng BOMBONERA = new LatLng(7.899444, -72.490921);

     //mMap.moveCamera(CameraUpdateFactory.newLatLngZoom(BOMBONERA, 15));
     mMap.animateCamera(CameraUpdateFactory.zoomIn());
     mMap.animateCamera(CameraUpdateFactory.zoomTo(10), 2000, null);
     CameraPosition cameraPosition = new CameraPosition.Builder()
     .target(BOMBONERA)
     .zoom(17)
     .bearing(90)
     .tilt(0)
     .build();
     mMap.animateCamera(CameraUpdateFactory.newCameraPosition(cameraPosition));
     mMap.addMarker(new MarkerOptions().title("La Bombonera").position(BOMBONERA));**/


//    }

    /**
     * This interface must be implemented by activities that contain this
     * fragment to allow an interaction in this fragment to be communicated
     * to the activity and potentially other fragments contained in that
     * activity.
     * <p>
     * See the Android Training lesson <a href=
     * "http://developer.android.com/training/basics/fragments/communicating.html"
     * >Communicating with Other Fragments</a> for more information.
     */
    public interface OnFragmentInteractionListener {
        // TODO: Update argument type and name
        void onFragmentInteraction(Uri uri);
    }
}
