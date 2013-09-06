package com.dowellmarket.android.model;

import java.util.List;

public class SearchMarket extends Model
{
  public static final String EXTRA = "search";
  private List<Market> result;
  private int total;
 
  public static SearchMarket fromString(String paramString)
  {
    return (SearchMarket)Model.fromString(paramString, SearchMarket.class);
  }

  public List<Market> getResults()
  {
    return this.result;
  }

  public Integer getTotal()
  {
    return this.result.size();
  }
  
  public Integer getSize() {
  
	return this.result.size();
  }

  public void merge(SearchMarket paramSearch)
  {
    if ((paramSearch != null) && (paramSearch.getResults() != null) && (paramSearch.getResults().size() > 0))
      this.result.addAll(paramSearch.getResults());
  }

  public void setResults(List<Market> paramList)
  {
    this.result = paramList;
  }

  public void setTotal(Integer paramInteger)
  {
    this.total = paramInteger.intValue();
  }
}
