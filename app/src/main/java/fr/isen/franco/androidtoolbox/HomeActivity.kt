package fr.isen.franco.androidtoolbox

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import android.widget.Toast
import androidx.fragment.app.Fragment
import kotlinx.android.synthetic.main.activity_home.*
import kotlinx.android.synthetic.main.activity_life_cycle.*
import kotlinx.android.synthetic.main.activity_login.*

class HomeActivity : AppCompatActivity() {


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_home)

    }

    fun lifeCycle(v: View) {
        val intent = Intent( this@HomeActivity, lifeCycle::class.java)
        startActivity(intent)
    }

    fun save(v: View) {
        setContentView(R.layout.activity_life_cycle);
    }

    fun permissions(v: View) {
        setContentView(R.layout.activity_life_cycle);
    }

    fun webservices(v: View) {
        setContentView(R.layout.activity_life_cycle);
    }

    fun alternate() {
        this.frag1.
    }
}
