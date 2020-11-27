import java.util.*;

public class LFUCache {
    class LFUNode {
        int frequency;
        int value;

        public LFUNode(int frequency, int value) {
            this.frequency = frequency;
            this.value = value;
        }
    }

    Map<Integer, LinkedHashSet<Integer>> frequencyByKeys = new HashMap<>();
    Map<Integer, LFUNode> keyToLFUNodes= new HashMap<>();
    int capacity;
    int minFrequency;

    public LFUCache(int capacity) {
        this.capacity = capacity;
    }

    public int get(int key) {
        if (capacity == 0 || !keyToLFUNodes.containsKey(key)) return -1;

        LFUNode node = keyToLFUNodes.get(key);
        updateKeyToLFUNodesAndFrequencyToFLUNodes(key, node.value, node.frequency);
        return node.value;
    }

    public void put(int key, int value) {
        if (!keyToLFUNodes.containsKey(key) && keyToLFUNodes.size() == capacity) {
            evict(minFrequency);
        }

        if (!keyToLFUNodes.containsKey(key)) {
            minFrequency = 1;
            updateKeyToLFUNodesAndFrequencyToFLUNodes(key, value, 0);
        } else {
            LFUNode node = keyToLFUNodes.get(key);
            updateKeyToLFUNodesAndFrequencyToFLUNodes(key, value, node.frequency);
        }
    }

    public void updateKeyToLFUNodesAndFrequencyToFLUNodes(int key, int value, int frequency) {

        if (frequencyByKeys.containsKey(frequency)) {
            LinkedHashSet<Integer> linkedlist = frequencyByKeys.get(frequency);
            linkedlist.remove(key);
            frequencyByKeys.put(frequency, linkedlist);

            if (frequencyByKeys.get(frequency).size() == 0) {
                frequencyByKeys.remove(frequency);
                if (frequency == minFrequency)
                    minFrequency++;
            }
        }

        if (!frequencyByKeys.containsKey(frequency + 1)) {
            LinkedHashSet<Integer> fluList = new LinkedHashSet<>();
            fluList.add(key);
            frequencyByKeys.put(frequency + 1, fluList);
        } else {
            LinkedHashSet<Integer> fluList = frequencyByKeys.get(frequency + 1);
            fluList.add(key);
            frequencyByKeys.put(frequency + 1, fluList);
        }
        keyToLFUNodes.put(key, new LFUNode(frequency + 1, value));
    }

    public void evict(int frequency) {

        LinkedHashSet<Integer> linkedList = frequencyByKeys.getOrDefault(frequency, null);

        while (linkedList != null && linkedList.iterator().hasNext()) {
            int lastNode = linkedList.iterator().next();
            frequencyByKeys.get(frequency).remove(lastNode);
            frequencyByKeys.remove(frequency);
            remove(lastNode);
            break;
        }
    }

    public void remove(int key) {
        keyToLFUNodes.remove(key);
    }

    public static void main(String args[]) {
        int ret[] = new int[10];
        LFUCache obj = new LFUCache(2);
        /*obj.put(1, 1);
        obj.put(2, 2);
        ret[0] = obj.get(1);
        obj.put(3, 3);
        ret[1] = obj.get(2);
        ret[2] = obj.get(3);
        obj.put(4, 4);
        ret[3] = obj.get(1);
        ret[4] = obj.get(3);
        ret[5] = obj.get(4);

        /*obj.put(2, 1);
        obj.put(1, 1);
        obj.put(2, 3);
        obj.put(4, 1);
        ret[0] = obj.get(1);
        ret[1] = obj.get(2);
        */

        obj.put(1, 1);
        obj.put(1, 10);
        obj.put(1, 2);
        obj.put(1, 4);
        obj.put(2, 1);
        obj.put(3, 1);
        obj.put(2, 3);
        ret[0] = obj.get(1);
        ret[1] = obj.get(2);
        ret[2] = obj.get(3);
        for (int i = 0; i < ret.length; i++)
            System.out.println(ret[i]);
    }
}
