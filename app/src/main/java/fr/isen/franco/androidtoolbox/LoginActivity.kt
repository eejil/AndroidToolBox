package fr.isen.franco.androidtoolbox

import android.content.Context
import android.content.Intent
import android.content.SharedPreferences
import android.os.Bundle
import android.view.View
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity
import kotlinx.android.synthetic.main.activity_login.*


class LoginActivity : AppCompatActivity() {



    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_login)


        val loggedInput: SharedPreferences = getSharedPreferences( "LoggedInfo", Context.MODE_PRIVATE)

        if(loggedInput.getString("User", "").equals("admin") && loggedInput.getString("Password", "").equals("123")) {
            val intent = Intent( this@LoginActivity, HomeActivity::class.java)
            startActivity(intent)
            finish()
        }

        button.setOnClickListener {
            loginButton(intent, loggedInput)
        }
    }




    fun loginButton(intent: Intent, loggedInput: SharedPreferences) {
        if (this.username.editableText.toString().equals("admin") && this.password.editableText.toString().equals("123"))
            {
                val editor = loggedInput.edit()
                editor.putString("User",this.username.editableText.toString())
                editor.putString("Password",this.password.editableText.toString())
                editor.apply()

                val intent = Intent( this@LoginActivity, HomeActivity::class.java)
                startActivity(intent)
                finish()



            }
        else{
            Toast.makeText( this, "Gros con",Toast.LENGTH_LONG).show();
        }
    }

}
