package algorithm;

import java.util.BitSet;

/**
 * BloomFilter class
 *
 * @author Soarkey
 * @date 2021/4/6
 */
public class BloomFilter {
    private BitSet bits = new BitSet(Integer.MAX_VALUE);
    private static final int[] seeds = {3, 5, 7, 11, 13, 19, 23, 37};
    private SimpleHash[] func = new SimpleHash[seeds.length];

    public BloomFilter() {
        for (int i = 0; i < seeds.length; ++i) {
            func[i] = new SimpleHash(seeds[i]);
        }
    }

    public void add(String value) {
        for (SimpleHash f : func) {
            bits.set(f.hash(value), true);
        }
    }

    public boolean contains(String value) {
        if (value == null) {
            return false;
        }
        boolean ans = true;
        for (SimpleHash f : func) {
            ans = ans && bits.get(f.hash(value));
        }
        return ans;
    }

    public static void main(String[] args) {
        BloomFilter bloomFilter = new BloomFilter();

        System.out.println(bloomFilter.contains("www.baidu.com"));
        bloomFilter.add("www.baidu.com");
        bloomFilter.add("www.badu.com");
        bloomFilter.add("www.baiu.com");
        bloomFilter.add("www.bajdu.com");
        System.out.println(bloomFilter.contains("www.baidu.com"));
        System.out.println(bloomFilter.contains("www.bajdu.com"));
        System.out.println(bloomFilter.contains("www.bakdu.com"));
    }

    static class SimpleHash {
        private int seed;

        public SimpleHash(int seed) {
            this.seed = seed;
        }

        public int hash(String s) {
            int t = 0;
            for (char c : s.toCharArray()) {
                t += c;
            }
            return t * seed % Integer.MAX_VALUE;
        }
    }
}
