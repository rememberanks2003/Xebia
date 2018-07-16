package yak.shop.live.stock;

import java.util.List;

public interface ILiveStock<T> {
	
	public double calculateMilk(T stockEntity,int elapsedDays);
	public int calculateWool(T stockEntity,int elapsedDays);
	public void calculateAge(List<T> stockEntity,int elapsedDays);
	
}
