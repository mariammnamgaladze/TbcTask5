package com.example.tbctask5

import android.app.Activity
import com.google.firebase.auth.FirebaseAuth
import java.lang.ref.WeakReference

object AuthenticationManager: FirebaseAuthentication{

    private var activity: WeakReference<Activity>? = null

    private var auth: FirebaseAuth = FirebaseAuth.getInstance()


    fun initActivity(activity: Activity){
        this.activity = WeakReference(activity)
    }



    override fun isLoggedIn(): Boolean {
        return auth.currentUser != null
    }



    override fun login(email: String, password:String,resultLambda: (Boolean) -> Unit) {
        auth.signInWithEmailAndPassword(email, password).addOnCompleteListener(activity?.get()!!) { task ->
            resultLambda(task.isSuccessful)
        }
    }

    override fun register(user: User,password: String,resultLambda: (Boolean) -> Unit) {
        auth.createUserWithEmailAndPassword(user.email, password).addOnCompleteListener(activity?.get()!!) { task ->
            resultLambda(task.isSuccessful)
        }
    }

}

interface FirebaseAuthentication{

    fun isLoggedIn(): Boolean

    fun login(email: String, password:String,resultLambda: (Boolean) -> Unit)

    fun register(user: User,password: String,resultLambda: (Boolean) -> Unit)

}