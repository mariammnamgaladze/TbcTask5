package com.example.tbctask5

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.View
import android.widget.Button
import androidx.navigation.fragment.findNavController

class LoggedOutFragment : Fragment(R.layout.fragment_logged_out),View.OnClickListener {
     private lateinit var logIn : Button
     private lateinit var register : Button

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        view.findViewById<Button>(R.id.logInBtn1).setOnClickListener(this)
        view.findViewById<Button>(R.id.registerBtn1).setOnClickListener(this)

        logIn = view.findViewById(R.id.logInBtn1)
        register = view.findViewById(R.id.registerBtn1)
    }

    override fun onClick(v: View?) {
        when (v!!.id) {
            R.id.logInBtn1 -> findNavController().navigate(R.id.action_loggedOutFragment_to_logInFragment)
            R.id.registerBtn1 -> findNavController().navigate(R.id.action_loggedOutFragment_to_registerFragment)
        }

    }


}