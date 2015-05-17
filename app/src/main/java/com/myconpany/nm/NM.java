package com.myconpany.nm;

import android.content.Context;
import android.content.Intent;
import android.support.v7.app.ActionBarActivity;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.MenuItem;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.CalendarView;
import android.widget.EditText;
import android.widget.Spinner;
import android.widget.TextView;
import android.widget.Toast;

import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;
import java.util.GregorianCalendar;


public class NM extends ActionBarActivity
{

    public CalendarView c;
    public String date;
    public String Hour;
    public String message;
    public String Filename;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_nm);

        Button boton_nuevaActividad = (Button) findViewById(R.id.boton_pide);

        boton_nuevaActividad.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent llamadaPideDatos = new Intent(NM.this, pidedatos.class);
                startActivity(llamadaPideDatos);
            }
        });

        //Spinner1
        Spinner spinner1 = (Spinner) findViewById(R.id.spinner1);
        // Create an ArrayAdapter using the string array and a default spinner layout
        ArrayAdapter<CharSequence> adapter1 = ArrayAdapter.createFromResource(this,R.array.hours, android.R.layout.simple_spinner_item);
        // Specify the layout to use when the list of choices appears
        adapter1.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
        // Apply the adapter to the spinner
        spinner1.setAdapter(adapter1);

        //Spinner2
        Spinner spinner2 = (Spinner) findViewById(R.id.spinner2);
        // Create an ArrayAdapter using the string array and a default spinner layout
        ArrayAdapter<CharSequence> adapter2 = ArrayAdapter.createFromResource(this,R.array.minutes, android.R.layout.simple_spinner_item);
        // Specify the layout to use when the list of choices appears
        adapter2.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
        // Apply the adapter to the spinner
        spinner2.setAdapter(adapter2);

        //Spinner3
        Spinner spinner3 = (Spinner) findViewById(R.id.spinner3);
        // Create an ArrayAdapter using the string array and a default spinner layout
        ArrayAdapter<CharSequence> adapter3 = ArrayAdapter.createFromResource(this,R.array.ampm, android.R.layout.simple_spinner_item);
        // Specify the layout to use when the list of choices appears
        adapter3.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
        // Apply the adapter to the spinner
        spinner3.setAdapter(adapter3);


        Calendar();
        Text();

    }


    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        //getMenuInflater().inflate(R.menu.menu_nm, menu);
        //return true;

        MenuInflater inflater = getMenuInflater();
        inflater.inflate(R.menu.main_activity_actions, menu);
        return super.onCreateOptionsMenu(menu);
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        // Handle action bar item clicks here. The action bar will
        // automatically handle clicks on the Home/Up button, so long
        // as you specify a parent activity in AndroidManifest.xml.
        int id = item.getItemId();

        //noinspection SimplifiableIfStatement
       /* if (id == R.id.action_settings) {
            return true;
        }*/
        switch(id)
        {
            case R.id.action_done:
                //Calendar();
                Spinn();
                Text();
                Create_File();
                break;
            case R.id.action_settings:
                break;
        }

        return super.onOptionsItemSelected(item);
    }

    public void Create_File()
    {
        FileOutputStream fos=null;

        Filename=date+"/"+Hour;

       /* try
        {
            fos = openFileOutput(Filename, Context.MODE_APPEND);
            fos.write(message.getBytes());
            fos.close();
        }
        catch(FileNotFoundException e)
        {
            Toast toast = Toast.makeText(getApplicationContext(),"File Not Created", Toast.LENGTH_SHORT);
            toast.show();
        }
        catch(IOException e)
        {
            Toast toast = Toast.makeText(getApplicationContext(),"IOEsception", Toast.LENGTH_SHORT);
            toast.show();
        }*/



        Toast toast = Toast.makeText(getApplicationContext(),Filename, Toast.LENGTH_SHORT);
        toast.show();
    }

    public void Calendar()
    {
        Calendar calendar = new GregorianCalendar();

        int Year= calendar.get(Calendar.YEAR);
        int Month=calendar.get(Calendar.MONTH);
        int Day=calendar.get(Calendar.DAY_OF_MONTH);
        date=Integer.toString(Day)+"/"+Integer.toString(Month+1)+"/"+Integer.toString(Year);

        c = (CalendarView) findViewById(R.id.calendarView);
        c.setOnDateChangeListener(new CalendarView.OnDateChangeListener()
        {
            //show the selected date as a toast
            @Override
            public void onSelectedDayChange(CalendarView view, int year, int month, int day)
            {
                date = day + "/" + (month+1) + "/" + year;

            }

        });
    }

    public void Spinn()
    {
        Spinner mySpinner1=(Spinner) findViewById(R.id.spinner1);
        String text1 = mySpinner1.getSelectedItem().toString();
        int H=Integer.parseInt(text1);

        Spinner mySpinner2=(Spinner) findViewById(R.id.spinner2);
        String text2 = mySpinner2.getSelectedItem().toString();

        Spinner mySpinner3=(Spinner) findViewById(R.id.spinner3);
        String text3 = mySpinner3.getSelectedItem().toString();
        if(text3.equals("PM")|| text3.equals("pm"))
        {
            H=H+12;
            text1=Integer.toString(H);
        }

        Hour=text1+"/"+text2;
    }

    public void Text()
    {
       // EditText editText = (EditText) findViewById(R.id.editText);
        //message= editText.getText().toString();

        //TextView textview=(TextView) findViewById(R.id.TextView);
        //textview.setText(message);
    }


}
