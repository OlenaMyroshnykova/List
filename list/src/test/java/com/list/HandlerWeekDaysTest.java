package com.list;

import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.Matchers.empty;
import static org.hamcrest.Matchers.hasItem;
import static org.hamcrest.Matchers.is;
import static org.hamcrest.Matchers.not;

import org.junit.jupiter.api.Test;

public class HandlerWeekDaysTest {

    @Test
    void testCreateList() {

        HandlerWeekDays handlerWeekDays = new HandlerWeekDays(); // 1
        assertThat(handlerWeekDays.days.size(), is(7));

    }

    @Test
    void testGetDays() {
        HandlerWeekDays handlerWeekDays = new HandlerWeekDays();
        assertThat(handlerWeekDays.getDays().get(0), is("Lunes"));
    }

    @Test
    void testRemoveDay() {
        HandlerWeekDays manager = new HandlerWeekDays();
        boolean removed = manager.removeDay("Lunes");
        assertThat(removed, is(true));
        assertThat(manager.getDays(), not(hasItem("Lunes")));
    }

    @Test
    void testGetDay() {
        HandlerWeekDays manager = new HandlerWeekDays();
        String day = manager.getDay(0);
        assertThat(day, is("Lunes"));
    }

    @Test
    void testDayExists() {
        HandlerWeekDays manager = new HandlerWeekDays();
        assertThat(manager.dayExists("Martes"), is(true));
        assertThat(manager.dayExists("Funday"), is(false));
    }

    @Test
    void testSortDaysAlphabetically() {
        HandlerWeekDays manager = new HandlerWeekDays();
        manager.sortDaysAlphabetically();
        assertThat(manager.getDays().get(0), is("Domingo"));
        assertThat(manager.getDays().get(6), is("Viernes"));
    }

    @Test
    void testClearDays() {
        HandlerWeekDays manager = new HandlerWeekDays();
        manager.clearDays();
        assertThat(manager.getDays(), is(empty()));
    }}
