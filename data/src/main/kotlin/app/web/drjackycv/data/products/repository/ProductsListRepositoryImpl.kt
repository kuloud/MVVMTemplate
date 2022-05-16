package app.web.drjackycv.data.products.repository

import androidx.paging.Pager
import androidx.paging.PagingConfig
import androidx.paging.PagingData
import app.web.drjackycv.data.products.datasource.ProductsPagingSourceByCoroutine
import app.web.drjackycv.domain.extension.allowReads
import app.web.drjackycv.domain.products.entity.Beer
import app.web.drjackycv.domain.products.repository.ProductsListRepository
import io.reactivex.rxjava3.core.Flowable
import kotlinx.coroutines.flow.Flow
import javax.inject.Inject
import javax.inject.Singleton

@Singleton
class ProductsListRepositoryImpl @Inject constructor(
    private val pagingSourceByCoroutine: ProductsPagingSourceByCoroutine,
) : ProductsListRepository {

    override fun getBeersListByCoroutine(ids: String): Flow<PagingData<Beer>> =
        allowReads {
            Pager(
                config = PagingConfig(
                    pageSize = 10,
                    enablePlaceholders = false,
                    maxSize = 30,
                    prefetchDistance = 5,
                    initialLoadSize = 10,
                    jumpThreshold = 60
                ),
                pagingSourceFactory = { pagingSourceByCoroutine }
            ).flow
        }
}