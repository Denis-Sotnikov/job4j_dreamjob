package ru.job4j.dream.store;


import java.util.Collection;
import java.util.Date;
import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;
import java.util.concurrent.atomic.AtomicInteger;

import ru.job4j.dream.model.Post;
import ru.job4j.dream.model.Candidate;

public class MemStore implements Store {

    private static AtomicInteger postid = new AtomicInteger(3);
    private static AtomicInteger canid = new AtomicInteger(3);

    //private static final PsqlStore INST = new PsqlStore();

    private final Map<Integer, Post> posts = new ConcurrentHashMap<>();

    private final Map<Integer, Candidate> candidates = new ConcurrentHashMap<>();

    private MemStore() {
        posts.put(1, new Post(1, "Junior Java Job", "Стартовая позиция", new Date()));
        posts.put(2, new Post(2, "Middle Java Job", "Средняя позиция", new Date()));
        posts.put(3, new Post(3, "Senior Java Job", "Высокая позиция", new Date()));
        candidates.put(1, new Candidate(1, "Junior Java"));
        candidates.put(2, new Candidate(2, "Middle Java"));
        candidates.put(3, new Candidate(3, "Senior Java"));
    }

    public void save(Post post) {
        if (post.getId() == 0) {
            post.setId(postid.incrementAndGet());
        }
        posts.put(post.getId(), post);
    }

    public Post findById(int id) {
        return posts.get(id);
    }

    public Candidate findCandidateById(int id) {
        System.out.println(candidates.get(id));
        return candidates.get(id);
    }

    public void save(Candidate candidate) {
        if (candidate.getId() == 0) {
            candidate.setId(canid.incrementAndGet());
        }
        candidates.put(candidate.getId(), candidate);
    }
/*
    public static PsqlStore instOf() {
        return INST;
    }
*/
    public Collection<Post> findAllPosts() {
        return posts.values();
    }

    public Collection<Candidate> findAllCandidates() {
        return candidates.values();
    }
}