package com.mvp.Calculator.Presenter;

import com.mvp.Calculator.Model.CalcModel;
import com.mvp.Calculator.Model.ICalcModel;
import com.mvp.Calculator.View.ICalcView;

public class PresenterManager {

    private CalcPresenter calcPresenter;
    private ICalcModel iCalcModel;

    private static PresenterManager instance;

    public static PresenterManager getInstance() {
        if (instance == null)
            instance = new PresenterManager();
        return instance;
    }

    public PresenterManager() {

    }

    public void initalCalPresenter(ICalcView iCalcView) {
        iCalcModel = new CalcModel();
        calcPresenter = new CalcPresenter(iCalcView, iCalcModel);
    }
}
