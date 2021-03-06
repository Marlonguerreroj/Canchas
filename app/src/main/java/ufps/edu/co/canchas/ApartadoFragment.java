package ufps.edu.co.canchas;

import android.app.DatePickerDialog;
import android.app.Dialog;
import android.app.DialogFragment;
import android.content.Context;
import android.net.Uri;
import android.os.Bundle;
import android.app.Fragment;
import android.support.v7.widget.AppCompatButton;
import android.support.v7.widget.AppCompatTextView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.DatePicker;

import java.text.DateFormat;
import java.util.Calendar;
import java.util.GregorianCalendar;


/**
 * A simple {@link Fragment} subclass.
 * Activities that contain this fragment must implement the
 * {@link ApartadoFragment.OnFragmentInteractionListener} interface
 * to handle interaction events.
 * Use the {@link ApartadoFragment#newInstance} factory method to
 * create an instance of this fragment.
 */
public class ApartadoFragment extends Fragment implements View.OnClickListener {
    // TODO: Rename parameter arguments, choose names that match
    // the fragment initialization parameters, e.g. ARG_ITEM_NUMBER
    private static final String ARG_PARAM1 = "param1";
    private static final String ARG_PARAM2 = "param2";

    // TODO: Rename and change types of parameters
    private String mParam1;
    private String mParam2;
    private AppCompatButton fecha;
    private AppCompatButton apartar;
    private AppCompatButton cancelar;


    private OnFragmentInteractionListener mListener;

    public ApartadoFragment() {
        // Required empty public constructor
    }

    /**
     * Use this factory method to create a new instance of
     * this fragment using the provided parameters.
     *
     * @param param1 Parameter 1.
     * @param param2 Parameter 2.
     * @return A new instance of fragment ApartadoFragment.
     */
    // TODO: Rename and change types and number of parameters
    public static ApartadoFragment newInstance(String param1, String param2) {
        ApartadoFragment fragment = new ApartadoFragment();
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
        View v = inflater.inflate(R.layout.fragment_apartado, container, false);
        fecha = (AppCompatButton) v.findViewById(R.id.sel);
        apartar = (AppCompatButton) v.findViewById(R.id.apartar);
        cancelar = (AppCompatButton) v.findViewById(R.id.cancelar);
        fecha.setOnClickListener(this);
        apartar.setOnClickListener(this);
        cancelar.setOnClickListener(this);
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
    public void onClick(View v) {
        Fragment newFragment;
        android.app.FragmentTransaction ft;
        switch (v.getId()) {
            case R.id.sel:
                datePicker(v);
                break;
            case R.id.apartar:
                newFragment = new homeFragment();
                ft = getFragmentManager().beginTransaction();
                ft.replace(R.id.content_main, newFragment);
                ft.commit();
                break;
            case R.id.cancelar:
                newFragment = new homeFragment();
                ft = getFragmentManager().beginTransaction();
                ft.replace(R.id.content_main, newFragment);
                ft.commit();
                break;
        }

    }

    public void datePicker(View view) {

        DialogFragment fragment = new searchFragment.DatePickerFragment();
        fragment.show(getFragmentManager(), "datePicker");
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

    public static class DatePickerFragment extends DialogFragment implements DatePickerDialog.OnDateSetListener {
        @Override
        public Dialog onCreateDialog(Bundle savedInstanceState) {
            final Calendar c = Calendar.getInstance();
            int year = c.get(Calendar.YEAR);
            int month = c.get(Calendar.MONTH);
            int day = c.get(Calendar.DAY_OF_MONTH);

            return new DatePickerDialog(getActivity(), this, year, month, day);
        }

        @Override
        public void onDateSet(DatePicker view, int year, int month, int dayOfMonth) {
            Calendar cal = new GregorianCalendar(year, month, dayOfMonth);
            setDate(cal);

        }

        private void setDate(final Calendar calendar) {
            final DateFormat dateFormat = DateFormat.getDateInstance(DateFormat.MEDIUM);
            AppCompatTextView a = (AppCompatTextView) getActivity().findViewById(R.id.fecha);
            a.setText(dateFormat.format(calendar.getTime()));
        }

    }
}
