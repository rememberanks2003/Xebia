package yak.shop.live.stock.impl;

import java.util.List;

import yak.shop.live.stock.ILiveStock;
import yak.shop.model.YakEntity;

public class YakStockImpl implements ILiveStock<YakEntity> {

	@Override
	public double calculateMilk(YakEntity stockEntity, int elapsedDays) {

		double milklimit = 0;
		if (stockEntity != null) {
			for (int i = 0; i < elapsedDays; i++) {
				double ageofYakindays = (stockEntity.getAge() * 100) + i;
				if (ageofYakindays < (10 * 100)) {
					milklimit += 50 - (ageofYakindays * 0.03);
				}
			}
		}
		return milklimit;
	}

	@Override
	public int calculateWool(YakEntity stockEntity, int elapsedDays) {
		int woollimit = 0;
		if (stockEntity != null) {
			for (int i = 0; i < elapsedDays; i++) {
				double ageofYakindays = (stockEntity.getAge() * 100) + i;
				int yakCanbeshaven = (int) Math.ceil(8 + (ageofYakindays * 0.01));
				if (ageofYakindays < (10 * 100) && (i == 0 || yakCanbeshaven == i)) {
					woollimit += 1;
				}
			}
		}
		return woollimit;
	}

	@Override
	public void calculateAge(List<YakEntity> stockEntity, int elapsedDays) {
		System.out.print("Herd:\n\t");
		for (YakEntity yak : stockEntity) {
			double totalAge = ((yak.getAge() * 100) + elapsedDays) / 100;
			String additinalAge = (totalAge > 10) ? " This Yak is dead %.0f days ago" : "";
			System.out.printf(yak.getName() + " " + "%.2f years old " + additinalAge + " \n\t", totalAge,
					(totalAge % 10) * 100);
		}
	}

}
