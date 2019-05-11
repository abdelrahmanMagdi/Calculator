package com.mvp.Calculator.Presenter;

import com.mvp.Calculator.Model.ICalcModel;
import com.mvp.Calculator.View.ICalcView;
import com.mvp.Calculator.View.ICompleteListener;

public class CalcPresenter implements ICompleteListener {
    ICalcView iCalcView;
    ICalcModel iCalcModel;

    public CalcPresenter(ICalcView iCalcView, ICalcModel iCalcModel) {
        this.iCalcView = iCalcView;
        this.iCalcModel = iCalcModel;
        onCompleteListener();
    }

    private void onCompleteListener() {
        iCalcView.SubScribe(this);
    }

    @Override
    public void add() {
        try {
            Double Result = iCalcModel.add(iCalcView.getOpr1(), iCalcView.getOpr2());
            iCalcView.Update(Result);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    @Override
    public void subtract() {
        try {
            Double Result = iCalcModel.subtract(iCalcView.getOpr1(), iCalcView.getOpr2());
            iCalcView.Update(Result);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    @Override
    public void multiply() {
        try {
            Double Result = iCalcModel.multiply(iCalcView.getOpr1(), iCalcView.getOpr2());
            iCalcView.Update(Result);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    @Override
    public void divide() {
        try {
            Double Result = iCalcModel.divided(iCalcView.getOpr1(), iCalcView.getOpr2());
            iCalcView.Update(Result);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
