package com.example.dynamiclayout

import android.content.res.Resources
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.Gravity
import android.view.View
import android.widget.*
import kotlinx.android.synthetic.main.activity_main.*
import java.util.*

const val margin: Int = 16

//extension property to convert dp into pixel
val Int.pixel: Int   //this functioj coverts dp to pixel    variable calls the function
    get() = (this * Resources.getSystem().displayMetrics.density).toInt()

class MainActivity : AppCompatActivity() {
    private var questions: MutableList<Question> = mutableListOf()


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        setupQuestions()
        setupQuiz()
        setupSubmitButton()
    }

    private fun setupQuestions(){

        questions.add(Question(1, QuestionType.Text, "What is the capital of Nagaland?",
            null, listOf("kohima")))
//line type me options pass nhi kara
//mutable list me add
            //answer pass
        questions.add(Question(2, QuestionType.Radio, "Which is the largest(area) state of India?",
            listOf("Bihar", "Madhya Pradesh", "Uttar Pradesh", "Rajasthan"), listOf("Rajasthan")))

        questions.add(Question(3, QuestionType.CheckBox, "Which of these are state capitals?",
            listOf("Guwahati", "Chennai", "Varanasi", "Dispur"), listOf("Chennai", "Dispur")))



    }

    private fun setupQuiz(){
        questions.forEachIndexed{index, element ->
            when(element.type){
                QuestionType.Text ->{
                    setupTextQuestion(index, element)
                }
                QuestionType.Radio ->{
                    setupRadioQuestion(index, element)
                }
                QuestionType.CheckBox ->{
                    setupCheckBoxQuestion(index, element)
                }
            }
        }
    }


    //method to pass a view to xml file for question of type text
    private fun setupTextQuestion(counter: Int, q: Question){//counter and question pass
        val textView = getQuestionTextView(counter, q.qText)//question remains the same

        val editText = EditText(this)
        editText.id = q.id
        editText.setSingleLine(true)
        editText.layoutParams = LinearLayout.LayoutParams(
            LinearLayout.LayoutParams.MATCH_PARENT,
            LinearLayout.LayoutParams.WRAP_CONTENT
        )
        quiz_container.addView(textView)//activuty main.xml me pass
        quiz_container.addView(editText)

    }
//method to pass a view to xml file for question of type radio
    private fun setupRadioQuestion(counter: Int, q: Question){

        val textView = getQuestionTextView(counter, q.qText)//get's the question

        val radioGroup = RadioGroup(this)//radio builting class
        radioGroup.id = q.id
        radioGroup.orientation = RadioGroup.VERTICAL

        radioGroup.layoutParams = LinearLayout.LayoutParams(
            LinearLayout.LayoutParams.MATCH_PARENT,//layout paramets pass
            LinearLayout.LayoutParams.WRAP_CONTENT
        )

        q.options?.forEachIndexed{ index, element ->//we go to each possible otoons to set it
            val radioButton = RadioButton(this)
            radioButton.text = element
            radioButton.id = (q.id.toString() + index.toString()).toInt()//to make the id of option unique
            radioGroup.addView(radioButton)
        }

        quiz_container.addView(textView)
        quiz_container.addView(radioGroup)
    }


    private fun setupCheckBoxQuestion(counter: Int, q: Question){

        val textView = getQuestionTextView(counter, q.qText)
        quiz_container.addView(textView)

        val params = LinearLayout.LayoutParams(
            LinearLayout.LayoutParams.MATCH_PARENT,
            LinearLayout.LayoutParams.WRAP_CONTENT
        )

        q.options?.forEachIndexed{ index, element ->
            val checkBox = CheckBox(this)
            checkBox.text = element
            checkBox.id = (q.id.toString() + index.toString()).toInt()
            checkBox.layoutParams = params
            quiz_container.addView(checkBox)//.xml me compoenet class hai
        }
    }

    private fun getQuestionTextView(counter: Int, question: String): TextView {
        val textView = TextView(this)
        textView.text = getString(R.string.question, counter, question)

        textView.layoutParams = LinearLayout.LayoutParams(//questions are at linear layout
            LinearLayout.LayoutParams.MATCH_PARENT,//setting the property
            LinearLayout.LayoutParams.WRAP_CONTENT
        ).apply { topMargin = margin.pixel }//space between each question
                                           //margin dp me hta hai so we have already declared it above
                                          //but this function takes in pixel so there is a function to convert a dp to pixel
        return textView//text view returned
    }


    private fun setupSubmitButton(){//submit button proprty set
        val params  = LinearLayout.LayoutParams(//para,eters for linear layout set
            LinearLayout.LayoutParams.WRAP_CONTENT,
            LinearLayout.LayoutParams.WRAP_CONTENT//pass the properties
        )
        params.topMargin = margin.pixel//margin pass
        params.gravity = Gravity.CENTER_HORIZONTAL//gravity pass

        val button = Button(this)
        button.layoutParams = params
        button.text = getString(R.string.submit)//text paas
        button.setOnClickListener{
            evaluateQuiz()
        }

        quiz_container.addView(button)//button view addd in activity main.xml
    }

//now evaluating the quiz on submit the quiz

    private fun evaluateQuiz() {
        var score = 0

        questions.forEach{ q ->//go throug eacj q
            when(q.type){//switch case
                QuestionType.Text ->{
                    val editText = quiz_container.findViewById<EditText>(q.id)//if the edit text is not absent

                    editText?.let{
                        val userAnswer = it.text.toString().toLowerCase(Locale.getDefault())//converting the answer to lower case
                        if(userAnswer == q.answers[0]){//matching the user entered answer to the correct answer
                            score++
                        }
                    }
                }
                QuestionType.Radio -> {
                    val radioGroup = quiz_container.findViewById<RadioGroup>(q.id)

                    radioGroup?.let{
                        val checkedId = it.checkedRadioButtonId//proprty of radio class
                        if(checkedId > 0){//if not checked values =-1
                            val radioButton = quiz_container.findViewById<RadioButton>(checkedId)
                            val userAnswer = radioButton.text
                            if(userAnswer == q.answers[0]){
                                score++
                            }
                        }
                    }
                }
                QuestionType.CheckBox -> {
                    var correct = true//assume uer answer as true

                    q.options?.forEachIndexed{index, element ->
                        val checkedId = (q.id.toString() + index.toString()).toInt()
                        val checkBox =  quiz_container.findViewById<CheckBox>(checkedId)
                        if(q.answers.contains(checkBox.text)){//first each oprion is passes to if then it is checked that whether it is selected or not
                            if(!checkBox.isChecked){//first each option is passed to check whether it is in anse=wer or not then it is checked that if it is selected by user or not
                                correct = false
                            }
                        } else{
                            if(checkBox.isChecked){
                                correct = false
                            }
                        }
                    }
                    if(correct) score++//if boolena remains true
                }
            }
        }
        //neeche jo message ata hai
        Toast.makeText(this, getString(R.string.score_result, score, questions.size), Toast.LENGTH_SHORT).show()
    }
}
