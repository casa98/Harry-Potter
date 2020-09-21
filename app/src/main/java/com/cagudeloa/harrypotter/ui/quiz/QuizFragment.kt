package com.cagudeloa.harrypotter.ui.quiz

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.appcompat.app.AppCompatActivity
import androidx.databinding.DataBindingUtil
import androidx.navigation.findNavController
import com.cagudeloa.harrypotter.R
import com.cagudeloa.harrypotter.databinding.FragmentQuizBinding

class QuizFragment : Fragment() {

    private lateinit var binding: FragmentQuizBinding
    data class Question(
        val text: String,
        val answers: List<String>)

    // This SHOULDN'T BE HARDCODED, NOT EVEN HERE BUT FROM A DATA SOURCE
    private val questions: MutableList<Question> = mutableListOf(
        Question(text = "¿Qué personaje tiene una  cicatriz en la rodilla?",
            answers = listOf("Albus Dumbledore", "Neville Longbottom", "Hermaione Granger", "Severus Snape")),
        Question(text = "¿Quién muere en el tornero de los 3 magos?",
            answers = listOf("Cedric  Diggoy", "Harry Potter", "Victor  Krum", "Fleur Delacour")),
        Question(text = "¿Cuál es la fecha de la muerte de los padres de Harry Potter?",
            answers = listOf("31-10-1981", "31-07-1980", "02-05-199", "No murieron")),
        Question(text = "¿Cuál es el nombre de Lord Voldemort?",
            answers = listOf("Tom Riddle", "El innombrable", "Lucius Malfoy", "Alastor Moody")),
        Question(text = "¿Cuántos hijos tiene la familia Weasly?",
            answers = listOf("7", "4", "2", "6")),
        Question(text = "¿En qué año  se fundó Hogwarts?",
            answers = listOf("990", "1900", "1945", "1810")),
        Question(text = "¿Cómo se llamaba el grupo de los amigos en la adolescencia del padre de Harry?",
            answers = listOf("Los merodeadores", "Los animagos", "Los mortifagos", "Trio de Oro")),
        Question(text = "¿Cuántos Jugadores tiene un equipo de Quidditch?",
            answers = listOf("7", "5", "6", "4")),
        Question(text = "El bezoar es una piedra utilizada en las pociones y sirve para salvarte de:",
            answers = listOf("Envenenamiento", "Quemaduras", "Magia negra", "Tu ex")),
        Question(text = "¿Qué posición  ocupa Harry Potter en el quidditch?",
            answers = listOf("Buscador", "Guardián", "Cazador", "Golpeador")),
        Question(text = "¿Quién mató  a Sirius Black?",
            answers = listOf("Bellatrix Lestrange", "Cola de gusano", "Severus Snape", "Está vivito y coleando")),
        Question(text = "Cuantos Horrocrux  tenía Voldemort?",
            answers = listOf("7", "1", "10", "4")))

    lateinit var currentQuestion: Question
    lateinit var answers: MutableList<String>
    private var questionIndex = 0
    private val numQuestions = 5

    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?, savedInstanceState: Bundle?): View? {
        // Inflate the layout for this fragment
        binding = DataBindingUtil.inflate(inflater, R.layout.fragment_quiz, container, false)

        // Shuffles the questions and sets the question index to the first question.
        randomizeQuestions()

        // Bind this fragment class to the layout
        binding.quiz = this

        binding.submitButton.setOnClickListener {view ->
            val checkedId = binding.quizRadioGroup.checkedRadioButtonId
            // Do nothing if nothing is checked (id == -1)
            if (checkedId != -1) {
                var answerIndex = 0
                when (checkedId) {
                    R.id.secondAnswerRadioButton -> answerIndex = 1
                    R.id.thirdAnswerRadioButton -> answerIndex = 2
                    R.id.fourthAnswerRadioButton -> answerIndex = 3
                }
                // The first answer in the original question is always the correct one, so if our
                // answer matches, we have the correct answer.
                if (answers[answerIndex] == currentQuestion.answers[0]) {
                    questionIndex++
                    // Advance to the next question
                    if (questionIndex < numQuestions) {
                        currentQuestion = questions[questionIndex]
                        setQuestion()
                        binding.invalidateAll()
                    } else {
                        // We've won!  Navigate to the gameWonFragment.
                        view.findNavController().navigate(R.id.action_quizFragment_to_gameWonFragment)
                    }
                } else {
                    // Game over! A wrong answer sends us to the gameOverFragment.
                    view.findNavController().navigate(R.id.action_quizFragment_to_gameLostFragment)
                }
            }
        }

        return binding.root
    }

    // randomize the questions and set the first question
    private fun randomizeQuestions() {
        questions.shuffle()
        questionIndex = 0
        setQuestion()
    }

    // Sets the question and randomizes the answers.  This only changes the data, not the UI.
    // Calling invalidateAll on the FragmentGameBinding updates the data.
    private fun setQuestion() {
        currentQuestion = questions[questionIndex]
        // randomize the answers into a copy of the array
        answers = currentQuestion.answers.toMutableList()
        // and shuffle them
        answers.shuffle()
        //(activity as AppCompatActivity).supportActionBar?.title = getString(R.string.title_android_trivia_question, questionIndex + 1, numQuestions)
    }
}