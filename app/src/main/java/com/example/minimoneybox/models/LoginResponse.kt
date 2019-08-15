package com.example.minimoneybox.models

data class LoginResponse(
    val User: User,
    val ActionMessage: ActionMessage,
    val InformationMessage: String,
    val Session: Session
) {
    override fun toString(): String {
        return "LoginResponse(Session=$Session)"
    }
}

data class ActionMessage (

    val type : String,
    val message : String,
    val actions : List<Actions>
)

data class Actions (

    val label : String,
    val amount : Int,
    val type : String,
    val animation : String
)

data class Session (

    val BearerToken : String,
    val ExternalSessionId : String,
    val SessionExternalId : String,
    val ExpiryInSeconds : Int
) {
    override fun toString(): String {
        return "Session(BearerToken='$BearerToken')"
    }
}