package com.example.minimoneybox.views

import android.app.ProgressDialog
import android.arch.lifecycle.Observer
import android.arch.lifecycle.ViewModelProviders
import android.databinding.DataBindingUtil
import android.support.v7.app.AppCompatActivity
import android.os.Bundle
import android.widget.Toast
import com.example.minimoneybox.*
import com.example.minimoneybox.databinding.ActivityIndividualAccountBinding
import com.example.minimoneybox.utils.*
import com.example.minimoneybox.viewmodels.IndividualAccountViewModel

class IndividualAccountActivity : AppCompatActivity() {

    private lateinit var dialog: ProgressDialog

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_individual_account)

        val binding: ActivityIndividualAccountBinding =
            DataBindingUtil.setContentView(this, R.layout.activity_individual_account)

        val viewModel: IndividualAccountViewModel =
            ViewModelProviders.of(this).get(IndividualAccountViewModel::class.java)

        dialog = ProgressDialog(this)

        viewModel.moneyAddedMessage.observe(this, Observer { message ->
            if(message != null) {
                Toast.makeText(this, message, Toast.LENGTH_SHORT).show()
                finish()
            }
        })

        viewModel.errorMessage.observe(this, Observer { message ->
            if(message != null) {
                Toast.makeText(this, message, Toast.LENGTH_SHORT).show()
            }
        })

        viewModel.showProgress.observe(this, Observer { message ->
            if (message != null) showProgress(message) else hideProgress()
        })

        val productName = intent.getStringExtra(INTENT_PRODUCT_NAME_EXTRA)
        val planValue = intent.getStringExtra(INTENT_PLAN_VALUE_EXTRA)
        val moneybox = intent.getStringExtra(INTENT_MONEYBOX_EXTRA)
        val id = intent.getStringExtra(INTENT_PRODUCT_ID_EXTRA)
        val token = intent.getStringExtra(INTENT_TOKEN_EXTRA)

        binding.productName.text = productName
        binding.planValue.text = getString(R.string.plan_value, planValue)
        binding.moneybox.text = getString(R.string.moneybox, moneybox)

        binding.addMoneyBtn.setOnClickListener {
            viewModel.addMoney(id, token)
        }


    }

    private fun hideProgress() {
        dialog.cancel()
    }

    private fun showProgress(message: Int) {
        dialog.isIndeterminate = true
        dialog.setTitle(message)
        dialog.setMessage(getString(message))
        dialog.show()
    }

}
