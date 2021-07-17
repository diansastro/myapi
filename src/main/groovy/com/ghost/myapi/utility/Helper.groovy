package com.ghost.myapi.utility

import org.springframework.data.domain.Page

/**
 * Created by widi (widiytk@gmail.com) on 2021-07-16.
 **/

class Helper {
    static def pageToResponse(Page page, def content) {
        return [
                content: content,
                page: [
                        last: page.last,
                        totalPages: page.totalPages,
                        totalElements: page.totalElements,
                        size: page.size,
                        number: page.number,
                        first: page.first,
                        sort: page.sort,
                        numberOfElements: page.numberOfElements,
                        empty: page.empty,
                        offset: page.pageable.offset,
                        pageNumber: page.pageable.pageNumber,
                        pageSize: page.pageable.pageSize,
                        paged: page.pageable.paged,
                        unpaged: page.pageable.unpaged
                ]
        ]
    }
}
