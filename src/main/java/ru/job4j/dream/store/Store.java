package ru.job4j.dream.store;


import java.util.Collection;
import java.util.Date;
import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;
import java.util.concurrent.atomic.AtomicInteger;

import ru.job4j.dream.model.Post;
import ru.job4j.dream.model.Candidate;

public class Store {

    private static AtomicInteger postid = new AtomicInteger(4);

    private static final Store INST = new Store();

    private final Map<Integer, Post> posts = new ConcurrentHashMap<>();

    private final Map<Integer, Candidate> candidates = new ConcurrentHashMap<>();

    private Store() {
        posts.put(1, new Post(1, "Junior Java Job", "Стартовая позиция", new Date()));
        posts.put(2, new Post(2, "Middle Java Job", "Средняя позиция", new Date()));
        posts.put(3, new Post(3, "Senior Java Job", "Высокая позиция", new Date()));
        candidates.put(1, new Candidate(1, "Junior Java"));
        candidates.put(2, new Candidate(2, "Middle Java"));
        candidates.put(3, new Candidate(3, "Senior Java"));
    }

    public void save(Post post) {
        post.setId(postid.incrementAndGet());
        posts.put(post.getId(), post);
    }

    public static Store instOf() {
        return INST;
    }

    public Collection<Post> findAllPosts() {
        return posts.values();
    }

    public Collection<Candidate> findAllCandidates() {
        return candidates.values();
    }
}