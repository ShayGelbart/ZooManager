package Promotion;

import java.util.ArrayList;


public class PromotionManager {

	private ArrayList<Promotion> promotionList;
	private static PromotionManager instance;
	private boolean isActivePromotion;

	private PromotionManager() {
		this.promotionList = new ArrayList<>();
		this.isActivePromotion = false;
	}

	public static PromotionManager getInstance() {
		if (instance == null) {
			instance = new PromotionManager();
		}
		return instance;
	}

	public void addPromotion(Promotion promotion) {
		if (this.promotionList.size() > 0)
			this.promotionList.get(this.promotionList.size() - 1).setActive(false);
		this.promotionList.add(promotion);
		this.isActivePromotion = true;
		 
	}
	
	public boolean getIsActivePromotion() {
		return isActivePromotion;
	}

	public void setActivePromotion(boolean isActivePromotion) {
		this.isActivePromotion = isActivePromotion;
	}
	
	public int getDiscountOfActivePromotion() {
		return this.promotionList.get(this.promotionList.size() - 1).getDiscount();
	}
}