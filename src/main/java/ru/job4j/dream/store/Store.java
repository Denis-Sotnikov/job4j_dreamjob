package ru.job4j.dream.store;

import ru.job4j.dream.model.Candidate;
import ru.job4j.dream.model.City;
import ru.job4j.dream.model.Post;
import ru.job4j.dream.model.User;
import ru.job4j.dream.servlet.CandidateServlet;

import java.util.Collection;
import java.util.Map;

public interface Store {
    Collection<Post> findAllPosts();

    Collection<Candidate> findAllCandidates();

    void save(Post post);

    void save(Candidate candidate);

    Post findById(int id);

    Candidate findCandidateById(int id);

    void update(Post post);

    void update(Candidate candidate);

    String incrementAndGetIdForPhoto(String s);

    String getIdForPhoto();

    String getPhotoFromStore();

    void delete(int id);

    User findUserById(int id);

    void deleteUser(User user);

    void save(User user);

    void update(User user);

    User findUserByEmail(String s);

    Collection<City> findAllCities();

    Map<Integer, String> findAllCitiesMap();
}
