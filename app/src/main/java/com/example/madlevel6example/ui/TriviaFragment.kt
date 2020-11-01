package com.example.madlevel6example.ui

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Toast
import androidx.fragment.app.activityViewModels
import com.example.madlevel6example.R
import androidx.lifecycle.Observer
import kotlinx.android.synthetic.main.fragment_trivia.*

class TriviaFragment : Fragment() {
    private val viewModel: TriviaViewModel by activityViewModels()

    override fun onCreateView(
            inflater: LayoutInflater, container: ViewGroup?,
            savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        return inflater.inflate(R.layout.fragment_trivia, container, false)
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        observeTrivia()
    }

    private fun observeTrivia() {
        viewModel.trivia.observe(viewLifecycleOwner, Observer {
                trivia ->
            tvTrivia.text = trivia?.text
        })

        // Observe the error message.
        viewModel.errorText.observe(viewLifecycleOwner, Observer {
                error ->
            Toast.makeText(activity, error, Toast.LENGTH_SHORT).show()
        })
    }

}