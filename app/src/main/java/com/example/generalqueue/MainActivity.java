package com.example.generalqueue;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;
import android.widget.Toast;

import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        EdgeToEdge.enable(this);
        setContentView(R.layout.activity_main);
        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main), (v, insets) -> {
            Insets systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars());
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom);
            return insets;
        });

        ArrayQueue queue = new ArrayQueue(50,this);

        TextView tv = findViewById(R.id.txtCapacityVal);
        tv.setText(""+queue.Capacity());
        Button btnEnQueue = findViewById(R.id.btnEnQueue);
        btnEnQueue.setOnClickListener(view -> {
            for (int i = 0; i < 10; i++) {
                queue.enqueue((int)(Math.random()*100));
            }
            Toast.makeText(this,"当前队列长度:"+queue.Count() + " 队头: "+queue.getFront() + " 队尾: "+queue.getRear(),Toast.LENGTH_LONG).show();
        });

        Button btnDequeu = findViewById(R.id.btnDeQueue);
        btnDequeu.setOnClickListener(view -> {
            for (int i = 0; i < 5; i++) {
                queue.dequeue();
            }
            Toast.makeText(this,"当前队列长度:"+queue.Count() + " 队头: "+queue.getFront() + " 队尾: "+queue.getRear(),Toast.LENGTH_LONG).show();
        });

        Button btnGetQueueCount = findViewById(R.id.btnGetQueueCount);
        btnGetQueueCount.setOnClickListener(view -> {
            Toast.makeText(this,"当前队列长度:"+queue.Count() + " 队头: "+queue.getFront() + " 队尾: "+queue.getRear(),Toast.LENGTH_LONG).show();
        });



    }
}