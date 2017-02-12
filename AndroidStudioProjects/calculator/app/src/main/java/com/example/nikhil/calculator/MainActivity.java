package com.example.nikhil.calculator;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {

    private EditText result;
    private EditText newNumber;
    private TextView displayOperation;

    private Double operand1 = null;
    private Double operand2 = null;
    private String pendingoperation = "=";

    private String data = null;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        result=(EditText) findViewById(R.id.result);
        newNumber=(EditText) findViewById(R.id.ev1);
        displayOperation=(TextView) findViewById(R.id.operationView);

        Button clear = (Button) findViewById(R.id.clear);
        View.OnClickListener clearlistener=new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Button b=(Button) view;
                result.setText("");
                displayOperation.setText("");
                operand1 = null;
                operand2 = null;
            }
        };
        clear.setOnClickListener(clearlistener);



        Button button0 = (Button) findViewById(R.id.button0);
        Button button1 = (Button) findViewById(R.id.button1);
        Button button2 = (Button) findViewById(R.id.button2);
        Button button3 = (Button) findViewById(R.id.button3);
        Button button4 = (Button) findViewById(R.id.button4);
        Button button5 = (Button) findViewById(R.id.button5);
        Button button6 = (Button) findViewById(R.id.button6);
        Button button7 = (Button) findViewById(R.id.button7);
        Button button8 = (Button) findViewById(R.id.button8);
        Button button9 = (Button) findViewById(R.id.button9);

        Button buttonDot = (Button) findViewById(R.id.dot);
        Button buttonEquals=(Button) findViewById(R.id.equals);
        Button buttonMinus = (Button) findViewById(R.id.minus);
        Button buttonDivide = (Button) findViewById(R.id.divide);
        Button buttonMultiply = (Button) findViewById(R.id.multiply);
        Button buttonAdd = (Button) findViewById(R.id.add);

        View.OnClickListener listener=new View.OnClickListener(){
            @Override
            public void onClick(View view){
                Button b=(Button) view;
                newNumber.append(b.getText().toString());
            }
        };
        button0.setOnClickListener(listener);
        button1.setOnClickListener(listener);
        button2.setOnClickListener(listener);
        button3.setOnClickListener(listener);
        button4.setOnClickListener(listener);
        button5.setOnClickListener(listener);
        button6.setOnClickListener(listener);
        button7.setOnClickListener(listener);
        button8.setOnClickListener(listener);
        button9.setOnClickListener(listener);
        buttonDot.setOnClickListener(listener);

        View.OnClickListener oplistener = new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Button b = (Button) view;
                String op=b.getText().toString();
                String value= newNumber.getText().toString();
                if(value.length()!=0){
                    performOperation(value,op);
                }
                pendingoperation=op;
                displayOperation.setText(pendingoperation);
            }
        };
        buttonEquals.setOnClickListener(oplistener);
        buttonAdd.setOnClickListener(oplistener);
        buttonMinus.setOnClickListener(oplistener);
        buttonMultiply.setOnClickListener(oplistener);
        buttonDivide.setOnClickListener(oplistener);

    }

    public String method(String str) {
        if (str != null && str.length() > 0 && str.charAt(str.length()-1)=='x') {
            str = str.substring(0, str.length()-1);
        }
        return str;
    }

    private void performOperation(String value,String operation){
        if(null==operand1){
            operand1=Double.valueOf(value);
        }else{
            operand2=Double.valueOf(value);
            if(pendingoperation.equals("=")){
                pendingoperation=operation;
            }
            switch (pendingoperation){
                case "=":
                    operand1=operand2;
                    break;
                case "/":
                    if(operand2==0){
                        operand1=0.0;
                    }else{
                        operand1/=operand2;
                    }
                    break;
                case "*":
                    operand1 *=operand2;
                    break;
                case "-":
                    operand1 -=operand2;
                    break;
                case "+":
                    operand1 +=operand2;
                    break;

            }
        }

        result.setText(operand1.toString());
        newNumber.setText("");
    }
}
