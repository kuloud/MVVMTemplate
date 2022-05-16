package app.web.drjackycv.domain.products.repository

import androidx.paging.PagingData
import app.web.drjackycv.domain.products.entity.Beer
import kotlinx.coroutines.flow.Flow

interface ProductsListRepository {


    fun getBeersListByCoroutine(ids: String): Flow<PagingData<Beer>>

}