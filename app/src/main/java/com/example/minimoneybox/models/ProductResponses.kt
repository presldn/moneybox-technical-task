package com.example.minimoneybox.models

data class ProductResponses(
    val Moneybox: String,

    val SubscriptionAmount: String,

    val TotalFees: String,

    val IsFavourite: String,

    val PlanValue: String,
    val Product: Product,

    val IsSelected: String,

    val Id: String,

    val Personalisation: Personalisation,

    val InvestorAccount: InvestorAccount
) {
    override fun toString(): String {
        return "ProductResponses(Product=$Product)"
    }
}

data class Product(
    val ProductHexCode: String,

    val Type: String,

    val FriendlyName: String,

    val AnnualLimit: String,
    val Id: String,

    val CategoryType: String,

    val DepositLimit: String,

    val Lisa: Lisa,

    val Name: String,

    val CanWithdraw: String

) {
    override fun toString(): String {
        return "Product(FriendlyName=$FriendlyName)"
    }
}

data class InvestorAccount(
    val EarningsNet: String,

    val ContributionsNet: String,

    val EarningsAsPercentage: String
)

data class Personalisation(
    val HideAccounts: HideAccounts,

    val QuickAddDeposit: QuickAddDeposit
)

data class Lisa(
    val MaximumBonus: String
)

data class HideAccounts(
    val IsHidden: String,

    val Enabled: String,

    val Sequence: String

)


data class QuickAddDeposit(
    val Amount: String
)