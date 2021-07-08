package com.example.sundayquiz;

import androidx.appcompat.app.AppCompatActivity;

import android.annotation.SuppressLint;
import android.os.Bundle;
import android.os.CountDownTimer;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.ProgressBar;
import android.widget.TextView;

import com.bumptech.glide.Glide;

public class MainActivity extends AppCompatActivity {
    int i = 0;
    int t = 10;
    int QChecker = 0;
    int Colour_Chk = 5;
    int Stop_btn_Animate = 11;
    int Stop_Watch = 1;
    int Stop_btn_Click = 0;
    int Collect_Final_Score = 0;
    private final String[] Qna = {"What is the fastest animal in the world?",
            "The hardest substance available on earth is",
            "Which of the following is a non metal that remains liquid at room temperature?",
            "Chlorophyll is a naturally occurring chelate compound in which central metal is", "Which of the following is used in pencils?",
            "Which of the following metals forms an amalgam with other metals?",
            "Chemical formula for water is", "The gas usually filled in the electric bulb is", "Washing soda is the common name for",
            "Which of the gas is not known as green house gas?"};

    private final String[] Ans0 = {"Turtle", "Cheetah", "Rabbit", "Leopard"};//Cheetah
    private final String[] Ans1 = {"Gold", "Iron", "Diamond", "Platinum"};//Diamond
    private final String[] Ans2 = {"Phosphorous", "Bromine", "Chlorine", "Helium"};//Bromine
    private final String[] Ans3 = {"Copper", "Magnesium", "Tiron", "Calcium"};//Magnesium
    private final String[] Ans4 = {"Graphite", "Silicon", "Charcoal", "Phosphorous"};//Graphite
    private final String[] Ans5 = {"Tin", "Mercury", "Lead", "Zinc"};//Mercury
    private final String[] Ans6 = {"NaAlO2", "H2O", "Al2O3", "CaSiO3"};//H2O
    private final String[] Ans7 = {"Nitrogen", "Hydrogen", "Carbon dioxide", "Oxygen"};//Nitrogen
    private final String[] Ans8 = {"Sodium carbonate", "Calcium bicarbonate", "Sodium bicarbonate", "Calcium carbonate"};//sodiun carbonate
    private final String[] Ans9 = {"Methane", "Nitrous oxide", "Carbon dioxide", "Hydrogen"};//Hydrogen

    Button button1;
    Button button2;
    Button button3;
    Button button4;
    Button playAgain;
    TextView Quiz;
    TextView Timer;
    TextView Question;
    TextView FinalAns;
    ProgressBar progressBar;
    CountDownTimer mCountDownTimer;
    public void Stop_Click_Again()
    {
        button1.setClickable(false);
        button2.setClickable(false);
        button3.setClickable(false);
        button4.setClickable(false);
    }
    public void Time_Start_Again()
    {
        mCountDownTimer = new CountDownTimer(10000, 1000) {
            @SuppressLint("SetTextI18n")
            @Override
            public void onTick(long millisUntilFinished) {
                i++;
                Timer.setText("0:0" + --t);
                progressBar.setProgress(i * 100 / (10000 / 1000));
            }
            @Override
            public void onFinish() {
                //Do what you want
                this.cancel();
                Cancelled_Animation();
                ResetData_And_Update_2();
            }
        }.start();
    }

