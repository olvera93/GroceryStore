package com.olvera.grocerystore.data.remote

import com.olvera.grocerystore.models.EmailConfirmedResponse
import com.olvera.grocerystore.models.RegisterRequest
import com.olvera.grocerystore.util.Constants.ENDPOINT_SIGN_UP
import com.olvera.grocerystore.util.Urls.BASE_URL
import retrofit2.http.POST

interface GroceryApi {

    @POST(BASE_URL + ENDPOINT_SIGN_UP)
    suspend fun signUp(request: RegisterRequest): EmailConfirmedResponse

}