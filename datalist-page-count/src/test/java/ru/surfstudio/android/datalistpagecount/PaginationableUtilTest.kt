package ru.surfstudio.android.datalistpagecount

import io.reactivex.Observable
import org.junit.Assert
import org.junit.Test
import ru.surfstudio.android.datalistpagecount.domain.datalist.DataList
import ru.surfstudio.android.datalistpagecount.util.PaginationableUtil


class PaginationableUtilTest {
    @Test
    fun paginationableRequest() {
        val response = (1..100).toList()

        var resultList: DataList<Int> = DataList.emptyUnspecifiedTotal()

        PaginationableUtil.getPaginationRequestPortions<Int>({ page ->
                Observable.just(DataList(arrayListOf(response[page]), page, 1))
        }, 10)
                .subscribe {
                    resultList.merge(it)
                }

        val expected = DataList(response.subList(0,10), 0,10,1)
        Assert.assertEquals(expected, resultList)
    }
}