    public void Cancelled_Animation()
    {
        if(Stop_btn_Animate==0)
        {
            Cancel_Animation_of_btn2();
        }
        else if(Stop_btn_Animate==1)
        {
            Cancel_Animation_of_btn3();
        }
        else if(Stop_btn_Animate==2)
        {
            Cancel_Animation_of_btn2();
        }
        else if(Stop_btn_Animate==3)
        {
            Cancel_Animation_of_btn2();
        }
        else if(Stop_btn_Animate==4)
        {
            Cancel_Animation_of_btn1();
        }
        else if(Stop_btn_Animate==5)
        {
            Cancel_Animation_of_btn2();
        }
        else if(Stop_btn_Animate==6)
        {
            Cancel_Animation_of_btn2();
        }
        else if(Stop_btn_Animate==7)
        {
            Cancel_Animation_of_btn1();
        }
        else if(Stop_btn_Animate==8)
        {
            Cancel_Animation_of_btn1();
        }
        else if(Stop_btn_Animate==9)
        {
            Cancel_Animation_of_btn4();
        }
    }
    public void Start_Animation_btn1()
    {
        button1.animate().translationYBy(-300f).translationXBy(180f).rotationX(360f).setDuration(1000);
        Quiz.setVisibility(View.INVISIBLE);
        Question.setVisibility(View.INVISIBLE);
        Timer.setVisibility(View.INVISIBLE);
        progressBar.setVisibility(View.INVISIBLE);
        button2.setVisibility(View.INVISIBLE);
        button3.setVisibility(View.INVISIBLE);
        button4.setVisibility(View.INVISIBLE);
        button1.setClickable(false);
    }
    public void Start_Animation_btn2()
    {
        button2.animate().translationYBy(-300f).translationXBy(-180f).rotationX(360f).setDuration(1000);
        Quiz.setVisibility(View.INVISIBLE);
        Question.setVisibility(View.INVISIBLE);
        Timer.setVisibility(View.INVISIBLE);
        progressBar.setVisibility(View.INVISIBLE);
        button1.setVisibility(View.INVISIBLE);
        button3.setVisibility(View.INVISIBLE);
        button4.setVisibility(View.INVISIBLE);
        button2.setClickable(false);
    }
    public void Start_Animation_btn3()
    {
        button3.animate().translationYBy(-520f).translationXBy(180f).rotationX(360f).setDuration(1000);
        Quiz.setVisibility(View.INVISIBLE);
        Question.setVisibility(View.INVISIBLE);
        Timer.setVisibility(View.INVISIBLE);
        progressBar.setVisibility(View.INVISIBLE);
        button1.setVisibility(View.INVISIBLE);
        button2.setVisibility(View.INVISIBLE);
        button4.setVisibility(View.INVISIBLE);
        button3.setClickable(false);
    }
    public void Start_Animation_btn4()
    {
        button4.animate().translationYBy(-520f).translationXBy(-180f).rotationX(360f).setDuration(1000);
        Quiz.setVisibility(View.INVISIBLE);
        Question.setVisibility(View.INVISIBLE);
        Timer.setVisibility(View.INVISIBLE);
        progressBar.setVisibility(View.INVISIBLE);
        button1.setVisibility(View.INVISIBLE);
        button3.setVisibility(View.INVISIBLE);
        button2.setVisibility(View.INVISIBLE);
        button4.setClickable(false);
    }
    public void Cancel_Animation_of_btn1()
    {
        Quiz.setVisibility(View.VISIBLE);
        Question.setVisibility(View.VISIBLE);
        Timer.setVisibility(View.VISIBLE);
        progressBar.setVisibility(View.VISIBLE);
        button2.setVisibility(View.VISIBLE);
        button3.setVisibility(View.VISIBLE);
        button4.setVisibility(View.VISIBLE);
        button1.animate().translationYBy(300f).translationXBy(-180f).setDuration(100);
        Stop_btn_Animate = 11;
    }
    public void Cancel_Animation_of_btn2()
    {
        Quiz.setVisibility(View.VISIBLE);
        Question.setVisibility(View.VISIBLE);
        Timer.setVisibility(View.VISIBLE);
        progressBar.setVisibility(View.VISIBLE);
        button1.setVisibility(View.VISIBLE);
        button3.setVisibility(View.VISIBLE);
        button4.setVisibility(View.VISIBLE);
        button2.animate().translationYBy(300f).translationXBy(180f).setDuration(100);
        Stop_btn_Animate = 11;
    }
    public void Cancel_Animation_of_btn3()
    {
        Quiz.setVisibility(View.VISIBLE);
        Question.setVisibility(View.VISIBLE);
        Timer.setVisibility(View.VISIBLE);
        progressBar.setVisibility(View.VISIBLE);
        button1.setVisibility(View.VISIBLE);
        button2.setVisibility(View.VISIBLE);
        button4.setVisibility(View.VISIBLE);
        button3.animate().translationYBy(520f).translationXBy(-180f).setDuration(100);
        Stop_btn_Animate = 11;
    }
    public void Cancel_Animation_of_btn4()
    {
        Quiz.setVisibility(View.VISIBLE);
        Question.setVisibility(View.VISIBLE);
        Timer.setVisibility(View.VISIBLE);
        progressBar.setVisibility(View.VISIBLE);
        button1.setVisibility(View.VISIBLE);
        button3.setVisibility(View.VISIBLE);
        button2.setVisibility(View.VISIBLE);
        button4.animate().translationYBy(520f).translationXBy(180f).setDuration(100);
        Stop_btn_Animate = 11;
    }

