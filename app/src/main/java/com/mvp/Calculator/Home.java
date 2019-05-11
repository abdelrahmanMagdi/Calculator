package com.mvp.Calculator;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.TextView;

import com.mvp.Calculator.Presenter.PresenterManager;
import com.mvp.Calculator.View.ICalcView;
import com.mvp.Calculator.View.ICompleteListener;

import java.util.ArrayList;

public class Home extends AppCompatActivity implements View.OnClickListener, ICalcView {

    private TextView screenTV;
    private ArrayList<ICompleteListener> iCompleteListeners = new ArrayList<>();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_home);
        initData();
        PresenterManager.getInstance().initalCalPresenter(Home.this);
    }

    private void initData() {
        screenTV = findViewById(R.id.screenTV);
        screenTV.setOnClickListener(this);
        findViewById(R.id.zeroBT).setOnClickListener(this);
        findViewById(R.id.oneBT).setOnClickListener(this);
        findViewById(R.id.twoBT).setOnClickListener(this);
        findViewById(R.id.threeBT).setOnClickListener(this);
        findViewById(R.id.fourBT).setOnClickListener(this);
        findViewById(R.id.fiveBT).setOnClickListener(this);
        findViewById(R.id.sixBT).setOnClickListener(this);
        findViewById(R.id.sevenBT).setOnClickListener(this);
        findViewById(R.id.eightBT).setOnClickListener(this);
        findViewById(R.id.nineBT).setOnClickListener(this);
        findViewById(R.id.addBT).setOnClickListener(this);
        findViewById(R.id.subBT).setOnClickListener(this);
        findViewById(R.id.multBT).setOnClickListener(this);
        findViewById(R.id.divideBT).setOnClickListener(this);
        findViewById(R.id.equalBT).setOnClickListener(this);
        findViewById(R.id.acBT).setOnClickListener(this);
        findViewById(R.id.dotBT).setOnClickListener(this);
    }

    @Override
    public void onClick(View v) {
        switch (v.getId()) {
            case R.id.oneBT:
                screenTV.append("1");
                break;
            case R.id.twoBT:
                screenTV.append("2");
                break;
            case R.id.threeBT:
                screenTV.append("3");
                break;
            case R.id.fourBT:
                screenTV.append("4");
                break;
            case R.id.fiveBT:
                screenTV.append("5");
                break;
            case R.id.sixBT:
                screenTV.append("6");
                break;
            case R.id.sevenBT:
                screenTV.append("7");
                break;
            case R.id.eightBT:
                screenTV.append("8");
                break;
            case R.id.nineBT:
                screenTV.append("9");
                break;
            case R.id.zeroBT:
                screenTV.append("0");
                break;
            case R.id.addBT:
                if (screenTV.getText().length() <= 0)
                    screenTV.setText("");
                else screenTV.append("\n" + "+" + "\n");
                break;
            case R.id.subBT:
                if (screenTV.getText().length() <= 0)
                    screenTV.setText("");
                else screenTV.append("\n" + "-" + "\n");
                break;
            case R.id.divideBT:
                if (screenTV.getText().length() <= 0)
                    screenTV.setText("");
                else screenTV.append("\n" + "/" + "\n");
                break;
            case R.id.multBT:
                if (screenTV.getText().length() <= 0)
                    screenTV.setText("");
                else screenTV.append("\n" + "*" + "\n");
//                screenTV.append( "*" );
                break;
            case R.id.dotBT:
                if (screenTV.getText().length() <= 0)
                    screenTV.setText("0");
                else if (!screenTV.getText().toString().contains("."))
                    screenTV.append(".");
                break;
            case R.id.acBT:
                screenTV.setText("");
                break;
            case R.id.equalBT:
                String text = screenTV.getText().toString().trim();
                if (text.contains("+")) {
                    for (ICompleteListener listener : iCompleteListeners) {
                        listener.add();
                    }
                } else if (text.contains("-")) {
                    for (ICompleteListener listener : iCompleteListeners) {
                        listener.subtract();
                    }

                } else if (text.contains("*")) {
                    for (ICompleteListener listener : iCompleteListeners) {
                        listener.multiply();
                    }

                } else if (text.contains("/")) {
                    for (ICompleteListener listener : iCompleteListeners) {
                        listener.divide();
                    }
                }
                break;
            case R.id.screenTV:
                String number = screenTV.getText().toString();
                if (number.length() >= 1) {
                    String code = number.substring(0, number.length() - 1);
                    screenTV.setText(code);
                }
                if (number.length() == 0 & screenTV.getText().toString().equals("0")) {
                    screenTV.setText("0");
                }
                break;
            default:
                break;
        }
    }

    @Override
    public Double getOpr1() {
        String Number = screenTV.getText().toString().trim();
        String[] FirstOperand = new String[0];
        if (Number.contains("+")) {
            FirstOperand = Number.split("\\+", 2);
        } else if (Number.contains("-")) {
            FirstOperand = Number.split("-", 2);

        } else if (Number.contains("/")) {
            FirstOperand = Number.split("/", 2);

        } else if (Number.contains("*")) {
            FirstOperand = Number.split("\\*", 2);

        }
        return Double.parseDouble(FirstOperand[0].trim());
    }

    @Override
    public Double getOpr2() {
        String Number = screenTV.getText().toString().trim();
        String[] secondOperand = new String[1];
        if (Number.contains("+")) {
            secondOperand = Number.split("\\+", 2);
        } else if (Number.contains("-")) {
            secondOperand = Number.split("-", 2);

        } else if (Number.contains("/")) {
            secondOperand = Number.split("/", 2);

        } else if (Number.contains("*")) {
            secondOperand = Number.split("\\*", 2);

        }
        return Double.parseDouble(secondOperand[1]);
    }

    @Override
    public void SubScribe(ICompleteListener iCompleteListener) {
        iCompleteListeners.add(iCompleteListener);

    }

    @Override
    public void Update(Double Result) {
        screenTV.setText(Result+"");
    }
}
