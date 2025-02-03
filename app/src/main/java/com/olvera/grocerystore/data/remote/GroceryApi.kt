package com.olvera.grocerystore.data.remote

import com.olvera.grocerystore.models.EmailConfirmedResponse
import com.olvera.grocerystore.models.RegisterRequest
import com.olvera.grocerystore.util.Constants.ENDPOINT_SIGN_UP
import retrofit2.http.Body
import retrofit2.http.POST

interface GroceryApi {

    @POST(ENDPOINT_SIGN_UP)
    suspend fun signUp(@Body request: RegisterRequest): EmailConfirmedResponse

}