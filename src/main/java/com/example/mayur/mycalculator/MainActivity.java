package com.example.mayur.mycalculator;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity implements View.OnClickListener {

    Button btnClear, btnBackSpace, btnOpen, btnClose, btnSqrt;
    Button btn1, btn2, btn3, btn4, btn5, btn6, btn7, btn8, btn9, btn0;
    Button btnMinus, btnAdd, btnMulti, btnDiv;
    Button btnDot, btnFact, btnInverse, btnPow;
    Button btnResult;

    TextView screenAns, screenMath;

    StringBuilder textMath = new StringBuilder("");
    StringBuilder textAns = new StringBuilder("0");
    StringBuilder screenTextMath = new StringBuilder("");

    double num1=0, num2=0, ans=0;
    boolean checkSubmit = false;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        //Control
        screenAns = (TextView) findViewById(R.id.txtResult);
        screenMath = (TextView) findViewById(R.id.txtCal);

        btn0 = (Button) findViewById(R.id.btn0);
        btn0.setOnClickListener(this);

        btn1 = (Button) findViewById(R.id.btn1);
        btn1.setOnClickListener(this);

        btn2 = (Button) findViewById(R.id.btn2);
        btn2.setOnClickListener(this);

        btn3 = (Button) findViewById(R.id.btn3);
        btn3.setOnClickListener(this);

        btn4 = (Button) findViewById(R.id.btn4);
        btn4.setOnClickListener(this);

        btn5 = (Button) findViewById(R.id.btn5);
        btn5.setOnClickListener(this);

        btn6 = (Button) findViewById(R.id.btn6);
        btn6.setOnClickListener(this);

        btn7 = (Button) findViewById(R.id.btn7);
        btn7.setOnClickListener(this);

        btn8 = (Button) findViewById(R.id.btn8);
        btn8.setOnClickListener(this);

        btn9 = (Button) findViewById(R.id.btn9);
        btn9.setOnClickListener(this);


        btnAdd = (Button) findViewById(R.id.btnAdd);
        btnAdd.setOnClickListener(this);

        btnMinus = (Button) findViewById(R.id.btnMinus);
        btnMinus.setOnClickListener(this);

        btnMulti = (Button) findViewById(R.id.btnMult);
        btnMulti.setOnClickListener(this);

        btnDiv = (Button) findViewById(R.id.btndiv);
        btnDiv.setOnClickListener(this);

        btnDot = (Button) findViewById(R.id.btnDot);
        btnDot.setOnClickListener(this);

        btnFact = (Button) findViewById(R.id.btnFactorial);
        btnFact.setOnClickListener(this);

        btnInverse = (Button) findViewById(R.id.btnInverse);
        btnInverse.setOnClickListener(this);

        btnPow = (Button) findViewById(R.id.btnpow);
        btnPow.setOnClickListener(this);

        btnSqrt = (Button) findViewById(R.id.btnSqrt);
        btnSqrt.setOnClickListener(this);

        btnOpen = (Button) findViewById(R.id.btnOpen);
        btnOpen.setOnClickListener(this);

        btnClose = (Button) findViewById(R.id.btnClose);
        btnClose.setOnClickListener(this);

        btnResult  = (Button) findViewById(R.id.btnResult);
        btnResult.setOnClickListener(this);

        btnBackSpace = (Button) findViewById(R.id.btnBackSpace);
        btnBackSpace.setOnClickListener(this);

        btnClear = (Button) findViewById(R.id.btnClear);
        btnClear.setOnClickListener(this);
    }

    public void error() {
        screenAns.setText("Math Error!");
        textAns = textMath = screenTextMath = new StringBuilder("");
    }

    public void submit(String[] elementMath) {
        InfixToPostfix ITP = new InfixToPostfix();


        if(textMath.length() > 0) {
            try {
                if(!ITP.check_error) elementMath = ITP.processString(textMath.toString());  // Split expression to elements
                if(!ITP.check_error) elementMath = ITP.postfix(elementMath);                // format elements to postfix
                if(!ITP.check_error) textAns = new StringBuilder(ITP.eval(elementMath));    // get result

                screenAns.setText(textAns);

                screenTextMath = new StringBuilder();
                textMath = new StringBuilder();

                checkSubmit = true;
            }
            catch (Exception e) {
                error();
            }
        }
    }

    @Override
    public void onClick(View v) {
        String ElementMath[] = null;

        switch(v.getId()) {
            case R.id.btn0:
                if(checkSubmit) {
                    screenTextMath = new StringBuilder("");
                    textMath = new StringBuilder("");
                    checkSubmit = false;
                }
                screenTextMath.append("0");
                textMath.append("0");
                screenMath.setText(screenTextMath);
                break;

            case R.id.btn1:
                if(checkSubmit) {
                    screenTextMath = new StringBuilder("");
                    textMath = new StringBuilder("");
                    checkSubmit = false;
                }
                screenTextMath.append("1");
                textMath.append("1");
                screenMath.setText(screenTextMath);
                break;

            case R.id.btn2:
                if(checkSubmit) {
                    screenTextMath = new StringBuilder("");
                    textMath = new StringBuilder("");
                    checkSubmit = false;
                }
                screenTextMath.append("2");
                textMath.append("2");
                screenMath.setText(screenTextMath);
                break;

            case R.id.btn3:
                if(checkSubmit) {
                    screenTextMath = new StringBuilder("");
                    textMath = new StringBuilder("");
                    checkSubmit = false;
                }
                screenTextMath.append("3");
                textMath.append("3");
                screenMath.setText(screenTextMath);
                break;

            case R.id.btn4:
                if(checkSubmit) {
                    screenTextMath = new StringBuilder("");
                    textMath = new StringBuilder("");
                    checkSubmit = false;
                }
                screenTextMath.append("4");
                textMath.append("4");
                screenMath.setText(screenTextMath);
                break;

            case R.id.btn5:
                if(checkSubmit) {
                    screenTextMath = new StringBuilder("");
                    textMath = new StringBuilder("");
                    checkSubmit = false;
                }
                screenTextMath.append("5");
                textMath.append("5");
                screenMath.setText(screenTextMath);
                break;

            case R.id.btn6:
                if(checkSubmit) {
                    screenTextMath = new StringBuilder("");
                    textMath = new StringBuilder("");
                    checkSubmit = false;
                }
                screenTextMath.append("6");
                textMath.append("6");
                screenMath.setText(screenTextMath);
                break;

            case R.id.btn7:
                if(checkSubmit) {
                    screenTextMath = new StringBuilder("");
                    textMath = new StringBuilder("");
                    checkSubmit = false;
                }
                screenTextMath.append("7");
                textMath.append("7");
                screenMath.setText(screenTextMath);
                break;

            case R.id.btn8:
                if(checkSubmit) {
                    screenTextMath = new StringBuilder("");
                    textMath = new StringBuilder("");
                    checkSubmit = false;
                }
                screenTextMath.append("8");
                textMath.append("8");
                screenMath.setText(screenTextMath);
                break;

            case R.id.btn9:
                if(checkSubmit) {
                    screenTextMath = new StringBuilder("");
                    textMath = new StringBuilder("");
                    checkSubmit = false;
                }
                screenTextMath.append("9");
                textMath.append("9");
                screenMath.setText(screenTextMath);
                break;

            case R.id.btnDot:
                if(checkSubmit) {
                    screenTextMath = new StringBuilder("");
                    textMath = new StringBuilder("");
                    checkSubmit = false;
                }
                screenTextMath.append(".");
                textMath.append(".");
                screenMath.setText(screenTextMath);
                break;

            case R.id.btnMinus:
                if(checkSubmit) {
                    screenTextMath = new StringBuilder("");
                    textMath = new StringBuilder("");
                    checkSubmit = false;
                }
                screenTextMath.append("-");
                textMath.append("-");
                screenMath.setText(screenTextMath);
                break;

            case R.id.btnAdd:
                if(checkSubmit) {
                    screenTextMath = new StringBuilder("");
                    textMath = new StringBuilder("");
                    checkSubmit = false;
                }
                screenTextMath.append("+");
                textMath.append("+");
                screenMath.setText(screenTextMath);
                break;

            case R.id.btnMult:
                if(checkSubmit) {
                    screenTextMath = new StringBuilder("");
                    textMath = new StringBuilder("");
                    checkSubmit = false;
                }
                screenTextMath.append("*");
                textMath.append("*");
                screenMath.setText(screenTextMath);
                break;

            case R.id.btndiv:
                if(checkSubmit) {
                    screenTextMath = new StringBuilder("");
                    textMath = new StringBuilder("");
                    checkSubmit = false;
                }
                screenTextMath.append("/");
                textMath.append("/");
                screenMath.setText(screenTextMath);
                break;

            case R.id.btnpow:
                if(checkSubmit) {
                    screenTextMath = new StringBuilder("");
                    textMath = new StringBuilder("");
                    checkSubmit = false;
                }
                screenTextMath.append("^(");
                textMath.append("^(");
                screenMath.setText(screenTextMath);
                break;

            case R.id.btnSqrt:
                if(checkSubmit) {
                    screenTextMath = new StringBuilder("");
                    textMath = new StringBuilder("");
                    checkSubmit = false;
                }
                screenTextMath.append("\u221a");       // unicode for sqrt symbol
                textMath.append("@");
                screenMath.setText(screenTextMath);
                break;

            case R.id.btnOpen:
                if(checkSubmit) {
                    screenTextMath = new StringBuilder("");
                    textMath = new StringBuilder("");
                    checkSubmit = false;
                }
                screenTextMath.append("(");
                textMath.append("(");
                screenMath.setText(screenTextMath);
                break;

            case R.id.btnClose:
                if(checkSubmit) {
                    screenTextMath = new StringBuilder("");
                    textMath = new StringBuilder("");
                    checkSubmit = false;
                }
                screenTextMath.append(")");
                textMath.append(")");
                screenMath.setText(screenTextMath);
                break;



            case R.id.btnInverse:
                if(screenTextMath.length() == 0) screenTextMath = new StringBuilder("0");
                screenTextMath = new StringBuilder("1/(" + screenTextMath + ")");
                screenMath.setText(screenTextMath);

                if(!checkSubmit) submit(ElementMath);
                textMath = new StringBuilder("1/" + textAns);
                submit(ElementMath);
                break;

            case R.id.btnClear:
                textMath = new StringBuilder("");
                textAns = new StringBuilder("0");
                screenTextMath = new StringBuilder("");

                screenAns.setText(textAns);
                screenMath.setText("");
                break;

            case R.id.btnBackSpace:
                if(screenMath.length() > 0) {
                    int l = textMath.length();
                    char c = textMath.charAt(l-1);
                    if(l>1 && c=='(' && textMath.charAt(l-2) == '^') {
                        screenTextMath = new StringBuilder(screenTextMath.substring(0,l-2));
                        textMath = new StringBuilder(screenTextMath);
                    }
                    screenTextMath = new StringBuilder(screenTextMath.substring(0, l-1));
                    textMath = new StringBuilder(textMath.substring(0, l-1));
                }
                screenMath.setText(screenTextMath);
                break;

            case R.id.btnResult:
                submit(ElementMath);
                break;
        }
    }
}
