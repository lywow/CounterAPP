package com.lywow.counterapp;

import android.app.Activity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import com.lywow.utils.Calculator;
import com.lywow.utils.MyUtils;

import java.lang.reflect.Method;

public class MainActivity extends Activity implements View.OnClickListener {
    private EditText et_equation;
    private TextView tv_back;
    private TextView tv_answer;
    private Button bn_one;
    private Button bn_two;
    private Button bn_three;
    private Button bn_four;
    private Button bn_five;
    private Button bn_six;
    private Button bn_seven;
    private Button bn_eight;
    private Button bn_nine;
    private Button bn_zero;
    private Button bn_add;
    private Button bn_subtraction;
    private Button bn_multiplication;
    private Button bn_division;
    private Button bn_equal;
    private Button bn_all_clear;
    private Button bn_plus_or_minus;
    private Button bn_point;
    private Button bn_delete;

    Calculator calc = new Calculator();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        init();
    }
    
    private void init(){
        et_equation=findViewById(R.id.et_equation);
        tv_back=findViewById(R.id.tv_back);
        tv_answer=findViewById(R.id.tv_answer);
        bn_one=findViewById(R.id.bn_one);
        bn_two=findViewById(R.id.bn_two);
        bn_three=findViewById(R.id.bn_three);
        bn_four=findViewById(R.id.bn_four);
        bn_five=findViewById(R.id.bn_five);
        bn_six=findViewById(R.id.bn_six);
        bn_seven=findViewById(R.id.bn_seven);
        bn_eight=findViewById(R.id.bn_eight);
        bn_nine=findViewById(R.id.bn_nine);
        bn_zero=findViewById(R.id.bn_zero);
        bn_add=findViewById(R.id.bn_add);//加法
        bn_subtraction=findViewById(R.id.bn_subtraction);//减法
        bn_multiplication=findViewById(R.id.bn_multiplication);//乘法
        bn_division=findViewById(R.id.bn_division);//除法
        bn_equal=findViewById(R.id.bn_equal);//等于
        bn_all_clear=findViewById(R.id.bn_all_clear);//归零
        bn_plus_or_minus=findViewById(R.id.bn_plus_or_minus);//正负号
        bn_point=findViewById(R.id.bn_point);//小数点
        bn_delete=findViewById(R.id.bn_delete);//退格

        et_equation.setOnClickListener(this);
        tv_back.setOnClickListener(this);
        tv_answer.setOnClickListener(this);
        bn_one.setOnClickListener(this);
        bn_two.setOnClickListener(this);
        bn_three.setOnClickListener(this);
        bn_four.setOnClickListener(this);
        bn_five.setOnClickListener(this);
        bn_six.setOnClickListener(this);
        bn_seven.setOnClickListener(this);
        bn_eight.setOnClickListener(this);
        bn_nine.setOnClickListener(this);
        bn_zero.setOnClickListener(this);
        bn_add.setOnClickListener(this);
        bn_subtraction.setOnClickListener(this);
        bn_multiplication.setOnClickListener(this);
        bn_division.setOnClickListener(this);
        bn_equal.setOnClickListener(this);
        bn_all_clear.setOnClickListener(this);
        bn_plus_or_minus.setOnClickListener(this);
        bn_point.setOnClickListener(this);
        bn_delete.setOnClickListener(this);

        disableShowSoftInput(et_equation);
    }

    @Override
    public void onClick(View v) {
        switch (v.getId()){
            case R.id.tv_back:
                this.finish();
                break;
            case R.id.bn_one:
                et_equation.setText(et_equation.getText()+"1");
                break;
            case R.id.bn_two:
                et_equation.setText(et_equation.getText()+"2");
                break;
            case R.id.bn_three:
                et_equation.setText(et_equation.getText()+"3");
                break;
            case R.id.bn_four:
                et_equation.setText(et_equation.getText()+"4");
                break;
            case R.id.bn_five:
                et_equation.setText(et_equation.getText()+"5");
                break;
            case R.id.bn_six:
                et_equation.setText(et_equation.getText()+"6");
                break;
            case R.id.bn_seven:
                et_equation.setText(et_equation.getText()+"7");
                break;
            case R.id.bn_eight:
                et_equation.setText(et_equation.getText()+"8");
                break;
            case R.id.bn_nine:
                et_equation.setText(et_equation.getText()+"9");
                break;
            case R.id.bn_zero:
                et_equation.setText(et_equation.getText()+"0");
                break;
            case R.id.bn_add:
                et_equation.setText(et_equation.getText()+"+");
                break;
            case R.id.bn_subtraction:
                et_equation.setText(et_equation.getText()+"-");
                break;
            case R.id.bn_multiplication:
                et_equation.setText(et_equation.getText()+"×");
                break;
            case R.id.bn_division:
                et_equation.setText(et_equation.getText()+"÷");
                break;
            case R.id.bn_equal:
                et_equation.setText(tv_answer.getText().toString().substring(1));
                break;
            case R.id.bn_all_clear:
                et_equation.setText("");
                break;
            case R.id.bn_delete:
                if(et_equation.getText().length()>1){
                    String sss=et_equation.getText().toString();
                    if(sss.charAt(sss.length()-1)==')') {
                        for (int i = sss.length() - 2; i > -1; i--) {
                            if(sss.charAt(i-1)=='('&&sss.charAt(i)=='-'){
                                StringBuilder sb=new StringBuilder (sss);
                                sb.delete(sss.length()-1,sss.length());
                                sb.delete(i-1,i+1);
                                et_equation.setText(sb);
                                break;
                            }
                        }
                    }else{
                        et_equation.setText(et_equation.getText().delete(et_equation.getText().length()-1,et_equation.getText().length()));
                    }
                }
                break;
            case R.id.bn_point:
                et_equation.setText(et_equation.getText()+".");
                break;
            case R.id.bn_plus_or_minus:
                if(et_equation.getText().length()>0){
                    if (calc.prepareParam(et_equation.getText().toString()+"=") != null) {
                        String sss=et_equation.getText().toString();
                        if(sss.charAt(sss.length()-1)==')'){
                            for(int i=sss.length()-2;i>-1;i--){
                                if(sss.charAt(i-1)=='('&&sss.charAt(i)=='-'){
                                    StringBuilder sb=new StringBuilder (sss);
                                    sb.delete(sss.length()-1,sss.length());
                                    sb.delete(i-1,i+1);
                                    et_equation.setText(sb);
                                    break;
                                }
                            }
                        }else{
                            for(int i=sss.length()-1;i>-1;i--){
                                if(!(sss.charAt(i)=='.'||MyUtils.isCharNum(sss.charAt(i)))||i-1==-1){
                                    StringBuilder sb=new StringBuilder (sss);
                                    sb.insert(i,"(-");
                                    sb.append(")");
                                    et_equation.setText(sb);
                                    break;
                                }
                            }
                        }
                    }
                }
                break;
        }

        if(et_equation.getText().length()>0){
            Double result = calc.prepareParam(et_equation.getText().toString()+"=");
            if (result != null) {
                tv_answer.setText("="+MyUtils.formatResult(String.format("%." + MyUtils.RESULT_DECIMAL_MAX_LENGTH + "f", result)));
            }else{
                tv_answer.setText("错误");
            }
        }else{
            tv_answer.setText("");
        }
    }

    /**
     * 禁止Edittext弹出软件盘，光标依然正常显示。
     */
    public static void disableShowSoftInput(EditText editText) {
        Class<EditText> cls = EditText.class;
        Method method;
        try {
            method = cls.getMethod("setShowSoftInputOnFocus", boolean.class);
            method.setAccessible(true);
            method.invoke(editText, false);
        } catch (Exception e) {
            // TODO: 2018/8/27 处理错误
        }
    }

}