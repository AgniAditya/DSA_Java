import java.util.HashMap;

class MapUsingHash{
    private Entity[] entities;

    public MapUsingHash(){
        entities = new Entity[100];
    }

    public void put(String key,String value){
        int hash = Math.abs(key.hashCode() % entities.length);
        entities[hash] = new Entity(key, value); //Overriding
    }

    public void remove(String key){
        int hash = Math.abs(key.hashCode() % entities.length);
        if(entities[hash] != null && entities[hash].key.equals(key)){
            entities[hash] = null;
        }
    }

    public String get(String key){
        int hash = Math.abs(key.hashCode() % entities.length);
        if(entities[hash] != null && entities[hash].key.equals(key)){
            return entities[hash].value;
        }
        return null;
    }

    private class  Entity {
        String key;
        String value;

        public Entity(String key, String value){
            this.key = key;
            this.value = value;
        }
    }
}

public class Main {
    public static void main(String[] args) {
        // HashMap<String,Integer> map = new HashMap<>();
        // map.put("Aditya", 10);
        // map.put("Adi", 15);
        // map.put("Agni", 20);
        // System.out.println(map.get("Aditya"));

        // MapUsingHash map = new MapUsingHash();
        // map.put("BMW", "Car");
        // map.put("Tom", "Cartoon");
        // map.put("Mumbai", "City");
        // System.out.println(map.get("Tom"));

        HashMapFinal<String,Integer> map = new HashMapFinal<>();
        map.put("Aditya",1);
        map.put("Adi",2);
        map.put("agni",3);
        System.out.println(map);
        map.remove("Adi");
        System.out.println(map);
        System.out.println(map.containKey("Adi"));
    }
}
