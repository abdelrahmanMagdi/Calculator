package com.mvp.Calculator.Model;

public class CalcModel implements ICalcModel {


    @Override
    public Double add(Double Opr1, Double Opr2) {
        return Opr1 + Opr2;
    }

    @Override
    public Double subtract(Double Opr1, Double Opr2) {
        return Opr1 - Opr2;
    }

    @Override
    public Double multiply(Double Opr1, Double Opr2) {
        return Opr1 * Opr2;
    }

    @Override
    public Double divided(Double Opr1, Double Opr2) {
        if (Opr1 != 0)
            return Opr1 / Opr2;
        else
            throw new IllegalArgumentException("Can`t Divide By Zero");
//        return 0.0;
    }
}
