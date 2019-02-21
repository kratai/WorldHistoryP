package com.example.admin.worldhistoryp;

import android.content.DialogInterface;
import android.content.Intent;
import android.support.v7.app.AlertDialog;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.view.animation.Animation;
import android.view.animation.AnimationUtils;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Random;

public class test3 extends AppCompatActivity {

    Animation lefttoright,righttoleft;

    private ImageView chooseans;
    private TextView questionLabel;
    private Button answerBtn1;
    private Button answerBtn2;
    private Button answerBtn3;
    private Button answerBtn4;

    private String rightAnswer;
    private int rightAnswerCount = 0;
    private int quizCount = 1;
    static final private int QUIZ_COUNT = 5;

    ArrayList<ArrayList<String>> quizArray = new ArrayList<>();

    String quizData[][] = {
            // {"Country", "Right Answer", "Choice1", "Choice2", "Choice3"}
            {"ในศาสนาฮินดูจะมีการแบ่งวรรณะเป็นกี่ชนชั้น และมีชนชั้นอะไรบ้าง", "4ชนชั้น พราหมณ์ กษัตริย์ แพศย์ ศูทร", "2ชนชั้น พราหมณ์ กษัตริย์", "1ชนชั้น พราหมณ์", "3ชนชั้น พราหมณ์ กษัตริย์ แพศย์"},
            {"เส้นที่ถูกใช้ในการแบ่งอณาเขตเกาหลีเหนือ และเกาหลีใต้คือ", "ละติจูดที่ 38", "ลองจิจูดที่ 38", "ละติจูดที่ 23", "ลองจิจูดที่ 23"},
            {"ยุคตื่นทองในออสเตรเลียเกิดจากใครเป็นผู้ค้นพบแร่ทอง", "เอดเวิร์ด ฮาร์กรีฟส์", "มาร์โคโปโล", "คริสโตเฟอร์ โคลัมบัส", "ลีโอนาโด ดาวินชี"},
            {"วินาศกรรม 9/11 เป็นเหตุให้ตึกใดในสหรัฐอเมริกาถล่ม", "เวิล์ดเทรด1 และ2", "เอ็มไพร์เสตต", "นิวยอร์คไทมส์", "432 พาร์กแอเวนู"},
            {"พีระมิดที่ถือเป็น 7 สิ่งมหัศจรรย์ของโลกมีชื่อว่า", "พีระมิดแห่งกีซา", "พีระมิดซิกกุรัต", "พีระมิดโจเซอร์", "พีระมิดแดง"},
            {"กลุ่มที่มีบทบาทในการล้มราชวงศ์หยวนมีชื่อว่าอะไร", "กบฏโพกผ้าแดง", "กบฏนักมวย", "กบฏชาวนา", "กบฏเมืองแมนแดนสันติ"},
            {"การเกิดสงครามฝิ่นในจีนทำให้จีนต้องลงนามในสนธิสัญญาอะไร และต้องยกที่ดินตรงไหนให้อังกฤษเช่า", "สนธิสัญญาหนานจิง/ฮ่องกง", "สนธิสัญญานานกิง/เซี่ยงไฮ้", "สนธิสัญญาปักกิ่ง/มาเก๊า", "สนธิสัญญาหนานจิง/ไทเป"},
            {"จุดเริ่มต้นของปีฮิจญ์เราะห์ศักราชเกิดจากอะไร", "การอพยพจากนครเมกะไปเมืองเมดีนา", "การอพยพจากเมืองเมดีนาไปนครเมกะ", "การตั้งรกรากที่นครเมกะ", "การตั้งรกรากที่เมืองเมดีนา"},
            {"ดาวเทียมดวงแรกถูกส่งจากประเทศใด และมีชื่อว่าอะไร", "สหภาพโซเวียต/ดาวเทียมสปุตนิค 1", "สหรัฐอเมริกา/ดาวเทียมเอ็กซ์พลอเรอ 1", "จีน/ดาวเทียมตงฟังหง 1", "ญี่ปุ่น/ดาวเทียมโอซุมิ"},
            {"ผู้ค้นพบทวีปออสเตรเลียมีชื่อว่าอะไร มาจากประเทศใด", "เจมส์ คุก จากประเทศอังกฤษ", "คริสโตเฟอร์ โคลัมบัส จากสหรัฐอเมริกา", "เดวิด ลิฟวิงสโตน จากประเทศอังกฤษ", "อเมริโก เวสปุชชี จากประเทศออิตาลี"},

    };


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_test3);
//        chooseans = (ImageView) findViewById(R.id.chooseans);
        questionLabel = (TextView) findViewById(R.id.questionLabel);
        answerBtn1 = (Button) findViewById(R.id.answerBtn1);
        answerBtn2 = (Button) findViewById(R.id.answerBtn2);
        answerBtn3 = (Button) findViewById(R.id.answerBtn3);
        answerBtn4 = (Button) findViewById(R.id.answerBtn4);

        lefttoright = AnimationUtils.loadAnimation(this,R.anim.lefttoright);
        righttoleft = AnimationUtils.loadAnimation(this,R.anim.righttoleft);
        lefttoright = AnimationUtils.loadAnimation(this,R.anim.lefttoright);
        righttoleft = AnimationUtils.loadAnimation(this,R.anim.righttoleft);

        // Create quizArray from quizData.
        for (int i = 0; i < quizData.length; i++) {
            // Prepare array.
            ArrayList<String> tmpArray = new ArrayList<>();
            tmpArray.add(quizData[i][0]);  // Country
            tmpArray.add(quizData[i][1]);  // Right Answer
            tmpArray.add(quizData[i][2]);  // Choice1
            tmpArray.add(quizData[i][3]);  // Choice2
            tmpArray.add(quizData[i][4]);  // Choice3

            // Add tmpArray to quizArray.
            quizArray.add(tmpArray);
        }

        showNextQuiz();
    }
    public void showNextQuiz() {

        // Generate random number between 0 and 14 (quizArray's size - 1).
        Random random = new Random();
        int randomNum = random.nextInt(quizArray.size());

        // Pick one quiz set.
        ArrayList<String> quiz = quizArray.get(randomNum);

        // Set question and right answer.
        // Array format: {"Country", "Right Answer", "Choice1", "Choice2", "Choice3"}
        questionLabel.setText(quiz.get(0));
        rightAnswer = quiz.get(1);

        // Remove "Country" from quiz and Shuffle choices.
        quiz.remove(0);
        Collections.shuffle(quiz);

        // Set Choices.
        answerBtn1.setText(quiz.get(0));
        answerBtn2.setText(quiz.get(1));
        answerBtn3.setText(quiz.get(2));
        answerBtn4.setText(quiz.get(3));

        answerBtn1.setAnimation(lefttoright);
        answerBtn2.setAnimation(righttoleft);
        answerBtn3.setAnimation(lefttoright);
        answerBtn4.setAnimation(righttoleft);

        // Remove this quiz from quizArray.
        quizArray.remove(randomNum);

    }
    public void checkAnswer(View view) {

        // Get pushed button.
        Button answerBtn = (Button) findViewById(view.getId());
        String btnText = answerBtn.getText().toString();

        String alertTitle;


        if (btnText.equals(rightAnswer)) {
            // Correct!
            alertTitle = "correct :)";
            rightAnswerCount++;

            AlertDialog.Builder builder = new AlertDialog.Builder(this);
            builder.setTitle(alertTitle);

            builder.setMessage("score : " + rightAnswerCount);
            builder.setPositiveButton("OK", new DialogInterface.OnClickListener() {
                @Override
                public void onClick(DialogInterface dialogInterface, int i) {
                    if(quizArray.size()!=0){
                        showNextQuiz();
                    }
                    else{
                        Intent it = new Intent(getApplicationContext(),sumscore3.class);
                        it.putExtra("sum",rightAnswerCount);
                        startActivity(it);
                        finish();
                        //summary
                    }
                }
            });
            builder.setCancelable(false);
            builder.show();
        } else {
            // Wrong...
            alertTitle = "wrong answer :(";

            AlertDialog.Builder builder = new AlertDialog.Builder(this);
            builder.setTitle(alertTitle);

            builder.setMessage("correct answer : " + rightAnswer + "  " + "\nscore : " + rightAnswerCount);
            Gobal global = Gobal.getInstance();
            global.setSum(rightAnswerCount);
            builder.setPositiveButton("OK", new DialogInterface.OnClickListener() {
                @Override
                public void onClick(DialogInterface dialogInterface, int i) {

                    if(quizArray.size()!=0){
                        showNextQuiz();
                    }
                    else{
                        Intent it = new Intent(getApplicationContext(),sumscore3.class);
                        it.putExtra("sum",rightAnswerCount);
                        startActivity(it);
                        finish();
                        //summary
                    }
                }
            });
            builder.setCancelable(false);
            builder.show();
        }

        // Create Dialog.


    }
}
