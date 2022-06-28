package com.example.tbctask5

import android.os.Bundle
import android.util.Patterns
import androidx.fragment.app.Fragment
import android.view.View
import android.widget.Button
import android.widget.EditText
import android.widget.ImageButton
import android.widget.Toast
import androidx.navigation.fragment.findNavController
import com.example.tbctask5.AuthenticationManager.login


class LogInFragment : Fragment(R.layout.fragment_log_in), View.OnClickListener {
    private lateinit var logInEmail: EditText
    private lateinit var logInPassword: EditText
    private lateinit var logInBtn2: Button
    private lateinit var logInBackBtn: ImageButton

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        logInBtn2 = view.findViewById(R.id.logInBtn2)
        logInEmail = view.findViewById(R.id.logInEmail)
        logInPassword = view.findViewById(R.id.logInPassword)
        logInBackBtn = view.findViewById(R.id.registerBackSignBtn)

        view.findViewById<ImageButton>(R.id.registerBackSignBtn).setOnClickListener(this)

    }

    override fun onClick(v: View?) {
        when (v!!.id) {
            R.id.registerBackSignBtn -> findNavController().navigate(R.id.action_logInFragment_to_loggedOutFragment)
            R.id.logInBtn2 -> checkLoginInfo()
        }

    }
    private fun checkLoginInputs(): Boolean{
        if (logInPassword.text.isNullOrEmpty())
            return false

        if (logInEmail.text.isNullOrEmpty() || !logInEmail.text.isValidEmail())
            return false

        return true
    }

    private fun CharSequence?.isValidEmail() =
        !isNullOrEmpty() && Patterns.EMAIL_ADDRESS.matcher(this).matches()

    private fun checkLoginInfo(){
        if(checkLoginInputs()){
            login(logInEmail.text.toString(),logInPassword.text.toString()){ isSuccess->
                if(isSuccess){
                    Toast.makeText(requireContext(), "success", Toast.LENGTH_SHORT).show()
                }else{
                    Toast.makeText(requireContext(), "Couldn't login, try again later!", Toast.LENGTH_SHORT).show()
                }
            }
        }else
            Toast.makeText(requireContext(), "Input correct login credentials!", Toast.LENGTH_SHORT).show()
    }



}





