package com.sunlightsoftware.android.ocean_county_library.provider;

import android.util.Log;

import java.util.HashMap;

/**
 * Created by Garrett on 1/11/2017.
 */

public enum LibraryProvider {
    TOMS_RIVER_BRANCH(LibraryBranch.TOMS_RIVER_BRANCH),
    BARNEGAT_BRANCH(LibraryBranch.BARNEGAT_BRANCH),
    BEACHWOOD_BRANCH(LibraryBranch.BEACHWOOD_BRANCH),
    BRICK_BRANCH(LibraryBranch.BRICK_BRANCH),
    JACKSON_BRANCH(LibraryBranch.JACKSON_BRANCH),
    LAKEWOOD_BRANCH(LibraryBranch.LAKEWOOD_BRANCH),
    LONG_BEACH_ISLAND_BRANCH(LibraryBranch.LONG_BEACH_ISLAND_BRANCH),
    PLUMSTED_BRANCH(LibraryBranch.PLUMSTED_BRANCH),
    POINT_PLEASANT_BORO_BRANCH(LibraryBranch.POINT_PLEASANT_BORO_BRANCH),
    TUCKERTOWN_BRANCH(LibraryBranch.TUCKERTON_BRANCH),
    WARETOWN_BRANCH(LibraryBranch.WARETOWN_BRANCH),
    BERKELEY_BRANCH(LibraryBranch.BERKELEY_BRANCH),
    ISLAND_HEIGHTS_BRANCH(LibraryBranch.ISLAND_HEIGHTS_BRANCH),
    LACEY_BRANCH(LibraryBranch.LACEY_BRANCH),
    LITTLE_EGG_HARBOR_BRANCH(LibraryBranch.LITTLE_EGG_HARBOR_BRANCH),
    MANCHESTER_BRANCH(LibraryBranch.MANCHESTER_BRANCH),
    POINT_PLEASANT_BEACH_BRANCH(LibraryBranch.POINT_PLEASANT_BEACH_BRANCH),
    STAFFORD_BRANCH(LibraryBranch.STAFFORD_BRANCH),
    UPPER_SHORES_BRANCH(LibraryBranch.UPPER_SHORES_BRANCH);

    private static final String TAG = "LibraryProvider";
    private static final String AM = "AM";
    private static final String PM = "PM";
    private HashMap<Day, Integer> openingHours;
    private HashMap<Day, Integer> closingHours;

