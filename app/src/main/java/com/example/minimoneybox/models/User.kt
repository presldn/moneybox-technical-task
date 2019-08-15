package com.example.minimoneybox.models
/*
Copyright (c) 2019 Kotlin LoginResponse Classes Generated from JSON powered by http://www.json2kotlin.com

Permission is hereby granted, free of charge, to any person obtaining a copy of this software and associated documentation files (the "Software"), to deal in the Software without restriction, including without limitation the rights to use, copy, modify, merge, publish, distribute, sublicense, and/or sell copies of the Software, and to permit persons to whom the Software is furnished to do so, subject to the following conditions:

The above copyright notice and this permission notice shall be included in all copies or substantial portions of the Software.

THE SOFTWARE IS PROVIDED "AS IS", WITHOUT WARRANTY OF ANY KIND, EXPRESS OR IMPLIED, INCLUDING BUT NOT LIMITED TO THE WARRANTIES OF MERCHANTABILITY, FITNESS FOR A PARTICULAR PURPOSE AND NONINFRINGEMENT. IN NO EVENT SHALL THE AUTHORS OR COPYRIGHT HOLDERS BE LIABLE FOR ANY CLAIM, DAMAGES OR OTHER LIABILITY, WHETHER IN AN ACTION OF CONTRACT, TORT OR OTHERWISE, ARISING FROM, OUT OF OR IN CONNECTION WITH THE SOFTWARE OR THE USE OR OTHER DEALINGS IN THE SOFTWARE.

For support, please feel free to contact me at https://www.linkedin.com/in/syedabsar */


data class User (

	val UserId : String,
	val HasVerifiedEmail : Boolean,
	val IsPinSet : Boolean,
	val AmlStatus : String,
	val AmlAttempts : Int,
	val RoundUpMode : String,
	val JisaRoundUpMode : String,
	val InvestorProduct : String,
	val RegistrationStatus : String,
	val JisaRegistrationStatus : String,
	val DirectDebitMandateStatus : String,
	val DateCreated : String,
	val Animal : String,
	val ReferralCode : String,
	val IntercomHmac : String,
	val IntercomHmaciOS : String,
	val IntercomHmacAndroid : String,
	val HasCompletedTutorial : Boolean,
	val LastPayment : Int,
	val PreviousMoneyboxAmount : Int,
	val MoneyboxRegistrationStatus : String,
	val Email : String,
	val FirstName : String,
	val LastName : String,
	val RoundUpWholePounds : Boolean,
	val DoubleRoundUps : Boolean,
	val MoneyboxAmount : Int,
	val InvestmentTotal : Int,
	val CanReinstateMandate : Boolean,
	val DirectDebitHasBeenSubmitted : Boolean,
	val MonthlyBoostEnabled : Boolean,
	val MonthlyBoostAmount : Int,
	val MonthlyBoostDay : Int
) {
	override fun toString(): String {
		return "User(email='$Email', firstName='$FirstName', lastName='$LastName')"
	}
}