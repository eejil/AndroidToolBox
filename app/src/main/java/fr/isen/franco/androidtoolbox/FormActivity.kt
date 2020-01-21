package fr.isen.franco.androidtoolbox

import android.app.AlertDialog
import android.app.DatePickerDialog
import android.content.Context
import android.content.SharedPreferences
import android.os.Bundle
import android.view.View
import android.widget.Button
import android.widget.DatePicker
import android.widget.TextView
import androidx.appcompat.app.AppCompatActivity
import com.google.gson.Gson
import kotlinx.android.synthetic.main.activity_form.*
import java.text.SimpleDateFormat
import java.util.*


class FormActivity : AppCompatActivity() {

    var button_date: Button? = null
    var textview_date: TextView? = null
    var cal = Calendar.getInstance()


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_form)
        val formInput: SharedPreferences = getSharedPreferences( "FormInfo", Context.MODE_PRIVATE)

        // get the references from layout file
        textview_date = this.inputBirthdate
        button_date = this.buttonDate

        textview_date!!.text = "--/--/----"

        // create an OnDateSetListener
        val dateSetListener = object : DatePickerDialog.OnDateSetListener {
            override fun onDateSet(view: DatePicker, year: Int, monthOfYear: Int,
                                   dayOfMonth: Int) {
                cal.set(Calendar.YEAR, year)
                cal.set(Calendar.MONTH, monthOfYear)
                cal.set(Calendar.DAY_OF_MONTH, dayOfMonth)
                updateDateInView()
            }
        }


        // when you click on the button, show DatePickerDialog that is set with OnDateSetListener
        button_date!!.setOnClickListener(object : View.OnClickListener {
            override fun onClick(view: View) {
                DatePickerDialog(this@FormActivity,
                    dateSetListener,
                    // set DatePickerDialog to point to today's date when it loads up
                    cal.get(Calendar.YEAR),
                    cal.get(Calendar.MONTH),
                    cal.get(Calendar.DAY_OF_MONTH)).show()
            }

        })






        buttonSend.setOnClickListener {
            loginForm(formInput)
        }

        buttonAlert.setOnClickListener {
            popUp(formInput,getAge(Calendar.YEAR,Calendar.MONTH,Calendar.DAY_OF_MONTH))
        }
    }

    private fun updateDateInView() {
        val myFormat = "MM/dd/yyyy" // mention the format you need
        val sdf = SimpleDateFormat(myFormat, Locale.US)
        textview_date!!.text = sdf.format(cal.getTime())
    }

    fun loginForm(formInput: SharedPreferences) {


            val gson: Gson = Gson()
            val user: User = User(this.textInputName.text.toString(), this.textInputFirstname.text.toString(), this.inputBirthdate.text.toString())
            val editor: SharedPreferences.Editor = formInput.edit()
            editor.putString("Profile", gson.toJson(user))
            editor.apply()
            this.textInputName.setText("")
            this.textInputFirstname.setText("")
            this.inputBirthdate.setText("")
            //Toast.makeText( this,formInput.getString("User", ""),Toast.LENGTH_LONG).show();


    }

    fun popUp(formInput: SharedPreferences, age: Int) {
        var gson: Gson = Gson()

        var json: String = formInput.getString("Profile", "").toString()
        var user: User
        if (formInput != null) {
            user = gson.fromJson(json, User::class.java)


            var alertDialogBuilder: AlertDialog.Builder = AlertDialog.Builder(this)

            alertDialogBuilder
                .setTitle("Informations")
                .setMessage("Nom :" + user.Name + "\nPrenom:" + user.Firstname + "\nDate de naissance:" + user.Birthdate + "\nAge:21")


            var alertDialog: AlertDialog = alertDialogBuilder.create()

            alertDialog.show()

            print(age)

        }


    }

     fun getAge(year: Int, month: Int, day: Int): Int {
        val dob = Calendar.getInstance()
        val today = Calendar.getInstance()
        dob[year, month] = day
        var age = today[Calendar.YEAR] - dob[Calendar.YEAR]
        if (today[Calendar.DAY_OF_YEAR] < dob[Calendar.DAY_OF_YEAR]) {
            age--
        }
        val ageInt = age
        return ageInt
    }



}
