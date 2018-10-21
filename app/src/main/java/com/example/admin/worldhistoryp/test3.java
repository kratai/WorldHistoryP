package com.example.admin.worldhistoryp;

import android.content.DialogInterface;
import android.content.Intent;
import android.support.v7.app.AlertDialog;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Random;

public class test3 extends AppCompatActivity {
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
            {"การเกิดสงครามพิวนิกครั้งที1 เกิดจากความขัดแย้งกันในเรื่องใด", "ทิศตะวันตก", "ทิศตะวันออก", "ทิศเหนือ", "ทิศใต้"},
            {"การประกาศอิสรภาพของอเมริกาได้รับการรับรองตามคำประกาศอิสรภาพของใคร", "ทอมัส เจฟเฟอร์สัน", "อับราฮัม ลิงคอร์น", "จอร์จ วอชิงตัน", "ทอมัส เอดิสัน"},
            {"การเกิดสงครามกลางเมืองอเมริกาเกิดขึ้นระหว่างรัฐใด", "รัฐทางเหนือและรัฐทางใต้", "รัฐทางตะวันออกและรัฐทางใต้", "รัฐทางใต้และรัฐทางตะวันตก", "รัฐทางเหนือและรัฐทางตะวันตก"},
            {"ใครเป็นคนประดิษฐ์หลอดไฟไส้คาร์บอน", "ทอมัส เอดิสัน", "อับลาฮัม ลิงคอร์น", "นีล อาร์มสตรอง", "เจ.เค.โรลว์ลิ่ง"},
            {"สงครามโลกครั้งที่1ฝ่ายมหาอำนาจกลางนำโดยประเทศใดบ้าง", "เยอรมนี ออสเตรีย-ฮังการี อิตาลี", "อังกฤษ ฝรั่งเศส รัสเซีย", "เยอรมนี อังกฤษ อิตาลี", "อังกฤษ เซอร์เบีย รัสเซีย"},
            {"การเกิดเศรษฐกิจตกต่ำครั้งใหญ่เริ่มมาจากประเทศใด", "สหรัฐอเมริกา", "อังกฤษ", "ญี่ปุ่น", "ฝรั่งเศส"},
            {"ระเบิดนิวเคลียร์ที่สหรัฐทิ้งที่ฮิโรชิม่ามีชื่อว่าอะไร", "ลิตเทิลบอย", "แฟตแมน", "บูมบาย่า", "ลิตเทิลแฟตแมน"},
            {"นักบินอวกาศที่ได้เหยียบดวงจันทร์คนแรกคือใคร", "นีล อาร์มสตรอง", "เอดวิน แอลดริน", "ไมเคิล คอลลินส์", "จอห์น เคเนดี"},
            {"ใครเป็นผู้พิชิตขั้วโลกใต้", "โรอัลด์ อามุนเซน", "มารี กูรี", "มาร์ติน ลูเทอร์", "เฟอร์ดินัน มาเจลลัน"},
            {"เข็มทิศเป็นสิ่งประดิษฐ์ของประเทศใด", "จีน", "อังกฤษ", "ญี่ปุ่น", "อินเดีย"},

    };


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_test3);
        chooseans = (ImageView) findViewById(R.id.chooseans);
        questionLabel = (TextView) findViewById(R.id.questionLabel);
        answerBtn1 = (Button) findViewById(R.id.answerBtn1);
        answerBtn2 = (Button) findViewById(R.id.answerBtn2);
        answerBtn3 = (Button) findViewById(R.id.answerBtn3);
        answerBtn4 = (Button) findViewById(R.id.answerBtn4);

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
                        startActivity(it);
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
                        startActivity(it);
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
