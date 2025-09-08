package com.sample_01.sample_01.dto;

import lombok.Getter;
import java.util.List;

@Getter
public class PageResponseDto<E> {
    private final List<E> dtoList;
    private final int currentPage;
    private final int totalPages;
    private final int startPage;
    private final int endPage;

    public PageResponseDto(List<E> dtoList, int totalCount, int page, int pageSize, int pageBlockSize) {
        this.dtoList = dtoList;
        this.currentPage = page;
        this.totalPages = (int) Math.ceil((double) totalCount / pageSize);

        this.startPage = ((page - 1) / pageBlockSize) * pageBlockSize + 1;
        int tempEndPage = startPage + pageBlockSize - 1;
        this.endPage = Math.min(tempEndPage, totalPages);
    }
}
