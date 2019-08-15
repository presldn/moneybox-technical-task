package com.example.minimoneybox.views.adapters

import android.content.Context
import android.content.Intent
import android.support.v7.widget.RecyclerView
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import com.example.minimoneybox.R
import com.example.minimoneybox.models.InvestorProductsResponse
import com.example.minimoneybox.models.ProductResponses
import com.example.minimoneybox.utils.*
import com.example.minimoneybox.views.IndividualAccountActivity

class ProductAdapter(private val context: Context, private val investorProductsResponse: InvestorProductsResponse,
                     private val sessionToken: String) :
    RecyclerView.Adapter<ProductAdapter.ViewHolder>() {

    private val productResponses: List<ProductResponses>
    get() = investorProductsResponse.ProductResponses


    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {
        val view = LayoutInflater.from(parent.context).inflate(R.layout.product_item, null)
        return ViewHolder(view)
    }

    override fun getItemCount(): Int = productResponses.size

    override fun onBindViewHolder(viewHolder: ViewHolder, position: Int) {
        val productResponse: ProductResponses = productResponses[position]

        viewHolder.friendlyName.text = productResponse.Product.FriendlyName
        viewHolder.planValue.text = context.getString(R.string.plan_value, productResponse.PlanValue)
        viewHolder.moneybox.text = context.getString(R.string.moneybox, productResponse.Moneybox)
        viewHolder.itemView.setOnClickListener {
            val intent = Intent(context, IndividualAccountActivity::class.java)
            intent.putExtra(INTENT_PRODUCT_NAME_EXTRA, productResponse.Product.FriendlyName)
            intent.putExtra(INTENT_PLAN_VALUE_EXTRA, productResponse.PlanValue)
            intent.putExtra(INTENT_MONEYBOX_EXTRA, productResponse.Moneybox)
            intent.putExtra(INTENT_PRODUCT_ID_EXTRA, productResponse.Id)
            intent.putExtra(INTENT_TOKEN_EXTRA, sessionToken)
            context.startActivity(intent)
        }

    }

    class ViewHolder(itemView: View): RecyclerView.ViewHolder(itemView) {
        val friendlyName: TextView = itemView.findViewById(R.id.friendlyName)
        val planValue: TextView = itemView.findViewById(R.id.planValue)
        val moneybox: TextView = itemView.findViewById(R.id.moneybox)
    }

}