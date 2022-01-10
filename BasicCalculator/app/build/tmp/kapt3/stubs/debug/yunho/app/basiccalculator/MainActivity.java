package yunho.app.basiccalculator;

import java.lang.System;

@kotlin.Metadata(mv = {1, 5, 1}, k = 1, d1 = {"\u0000N\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0010\u000b\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\b\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0002\b\b\n\u0002\u0018\u0002\n\u0002\b\u0005\u0018\u00002\u00020\u0001B\u0005\u00a2\u0006\u0002\u0010\u0002J\u000e\u0010\u001f\u001a\u00020 2\u0006\u0010!\u001a\u00020\"J\b\u0010#\u001a\u00020$H\u0002J\u000e\u0010%\u001a\u00020 2\u0006\u0010!\u001a\u00020\"J\u000e\u0010&\u001a\u00020 2\u0006\u0010!\u001a\u00020\"J\u000e\u0010\'\u001a\u00020 2\u0006\u0010!\u001a\u00020\"J\u000e\u0010(\u001a\u00020 2\u0006\u0010!\u001a\u00020\"J\u0010\u0010)\u001a\u00020 2\u0006\u0010*\u001a\u00020$H\u0002J\u0012\u0010+\u001a\u00020 2\b\u0010,\u001a\u0004\u0018\u00010-H\u0014J\u0010\u0010.\u001a\u00020 2\u0006\u0010/\u001a\u00020$H\u0002J\u000e\u00100\u001a\u00020 2\u0006\u0010!\u001a\u00020\"J\n\u00101\u001a\u00020\u0010*\u00020$R\u001a\u0010\u0003\u001a\u00020\u0004X\u0086.\u00a2\u0006\u000e\n\u0000\u001a\u0004\b\u0005\u0010\u0006\"\u0004\b\u0007\u0010\bR\u001b\u0010\t\u001a\u00020\n8BX\u0082\u0084\u0002\u00a2\u0006\f\n\u0004\b\r\u0010\u000e\u001a\u0004\b\u000b\u0010\fR\u000e\u0010\u000f\u001a\u00020\u0010X\u0082\u000e\u00a2\u0006\u0002\n\u0000R\u001b\u0010\u0011\u001a\u00020\u00128BX\u0082\u0084\u0002\u00a2\u0006\f\n\u0004\b\u0015\u0010\u000e\u001a\u0004\b\u0013\u0010\u0014R\u001b\u0010\u0016\u001a\u00020\u00178BX\u0082\u0084\u0002\u00a2\u0006\f\n\u0004\b\u001a\u0010\u000e\u001a\u0004\b\u0018\u0010\u0019R\u000e\u0010\u001b\u001a\u00020\u0010X\u0082\u000e\u00a2\u0006\u0002\n\u0000R\u001b\u0010\u001c\u001a\u00020\n8BX\u0082\u0084\u0002\u00a2\u0006\f\n\u0004\b\u001e\u0010\u000e\u001a\u0004\b\u001d\u0010\f\u00a8\u00062"}, d2 = {"Lyunho/app/basiccalculator/MainActivity;", "Landroidx/appcompat/app/AppCompatActivity;", "()V", "db", "Lyunho/app/basiccalculator/AppDatabase;", "getDb", "()Lyunho/app/basiccalculator/AppDatabase;", "setDb", "(Lyunho/app/basiccalculator/AppDatabase;)V", "expressTextview", "Landroid/widget/TextView;", "getExpressTextview", "()Landroid/widget/TextView;", "expressTextview$delegate", "Lkotlin/Lazy;", "hasOperator", "", "historyLayout", "Landroidx/constraintlayout/widget/ConstraintLayout;", "getHistoryLayout", "()Landroidx/constraintlayout/widget/ConstraintLayout;", "historyLayout$delegate", "historyLinearLayout", "Landroid/widget/LinearLayout;", "getHistoryLinearLayout", "()Landroid/widget/LinearLayout;", "historyLinearLayout$delegate", "isOperator", "resultTextView", "getResultTextView", "resultTextView$delegate", "buttonClicked", "", "v", "Landroid/view/View;", "calculateExpression", "", "clearButtonClicked", "historyButtonClicked", "historyClearButtonClicked", "historyCloseButtonClicked", "numberButtonClicked", "number", "onCreate", "savedInstanceState", "Landroid/os/Bundle;", "operatorButtonClicked", "op", "resultButtonClicked", "isNumber", "app_debug"})
public final class MainActivity extends androidx.appcompat.app.AppCompatActivity {
    private final kotlin.Lazy expressTextview$delegate = null;
    private final kotlin.Lazy resultTextView$delegate = null;
    private final kotlin.Lazy historyLayout$delegate = null;
    private final kotlin.Lazy historyLinearLayout$delegate = null;
    public yunho.app.basiccalculator.AppDatabase db;
    private boolean isOperator = false;
    private boolean hasOperator = false;
    
    public MainActivity() {
        super();
    }
    
    private final android.widget.TextView getExpressTextview() {
        return null;
    }
    
    private final android.widget.TextView getResultTextView() {
        return null;
    }
    
    private final androidx.constraintlayout.widget.ConstraintLayout getHistoryLayout() {
        return null;
    }
    
    private final android.widget.LinearLayout getHistoryLinearLayout() {
        return null;
    }
    
    @org.jetbrains.annotations.NotNull()
    public final yunho.app.basiccalculator.AppDatabase getDb() {
        return null;
    }
    
    public final void setDb(@org.jetbrains.annotations.NotNull()
    yunho.app.basiccalculator.AppDatabase p0) {
    }
    
    @java.lang.Override()
    protected void onCreate(@org.jetbrains.annotations.Nullable()
    android.os.Bundle savedInstanceState) {
    }
    
    public final void buttonClicked(@org.jetbrains.annotations.NotNull()
    android.view.View v) {
    }
    
    private final void numberButtonClicked(java.lang.String number) {
    }
    
    private final void operatorButtonClicked(java.lang.String op) {
    }
    
    public final void clearButtonClicked(@org.jetbrains.annotations.NotNull()
    android.view.View v) {
    }
    
    public final void resultButtonClicked(@org.jetbrains.annotations.NotNull()
    android.view.View v) {
    }
    
    private final java.lang.String calculateExpression() {
        return null;
    }
    
    public final void historyButtonClicked(@org.jetbrains.annotations.NotNull()
    android.view.View v) {
    }
    
    public final void historyClearButtonClicked(@org.jetbrains.annotations.NotNull()
    android.view.View v) {
    }
    
    public final void historyCloseButtonClicked(@org.jetbrains.annotations.NotNull()
    android.view.View v) {
    }
    
    public final boolean isNumber(@org.jetbrains.annotations.NotNull()
    java.lang.String $this$isNumber) {
        return false;
    }
}