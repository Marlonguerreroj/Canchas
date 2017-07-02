package ufps.edu.co.canchas;

import android.content.Context;
import android.net.Uri;
import android.os.Bundle;
import android.app.Fragment;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ExpandableListView;

import com.android.volley.Request;
import com.android.volley.RequestQueue;
import com.android.volley.Response;
import com.android.volley.VolleyError;
import com.android.volley.toolbox.JsonArrayRequest;
import com.android.volley.toolbox.JsonObjectRequest;
import com.android.volley.toolbox.Volley;
import com.google.gson.Gson;

import org.json.JSONArray;
import org.json.JSONObject;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

import ufps.edu.co.canchas.dto.CanchaDTO;
import ufps.edu.co.canchas.dto.UsuarioDTO;


/**
 * A simple {@link Fragment} subclass.
 * Activities that contain this fragment must implement the
 * {@link homeFragment.OnFragmentInteractionListener} interface
 * to handle interaction events.
 * Use the {@link homeFragment#newInstance} factory method to
 * create an instance of this fragment.
 */
public class homeFragment extends Fragment {
    // TODO: Rename parameter arguments, choose names that match
    // the fragment initialization parameters, e.g. ARG_ITEM_NUMBER
    private static final String ARG_PARAM1 = "param1";
    private static final String ARG_PARAM2 = "param2";

    private ExpandableListView expandableListView;
    private ExpandableListAdapter expandableListAdapter;
    private RequestQueue queue;
    private List<String> listDataHeader;
    private HashMap<String, Cancha> listHashMap;

    // TODO: Rename and change types of parameters
    private String mParam1;
    private String mParam2;

    private OnFragmentInteractionListener mListener;

    public homeFragment() {
        // Required empty public constructor
    }

    /**
     * Use this factory method to create a new instance of
     * this fragment using the provided parameters.
     *
     * @param param1 Parameter 1.
     * @param param2 Parameter 2.
     * @return A new instance of fragment homeFragment.
     */
    // TODO: Rename and change types and number of parameters
    public static homeFragment newInstance(String param1, String param2) {
        homeFragment fragment = new homeFragment();
        Bundle args = new Bundle();
        args.putString(ARG_PARAM1, param1);
        args.putString(ARG_PARAM2, param2);
        fragment.setArguments(args);
        return fragment;
    }

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        queue = Volley.newRequestQueue(getActivity());
        if (getArguments() != null) {
            mParam1 = getArguments().getString(ARG_PARAM1);
            mParam2 = getArguments().getString(ARG_PARAM2);
        }
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View v = inflater.inflate(R.layout.fragment_home, container, false);
        expandableListView = (ExpandableListView)v.findViewById(R.id.expList);
        initData();
        expandableListAdapter = new ExpandableListAdapter(getActivity(), listDataHeader,listHashMap);
        expandableListView.setAdapter(expandableListAdapter);


        return v;
    }

    private void initData(){
        listDataHeader = new ArrayList<>();
        listHashMap = new HashMap<>();
        JsonArrayRequest getRequest = new JsonArrayRequest(Request.Method.GET, Constant.URL_LISTAR_CANCHAS, null,
                new Response.Listener<JSONArray>()
                {
                    @Override
                    public void onResponse(JSONArray response) {
                        // display response
                        Gson g = new Gson();
                        CanchaDTO[] dto = g.fromJson(response.toString(), CanchaDTO[].class);
                        Log.i("response",response.toString());
                        int i = 0;
                        while(i< dto.length){
                            Log.i("Descripcion",dto[i].getDescripcion());
                            float valoracion = (float) dto[i].getValoracionGeneral();
                            Cancha cancha = new Cancha(dto[i].getEstablecimiento().getNombre(), "Ubicación: "+dto[i].getEstablecimiento().getCiudad(), valoracion);
                            listDataHeader.add((i+1)+"- "+cancha.getNombre());
                            listHashMap.put(listDataHeader.get(i),cancha);
                            if(i == 1 || i == 0){
                                expandableListView.expandGroup(i);
                            }
                            Log.i("add",""+i);
                            i++;
                        }
                        i=0;
                        while(i< listDataHeader.size()){
                            Log.i("ListDataHeader",listDataHeader.get(i));
                            i++;
                        }
                    }
                },
                new Response.ErrorListener()
                {
                    @Override
                    public void onErrorResponse(VolleyError error) {
                        Log.i("Error.Response", "Error: "+error.getMessage());
                    }
                }
        );
        queue.add(getRequest);






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
