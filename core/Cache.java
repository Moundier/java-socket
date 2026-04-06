package core;

import java.util.LinkedHashSet;

public class Cache<T> extends LinkedHashSet<T> {
    
    private final int maxSize;
    
    public Cache(int maxSize) {
        this.maxSize = maxSize;
    }
    
    @Override
    public boolean add(T item) {
        boolean added = super.add(item);
        
        while (super.size() > maxSize) {
            T oldest = iterator().next();
            super.remove(oldest);
        }
        
        return added;
    }
    
    public boolean access(T item) {
        if (super.contains(item)) {
            super.remove(item);
            return super.add(item); 
        }
        return false;
    }
}