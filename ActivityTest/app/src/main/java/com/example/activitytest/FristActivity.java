package com.example.activitytest;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

public class FirstActivity extends AppCompatActivity {

    Button btn1; // 数字1
    Button btn2; // 数字2
    Button btn3; // 数字3
    Button btn4; // 数字4
    Button btn5; // 数字5
    Button btn6; // 数字6
    Button btn7; // 数字7
    Button btn8; // 数字8
    Button btn9; // 数字9
    Button btn0; // 数字0
    Button add; // +号
    Button sub; // -号
    Button mul; // *号
    Button div; // 除号
    Button dot; // 小数点
    Button equ; // =号
    Button clear; //清除
    Button fh; //正负号
    Button percent; //百分号
    Button sq; //平方根
    EditText result; // 显示文本

    double num1=0,num2=0;//计算的数字
    double Result=0;//计算结果
    int op=0;//操作符判断
    String opd=" ";//显示操作符
    public static int flag=0;
    public static int sum=0;
    @Override
    protected void onCreate(Bundle savedInstanceState) {

        super.onCreate(savedInstanceState);
        setContentView(R.layout.first_layout);

        //获取页面上的控件
        btn1 = findViewById(R.id.btn_1);
        btn2 = findViewById(R.id.btn_2);
        btn3 = findViewById(R.id.btn_3);
        btn4 = findViewById(R.id.btn_4);
        btn5 = findViewById(R.id.btn_5);
        btn6 = findViewById(R.id.btn_6);
        btn7 = findViewById(R.id.btn_7);
        btn8 = findViewById(R.id.btn_8);
        btn9 = findViewById(R.id.btn_9);
        btn0 = findViewById(R.id.btn_0);
        add = findViewById(R.id.btn_add);
        sub = findViewById(R.id.btn_sub);
        mul = findViewById(R.id.btn_mul);
        div = findViewById(R.id.btn_div);
        equ = findViewById(R.id.btn_equ);
        dot = findViewById(R.id.btn_dot);
        clear = findViewById(R.id.btn_clear);
        fh=findViewById(R.id.btn_fh);
        percent=findViewById(R.id.btn_percent);
        sq=findViewById(R.id.btn_sq);
        result = findViewById(R.id.et_result);

        //按钮的单击事件
        btn1.setOnClickListener(new Click());
        btn2.setOnClickListener(new Click());
        btn3.setOnClickListener(new Click());
        btn4.setOnClickListener(new Click());
        btn5.setOnClickListener(new Click());
        btn6.setOnClickListener(new Click());
        btn7.setOnClickListener(new Click());
        btn8.setOnClickListener(new Click());
        btn9.setOnClickListener(new Click());
        btn0.setOnClickListener(new Click());
        add.setOnClickListener(new Click());
        sub.setOnClickListener(new Click());
        mul.setOnClickListener(new Click());
        div.setOnClickListener(new Click());
        equ.setOnClickListener(new Click());
        dot.setOnClickListener(new Click());
        clear.setOnClickListener(new Click());
        fh.setOnClickListener(new Click());
        percent.setOnClickListener(new Click());
        sq.setOnClickListener(new Click());
        result.setOnClickListener(new Click());

    }

    class Click implements  View.OnClickListener{


