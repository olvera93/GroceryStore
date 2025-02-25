package com.olvera.grocerystore.repository

import android.util.Log
import com.olvera.grocerystore.data.remote.GroceryApi
import com.olvera.grocerystore.models.EmailConfirmedResponse
import com.olvera.grocerystore.models.RegisterRequest
import com.olvera.grocerystore.util.NetworkResult
import dagger.hilt.android.scopes.ActivityScoped
import javax.inject.Inject

//@ActivityScoped
class AuthUserRepository @Inject constructor(
    private val api: GroceryApi
) {


    suspend fun signUp(request: RegisterRequest): NetworkResult<EmailConfirmedResponse> {
        val response = try {
            api.signUp(request)
        } catch (e: Exception) {
            Log.e("AuthUserRepository", "Error signing up: ${e.message}", e)
            return NetworkResult.Error("Something went wrong")
        }
        return NetworkResult.Success(response)
    }

}