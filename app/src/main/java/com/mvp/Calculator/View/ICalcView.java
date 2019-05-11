package com.mvp.Calculator.View;

public interface ICalcView {
    Double getOpr1();
    Double getOpr2();
    void SubScribe(ICompleteListener iCompleteListener);
    void Update(Double Result);
}
