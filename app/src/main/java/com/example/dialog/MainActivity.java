package com.example.dialog;

import androidx.appcompat.app.AppCompatActivity;

import android.app.Dialog;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.view.Window;
import android.widget.Button;
import android.widget.CheckBox;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {

    Button bt_dialog;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        bt_dialog = findViewById(R.id.bt_dialog);

        bt_dialog.setOnClickListener(new View.OnClickListener(){
            @Override
            public void onClick(View view){
                showDialog();
            }
        });

    }

    void showDialog(){
        final Dialog dialog = new Dialog(MainActivity.this);
        //We have added a title in the custom layout. So let's disable the default title.
        dialog.requestWindowFeature(Window.FEATURE_NO_TITLE);
        //The user will be able to cancel the dialog bu clicking anywhere outside the dialog.
        dialog.setCancelable(true);
        //Mention the name of the layout of your custom dialog.
        dialog.setContentView(R.layout.main_layout);

        //Initializing the views of the dialog.
        final CheckBox cbGunars = dialog.findViewById(R.id.cb_gunars);
        final CheckBox cbJanis = dialog.findViewById(R.id.cb_janis);
        final CheckBox cbNormunds = dialog.findViewById(R.id.cb_normunds);
        Button okButton = dialog.findViewById(R.id.bt_ok_dialog);
        Button closeButton = dialog.findViewById(R.id.bt_close_dialog);

        closeButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Toast.makeText(MainActivity.this,"You closed dialog",Toast.LENGTH_LONG).show();
                dialog.dismiss();
            }
        });

        okButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Toast.makeText(MainActivity.this,"You clicked OK",Toast.LENGTH_LONG).show();
            }
        });

        cbGunars.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if(cbGunars.isChecked()) {
                    Toast.makeText(MainActivity.this, "Gunārs Božis checked!", Toast.LENGTH_SHORT).show();
                }else{
                    Toast.makeText(MainActivity.this, "Gunārs Božis unchecked!", Toast.LENGTH_SHORT).show();
                }
            }
        });

        cbJanis.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if(cbJanis.isChecked()) {
                    Toast.makeText(MainActivity.this, "Jānis Jansons checked!", Toast.LENGTH_SHORT).show();
                }else{
                    Toast.makeText(MainActivity.this, "Jānis Jansons unchecked!", Toast.LENGTH_SHORT).show();
                }
            }
        });

        cbNormunds.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if(cbNormunds.isChecked()) {
                    Toast.makeText(MainActivity.this, "Normunds Vējiņš checked!", Toast.LENGTH_SHORT).show();
                }else{
                    Toast.makeText(MainActivity.this, "Normunds Vējiņš unchecked!", Toast.LENGTH_SHORT).show();
                }
            }
        });


        dialog.show();
    }

    public void toScnd(View view) {
        Intent intent = new Intent(this, SecondActivity.class);
        startActivity(intent);
    }
}