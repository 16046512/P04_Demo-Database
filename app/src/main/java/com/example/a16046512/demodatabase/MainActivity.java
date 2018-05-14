package com.example.a16046512.demodatabase;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.ListView;
import android.widget.TextView;

import java.util.ArrayList;

public class MainActivity extends AppCompatActivity {
    Button btnInsert,btnGetTasks;
    TextView tvResults;
    ListView lv;
    ArrayAdapter aa;
    ArrayList<Task> tasks;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);



        btnInsert = (Button) findViewById(R.id.buttonInsert);
        btnGetTasks = (Button) findViewById(R.id.btnGetTasks);
        tvResults = (TextView)  findViewById(R.id.tvResults);
        lv = (ListView)findViewById(R.id.listview);

        btnInsert.setOnClickListener(new View.OnClickListener(){
            @Override
            public void onClick(View v) {
                // Create the DBHelper object, passing in the
                // activity's Context
                DBHelper db = new DBHelper(MainActivity.this);

                // Insert a task
                db.insertTask("Submit RJ", "25 Apr 2016");
                db.close();
            }
        });


        btnGetTasks.setOnClickListener(new View.OnClickListener(){
            @Override
            public void onClick(View v) {
                // Create the DBHelper object, passing in the
                // activity's Context
                DBHelper db = new DBHelper(MainActivity.this);

                // Insert a task
                ArrayList<String> data = db.getTaskContent();
                ArrayList<Task> taskdata = db.getTasks();
                db.close();

                String txt = "";
                for (int i = 0; i < data.size(); i++) {
                    Log.i("Database Content", i +". "+data.get(i));
                    txt += i + ". " + data.get(i) + "\n";
                }

                tasks = new ArrayList<Task>();
                for (int i = 0; i < taskdata.size(); i++) {
//                    Log.i("Database Content", i +". "+taskdata.get(i).getId()+taskdata.get(i).getDescription()+taskdata.get(i).getDate());

                    tasks.add(new Task(taskdata.get(i).getId(),taskdata.get(i).getDescription(),taskdata.get(i).getDate()));

                }
                aa = new TaskAdapter(MainActivity.this, R.layout.row, tasks);
                lv.setAdapter(aa);

                tvResults.setText(txt);
            }
        });
    }

}

