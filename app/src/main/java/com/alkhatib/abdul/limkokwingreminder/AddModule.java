package com.alkhatib.abdul.limkokwingreminder;

import android.app.Activity;
import android.app.Dialog;
import android.app.DialogFragment;
import android.app.TimePickerDialog;
import android.os.Bundle;
import android.text.format.DateFormat;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.TimePicker;
import android.widget.Toast;

import com.parse.ParseObject;
import com.parse.ParseUser;

import java.util.Calendar;


public class AddModule extends Activity {

    EditText moduleHere;
    Button save,time;
    static TextView timeC;

    public static int userHour;
    public static int userMinutes;
    ParseObject module;
    ParseUser currentUser;
    static String check;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.add);

        moduleHere = (EditText)findViewById(R.id.textView);
        timeC = (TextView)findViewById(R.id.timeContainer);

        check = timeC.getText().toString();
        currentUser = ParseUser.getCurrentUser();
    }

    public void showTimePicker(View view) {
        DialogFragment newFragment = new TimePickerFragment();
        newFragment.show(getFragmentManager(), "timePicker");


    }

    public void save(View view) {
        // check if fields are filled
        if(moduleHere.length() == 0 || check.equals("")){
            Toast.makeText(AddModule.this,"you have not set the fields",Toast.LENGTH_SHORT).show();
            return;
        }else{

            String s = moduleHere.getText().toString();
            module = new ParseObject("Modules");
            module.put("moduleName",s);
            module.put("hour",userHour);
            module.put("minute",userMinutes);
            module.put("user",currentUser);
            module.saveInBackground();

            //Intent i = new Intent(this,HomePage.class);
            //startActivity(i);
            finish();

        }

    }



    public static class TimePickerFragment extends DialogFragment
            implements TimePickerDialog.OnTimeSetListener {

        @Override
        public Dialog onCreateDialog(Bundle savedInstanceState) {
            // Use the current time as the default values for the picker
            final Calendar c = Calendar.getInstance();
            int hour = c.get(Calendar.HOUR_OF_DAY);
            int minute = c.get(Calendar.MINUTE);

            // Create a new instance of TimePickerDialog and return it
            return new TimePickerDialog(getActivity(), this, hour, minute,
                    DateFormat.is24HourFormat(getActivity()));
        }

        public void onTimeSet(TimePicker view, int hourOfDay, int minute) {
            // Do something with the time chosen by the user
            userHour = hourOfDay;
            userMinutes = minute;

            // show the time
            timeC.setText(hourOfDay+" : "+minute);
            check = "asd";
        }
    }


}
