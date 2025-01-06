package com.example.stest.model;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class Movie {
    private Long id;
    private String poster;
    private String title;
    private String date;
    private String actor;
    private String director;


}
