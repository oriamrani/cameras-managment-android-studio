package com.example.tutorial;

import androidx.appcompat.app.AlertDialog;
import androidx.appcompat.app.AppCompatActivity;

import android.content.DialogInterface;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.ListView;
import android.widget.TableLayout;
import android.widget.TableRow;
import android.widget.TextView;
import android.widget.Toast;

import java.util.ArrayList;
import java.util.List;

public class CameraList extends AppCompatActivity {

    ListView camerasListView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_camera_list);

        final DataBaseHelper dataBaseHelper = new DataBaseHelper(this);
        final List<CameraModel> cameras = dataBaseHelper.getCameras();

        camerasListView = (ListView) findViewById(R.id.camerasListView);
        camerasListView.setAdapter(new CameraAdapter(this, cameras));


        // Set an item click listener for ListView
        camerasListView.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {

               CameraModel camera = (CameraModel) parent.getItemAtPosition(position);

                Intent intent = new Intent(CameraList.this, DisplayCamera.class);
                intent.putExtra("userName", camera.getUserName());
                intent.putExtra("ip", camera.getIpAddress());
                intent.putExtra("port",String.valueOf(camera.getPort()));
                intent.putExtra("userName", camera.getUserName());
                intent.putExtra("password", camera.getPassword());
                startActivity(intent);

            }

        });
        camerasListView.setOnItemLongClickListener(new AdapterView.OnItemLongClickListener() {
            @Override
           public boolean onItemLongClick(final AdapterView<?> adapterView, View view, int position, long l) {
                final CameraModel clickedCamera = (CameraModel) adapterView.getItemAtPosition(position);
                AlertDialog.Builder builder = new AlertDialog.Builder(CameraList.this);
                builder.setIcon(android.R.drawable.ic_delete);
                builder.setTitle("Are you sure ?");
                builder.setMessage("Do you want to delete this camera?");
                builder.setPositiveButton("Yes", new DialogInterface.OnClickListener() {
                    @Override
                    public void onClick(DialogInterface dialogInterface, int i) {
                        dataBaseHelper.deleteOne(clickedCamera.getId());
                        Toast.makeText(CameraList.this, "The camera was successfully deleted!", Toast.LENGTH_SHORT).show();
                        Intent intent = new Intent(CameraList.this, MainActivity.class);
                        startActivity(intent);
                    }
                });
                builder.setNegativeButton("No", null);
                builder.show();
                return true;
            }
       });

    }

}