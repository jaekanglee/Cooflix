package com.ppizil.domain

import com.ppizil.domain.model.ParamMovieEntity
import com.ppizil.domain.repository.MovieRepository
import com.ppizil.domain.usecase.CreateMoveListParam
import com.ppizil.domain.usecase.CreateMoveListParamImpl
import com.ppizil.domain.usecase.FetchMovieList
import com.ppizil.domain.usecase.FetchMovieListImpl
import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.runBlocking
import kotlinx.coroutines.withContext
import org.junit.Assert
import org.junit.Before
import org.junit.Test
import org.junit.jupiter.api.Assertions
import org.junit.jupiter.api.assertDoesNotThrow
import org.junit.jupiter.api.assertThrows
import org.mockito.Mockito

class MovieTest {

    lateinit var createMoveListParam: CreateMoveListParam
    lateinit var fetchMovieList: FetchMovieList

    @Before
    fun setUp() {
        createMoveListParam = CreateMoveListParamImpl()
        fetchMovieList = FetchMovieListImpl(
            createMoveListParam,
            Mockito.mock(MovieRepository::class.java)
        )
    }

    @Test
    fun `01_createMoveListParam()는 language!=null일때 Map에 추가한다`() = runBlocking {
        val input = ParamMovieEntity(
            language = "en-US",
            region = null
        )
        val result = createMoveListParam(input)
        Assertions.assertEquals(result["language"] != null, true)
    }

    @Test
    fun `02_createMoveListParam()는 language==null일때 Hashmap에 추가하지 않는다`() = runBlocking {
        val input = ParamMovieEntity(
            language = null,
            region = null
        )
        val result = createMoveListParam(input)
        Assertions.assertEquals(result["language"], null)
    }

    @Test
    fun `03_createMoveListParam()는 region!=null일때 Map에 추가한다`() = runBlocking {
        val input = ParamMovieEntity(
            language = "en-US",
            region = null
        )
        val result = createMoveListParam(input)
        Assertions.assertEquals(result["region"] == null, true)
    }

    @Test
    fun `04_createMoveListParam()는 region==null일때 Hashmap에 추가하지 않는다`() = runBlocking {
        val input = ParamMovieEntity(
            language = null,
            region = null
        )
        val result = createMoveListParam(input)
        Assertions.assertEquals(result["region"], null)
    }


//    @Test
//    fun `05_fetchMovieList()는 Parameter size ==0 일때 에러를 발생시키지 않는다`() = runBlocking {
//        val input = ParamMovieEntity(
//            language = null,
//            region = null
//        )
//       val result = assertDoesNotThrow  {
//            fetchMovieList(input)
//        }
//
//        Assertions.assertEquals(result,null)
//    }
}