    public void ResetData_And_Update()
    {
        i=0;
        t=10;
        Question.setText(Qna[QChecker+1]);
        QChecker++;
        button1.setBackgroundResource(R.drawable.btn_bg);
        button2.setBackgroundResource(R.drawable.btn_bg);
        button3.setBackgroundResource(R.drawable.btn_bg);
        button4.setBackgroundResource(R.drawable.btn_bg);
    }
    @SuppressLint("SetTextI18n")
    public void ResetData_And_Update_2()
    {
        Quiz.setVisibility(View.INVISIBLE);
        Question.setVisibility(View.INVISIBLE);
        Timer.setVisibility(View.INVISIBLE);
        progressBar.setVisibility(View.INVISIBLE);
        button1.setVisibility(View.INVISIBLE);
        button2.setVisibility(View.INVISIBLE);
        button3.setVisibility(View.INVISIBLE);
        button4.setVisibility(View.INVISIBLE);
        FinalAns.setVisibility(View.VISIBLE);
        //playAgain.setVisibility(View.VISIBLE);//Working On it.... See Line 653
        FinalAns.setText("Your Final Score is "+Collect_Final_Score+"/10");
    }

    @SuppressLint("SetTextI18n")
    public void GenerateQuestion() {
        if(QChecker==1)
        {

           button1.setText(Ans1[0]);
           button2.setText(Ans1[1]);
           button3.setText(Ans1[2]);
           button4.setText(Ans1[3]);
           //Colour Changing...
            button1.setOnClickListener(v -> {
                Stop_btn_Click = 0;
                button1.setBackgroundResource(R.drawable.bg_red);
                if(Stop_btn_Click == 0) {
                    Stop_Click_Again();
                }
            });
            button2.setOnClickListener(v -> {
                Stop_btn_Click = 0;
                button2.setBackgroundResource(R.drawable.bg_red);
                if(Stop_btn_Click == 0) {
                    Stop_Click_Again();
                }
            });
            button3.setOnClickListener(v -> {
                button3.setBackgroundResource(R.drawable.bg_green);
                Stop_btn_Animate = 1;
                Collect_Final_Score++;
                Start_Animation_btn3();
            });
            button4.setOnClickListener(v -> {
                Stop_btn_Click = 0;
                button4.setBackgroundResource(R.drawable.bg_red);
                if(Stop_btn_Click == 0) {
                    Stop_Click_Again();
                }
            });
        }
        else if(QChecker==2)
        {

            button1.setText(Ans2[0]);
            button2.setText(Ans2[1]);
            button3.setText(Ans2[2]);
            button4.setText(Ans2[3]);
            //Colour Changing...
            button1.setOnClickListener(v -> {
                Stop_btn_Click = 1;
                button1.setBackgroundResource(R.drawable.bg_red);
                if(Stop_btn_Click == 1) {
                    Stop_Click_Again();
                }
            });
            button2.setOnClickListener(v -> {
                button2.setBackgroundResource(R.drawable.bg_green);
                Stop_btn_Animate = 2;
                Collect_Final_Score++;
                Start_Animation_btn2();
            });
            button3.setOnClickListener(v -> {
                Stop_btn_Click = 1;
                button3.setBackgroundResource(R.drawable.bg_red);
                if(Stop_btn_Click == 1) {
                    Stop_Click_Again();
                }
            });
            button4.setOnClickListener(v -> {
                Stop_btn_Click=1;
                button4.setBackgroundResource(R.drawable.bg_red);
                if(Stop_btn_Click == 1) {
                    Stop_Click_Again();
                }
            });
        }
        else if(QChecker==3)
        {

            button1.setText(Ans3[0]);
            button2.setText(Ans3[1]);
            button3.setText(Ans3[2]);
            button4.setText(Ans3[3]);
            //Colour Changing...
            button1.setOnClickListener(v -> {
                Stop_btn_Click=0;
                button1.setBackgroundResource(R.drawable.bg_red);
                if(Stop_btn_Click == 0) {
                    Stop_Click_Again();
                }
            });
            button2.setOnClickListener(v -> {
                button2.setBackgroundResource(R.drawable.bg_green);
                Stop_btn_Animate = 3;
                Collect_Final_Score++;
                Start_Animation_btn2();
            });
            button3.setOnClickListener(v -> {
                Stop_btn_Click=0;
                button3.setBackgroundResource(R.drawable.bg_red);
                if(Stop_btn_Click == 0) {
                    Stop_Click_Again();
                }
            });
            button4.setOnClickListener(v -> {
                Stop_btn_Click=0;
                button4.setBackgroundResource(R.drawable.bg_red);
                if(Stop_btn_Click == 0) {
                    Stop_Click_Again();
                }
            });
        }
        else if(QChecker==4)
        {

            button1.setText(Ans4[0]);
            button2.setText(Ans4[1]);
            button3.setText(Ans4[2]);
            button4.setText(Ans4[3]);
            //Colour Changing...
            button1.setOnClickListener(v -> {
                button1.setBackgroundResource(R.drawable.bg_green);
                Stop_btn_Animate = 4;
                Collect_Final_Score++;
                Start_Animation_btn1();
            });
            button2.setOnClickListener(v -> {
                Stop_btn_Click=1;
                button2.setBackgroundResource(R.drawable.bg_red);
                if(Stop_btn_Click == 1) {
                    Stop_Click_Again();
                }
            });
            button3.setOnClickListener(v -> {
                Stop_btn_Click=1;
                button3.setBackgroundResource(R.drawable.bg_red);
                if(Stop_btn_Click == 1) {
                    Stop_Click_Again();
                }
            });
            button4.setOnClickListener(v -> {
                Stop_btn_Click=1;
                button4.setBackgroundResource(R.drawable.bg_red);
                if(Stop_btn_Click == 1) {
                    Stop_Click_Again();
                }
            });
        }
        else if(QChecker==5)
        {

            button1.setText(Ans5[0]);
            button2.setText(Ans5[1]);
            button3.setText(Ans5[2]);
            button4.setText(Ans5[3]);
            //Colour Changing...
            button1.setOnClickListener(v -> {
                Stop_btn_Click=0;
                button1.setBackgroundResource(R.drawable.bg_red);
                if(Stop_btn_Click == 0) {
                    Stop_Click_Again();
                }
            });
            button2.setOnClickListener(v -> {
                button2.setBackgroundResource(R.drawable.bg_green);
                Stop_btn_Animate = 5;
                Collect_Final_Score++;
                Start_Animation_btn2();
            });
            button3.setOnClickListener(v -> {
                Stop_btn_Click=0;
                button3.setBackgroundResource(R.drawable.bg_red);
                if(Stop_btn_Click == 0) {
                    Stop_Click_Again();
                }
            });
            button4.setOnClickListener(v -> {
                Stop_btn_Click=0;
                button4.setBackgroundResource(R.drawable.bg_red);
                if(Stop_btn_Click == 0) {
                    Stop_Click_Again();
                }
            });
        }
        else if(QChecker==6)
        {

            button1.setText(Ans6[0]);
            button2.setText(Ans6[1]);
            button3.setText(Ans6[2]);
            button4.setText(Ans6[3]);
            //Colour Changing...
            button1.setOnClickListener(v -> {
                Stop_btn_Click=1;
                button1.setBackgroundResource(R.drawable.bg_red);
                if(Stop_btn_Click == 1) {
                    Stop_Click_Again();
                }
            });
            button2.setOnClickListener(v -> {
                button2.setBackgroundResource(R.drawable.bg_green);
                Stop_btn_Animate = 6;
                Collect_Final_Score++;
                Start_Animation_btn2();
            });
            button3.setOnClickListener(v -> {
                Stop_btn_Click=1;
                button3.setBackgroundResource(R.drawable.bg_red);
                if(Stop_btn_Click == 1) {
                    Stop_Click_Again();
                }
            });
            button4.setOnClickListener(v -> {
                Stop_btn_Click=1;
                button4.setBackgroundResource(R.drawable.bg_red);
                if(Stop_btn_Click == 1) {
                    Stop_Click_Again();
                }
            });
        }
        else if(QChecker==7)
        {

            button1.setText(Ans7[0]);
            button2.setText(Ans7[1]);
            button3.setText(Ans7[2]);
            button4.setText(Ans7[3]);
            //Colour Changing...
            button1.setOnClickListener(v -> {
                button1.setBackgroundResource(R.drawable.bg_green);
                Stop_btn_Animate = 7;
                Collect_Final_Score++;
                Start_Animation_btn1();
            });
            button2.setOnClickListener(v -> {
                Stop_btn_Click=0;
                button2.setBackgroundResource(R.drawable.bg_red);
                if(Stop_btn_Click == 0) {
                    Stop_Click_Again();
                }
            });
            button3.setOnClickListener(v -> {
                Stop_btn_Click=0;
                button3.setBackgroundResource(R.drawable.bg_red);
                if(Stop_btn_Click == 0) {
                    Stop_Click_Again();
                }
            });
            button4.setOnClickListener(v -> {
                Stop_btn_Click=0;
                button4.setBackgroundResource(R.drawable.bg_red);
                if(Stop_btn_Click == 0) {
                    Stop_Click_Again();
                }
            });
        }
        else if(QChecker==8)
        {

            button1.setText(Ans8[0]);
            button2.setText(Ans8[1]);
            button3.setText(Ans8[2]);
            button4.setText(Ans8[3]);
            //Colour Changing...
            button1.setOnClickListener(v -> {
                button1.setBackgroundResource(R.drawable.bg_green);
                Stop_btn_Animate = 8;
                Collect_Final_Score++;
                Start_Animation_btn1();
            });
            button2.setOnClickListener(v -> {
                Stop_btn_Click=1;
                button2.setBackgroundResource(R.drawable.bg_red);
                if(Stop_btn_Click == 1) {
                    Stop_Click_Again();
                }
            });
            button3.setOnClickListener(v -> {
                Stop_btn_Click=1;
                button3.setBackgroundResource(R.drawable.bg_red);
                if(Stop_btn_Click == 1) {
                    Stop_Click_Again();
                }
            });
            button4.setOnClickListener(v -> {
                Stop_btn_Click=1;
                button4.setBackgroundResource(R.drawable.bg_red);
                if(Stop_btn_Click == 1) {
                    Stop_Click_Again();
                }
            });
        }
        else if(QChecker==9)
        {
            button1.setText(Ans9[0]);
            button2.setText(Ans9[1]);
            button3.setText(Ans9[2]);
            button4.setText(Ans9[3]);
            //Colour Changing...
            button1.setOnClickListener(v -> {
                Stop_btn_Click=0;
                button1.setBackgroundResource(R.drawable.bg_red);
                if(Stop_btn_Click == 0) {
                    Stop_Click_Again();
                }
            });
            button2.setOnClickListener(v -> {
                Stop_btn_Click=0;
                button2.setBackgroundResource(R.drawable.bg_red);
                if(Stop_btn_Click == 0) {
                    Stop_Click_Again();
                }
            });
            button3.setOnClickListener(v -> {
                Stop_btn_Click=0;
                button3.setBackgroundResource(R.drawable.bg_red);
                if(Stop_btn_Click == 0) {
                    Stop_Click_Again();
                }
            });
            button4.setOnClickListener(v -> {
                button4.setBackgroundResource(R.drawable.bg_green);
                Stop_btn_Animate = 9;
                Collect_Final_Score++;
                Start_Animation_btn4();
            });
        }
    }

