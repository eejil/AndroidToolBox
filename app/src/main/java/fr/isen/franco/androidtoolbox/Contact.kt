package fr.isen.franco.androidtoolbox

import android.util.Log
import android.view.View
import androidx.recyclerview.widget.RecyclerView

class Contact {
     var nom: String = ""
     var phone: String = ""

    constructor(nom: String, phone: String) {
        this.nom = nom
        this.phone = phone
    }

    constructor() {
        this.nom = ""
        this.phone = ""
    }

}