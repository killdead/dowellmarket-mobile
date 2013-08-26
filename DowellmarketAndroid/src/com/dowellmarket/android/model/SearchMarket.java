package com.dowellmarket.android.model;

import java.util.List;

public class SearchMarket extends Model
{
  public static final String EXTRA = "search";
  private List<Market> results;
  private int total;

  public static SearchMarket fromString(String paramString)
  {
    return (SearchMarket)Model.fromString(paramString, SearchMarket.class);
  }

  public List<Market> getResults()
  {
    return this.results;
  }

  public Integer getTotal()
  {
    return Integer.valueOf(this.total);
  }

  public void merge(SearchMarket paramSearch)
  {
    if ((paramSearch != null) && (paramSearch.getResults() != null) && (paramSearch.getResults().size() > 0))
      this.results.addAll(paramSearch.getResults());
  }

  public void setResults(List<Market> paramList)
  {
    this.results = paramList;
  }

  public void setTotal(Integer paramInteger)
  {
    this.total = paramInteger.intValue();
  }
}
