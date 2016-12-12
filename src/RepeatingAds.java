import java.util.ArrayList;

/**
 * Created by ashwin on 12/12/16.
 */

/**
 * This program shows how to repeatedly add one list in another list
 * based on the required position
 * Application: Repeating list of Ads between a list of products
 */

public class RepeatingAds
{
    public static void main(String[] args)
    {
        // Arraylist of ads
        ArrayList<Item> adItemsList = getAdItemsList();

        // Arraylist of products
        ArrayList<Item> productItemsList = getProductItemsList();

        // Final arraylist of ads amd products
        ArrayList<Item> finalItemsList = new ArrayList<Item>();

        // Repeat ads list after 5 products
        int adsListRepeatAfter = 5;

        // Total number of ads
        int adsListSize = adItemsList.size();

        // Next ad in ads arraylist
        int nextAdInList = 0;

        // Next position where ad should appear
        int nextAdAt = adItemsList.get(0).getPosition();

        // Get difference between ads
        int[] diff = new int[adsListSize];
        int i;
        for(i=1; i<adsListSize; i++)
        {
            diff[i-1] = adItemsList.get(i).getPosition() - adItemsList.get(i-1).getPosition() - 1;
        }
        diff[i-1] = adsListRepeatAfter;

        int nextDiff = 0;

        // Add items to final items list
        int currentPosition = 0;
        for( Item item : productItemsList )
        {
            // Adding ad
            if( currentPosition == nextAdAt )
            {
                finalItemsList.add( adItemsList.get( (nextAdInList++)%adsListSize ) );

                nextAdAt += diff[(nextDiff++)%diff.length];
            }

            // Adding product
            finalItemsList.add(item);

            // Incrementing current position of final items list
            currentPosition++;
        }

        // Print final items list
        for(Item item : finalItemsList)
        {
            System.out.println(item);
        }
    }

    // Returns arraylist of ads
    private static ArrayList<Item> getAdItemsList()
    {
        ArrayList<Item> adItemsList = new ArrayList<Item>();

        Item item = new Item(1, "ad");
        adItemsList.add(item);

        item = new Item(7, "ad");
        adItemsList.add(item);

        item = new Item(13, "ad");
        adItemsList.add(item);

        return adItemsList;
    }

    // Returns arraylist of products
    private static ArrayList<Item> getProductItemsList()
    {
        ArrayList<Item> productItemsList = new ArrayList<Item>();

        Item item;

        for( int i=1; i<=30; i++ ) {
            item = new Item(i, "product");
            productItemsList.add(item);
        }

        return productItemsList;
    }
}

class Item
{
    private int position=0;
    private String type="";

    public Item() { }

    public Item(int position, String type)
    {
        this.position = position;
        this.type = type;
    }

    public void setPosition(int p) { position = p; }

    public int getPosition() { return position; }

    public void setType(String t) { type = t; }

    public String getType() { return type; }

    @Override
    public String toString()
    {
        return position + ": " + type;
    }
}
