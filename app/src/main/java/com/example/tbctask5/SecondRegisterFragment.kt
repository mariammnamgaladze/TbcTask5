package com.example.tbctask5

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.View
import android.widget.Button
import android.widget.EditText
import android.widget.ImageButton
import androidx.navigation.fragment.findNavController


class SecondRegisterFragment : Fragment(),View.OnClickListener {
    private lateinit var registerUsername : EditText
    private lateinit var signUp : Button
    private lateinit var registerBackBtn2 : ImageButton

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        registerUsername = view.findViewById(R.id.usernameText)
        signUp = view.findViewById(R.id.signUpBtn)
        registerBackBtn2 = view.findViewById(R.id.registerBackSignBtn2)

        view.findViewById<Button>(R.id.registerBackSignBtn2).setOnClickListener(this)

    }

    override fun onClick(v: View?) {
        when (v!!.id) {
            R.id.registerBackSignBtn2 -> findNavController().navigate(R.id.action_secondRegisterFragment_to_registerFragment)
        }

        

    }


}
