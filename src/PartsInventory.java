import com.sun.source.tree.Tree;

import java.util.*;

/**
 * The parts offered.
 * TODO: Complete the getCost method in this class for part 3.
 */
public class PartsInventory
{
    // The parts, indexed by part code.
    private final Map<Integer, Part> parts = new TreeMap<>();


    /**
     * TODO Part 3.
     * Calculate the cost of the given order.
     * @param order The order.
     * @return The cost of the order.
     */
    public double getCost(ClientOrder order)
    {
        double cost = 0;
        // TODO: Calculate the cost of each item in the customer's order.
        ItemInventory itemInventory = order.getItemInventory();
        for (Item item : itemInventory.getItems()) {
            int partCode = item.getPartCode();

            Part part = parts.get(partCode);

            if (part != null) {
                cost += part.price() * item.getQuantity();
            }
        }

        return cost;
    }
    
    /**
     * Get the parts in the inventory.
     * @return The parts.
     */
    public Collection<Part> getParts()
    {
        return parts.values();
    }

    /**
     * Add a part to the inventory.
     * @param aPart The part to be added.
     */
    public void addPart(Part aPart)
    {
        parts.put(aPart.partCode(), aPart);
    }

    /**
     * Print the parts.
     */
    public void printParts() {
        for (Part aPart : parts.values()) {
            System.out.println(aPart);
        }
    }
}

