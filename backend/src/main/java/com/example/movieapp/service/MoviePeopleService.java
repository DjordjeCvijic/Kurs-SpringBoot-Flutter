package com.example.movieapp.service;


import com.example.movieapp.dto.MoviePeopleDto;
import com.example.movieapp.model.MoviePeople;
import com.example.movieapp.repository.MoviePeopleRepository;
import javassist.NotFoundException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.RequestBody;

import java.util.List;

@Service
public class MoviePeopleService {
    @Autowired
    MoviePeopleRepository moviePeopleRepository;
    @Autowired
    MovieRoleService movieRoleService;


    public MoviePeople saveMoviePeople(@RequestBody MoviePeopleDto moviePeopleDto) {
        MoviePeople moviePeople = moviePeopleRepository.save(buildMoviePeopleFromDto(moviePeopleDto));
//        moviePeopleDto.getMovieRoleIds().forEach(movieRoleId -> {
//            MoviePeopleRole moviePeopleRole=new MoviePeopleRole();
//            moviePeopleRole.setMoviePeople(moviePeople);
//            try {
//                moviePeopleRole.setMovieRole(movieRoleService.getMovieRoleById(movieRoleId));
//                moviePeopleRoleService.saveMoviePeopleRole(moviePeopleRole);
//
//            } catch (Exception e) {
//                e.printStackTrace();
//            }
//
//        });
        return moviePeople;
    }

    private MoviePeople buildMoviePeopleFromDto(MoviePeopleDto moviePeopleDto) {
        MoviePeople moviePeople = new MoviePeople();
        if (moviePeopleDto.getMoviePeopleId() != null)
            moviePeople.setMoviePeopleId(moviePeopleDto.getMoviePeopleId());
        moviePeople.setFirstName(moviePeopleDto.getFirstName());
        moviePeople.setLastName(moviePeopleDto.getLastName());
        moviePeople.setBirthDate(moviePeopleDto.getBirthDate());
        moviePeople.setGender(moviePeopleDto.getGender());


        return moviePeople;
    }

    public List<MoviePeople> getAll() {
        return moviePeopleRepository.findAll();
    }

    public MoviePeople updateMoviePeople(MoviePeople item) throws NotFoundException {
        MoviePeople moviePeople = getMoviePeopleById(item.getMoviePeopleId());
        moviePeople.setFirstName(item.getFirstName());
        moviePeopleRepository.save(moviePeople);
        return moviePeople;
    }

    public MoviePeople getMoviePeopleById(Integer id) throws NotFoundException {
        return moviePeopleRepository.findById(id).orElseThrow(() -> new NotFoundException("Nije pronađen movie people sa id-em:" + id));
    }

    public void deleteMoviePeople(Integer moviePeopleId) throws NotFoundException {
        if (moviePeopleRepository.existsById(moviePeopleId))
            moviePeopleRepository.deleteById(moviePeopleId);
        throw new NotFoundException("Nije pronađea movie people sa id-em:" + moviePeopleId);

    }
}
