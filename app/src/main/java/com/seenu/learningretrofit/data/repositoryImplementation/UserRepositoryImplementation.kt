package com.seenu.learningretrofit.data.repositoryImplementation

import android.util.Log
import com.seenu.learningretrofit.data.api.UserApi
import com.seenu.learningretrofit.data.mappers.toDomain
import com.seenu.learningretrofit.domain.model.User
import com.seenu.learningretrofit.domain.repository.UserRepository
import com.seenu.learningretrofit.utils.Resource
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.flow
import retrofit2.HttpException
import javax.inject.Inject

class UserRepositoryImplementation @Inject constructor(
    private val api : UserApi
) : UserRepository {
    override fun getUserProfile(): Flow<Resource<User>> {
        return flow {
            emit(Resource.IsLoading())
            try{
                val response = api.userProfile()
                Log.d("API RESPONSE","$response")
                val user = response.toDomain()
                Log.d("User fetched : ","$user")
                emit(Resource.Success(user))
            }catch(e : HttpException){
                emit(Resource.Error("Error : ${e.localizedMessage}"))
            }catch(e : Exception){
                emit(Resource.Error("Error : ${e.localizedMessage}"))
            }
        }
    }
}