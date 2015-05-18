package com.alkhatib.abdul.limkokwingreminder;

import android.content.Context;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import com.parse.ParseObject;
import com.parse.ParseQuery;
import com.parse.ParseQueryAdapter;
import com.parse.ParseUser;


public class Adapter extends ParseQueryAdapter<ParseObject> {

    ParseUser currentUser;

    // CONSTRUCTOR
    public Adapter(Context context) {


        super(context, new ParseQueryAdapter.QueryFactory<ParseObject>() {
            public ParseQuery create() {
                ParseQuery query = new ParseQuery("Modules");
                query.whereEqualTo("user", ParseUser.getCurrentUser());
                query.orderByDescending("createdAt");

                return query;
            }
        });
    }

    public View getItemView(final ParseObject object, View v, ViewGroup parent) {

        if (v == null) {
            v = View.inflate(getContext(), R.layout.modules_layout, null);
        }

        super.getItemView(object, v, parent);

        TextView name = (TextView) v.findViewById(R.id.moduleName);
        TextView time = (TextView) v.findViewById(R.id.timeViewer);

        String mName = object.getString("moduleName");
        name.setText(mName);

        int h = object.getInt("hour");
        int m = object.getInt("minute");

        time.setText(h+" : "+m);


        return v;
    }
}
