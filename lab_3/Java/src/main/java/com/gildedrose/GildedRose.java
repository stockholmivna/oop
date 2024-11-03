package com.gildedrose;

class GildedRose {
    Item[] items;

    public GildedRose(Item[] items) {
        this.items = items;
        }

    public void updateQuality() {
        for (int i = 0; i < items.length; i++) {
            updateItemQuality(items[i]); //i call the new method to exchange the nested logic
            updateSellIn(items[i]); //new method to update sellIn
            handleExpiredItems(items[i]); //analogous to the previous method
        }
    }

    private void increaseQuality(Item item) {
        if (item.quality < 50) { //if quality is less than 50, we increase it by 1
            item.quality += 1;
        }
    }

    private void decreaseQuality(Item item) {
        if (item.quality > 0 && !item.name.equals("Sulfuras, Hand of Ragnaros")) {
            item.quality -= 1;
        }
    }

    //New method selIn to avoid nested logic
    private void updateSellIn(Item item) { //we use the same logic as before, selIn decrease by 1 for every item except Sulfuras
        if (!item.name.equals("Sulfuras, Hand of Ragnaros")) {
        item.sellIn -= 1;
    }
}

    private void handleExpiredItems(Item item) { //new method to handle expired items
        if (item.sellIn >= 0) return;

        if (item.name.equals("Aged Brie")) { //condition for Aged Brie
            increaseQuality(item);
            return; //we get rid of the else statement and add return statement to return to the main method
        }
        
        if (item.name.equals("Backstage passes to a TAFKAL80ETC concert")) { //condition for BackstagePasses
            item.quality = 0;
            return;
        }
    }

//i chsnged this method to make it simpler and of course to avoid nested logic
private void updateItemQuality(Item item) {
    if (SpecialItem(item)) {
        increaseQuality(item);
        handleBackstagePasses(item);  //i will add new method to handle BackstagePasses
        return; //the same logic as in the previous method
    }
    
    decreaseQuality(item);
}

private void handleBackstagePasses(Item item) {
    if (item.name.equals("Backstage passes to a TAFKAL80ETC concert")) {
        if (item.sellIn < 11) {
            increaseQuality(item);
        }
        if (item.sellIn < 6) {
            increaseQuality(item);
        }
    }
}

private boolean SpecialItem(Item item) { //i add this method to check if the item is Aged Brie or BackstagePasses
    return item.name.equals("Aged Brie") || item.name.equals("Backstage passes to a TAFKAL80ETC concert"); //it returns true if the item is Aged Brie or BackstagePasses
    }
}
