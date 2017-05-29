package ufps.edu.co.canchas;

import android.app.Activity;
import android.app.Fragment;
import android.content.Context;
import android.graphics.Typeface;
import android.support.v7.widget.AppCompatButton;
import android.support.v7.widget.AppCompatTextView;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseExpandableListAdapter;
import android.widget.RatingBar;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

/**
 * Created by marlonguerrero on 24/05/17.
 */

public class ExpandableListAdapter extends BaseExpandableListAdapter {
    private Context context;
    private List<String> listDataHeader;
    private HashMap<String, Cancha> listHashMap;


    public ExpandableListAdapter(Context context, List<String> listDataHeader, HashMap<String, Cancha> listHashMap) {
        this.context = context;
        this.listDataHeader = listDataHeader;
        this.listHashMap = listHashMap;
    }


    @Override

    public int getGroupCount() {
        return listDataHeader.size();
    }

    @Override
    public int getChildrenCount(int groupPosition) {
        return 1;
    }

    @Override
    public Object getGroup(int groupPosition) {
        return listDataHeader.get(groupPosition);
    }

    @Override
    public Object getChild(int groupPosition, int childPosition) {
        return listHashMap.get(listDataHeader.get(groupPosition));
    }

    @Override
    public long getGroupId(int groupPosition) {
        return groupPosition;
    }

    @Override
    public long getChildId(int groupPosition, int childPosition) {
        return childPosition;
    }

    @Override
    public boolean hasStableIds() {
        return false;
    }

    @Override
    public View getGroupView(int groupPosition, boolean isExpanded, View convertView, ViewGroup parent) {
        String headerTitle = (String) getGroup(groupPosition);
        if (convertView == null) {
            LayoutInflater inflater = (LayoutInflater) this.context.getSystemService(Context.LAYOUT_INFLATER_SERVICE);
            convertView = inflater.inflate(R.layout.list_group, null);

        }
        AppCompatTextView lblListHeader = (AppCompatTextView) convertView.findViewById(R.id.lblListHeader);
        lblListHeader.setTypeface(null, Typeface.BOLD);
        lblListHeader.setText(headerTitle);
        return convertView;
    }

    @Override
    public View getChildView(int groupPosition, int childPosition, boolean isLastChild, View convertView, ViewGroup parent) {
        ViewHolder holder;
        if (convertView == null) {
            LayoutInflater inflater = (LayoutInflater) this.context.getSystemService(Context.LAYOUT_INFLATER_SERVICE);
            convertView = inflater.inflate(R.layout.list_item, null);
            holder = new ViewHolder(convertView);
            convertView.setTag(holder);
        }else{
            holder = (ViewHolder) convertView.getTag();
        }
        final Cancha c = (Cancha)getChild(groupPosition,childPosition);
        holder.ver_mas.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Log.i("as",c.getNombre());
                Activity activity = (Activity) context;
                Fragment newFragment = new ver_masFragment();
                android.app.FragmentTransaction ft = activity.getFragmentManager().beginTransaction();
                ft.replace(R.id.content_main, newFragment);
                ft.commit();
            }
        });
        holder.ratingBar.setTag(groupPosition);
        holder.ratingBar.setRating(c.getValoracion());
        holder.ciudad.setText(c.getCiudad());

        return convertView;
    }

    @Override
    public boolean isChildSelectable(int groupPosition, int childPosition) {
        return true;
    }

    private static class ViewHolder {
        private RatingBar ratingBar;
        private AppCompatTextView ciudad;
        private AppCompatButton ver_mas;



        public ViewHolder(View view) {
            ratingBar = (RatingBar) view.findViewById(R.id.lblCalificacion);
            ciudad = (AppCompatTextView) view.findViewById(R.id.lblUbicacion);
            ver_mas = (AppCompatButton) view.findViewById(R.id.verMas);
        }
    }
}
