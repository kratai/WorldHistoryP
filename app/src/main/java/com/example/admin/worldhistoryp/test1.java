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
import android.widget.LinearLayout;
import android.widget.TextView;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Random;

public class test1 extends AppCompatActivity {
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
            {"พระเจ้าเอล็กซานเดอร์มหาราชไม่ได้ไปพิชิตทวีปใด", "ออสเตรเลีย", "ยุโรป", "เอเชีย", "แอฟริกา"},
            {"มนุษย์ประเภทใดที่เป็นบรรพบุรุษของมนุษย์ยุคปัจจุบัน", "โฮโม เซเปียนส์", "นีแอนเดอร์ทัล", "โฮโม อิเล็กตัส", "ออสตราโลพิเทคัส"},
            {"อารยธรรมอียิปต์เกิดขึ้นที่บริเวณลุ่มแม่น้ำใด", "ไนล์", "สินธุ", "ไทกริส-ยูเฟรทีส", "ฮวงโห"},
            {"ราชวงศ์ใดของจีนที่เป็นยุคทองของอารยธรรมจีน", "ราชวงศ์ถัง", "ราชวงศ์หมิง", "ราชวงศ์ฉิน", "ราชวงศ์ชิง"},
            {"บันทึกของ มาร์โก โปโล มีจุดหมายอยู่ที่ประเทศใด", "จีน", "ตุรกี", "อิหร่าน", "อิรัก"},
            {"ใครเป็นผู้ผลิตแป้นพิมพ์", "โยฮันน์ กูเทนแบร์ก", "ไช่หลุน", "ชอง โกแวง", "โจนออฟอาร์ก"},
            {"ใครเป็นคนจัดตั้งนิกายโปรเตสแตนท์ในศาสนาคริสต์", "มา์ติน ลูเทอร์", "ชอง โกแวง", "โสคราตีส", "ชาล์ส ดาร์วิน"},
            {"เกาหลีเหนือได้รับการสนับสนุนจากประเทศใด", "จีน สหภาพโซเวียต", "สหภาพโซเวียต อเมริกา", "อังกฤษ ฝรั่งเศษ", "จีน อเมริกา"},
            {"สงครามที่ไม่ได้ต่อสู้กันด้วย อาวุธ ยุทโธปกรณ์ คือสงครามใด", "สงครามเย็น", "สงครามอ่าวเปอร์เซีย", "สงครามโลกครั้งที่2", "สงครามครูเสด"},
            {"สงครามสามสิบปีไม่ได้ครอบคลุมพื้นที่ใด", "อังกฤษ", "บาวาเรีย", "เยอรมนี", "อิตาลี"},

    };


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_test1);

//        chooseans = (ImageView)findViewById(R.id.chooseans);
        questionLabel = (TextView)findViewById(R.id.questionLabel);
        answerBtn1 = (Button)findViewById(R.id.answerBtn1);
        answerBtn2 = (Button)findViewById(R.id.answerBtn2);
        answerBtn3 = (Button)findViewById(R.id.answerBtn3);
        answerBtn4 = (Button)findViewById(R.id.answerBtn4);

        lefttoright = AnimationUtils.loadAnimation(this,R.anim.lefttoright);
        righttoleft = AnimationUtils.loadAnimation(this,R.anim.righttoleft);
        lefttoright = AnimationUtils.loadAnimation(this,R.anim.lefttoright);
        righttoleft = AnimationUtils.loadAnimation(this,R.anim.righttoleft);

        //answerBtn1.setAnimation(lefttoright);
        //answerBtn2.setAnimation(righttoleft);
        //answerBtn3.setAnimation(lefttoright);
        //answerBtn4.setAnimation(righttoleft);

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
        //140261 1.17 pm
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
                        Intent it = new Intent(getApplicationContext(),sumscore.class);
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
                        Intent it = new Intent(getApplicationContext(),sumscore.class);
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