        public void onClick(View v){

            switch(v.getId()){//获取点击按钮后的值
                case R.id.btn_0:
                    String myString=result.getText().toString();//获取文本内容（下同）
                    myString+="0";//字符串加0（下同）
                    result.setText(myString);
                    break;
                case R.id.btn_1:
                    String myString1 = result.getText().toString();
                    myString1 += "1";
                    result.setText(myString1);
                    break;
                case R.id.btn_2:
                    String myString2 = result.getText().toString();
                    myString2 += "2";
                    result.setText(myString2);
                    break;
                case R.id.btn_3:
                    String myString3 = result.getText().toString();
                    myString3 += "3";
                    result.setText(myString3);
                    break;
                case R.id.btn_4:
                    String myString4 = result.getText().toString();
                    myString4 += "4";
                    result.setText(myString4);
                    break;
                case R.id.btn_5:
                    String myString5 = result.getText().toString();
                    myString5 += "5";
                    result.setText(myString5);
                    break;
                case R.id.btn_6:
                    String myString6 = result.getText().toString();
                    myString6 += "6";
                    result.setText(myString6);
                    break;
                case R.id.btn_7:
                    String myString7 = result.getText().toString();
                    myString7 += "7";
                    result.setText(myString7);
                    break;
                case R.id.btn_8:
                    String myString8 = result.getText().toString();
                    myString8 += "8";
                    result.setText(myString8);
                    break;
                case R.id.btn_9:
                    String myString9 = result.getText().toString();
                    myString9 += "9";
                    result.setText(myString9);
                    break;
                case R.id.btn_dot:                  //小数点
                    String myStringDot=result.getText().toString();
                    myStringDot +=".";
                    //如果输入的一个数字小数点数大于1
                    if(sum>=1){
                        Toast.makeText(FirstActivity.this,"输入格式有问题！",Toast.LENGTH_SHORT).show();//弹出错误提醒
                        break;
                    }
                    result.setText(myStringDot);
                    sum++;
                    break;
                case R.id.btn_fh:                   //正负号
                    String myStringFh=result.getText().toString();
                    //flag为0：显示负号，flag为1：显示正号
                    if(flag==0){
                        myStringFh="";
                        myStringFh +="-";
                        flag=1;//点击一次负号后flag变为1（正号）
                    }else{
                        myStringFh="";
                        myStringFh +="+";
                        flag=0;//点击一次正号后flag变为0（负号）
                    }
                    result.setText(myStringFh);
                    break;




                case R.id.btn_add:
                    String myStringAdd=result.getText().toString();
                    //如果数字字符串为空返回
                    if(myStringAdd.equals(null)){
                        return;
                    }
                    num1=Double.valueOf(myStringAdd);
                    result.setText(null);
                    op=1;
                    opd="+";
                    sum=0;
                    flag=0;
                    break;
                case R.id.btn_sub:
                    String myStringSub = result.getText().toString();
                    if (myStringSub.equals(null)) {
                        return;
                    }
                    num1 = Double.valueOf(myStringSub);
                    result.setText(null);
                    op = 2;
                    opd = "-";
                    sum=0;
                    flag=0;
                    break;
                case R.id.btn_mul:
                    String myStringMul = result.getText().toString();
                    if (myStringMul.equals(null)) {
                        return;
                    }
                    num1 = Double.valueOf(myStringMul);
                    result.setText(null);
                    op = 3;
                    opd = "×";
                    sum=0;
                    flag=0;
                    break;
                case R.id.btn_div:
                    String myStringDiv = result.getText().toString();
                    if (myStringDiv.equals(null)) {
                        return;
                    }
                    num1 = Double.valueOf(myStringDiv);
                    result.setText(null);
                    op = 4;
                    opd = "÷";
                    sum=0;
                    flag=0;
                    break;
                case R.id.btn_percent:
                    String myStringPc=result.getText().toString();
                    if(myStringPc.equals(null)){
                        return;

                    }
                    num1=Double.valueOf(myStringPc);
                    result.setText(null);
                    Result=num1/100;
                    result.setText(Double.toString(num1)+"%"+"="+Double.toString(Result));
                    break;
                case R.id.btn_sq:                       //求平方根
                    String myStringSq=result.getText().toString();
                    if(myStringSq.equals(null)){
                        return;

                    }
                    num1=Double.valueOf(myStringSq);
                    //如果输入的数字小于0
                    if(num1<0){
                        Toast.makeText(FirstActivity.this,"负数不能开平方根！",Toast.LENGTH_SHORT).show();
                        break;
                    }
                    result.setText(null);
                    Result=Math.sqrt(num1);
                    result.setText("√"+Double.toString(num1)+"="+Double.toString(Result));
                    break;
                case R.id.btn_clear:                 //清除，将编辑框文本显示为空
                    result.setText(null);
                    sum=0;
                    flag=0;
                    break;
                case R.id.btn_equ:                   //计算，以操作符为判断，选择所需的运算，并将结果输出
                    String myStringEqu = result.getText().toString();
                    if (myStringEqu.equals(null)) {
                        return;
                    }
                    num2 = Double.valueOf(myStringEqu);
                    result.setText(null);
                    switch (op) {
                        case 0:
                            Result = num2;
                            break;
                        case 1:
                            Result = num1 + num2;
                            break;
                        case 2:
                            Result = num1 - num2;
                            break;
                        case 3:
                            Result = num1 * num2;
                            break;
                        case 4:
                            if (num2 == 0){
                                Toast.makeText(FirstActivity.this,"除数不能为0！",Toast.LENGTH_SHORT).show();
                                sum=0;
                                break;
                            }else
                                Result = num1 / num2;
                            break;

                        default:
                            Result = 0;
                            break;
                    }
                    result.setText(Double.toString(num1) + opd + Double.toString(num2) + "=" + Double.toString(Result));    //将结果完整输出
                    break;
                default:
                    break;

            }
        }
    }

}