    @SuppressLint("SetTextI18n")
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        ImageView imageView4;
        imageView4 = findViewById(R.id.imageView4);
        Glide.with(this).load(R.drawable.celeb).into(imageView4);
        progressBar = findViewById(R.id.progressBar);
        Timer = findViewById(R.id.Timer);
        Quiz = findViewById(R.id.Quiz);
        FinalAns = findViewById(R.id.FinalAns);
        Question = findViewById(R.id.Question);
        playAgain = findViewById(R.id.playAgain);
        button1 = findViewById(R.id.button1);
        button2 = findViewById(R.id.button2);
        button3 = findViewById(R.id.button3);
        button4 = findViewById(R.id.button4);
        if(Colour_Chk==5)
        {
                    button1.setOnClickListener(v -> {
                        Stop_btn_Click = 1;
                        button1.setBackgroundResource(R.drawable.bg_red);
                        if(Stop_btn_Click == 1) {
                            Stop_Click_Again();
                        }
                    });
                    button2.setOnClickListener(v -> {
                        button2.setBackgroundResource(R.drawable.bg_green);
                        Stop_btn_Animate = 0;
                        Collect_Final_Score++;
                        Start_Animation_btn2();
                    });
                    button3.setOnClickListener(v -> {
                        Stop_btn_Click = 1;
                        button3.setBackgroundResource(R.drawable.bg_red);
                        if(Stop_btn_Click == 1) {
                            Stop_Click_Again();
                        }
                    });
                    button4.setOnClickListener(v -> {
                        Stop_btn_Click = 1;
                        button4.setBackgroundResource(R.drawable.bg_red);
                        if(Stop_btn_Click == 1) {
                            Stop_Click_Again();
                        }
                    });
            Colour_Chk=6;
        }
        progressBar.setProgress(i);
            mCountDownTimer = new CountDownTimer(10000, 1000) {
                @SuppressLint("SetTextI18n")
                @Override
                public void onTick(long millisUntilFinished) {
                    i++;
                    Timer.setText("0:0" + --t);
                    progressBar.setProgress(i * 100 / (10000 / 1000));
                }
                @SuppressLint("SetTextI18n")
                @Override
                public void onFinish() {
                    //Do what you want
                    Timer.setText("0:00");
                    i++;
                    Stop_Watch++;
                    progressBar.setProgress(100);
                    this.cancel();
                    Cancelled_Animation();
                    ResetData_And_Update();
                    GenerateQuestion();
                    this.start();
                    if(Stop_Watch==10) {
                     mCountDownTimer.cancel();
                     Time_Start_Again();
                    }
                }
            }.start();
          /*  playAgain.setOnClickListener(v -> {
                i=0;
                t=10;
                QChecker=0;
                Colour_Chk = 5;
                Stop_btn_Animate = 11;
                Stop_Watch = 1;
                Stop_btn_Click = 0;
                Collect_Final_Score = 0;
                Question.setText(Qna[QChecker]);
                QChecker++;
                button1.setBackgroundResource(R.drawable.btn_bg);
                button2.setBackgroundResource(R.drawable.btn_bg);
                button3.setBackgroundResource(R.drawable.btn_bg);
                button4.setBackgroundResource(R.drawable.btn_bg);
                FinalAns.setVisibility(View.INVISIBLE);
                playAgain.setVisibility(View.INVISIBLE);
                Quiz.setVisibility(View.VISIBLE);
                Question.setVisibility(View.VISIBLE);
                Timer.setVisibility(View.VISIBLE);
                progressBar.setVisibility(View.VISIBLE);
                button1.setVisibility(View.VISIBLE);
                button2.setVisibility(View.VISIBLE);
                button3.setVisibility(View.VISIBLE);
                button4.setVisibility(View.VISIBLE);
                button1.setText(Ans0[0]);
                button2.setText(Ans0[1]);
                button3.setText(Ans0[2]);
                button4.setText(Ans0[3]);
                Timer_For_Play_Again();
            });
        }
        public void Timer_For_Play_Again()
        {
            progressBar.setProgress(i);
            mCountDownTimer = new CountDownTimer(10000, 1000) {
                @SuppressLint("SetTextI18n")
                @Override
                public void onTick(long millisUntilFinished) {
                    i++;
                    Timer.setText("0:0" + --t);
                    progressBar.setProgress(i * 100 / (10000 / 1000));
                }
                @SuppressLint("SetTextI18n")
                @Override
                public void onFinish() {
                    //Do what you want
                    Timer.setText("0:00");
                    i++;
                    Stop_Watch++;
                    progressBar.setProgress(100);
                    this.cancel();
                    Cancelled_Animation();
                    ResetData_And_Update();
                    GenerateQuestion();
                    this.start();
                    if(Stop_Watch==10) {
                        mCountDownTimer.cancel();
                        Time_Start_Again();
                    }
                }
            }.start();*/
        }
}