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
import com.example.tbctask5.AuthenticationManager.register


class RegisterFragment : Fragment(R.layout.fragment_register), View.OnClickListener {
    private lateinit var registerEmail: EditText
    private lateinit var registerPassword: EditText
    private lateinit var registerNextButton: Button
    private lateinit var registerBackBtn: ImageButton


    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        view.findViewById<ImageButton>(R.id.registerBackSignBtn).setOnClickListener(this)
        view.findViewById<Button>(R.id.registerNextBtn).setOnClickListener(this)

        registerEmail = view.findViewById(R.id.registerEmail)
        registerPassword = view.findViewById(R.id.registerPassword)
        registerBackBtn = view.findViewById(R.id.registerBackSignBtn)
        registerNextButton = view.findViewById(R.id.registerNextBtn)

    }

    override fun onClick(v: View?) {
        when (v!!.id) {
            R.id.registerBackSignBtn -> findNavController().navigate(R.id.action_registerFragment_to_loggedOutFragment)
            R.id.registerNextBtn -> registerAccount()
        }
    }
    private fun checkInputs(): Boolean {
        if (registerPassword.text.isNullOrEmpty())
            return false

        if (registerEmail.text.isNullOrEmpty() || !registerEmail.text.isValidEmail())
            return false

        return true
    }

    private fun CharSequence?.isValidEmail() =
        !isNullOrEmpty() && Patterns.EMAIL_ADDRESS.matcher(this).matches()

    private fun registerAccount() {
        if (checkInputs()){
            val user = User(email = registerEmail.text.toString())
            register(user, registerPassword.text.toString()) { isSuccess ->
                if (isSuccess) {
                    navigateToSecondRegister()
                } else {
                    Toast.makeText(
                        requireContext(),
                        "Couldn't create account, try again later!",
                        Toast.LENGTH_SHORT
                    ).show()
                }
            }
        }
        else
            Toast.makeText(requireContext(), "Your input is not correct", Toast.LENGTH_SHORT).show()
    }


    private fun navigateToSecondRegister(){
        findNavController().navigate(R.id.action_registerFragment_to_secondRegisterFragment)
    }


}


