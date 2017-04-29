package com.atidon.trackit;

import android.content.Context;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Spinner;
import android.widget.TextView;
import android.widget.Toast;


public class AddNewTask extends AppCompatActivity {


    Task task;
    Spinner spinner;
    EditText title;
    EditText discription;
    Button btn;
    DataProvider dataProvider;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.add_new_task);
        dataProvider = new DataProvider(this);

        spinner = (Spinner) findViewById(R.id.spinner);
        title = (EditText) findViewById(R.id.editText);
        discription = (EditText) findViewById(R.id.editText2);
        btn = (Button) findViewById(R.id.button2);
        btn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if(title.getText().toString().matches("") | discription.getText().toString().matches("")){
                    Context context = getApplicationContext();
                    CharSequence text = "Please enter all fields";
                    int duration = Toast.LENGTH_SHORT;

                    Toast toast = Toast.makeText(context, text, duration);
                    toast.show();

                }else{
                    task = new Task(title.getText().toString(), discription.getText().toString(), spinner.getSelectedItemPosition(), "TO DO");
                    dataProvider.insertTask(task);
                    setResult(AddNewTask.RESULT_OK);
                    finish();
                }


            }
        });
        }

}
