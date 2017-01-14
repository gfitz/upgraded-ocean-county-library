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
    private double latitude;
    private double longitude;
    private String phoneNumber;

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

                latitude = 39.952568;
                longitude = -74.195703;

                phoneNumber = "7323496200";

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

                latitude = 39.756380;
                longitude = -74.233042;

                phoneNumber = "6096983331";

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

                latitude = 39.942332;
                longitude = -74.188059;

                phoneNumber = "7322444573";

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

                latitude = 40.072600;
                longitude = -74.147067;

                phoneNumber = "7324774513";

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

                latitude = 40.110621;
                longitude = -74.356152;

                phoneNumber = "7329284400";

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

                latitude = 40.094325;
                longitude = -74.211845;

                phoneNumber = "7323631335";

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

                latitude = 39.654029;
                longitude = -74.174205;

                phoneNumber = "6094942480";

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

                latitude = 40.082020;
                longitude = -74.531827;

                phoneNumber = "6097587888";

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

                latitude = 40.078154;
                longitude = -74.068446;

                phoneNumber = "7322951555";

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

                latitude = 39.595940;
                longitude = -74.337452;

                phoneNumber = "6092961470";

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

                latitude = 39.794545;
                longitude = -74.191933;

                phoneNumber = "6096935133";

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

                latitude = 39.899944;
                longitude = -74.159459;

                phoneNumber = "7322692144";

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

                latitude = 39.944129;
                longitude = -74.149961;

                phoneNumber = "7322706266";

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

                latitude = 39.839613;
                longitude = -74.190031;

                phoneNumber = "6096938566";

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

                latitude = 39.586032;
                longitude = -74.374057;

                phoneNumber = "6092941197";

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

                latitude = 40.007870;
                longitude = -74.295226;

                phoneNumber = "7326577600";

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

                latitude = 40.093573;
                longitude = -74.052303;

                phoneNumber = "7328924575";
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

                latitude = 39.698725;
                longitude = -74.256958;

                phoneNumber = "6095973381";

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

                latitude = 39.963785;
                longitude = -74.072154;

                phoneNumber = "7327934942";

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

    public int getOpeningHour(Day day) {
        return openingHours.get(day);
    }

    public int getClosingHour(Day day) {
        return closingHours.get(day);
    }

    public double getLatitude() {
        return latitude;
    }

    public double getLongitude() {
        return longitude;
    }

    public String getPhoneNumber() {
        return phoneNumber;
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
