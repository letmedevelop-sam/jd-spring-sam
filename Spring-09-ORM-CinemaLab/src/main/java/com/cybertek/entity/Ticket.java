package com.cybertek.entity;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.*;
import java.time.LocalDateTime;

@Entity
@Getter
@Setter
@NoArgsConstructor
public class Ticket extends BaseEntity{

    @Column(columnDefinition = "seat_number")
    private Integer seatNumber;

    @Column(columnDefinition = "row_number")
    private Integer rowNumber;

    @Column(columnDefinition = "TIMESTAMP")
    private LocalDateTime DateTime;

    @ManyToOne (fetch = FetchType.LAZY)
    @JoinColumn(name = "movie_cinema_id")
    private MovieCinema movieCinema;


    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "user_account_id")
    private User user;

    public Ticket(Integer seatNumber, Integer rowNumber, LocalDateTime localDateTime) {
        this.seatNumber = seatNumber;
        this.rowNumber = rowNumber;
        this.DateTime = localDateTime;
    }
}
