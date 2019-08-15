package com.example.minimoneybox.models

data class InvestorProductsResponse(
    val TotalPlanValue: String,
    val TotalEarnings: String,
    val TotalContributionsNet: String,
    val TotalEarningsAsPercentage: String,
    val ProductResponses: List<ProductResponses>,
    val MoneyboxEndOfTaxYear: String
) {
    override fun toString(): String {
        return "InvestorProductsResponse(TotalPlanValue='$TotalPlanValue', ProductResponses=$ProductResponses)"
    }
}