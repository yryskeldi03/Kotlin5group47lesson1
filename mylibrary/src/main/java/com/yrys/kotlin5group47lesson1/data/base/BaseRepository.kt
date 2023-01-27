package com.yrys.kotlin5group47lesson1.data.base

import com.yrys.kotlin5group47lesson1.domain.utils.Resource
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.flow.flow
import kotlinx.coroutines.flow.flowOn
import java.io.IOException

abstract class BaseRepository {

    protected fun <T> doRequest(request: suspend () -> T) = flow {
        emit(Resource.Loading())
        try {
            val data = request()
            emit(Resource.Success(data))
        } catch (ioException: IOException) {
            emit(Resource.Error(ioException.localizedMessage ?: "Unknown exception"))
        }
    }.flowOn(Dispatchers.IO)

//    override fun createNote(note: Note) = flow {
//        emit(Resource.Loading())
//        try {
//            val data = noteDao.createNote(note.toNoteEntity())
//            emit(Resource.Success(data))
//        } catch (ioException: IOException) {
//            emit(Resource.Error(ioException.localizedMessage ?: "Unknown exception"))
//        }
//    }.flowOn(Dispatchers.IO)


}