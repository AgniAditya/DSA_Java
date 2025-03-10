import java.util.*;

public class HashMap<K,V> {

    ArrayList<LinkedList<Entity>> list;

    private int size = 0;

    private float lf = 0.5f;

    public HashMap(){
        list = new ArrayList<>();
        for(int i = 0; i < 10; i++){
            list.add(new LinkedList<>());
        }
    }

    public void put(K key, V value){
        int hash = Math.abs(key.hashCode() % list.size());
        LinkedList<Entity> entities = list.get(hash);

        for(Entity entity: entities){
            if(entity.key.equals(key)){
                entity.value = value;
                return;
            }
        }

        if((float)(size) / list.size() > lf){
            reHash();
        }
    }

    private class Entity {
        K key;
        V value;
    
        public Entity(K key, V value){
            this.key = key;
            this.value = value;
        }
    }
}
