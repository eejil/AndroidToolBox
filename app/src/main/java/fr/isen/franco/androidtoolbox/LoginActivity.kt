package fr.isen.franco.androidtoolbox

import android.content.Intent
import android.os.Bundle
import android.view.View
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity
import kotlinx.android.synthetic.main.activity_login.*

class LoginActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_login)
    }


    fun loginButton(v: View) {
        if (this.username.editableText.toString().equals("admin") && this.password.editableText.toString().equals("123"))
            {
                val intent = Intent( this@LoginActivity, HomeActivity::class.java)
                startActivity(intent)
            }
        else{
            Toast.makeText( this, "Gros con",Toast.LENGTH_LONG).show();
        }
    }

}