    LibraryProvider(LibraryBranch branch) {
        openingHours = new HashMap<>();
        closingHours = new HashMap<>();

        switch (branch) {
            case TOMS_RIVER_BRANCH:
                //only open on sunday from sept-may
                openingHours.put(Day.SUNDAY, 1);
                openingHours.put(Day.MONDAY, 9);
                openingHours.put(Day.TUESDAY, 9);
                openingHours.put(Day.WEDNESDAY, 9);
                openingHours.put(Day.THURSDAY, 9);
                openingHours.put(Day.FRIDAY, 9);
                openingHours.put(Day.SATURDAY, 9);

                closingHours.put(Day.SUNDAY, 5);
                closingHours.put(Day.MONDAY, 9);
                closingHours.put(Day.TUESDAY, 9);
                closingHours.put(Day.WEDNESDAY, 9);
                closingHours.put(Day.THURSDAY, 9);
                closingHours.put(Day.FRIDAY, 5);
                closingHours.put(Day.SATURDAY, 5);

                break;
            case BARNEGAT_BRANCH:
                openingHours.put(Day.SUNDAY, null);
                openingHours.put(Day.MONDAY, 10);
                openingHours.put(Day.TUESDAY, 10);
                openingHours.put(Day.WEDNESDAY, 10);
                openingHours.put(Day.THURSDAY, 10);
                openingHours.put(Day.FRIDAY, 10);
                openingHours.put(Day.SATURDAY, 10);

                closingHours.put(Day.SUNDAY, null);
                closingHours.put(Day.MONDAY, 5);
                closingHours.put(Day.TUESDAY, 9);
                closingHours.put(Day.WEDNESDAY, 9);
                closingHours.put(Day.THURSDAY, 9);
                closingHours.put(Day.FRIDAY, 5);
                closingHours.put(Day.SATURDAY, 5);
                break;
            case BEACHWOOD_BRANCH:
                openingHours.put(Day.SUNDAY, null);
                openingHours.put(Day.MONDAY, 1);
                openingHours.put(Day.TUESDAY, 1);
                openingHours.put(Day.WEDNESDAY, 10);
                openingHours.put(Day.THURSDAY, 10);
                openingHours.put(Day.FRIDAY, 1);
                openingHours.put(Day.SATURDAY, 10);

                closingHours.put(Day.SUNDAY, null);
                closingHours.put(Day.MONDAY, 9);
                closingHours.put(Day.TUESDAY, 5);
                closingHours.put(Day.WEDNESDAY, 5);
                closingHours.put(Day.THURSDAY, 5);
                closingHours.put(Day.FRIDAY, 5);
                closingHours.put(Day.SATURDAY, 1);

                break;
            case BRICK_BRANCH:
                openingHours.put(Day.SUNDAY, null);
                openingHours.put(Day.MONDAY, 9);
                openingHours.put(Day.TUESDAY, 9);
                openingHours.put(Day.WEDNESDAY, 9);
                openingHours.put(Day.THURSDAY, 9);
                openingHours.put(Day.FRIDAY, 9);
                openingHours.put(Day.SATURDAY, 9);

                closingHours.put(Day.SUNDAY, null);
                closingHours.put(Day.MONDAY, 9);
                closingHours.put(Day.TUESDAY, 9);
                closingHours.put(Day.WEDNESDAY, 9);
                closingHours.put(Day.THURSDAY, 9);
                closingHours.put(Day.FRIDAY, 5);
                closingHours.put(Day.SATURDAY, 5);
                break;
            case JACKSON_BRANCH:
                openingHours.put(Day.SUNDAY, null);
                openingHours.put(Day.MONDAY, 9);
                openingHours.put(Day.TUESDAY, 9);
                openingHours.put(Day.WEDNESDAY, 9);
                openingHours.put(Day.THURSDAY, 9);
                openingHours.put(Day.FRIDAY, 9);
                openingHours.put(Day.SATURDAY, 9);

                closingHours.put(Day.SUNDAY, null);
                closingHours.put(Day.MONDAY, 9);
                closingHours.put(Day.TUESDAY, 9);
                closingHours.put(Day.WEDNESDAY, 9);
                closingHours.put(Day.THURSDAY, 9);
                closingHours.put(Day.FRIDAY, 5);
                closingHours.put(Day.SATURDAY, 5);

                break;
            case LAKEWOOD_BRANCH:
                //Closed when not Sept-May
                openingHours.put(Day.SUNDAY, 1);
                openingHours.put(Day.MONDAY, 9);
                openingHours.put(Day.TUESDAY, 9);
                openingHours.put(Day.WEDNESDAY, 9);
                openingHours.put(Day.THURSDAY, 9);
                openingHours.put(Day.FRIDAY, 9);
                openingHours.put(Day.SATURDAY, 9);

                closingHours.put(Day.SUNDAY, 5);
                closingHours.put(Day.MONDAY, 9);
                closingHours.put(Day.TUESDAY, 9);
                closingHours.put(Day.WEDNESDAY, 9);
                closingHours.put(Day.THURSDAY, 9);
                closingHours.put(Day.FRIDAY, 5);
                closingHours.put(Day.SATURDAY, 5);
                break;
            case LONG_BEACH_ISLAND_BRANCH:
                openingHours.put(Day.SUNDAY, null);
                openingHours.put(Day.MONDAY, 9);
                openingHours.put(Day.TUESDAY, 9);
                openingHours.put(Day.WEDNESDAY, 9);
                openingHours.put(Day.THURSDAY, 9);
                openingHours.put(Day.FRIDAY, 9);
                openingHours.put(Day.SATURDAY, 9);

                closingHours.put(Day.SUNDAY, null);
                closingHours.put(Day.MONDAY, 9);
                closingHours.put(Day.TUESDAY, 5);
                closingHours.put(Day.WEDNESDAY, 9);
                closingHours.put(Day.THURSDAY, 5);
                closingHours.put(Day.FRIDAY, 5);
                closingHours.put(Day.SATURDAY, 5);
                break;
            case PLUMSTED_BRANCH:
                openingHours.put(Day.SUNDAY, null);
                openingHours.put(Day.MONDAY, 1);
                openingHours.put(Day.TUESDAY, 10);
                openingHours.put(Day.WEDNESDAY, 1);
                openingHours.put(Day.THURSDAY, 1);
                openingHours.put(Day.FRIDAY, 10);
                openingHours.put(Day.SATURDAY, 10);

                closingHours.put(Day.SUNDAY, null);
                closingHours.put(Day.MONDAY, 9);
                closingHours.put(Day.TUESDAY, 5);
                closingHours.put(Day.WEDNESDAY, 9);
                closingHours.put(Day.THURSDAY, 5);
                closingHours.put(Day.FRIDAY, 5);
                closingHours.put(Day.SATURDAY, 1);
                break;
            case POINT_PLEASANT_BORO_BRANCH:
                openingHours.put(Day.SUNDAY, null);
                openingHours.put(Day.MONDAY, 10);
                openingHours.put(Day.TUESDAY, 10);
                openingHours.put(Day.WEDNESDAY, 10);
                openingHours.put(Day.THURSDAY, 10);
                openingHours.put(Day.FRIDAY, 10);
                openingHours.put(Day.SATURDAY, 10);

                closingHours.put(Day.SUNDAY, null);
                closingHours.put(Day.MONDAY, 9);
                closingHours.put(Day.TUESDAY, 5);
                closingHours.put(Day.WEDNESDAY, 9);
                closingHours.put(Day.THURSDAY, 9);
                closingHours.put(Day.FRIDAY, 5);
                closingHours.put(Day.SATURDAY, 5);

                break;
            case TUCKERTON_BRANCH:
                openingHours.put(Day.SUNDAY, null);
                openingHours.put(Day.MONDAY, 1);
                openingHours.put(Day.TUESDAY, 10);
                openingHours.put(Day.WEDNESDAY, 1);
                openingHours.put(Day.THURSDAY, 10);
                openingHours.put(Day.FRIDAY, 1);
                openingHours.put(Day.SATURDAY, 10);

                closingHours.put(Day.SUNDAY, null);
                closingHours.put(Day.MONDAY, 9);
                closingHours.put(Day.TUESDAY, 5);
                closingHours.put(Day.WEDNESDAY, 5);
                closingHours.put(Day.THURSDAY, 5);
                closingHours.put(Day.FRIDAY, 5);
                closingHours.put(Day.SATURDAY, 1);

                break;
            case WARETOWN_BRANCH:
                openingHours.put(Day.SUNDAY, null);
                openingHours.put(Day.MONDAY, 1);
                openingHours.put(Day.TUESDAY, 10);
                openingHours.put(Day.WEDNESDAY, 1);
                openingHours.put(Day.THURSDAY, 10);
                openingHours.put(Day.FRIDAY, 1);
                openingHours.put(Day.SATURDAY, 10);

                closingHours.put(Day.SUNDAY, null);
                closingHours.put(Day.MONDAY, 9);
                closingHours.put(Day.TUESDAY, 5);
                closingHours.put(Day.WEDNESDAY, 5);
                closingHours.put(Day.THURSDAY, 5);
                closingHours.put(Day.FRIDAY, 5);
                closingHours.put(Day.SATURDAY, 1);

                break;
            case BERKELEY_BRANCH:
                openingHours.put(Day.SUNDAY, null);
                openingHours.put(Day.MONDAY, 9);
                openingHours.put(Day.TUESDAY, 9);
                openingHours.put(Day.WEDNESDAY, 9);
                openingHours.put(Day.THURSDAY, 9);
                openingHours.put(Day.FRIDAY, 9);
                openingHours.put(Day.SATURDAY, 9);

                closingHours.put(Day.SUNDAY, null);
                closingHours.put(Day.MONDAY, 9);
                closingHours.put(Day.TUESDAY, 9);
                closingHours.put(Day.WEDNESDAY, 9);
                closingHours.put(Day.THURSDAY, 9);
                closingHours.put(Day.FRIDAY, 5);
                closingHours.put(Day.SATURDAY, 5);
                break;
            case ISLAND_HEIGHTS_BRANCH:
                openingHours.put(Day.SUNDAY, null);
                openingHours.put(Day.MONDAY, 1);
                openingHours.put(Day.TUESDAY, 10);
                openingHours.put(Day.WEDNESDAY, 10);
                openingHours.put(Day.THURSDAY, 10);
                openingHours.put(Day.FRIDAY, 1);
                openingHours.put(Day.SATURDAY, 10);

                closingHours.put(Day.SUNDAY, null);
                closingHours.put(Day.MONDAY, 9);
                closingHours.put(Day.TUESDAY, 5);
                closingHours.put(Day.WEDNESDAY, 1);
                closingHours.put(Day.THURSDAY, 5);
                closingHours.put(Day.FRIDAY, 5);
                closingHours.put(Day.SATURDAY, 1);
                break;
            case LACEY_BRANCH:
                openingHours.put(Day.SUNDAY, null);
                openingHours.put(Day.MONDAY, 9);
                openingHours.put(Day.TUESDAY, 9);
                openingHours.put(Day.WEDNESDAY, 9);
                openingHours.put(Day.THURSDAY, 9);
                openingHours.put(Day.FRIDAY, 9);
                openingHours.put(Day.SATURDAY, 9);

                closingHours.put(Day.SUNDAY, null);
                closingHours.put(Day.MONDAY, 9);
                closingHours.put(Day.TUESDAY, 9);
                closingHours.put(Day.WEDNESDAY, 9);
                closingHours.put(Day.THURSDAY, 9);
                closingHours.put(Day.FRIDAY, 5);
                closingHours.put(Day.SATURDAY, 5);
                break;
            case LITTLE_EGG_HARBOR_BRANCH:
                openingHours.put(Day.SUNDAY, null);
                openingHours.put(Day.MONDAY, 10);
                openingHours.put(Day.TUESDAY, 10);
                openingHours.put(Day.WEDNESDAY, 10);
                openingHours.put(Day.THURSDAY, 10);
                openingHours.put(Day.FRIDAY, 10);
                openingHours.put(Day.SATURDAY, 10);

                closingHours.put(Day.SUNDAY, null);
                closingHours.put(Day.MONDAY, 5);
                closingHours.put(Day.TUESDAY, 9);
                closingHours.put(Day.WEDNESDAY, 9);
                closingHours.put(Day.THURSDAY, 9);
                closingHours.put(Day.FRIDAY, 5);
                closingHours.put(Day.SATURDAY, 5);
                break;
            case MANCHESTER_BRANCH:
                openingHours.put(Day.SUNDAY, null);
                openingHours.put(Day.MONDAY, 9);
                openingHours.put(Day.TUESDAY, 9);
                openingHours.put(Day.WEDNESDAY, 9);
                openingHours.put(Day.THURSDAY, 9);
                openingHours.put(Day.FRIDAY, 9);
                openingHours.put(Day.SATURDAY, 9);

                closingHours.put(Day.SUNDAY, null);
                closingHours.put(Day.MONDAY, 9);
                closingHours.put(Day.TUESDAY, 9);
                closingHours.put(Day.WEDNESDAY, 9);
                closingHours.put(Day.THURSDAY, 9);
                closingHours.put(Day.FRIDAY, 5);
                closingHours.put(Day.SATURDAY, 5);
                break;
            case POINT_PLEASANT_BEACH_BRANCH:
                openingHours.put(Day.SUNDAY, null);
                openingHours.put(Day.MONDAY, 10);
                openingHours.put(Day.TUESDAY, 1);
                openingHours.put(Day.WEDNESDAY, 10);
                openingHours.put(Day.THURSDAY, 10);
                openingHours.put(Day.FRIDAY, 1);
                openingHours.put(Day.SATURDAY, 10);

                closingHours.put(Day.SUNDAY, null);
                closingHours.put(Day.MONDAY, 5);
                closingHours.put(Day.TUESDAY, 9);
                closingHours.put(Day.WEDNESDAY, 5);
                closingHours.put(Day.THURSDAY, 5);
                closingHours.put(Day.FRIDAY, 5);
                closingHours.put(Day.SATURDAY, 1);
                break;
            case STAFFORD_BRANCH:
                //Only open sept-may on sun
                openingHours.put(Day.SUNDAY, 1);
                openingHours.put(Day.MONDAY, 9);
                openingHours.put(Day.TUESDAY, 9);
                openingHours.put(Day.WEDNESDAY, 9);
                openingHours.put(Day.THURSDAY, 9);
                openingHours.put(Day.FRIDAY, 9);
                openingHours.put(Day.SATURDAY, 9);

                closingHours.put(Day.SUNDAY, 5);
                closingHours.put(Day.MONDAY, 9);
                closingHours.put(Day.TUESDAY, 5);
                closingHours.put(Day.WEDNESDAY, 9);
                closingHours.put(Day.THURSDAY, 9);
                closingHours.put(Day.FRIDAY, 5);
                closingHours.put(Day.SATURDAY, 5);
                break;
            case UPPER_SHORES_BRANCH:
                openingHours.put(Day.SUNDAY, null);
                openingHours.put(Day.MONDAY, 10);
                openingHours.put(Day.TUESDAY, 10);
                openingHours.put(Day.WEDNESDAY, 10);
                openingHours.put(Day.THURSDAY, 10);
                openingHours.put(Day.FRIDAY, 10);
                openingHours.put(Day.SATURDAY, 10);

                closingHours.put(Day.SUNDAY, null);
                closingHours.put(Day.MONDAY, 5);
                closingHours.put(Day.TUESDAY, 9);
                closingHours.put(Day.WEDNESDAY, 9);
                closingHours.put(Day.THURSDAY, 5);
                closingHours.put(Day.FRIDAY, 5);
                closingHours.put(Day.SATURDAY, 5);
                break;

            default:
                break;
        }


        //DEBUG
        for (LibraryBranch bronch : LibraryBranch.values()) {
            Log.d(TAG, "Branch: " + bronch);
        }

        Log.d(TAG, "Branch: " + this);

    }

    public String getOpeningHourString(Day day) {

        Integer hour = openingHours.get(day);

        return hour == null
                ? "Closed" : hour.equals(1) ? hour.toString() + PM : hour.toString() + AM;
    }

    public String getClosingHourString(Day day) {

        Integer hour = closingHours.get(day);

        return hour == null ? "Closed" : hour.toString() + PM;
    }


    public enum LibraryBranch {
        TOMS_RIVER_BRANCH, BARNEGAT_BRANCH, BEACHWOOD_BRANCH, BRICK_BRANCH,
        JACKSON_BRANCH, LAKEWOOD_BRANCH, LONG_BEACH_ISLAND_BRANCH,
        PLUMSTED_BRANCH, POINT_PLEASANT_BORO_BRANCH, TUCKERTON_BRANCH,
        WARETOWN_BRANCH, BERKELEY_BRANCH, ISLAND_HEIGHTS_BRANCH,
        LACEY_BRANCH, LITTLE_EGG_HARBOR_BRANCH, MANCHESTER_BRANCH,
        POINT_PLEASANT_BEACH_BRANCH, STAFFORD_BRANCH, UPPER_SHORES_BRANCH

    }
}
