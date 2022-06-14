package com.example.wecareapp

import android.content.Context
import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.AutoCompleteTextView
import android.widget.Button
import android.widget.Toast
import androidx.lifecycle.Observer
import androidx.lifecycle.ViewModelProvider
import com.demo.retrofitwithpost.GetEventsVM
import com.example.wecareapp.model.*
import com.example.wecareapp.viewmodel.CreateLogUserVM


class MainActivity : AppCompatActivity() {
    lateinit var viewModel: CreateLogUserVM
    lateinit var vm: GetEventsVM
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        initViewModel()
        val registro=findViewById<Button>(R.id.bt_signup)
        val login=findViewById<Button>(R.id.bt_login)
        val login2=findViewById<Button>(R.id.bt_login)
        val sharedPref = this?.getSharedPreferences(
            getString(R.string.preference_file_key), Context.MODE_PRIVATE)

        login.setOnClickListener(){
            /*PERMITIENDO ACCESO DIRECTO TEMPORAL*/
            val intent=Intent(this,SelectorActivity::class.java)
            startActivity(intent)
            /*if(createLogUser(this)){
                val intent = Intent(this, SelectRolActivity::class.java).apply {
                    //putExtra("Username",user.name)
                }
                startActivity(intent)
            }*/
        }
        login2.setOnClickListener(){
            val intent=Intent(this,LogAsActivity::class.java)
            startActivity(intent)
        }
        registro.setOnClickListener(){

            val intent = Intent(this, SelectRolActivity::class.java).apply {
                //putExtra("Username",user.name)
            }
            startActivity(intent)

        }
    }


    private fun createLogUser(con: Context):Boolean {

        val Email=findViewById<AutoCompleteTextView>(R.id.tv_emaillog).text.toString().replace(" ","")
        val Password=findViewById<AutoCompleteTextView>(R.id.tv_passwordlog).text.toString().replace(" ","")

        val user = User( Email, Password)
        return viewModel.createNewUser(user,con)

    }

    private fun initViewModel() {
        viewModel = ViewModelProvider(this).get(CreateLogUserVM::class.java)
        viewModel.getCreateNewUserObserver().observe(this, Observer <UserResponse?>{

            if(it  == null) {
                Toast.makeText(this, "Failed to create User", Toast.LENGTH_LONG).show()
            } else {
                //{"code":201,"meta":null,"data":{"id":2877,"name":"xxxxxaaaaabbbbb","email":"xxxxxaaaaabbbbb@gmail.com","gender":"male","status":"active"}}
                Toast.makeText(this, "Successfully created User", Toast.LENGTH_LONG).show()
            }
        })
    }

}
