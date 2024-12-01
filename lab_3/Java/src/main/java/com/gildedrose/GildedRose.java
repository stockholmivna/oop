package com.gildedrose;

class GildedRose {
    Item[] items;

    public GildedRose(Item[] items) {
        this.items = items;
        }

    public void updateQuality() {
        for (Item item : items) {
            updateItemQuality(item);
            updateSellIn(item);
            handleExpiredItems(item);
        }
    }

    private void increaseQuality(Item item) {
        if (item.quality >= 50) return;
        item.quality += 1;
    }

    private void decreaseQuality(Item item) {
        if (item.quality <= 0) return;
        if (isSulfuras(item)) return;
        item.quality -= 1;
    }

    private boolean isSulfuras(Item item) {
        return item.name.equals("Sulfuras, Hand of Ragnaros");
    }

    
    private boolean isAgedBrie(Item item) {
        return item.name.equals("Aged Brie");
    }

    private boolean isBackstagePass(Item item) {
        return item.name.equals("Backstage passes to a TAFKAL80ETC concert");
    }

    private void updateSellIn(Item item) {
        if (isSulfuras(item)) return;
        item.sellIn -= 1;
    }

    private void handleExpiredItems(Item item) {
        if (item.sellIn >= 0) return;

        if (isAgedBrie(item)) {
            increaseQuality(item);
            return;
        }

        if (isBackstagePass(item)) {
            resetQuality(item);
            return;
        }

        decreaseQuality(item);
    }

    private void resetQuality(Item item) {
        item.quality = 0;
    }
    

    private void updateItemQuality(Item item) {
    if (SpecialItem(item)) {
        increaseQuality(item);
        handleBackstagePasses(item);  //i will add new method to handle BackstagePasses
        return; //the same logic as in the previous method
    }
    
    decreaseQuality(item);
}

private void handleBackstagePasses(Item item) {
    if (!isBackstagePass(item)) return;

    if (item.sellIn < 11) increaseQuality(item);
    if (item.sellIn < 6) increaseQuality(item);
}

private boolean SpecialItem(Item item) { //i add this method to check if the item is Aged Brie or BackstagePasses
    return item.name.equals("Aged Brie") || item.name.equals("Backstage passes to a TAFKAL80ETC concert"); //it returns true if the item is Aged Brie or BackstagePasses
    }
}
