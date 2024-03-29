package com.example.basicactivityapp;

import android.app.AlertDialog;
import android.content.DialogInterface;
import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;

import com.google.android.material.floatingactionbutton.FloatingActionButton;
import com.google.android.material.snackbar.Snackbar;

import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.Toolbar;

import android.provider.Settings;
import android.view.View;
import android.view.Menu;
import android.view.MenuItem;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        Toolbar toolbar = findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);

        FloatingActionButton fab = findViewById(R.id.fab);
        fab.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent emailIntent = new Intent(Intent.ACTION_SENDTO,
                        Uri.fromParts("mailto","@gmail.com", null));
                emailIntent.putExtra(Intent.EXTRA_SUBJECT, "Subject:");
                emailIntent.putExtra(Intent.EXTRA_TEXT, "Body:");
                startActivity(Intent.createChooser(emailIntent, "Send email..."));
            }
        });
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.menu_main, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        // Handle action bar item clicks here. The action bar will
        // automatically handle clicks on the Home/Up button, so long
        // as you specify a parent activity in AndroidManifest.xml.
        int id = item.getItemId();

        //noinspection SimplifiableIfStatement
        if (id == R.id.action_settings) {
            Toast.makeText(this, "Settings Clicked", Toast.LENGTH_SHORT).show();;
        }else if (id== R.id.action_mpesa){
            Toast.makeText(this, "M-pesa clicked", Toast.LENGTH_SHORT).show();
        }else if (id == R.id.action_exit){
//write the code to exit the app
      //      System.exit(0);

            //create an alert dialog

            AlertDialog.Builder builder = new AlertDialog.Builder(this);
            builder.setTitle("Exiting App!!!!");
            builder.setMessage("Are you sure you want to exit?");
            builder.setNegativeButton("No", new DialogInterface.OnClickListener() {
                @Override
                public void onClick(DialogInterface dialogInterface, int i) {

                }
            });
            builder.setPositiveButton("yes", new DialogInterface.OnClickListener() {
                @Override
                public void onClick(DialogInterface dialogInterface, int i) {
                    System.exit(0);
                }
            });
            builder.create().show();

        }
        return super.onOptionsItemSelected(item);
    }
}
