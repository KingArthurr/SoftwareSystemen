package ss.week5;

import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.Map.Entry;
import java.util.Set;

public class MapUtil {
	
    /* @ensures \result == (\forall K k, l; map.keySet().contains(k) && map.keySet().contains(l)
    && k != l;    !map.get(k).equals(map.get(l))); */
    public static <K, V> boolean isOneOnOne(Map<K, V> map) {
		Set<V> values = new HashSet<V>();
		for (V value : map.values()) {
			values.add(value);   
		}
    	return (map.keySet().size() == values.size());
    }
    
    /*@ensures \result == (\forall V v; range.contains(v);
    \exists K k;  map.get(k).equals(v)); */ 
    public static <K, V> boolean isSurjectiveOnRange(Map<K, V> map, Set<V> range) {
		boolean isSurjectiveOnRange = true;
		for(V value : range){
			isSurjectiveOnRange = false;
			
			for(K key : map.keySet()){
				V valueCompare = map.get(key);
				if(value == valueCompare){
					isSurjectiveOnRange = true;
				}
			}
			
			if(!isSurjectiveOnRange){
				return false;
			}
		}
		return isSurjectiveOnRange;
    }
    
    //@ensures \forall K k; map.keySet().contains(k); \result.get(map.get(k)).contains(k);
    public static <K, V> Map<V, Set<K>> inverse(Map<K, V> map) {
		Map<V,Set<K>> inversedMap = new HashMap<V,Set<K>>();
		Set<K> keySet = map.keySet();
		for (K key : keySet) {
			V value = map.get(key);
			if (inversedMap.containsKey(value)) {
				inversedMap.get(value).add(key);
			} 
			else { 
				inversedMap.put(value, new HashSet<K>());
				inversedMap.get(value).add(key);
			}
		}
		return inversedMap;
	}
    
    /* @requires (isOneOnOne(map) && isSurjectiveOnRange(map, (new HashSet<V>(map.values()))));
    ensures (\forall K k;  map.keySet().contains(k); \result.get(map.get(k)).equals(k)); */
	public static <K, V> Map<V, K> inverseBijection(Map<K, V> map) {
		Map<V, K> output = new HashMap<V, K>();
		for (Entry<K, V> entry : map.entrySet()) {
			output.put(entry.getValue(), entry.getKey());
		}
		return output;
	}
	
    /*@ensures \result==(\forall V v; f.values().contains(v); g.keySet().contains(v)); */
	public static <K, V, W> boolean compatible(Map<K, V> f, Map<V, W> g) {
		boolean output = true;
		Set<V> keys2 = g.keySet();
		for (V value : f.values()) {
			if (!keys2.contains(value)) 
				output = false;
		}
		return output;
	}
	
    /* @requires compatible(f,g);
    ensures (\forall K k; \result.get(k)==g.get(f.get(k))); */
	public static <K, V, W> Map<K, W> compose(Map<K, V> f, Map<V, W> g) {
		if (!compatible(f, g)) return null;
		Map<K, W> output = new HashMap<K, W>();
		for (Entry<K, V> entry : f.entrySet()) {
			output.put(entry.getKey(), g.get(entry.getValue()));
		}
		return output;
	}
}
