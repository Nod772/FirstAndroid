package com.example.pr2;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        Intent intent = getIntent();

    }

    private Double getDouble(Double x, Double y, Double a) {
        Intent intent = getIntent();
        Double D = (Math.cos(Math.pow(x, 3) + 6) - Math.sin(y - a)) / (Math.log1p(Math.pow(x, 4)) - 2 * Math.pow(Math.sin(x), 5));
        String message = intent.getStringExtra("message");
        return D;
    }

    // Метод обработки нажатия на кнопку
    public void sendMessage(View view) {
        // действия, совершаемые после нажатия на кнопку
        // Создаем объект Intent для вызова новой Activity
        Intent intent = new Intent(this, MainActivity.class);

        EditText textX = (EditText) findViewById(R.id.editText_x);
        Double x = Double.parseDouble(textX.getText().toString());
        EditText textY = (EditText) findViewById(R.id.editText_y);
        Double y = Double.parseDouble(textY.getText().toString());
        EditText textA = (EditText) findViewById(R.id.editText_a);
        Double a = Double.parseDouble(textA.getText().toString());


        Double d =getDouble(x, y, a);
      //  d=(Math.ceil(d)) ;
        TextView messageText = (TextView) findViewById(R.id.messageText);

        messageText.setText("Result equals: " +d);

    }
}
