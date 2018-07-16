package yak.shop.factory;

import yak.shop.exception.StockInvalidException;
import yak.shop.live.stock.ILiveStock;
import yak.shop.live.stock.impl.YakStockImpl;
import yak.shop.model.YakEntity;

public class LiveStockFactory<T> {

	public static enum STOCKTYPE{YAK};
	public static ILiveStock<YakEntity> getInstance(String stockType)throws StockInvalidException{
		ILiveStock<YakEntity> returnStock = null;
		if(stockType != null && stockType.equalsIgnoreCase(STOCKTYPE.YAK.toString())){
			returnStock= new YakStockImpl();
		}else{
			throw new StockInvalidException("Provided Stack is not Valid");
		}
		return returnStock;
	}
}
