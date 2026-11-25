package il.ac.tau.cs.software1.inventory;

/*
 * A simple array-based Inventory (Question 6).
 */
	public class NaiveInventory implements Inventory {

		private static final int INITIAL_CAPACITY = 100;
		private Collectible[] collectibles;
		private int count;

		public NaiveInventory() {
			this.collectibles = new Collectible[INITIAL_CAPACITY];
			this.count = 0;
		}

		@Override
		public void collect(Collectible collectible) {
			if (count == collectibles.length) {
				Collectible[] newCollectibles = new Collectible[collectibles.length * 2];
				for (int i = 0; i < collectibles.length; i++) {
					newCollectibles[i] = collectibles[i];
				}
				collectibles = newCollectibles;
			}
			collectibles[count] = collectible;
			count++;
		}

		@Override
		public float getTotalWeight() {
			float totalWeight = 0.f;
			for (int i = 0; i < count; i++) {
				totalWeight += collectibles[i].getWeight();
			}
			return totalWeight;
		}

		@Override
		public int getCurrentCount() {
			return count;
		}

		// Returns the array of Collectibles that is stored in the field of this class
		public Collectible[] getCollArr() {
			return collectibles;
		}
	}
