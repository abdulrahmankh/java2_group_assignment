package com.alkhatib.abdul.limkokwingreminder;

import android.app.ListFragment;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;


public class MyListFragment extends ListFragment {

    protected static Adapter myAdapter;

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        return inflater.inflate(R.layout.list_fragment,container,false);

    }

    @Override
    public void onActivityCreated(Bundle savedInstanceState) {
        super.onActivityCreated(savedInstanceState);

        myAdapter = new Adapter(getActivity());
        setListAdapter(myAdapter);
        myAdapter.loadObjects();

    }
}
