package com.example.minimoneybox.views

import android.arch.lifecycle.Observer
import android.arch.lifecycle.ViewModelProviders
import android.databinding.DataBindingUtil
import android.support.v7.app.AppCompatActivity
import android.os.Bundle
import android.support.annotation.StringRes
import android.support.design.widget.Snackbar
import com.example.minimoneybox.views.adapters.ProductAdapter
import com.example.minimoneybox.R
import com.example.minimoneybox.viewmodels.UserAccountsViewModel
import com.example.minimoneybox.databinding.ActivityUserAccountsBinding

class UserAccountsActivity : AppCompatActivity() {

    lateinit var binding: ActivityUserAccountsBinding

    private var snackbar: Snackbar? = null

    lateinit var viewModel: UserAccountsViewModel


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_user_accounts)

        viewModel = ViewModelProviders.of(this).get(UserAccountsViewModel::class.java)

        binding = DataBindingUtil.setContentView(this, R.layout.activity_user_accounts)

        viewModel.user.observe(this, Observer { user ->
            if (user != null) {
                binding.welcomeMessage.text = getString(R.string.welcome_message, user.FirstName)
            }
        })

        viewModel.progressMessage.observe(this, Observer { message ->
            if (message != null) showProgressMessage(message) else hide()

        })

        viewModel.errorMessage.observe(this, Observer {
                errorMessage -> if(errorMessage != null) showError(errorMessage) else hide()
        })

        viewModel.investmentData.observe(this, Observer { data ->
            if(data != null) {
                val adapter = ProductAdapter(this, data, viewModel.token)
                binding.recyclerView.adapter = adapter
                binding.totalPlanValue.text = getString(R.string.total_plan_value, data.TotalPlanValue)
            }


        })

    }

    private fun showProgressMessage(@StringRes message: Int) {
        snackbar = Snackbar.make(binding.root, message, Snackbar.LENGTH_INDEFINITE)
        snackbar?.show()
    }


    private fun showError(@StringRes errorMessage:Int){
        snackbar = Snackbar.make(binding.root, errorMessage, Snackbar.LENGTH_INDEFINITE)
        snackbar?.setAction(R.string.retry, viewModel.errorClickListener)
        snackbar?.show()
    }

    private fun hide(){
        snackbar?.dismiss()
    }
}
