package com.example.oriin_bsqgiqy.webview_practice;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.webkit.WebView;
import android.webkit.WebViewClient;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {
EditText ed1,ed2,ed3;
TextView x1,x2;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        ed1=findViewById(R.id.ed1);
        ed2 = findViewById(R.id.ed2);
        ed3 = findViewById(R.id.ed3);

        x1=findViewById(R.id.x1);
        x2=findViewById(R.id.x2);
    }

    public void calculate(View view) {
        int a = Integer.parseInt(ed1.getText().toString());
        int b = Integer.parseInt(ed2.getText().toString());
        int c = Integer.parseInt(ed3.getText().toString());

        go(a,b,c);
    }
    public void go(int a,int b,int c) {
        int checkparam1 = checkparam(a,b,c);

        switch (checkparam1)
        {
            case -1:
            {
                if (b!=0)
                {
                    double LinSulOnlySul = (c/b)*(-1);
                    x1.setText("this is a linear equation solution-the sulotion is "+LinSulOnlySul);
                    x2.setText("");
                }
                break;
            }

            case -2:
            {
                x1.setText("this is a linear equation without solution");
                x2.setText("");
                break;
            }

            case -3:
            {
                x1.setText("this is a linear equation with endless solutions");
                break;
            }

            case 0:
            {
                x1.setText("this is a squar equation without solutions");
                x2.setText("");
                break;
            }

            case 1:
            {
                double checkparam2 = CALCULATE_ONE_RESULT(a,b,c);
                x1.setText("this is the only sulotion for this squar equation-the sulotion is "+checkparam2);
                x2.setText("");
                break;
            }

            case 2:
            {
                double checkparam2 = CALCULATE_FIRST_RESULT(a,b,c);
                double checkparam3 = CALCULATE_SECOND_RESULT(a,b,c);
                x1.setText("this is the first sulotion for this squar equation-the sulotion is"+" "+checkparam2);
                x2.setText("this is the second sulotion for this squar equation-the sulotion is"+" "+checkparam3);
                break;
            }

            default:
            {
                x1.setText("check param returned garbege:"+checkparam1);
                x2.setText("");
                break;
            }

        }

        Intent si = new Intent(this,Main2Activity.class);
        si.putExtra("a",a);
        si.putExtra("b",b);
        si.putExtra("c",c);
        startActivity(si);
    }

    public void random(View view) {
        int a = (int)(100*Math.random());
        int b = (int)(100*Math.random());
        int c = (int)(100*Math.random());

        ed1.setText(String.valueOf(a));
        ed2.setText(String.valueOf(b));
        ed3.setText(String.valueOf(c));

        go(a,b,c);
    }

    public static int checkparam(double a,double b,double c)
    {
        if(a == 0)
        {
            if(b!= 0)
            {
                return -1;
            }
            else
            {
                if (c!=0)
                {
                    return -2;
                }
                else
                {
                    return -3;
                }
            }
        }
        else
        {
            double discriminanta = b*b-4*a*c;
            if(discriminanta < 0)
            {
                return 0;
            }
            else
            {
                if (discriminanta == 0)
                {
                    return 1;
                }
                else
                {
                    return 2;
                }
            }
        }
    }
    public static double CALCULATE_ONE_RESULT(double a,double b,double c)
    {
        if(a != 0)
        {
            return ((-1*b)/(2*a));
        }
        else
        {
            return 0;
        }
    }
    public static double CALCULATE_FIRST_RESULT(double a,double b,double c)
    {
        if (a != 0)
        {
            double discriminanta = b*b-4*a*c;
            if(discriminanta>=0)
            {
                return (((-1*b)+Math.sqrt(discriminanta))/(2*a));
            }
            else
            {
                return 0;
            }
        }
        else
        {
            return 0;
        }
    }
    public static double CALCULATE_SECOND_RESULT(double a,double b,double c)
    {
        if (a != 0)
        {
            double discriminanta = b*b-4*a*c;
            if(discriminanta>=0)
            {

                return (((-1*b)-Math.sqrt(discriminanta))/(2*a));
            }
            else
            {
                return 0;
            }
        }
        else
        {
            return 0;
        }
    }
}
