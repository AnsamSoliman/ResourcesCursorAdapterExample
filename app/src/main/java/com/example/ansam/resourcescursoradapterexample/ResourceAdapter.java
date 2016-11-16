package com.example.ansam.resourcescursoradapterexample;

import android.content.Context;
import android.database.Cursor;
import android.view.View;
import android.widget.ResourceCursorAdapter;
import android.widget.TextView;

import org.w3c.dom.Text;

/**
 * Created by ansam on 11/16/2016.
 */

public class ResourceAdapter extends ResourceCursorAdapter {


    public ResourceAdapter(Context context, int layout, Cursor c, int flags) {
        super(context, layout, c, flags);
    }

    @Override
    public void bindView(View view, Context context, Cursor cursor) {
        TextView name=(TextView)view.findViewById(R.id.nameA);
        TextView email=(TextView)view.findViewById(R.id.emailA);
        name.setText(cursor.getString(cursor.getColumnIndex("name")));
        email.setText(cursor.getString(cursor.getColumnIndex("email")));

    }
}
