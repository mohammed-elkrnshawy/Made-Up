package com.example.a3zt.madeup.SharedPackage.Class.ResponseProducts;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

public class Paginate {

    @SerializedName("total")
    @Expose
    private Integer total;
    @SerializedName("count")
    @Expose
    private Integer count;
    @SerializedName("per_page")
    @Expose
    private Integer perPage;
    @SerializedName("next_page_url")
    @Expose
    private Object nextPageUrl;
    @SerializedName("prev_page_url")
    @Expose
    private Object prevPageUrl;
    @SerializedName("current_page")
    @Expose
    private Integer currentPage;
    @SerializedName("total_pages")
    @Expose
    private Integer totalPages;

    public Integer getTotal() {
        return total;
    }

    public void setTotal(Integer total) {
        this.total = total;
    }

    public Integer getCount() {
        return count;
    }

    public void setCount(Integer count) {
        this.count = count;
    }

    public Integer getPerPage() {
        return perPage;
    }

    public void setPerPage(Integer perPage) {
        this.perPage = perPage;
    }

    public Object getNextPageUrl() {
        return nextPageUrl;
    }

    public void setNextPageUrl(Object nextPageUrl) {
        this.nextPageUrl = nextPageUrl;
    }

    public Object getPrevPageUrl() {
        return prevPageUrl;
    }

    public void setPrevPageUrl(Object prevPageUrl) {
        this.prevPageUrl = prevPageUrl;
    }

    public Integer getCurrentPage() {
        return currentPage;
    }

    public void setCurrentPage(Integer currentPage) {
        this.currentPage = currentPage;
    }

    public Integer getTotalPages() {
        return totalPages;
    }

    public void setTotalPages(Integer totalPages) {
        this.totalPages = totalPages;
    }

}