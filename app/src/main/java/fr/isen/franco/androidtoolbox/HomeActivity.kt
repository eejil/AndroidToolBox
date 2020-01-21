package fr.isen.franco.androidtoolbox

import android.content.Context
import android.content.Intent
import android.content.SharedPreferences
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import kotlinx.android.synthetic.main.activity_home.*

var visibleInfo: Boolean? = null

class HomeActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_home)

        visibleInfo = false
        val loggedInput: SharedPreferences = getSharedPreferences( "LoggedInfo", Context.MODE_PRIVATE)

        imageButton.setOnClickListener {
            lifeCycle(intent)
        }

        buttonLogout.setOnClickListener {
            logout(loggedInput)
        }

    }

    fun lifeCycle(intent: Intent) {
        val intent = Intent( this@HomeActivity, lifeCycle::class.java)
        startActivity(intent)
    }

    fun save(v: View) {
        val intent = Intent( this@HomeActivity, FormActivity::class.java)
        startActivity(intent)
    }

    fun permissions(v: View) {

    }

    fun webservices(v: View) {

    }

    fun logout(loggedInput: SharedPreferences) {
        val intent = Intent( this@HomeActivity, LoginActivity::class.java)
        val editor: SharedPreferences.Editor = loggedInput.edit()
        editor.clear()
        editor.apply()
        startActivity(intent)
        finish()

    }



}
