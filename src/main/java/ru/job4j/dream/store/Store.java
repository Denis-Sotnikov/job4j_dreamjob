package ru.job4j.dream.store;


import java.util.Collection;
import java.util.Date;
import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;
import ru.job4j.dream.model.Post;

public class Store {

    private static final Store INST = new Store();

    private Map<Integer, Post> posts = new ConcurrentHashMap<>();

    private Store() {
        posts.put(1, new Post(1, "Junior Java Job", "Стартовая позиция", new Date()));
        posts.put(2, new Post(2, "Middle Java Job", "Средняя позиция", new Date()));
        posts.put(3, new Post(3, "Senior Java Job", "Высокая позиция", new Date()));
    }

    public static Store instOf() {
        return INST;
    }

    public Collection<Post> findAll() {
        return posts.values();
    }
}