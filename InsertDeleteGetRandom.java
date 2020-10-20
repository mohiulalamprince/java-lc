import java.util.*;

public class InsertDeleteGetRandom {
    public static void main(String args[]) {

    }

    static class RandomizedSet {
        Map<Integer, Integer> map = new HashMap<>();
        List<Integer> list = new ArrayList<>();
        Random rand = new Random();

        /** Initialize your data structure here. */
        public RandomizedSet() {

        }

        /** Inserts a value to the set. Returns true if the set did not already contain the specified element. */
        public boolean insert(int val) {
            if (map.containsKey(val)) return false;

            map.put(val, list.size());
            list.add(val);
            return true;
        }

        /** Removes a value from the set. Returns true if the set contained the specified element. */
        public boolean remove(int val) {
            if (!map.containsKey(val)) return false;

            int lastElement = list.get(list.size() - 1);
            int index = map.get(val);

            map.put(lastElement, index);
            list.set(index, lastElement);

            list.remove(list.size()-1);
            map.remove(val);

            return true;
        }

        /** Get a random element from the set. */
        public int getRandom() {
            return list.get(rand.nextInt(list.size()));
        }
    }

}
