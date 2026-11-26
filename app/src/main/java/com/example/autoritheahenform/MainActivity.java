package com.example.autoritheahenform;

import android.os.Bundle;

import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;
import android.view.MotionEvent;

public class MainActivity extends AppCompatActivity {
int start_x=0;
int end_x=0;
@Override
public boolean onTouchEvent(MotionEvent event)
{
    switch (event.getAction())
    {
        case MotionEvent.ACTION_UP:
            start_x=(int)event.getX();
            break;
        case MotionEvent.ACTION_DOWN:
        {
            end_x=(int)event.getX();
            break;
        }
    }
    if(start_x!=0&&end_x!=0)
    {
        if(start_x>end_x)
        {
            setContentView(R.layout.activity_main);
        }
        else if (start_x<end_x)
        {
            setContentView(R.layout.regin);
        }
        start_x=0;
        end_x=0;
    }
    return false;
}
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
    }
}