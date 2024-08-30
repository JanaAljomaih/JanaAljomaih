package com.example.hhr_project;



import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

import androidx.annotation.Nullable;

public class DB extends SQLiteOpenHelper {
    public DB(@Nullable Context context, @Nullable String name, @Nullable SQLiteDatabase.CursorFactory factory, int version) {
        super(context, name, factory, version);
    }

    // Database Information
    static final String DB_NAME = "HHR.DB";

    // database version
    static final int DB_VERSION = 1;

    // Creating table queries
    private static final String CREATE_STATIONS_TABLE =
            "CREATE TABLE IF NOT EXISTS Stations (" +
                    "StationID INTEGER PRIMARY KEY AUTOINCREMENT, " +
                    "Name TEXT NOT NULL, " +
                    "Location TEXT NOT NULL);";

    private static final String CREATE_TRAINS_TABLE =
            "CREATE TABLE IF NOT EXISTS Trains (" +
                    "TrainID INTEGER PRIMARY KEY AUTOINCREMENT, " +
                    "Capacity INTEGER NOT NULL);";

    private static final String CREATE_TRIPS_TABLE =
            "CREATE TABLE IF NOT EXISTS Trips (" +
                    "TripID INTEGER PRIMARY KEY AUTOINCREMENT, " +
                    "TrainID INTEGER, " +
                    "DepartureStationID INTEGER, " +
                    "ArrivalStationID INTEGER, " +
                    "DepartureTime TEXT NOT NULL, " +
                    "ArrivalTime TEXT NOT NULL, " +
                    "TripDate DATE NOT NULL, " +
                    "FOREIGN KEY (TrainID) REFERENCES Trains(TrainID), " +
                    "FOREIGN KEY (DepartureStationID) REFERENCES Stations(StationID), " +
                    "FOREIGN KEY (ArrivalStationID) REFERENCES Stations(StationID));";

    private static final String CREATE_USERS_TABLE =
            "CREATE TABLE IF NOT EXISTS Users (" +
                    "UserID INTEGER PRIMARY KEY AUTOINCREMENT, " +
                    "FullName TEXT NOT NULL, " +
                    "Email TEXT NOT NULL, " +
                    "Phone TEXT, " +
                    "NationalID TEXT NOT NULL, " +
                    "HashPassword TEXT NOT NULL, " +
                    "Age INTEGER NOT NULL);";

    private static final String CREATE_SEATS_TABLE =
            "CREATE TABLE IF NOT EXISTS Seats (" +
                    "SeatID INTEGER PRIMARY KEY AUTOINCREMENT, " +
                    "TripID INTEGER, " +
                    "TrainID INTEGER, " +
                    "SeatNumber TEXT NOT NULL, " +
                    "Class TEXT NOT NULL, " +
                    "IsOccupied INTEGER NOT NULL, " +
                    "FOREIGN KEY (TripID) REFERENCES Trips(TripID), " +
                    "FOREIGN KEY (TrainID) REFERENCES Trains(TrainID));";

    private static final String CREATE_TICKETS_TABLE =
            "CREATE TABLE IF NOT EXISTS Tickets (" +
                    "TicketID INTEGER PRIMARY KEY AUTOINCREMENT, " +
                    "UserID INTEGER, " +
                    "TripID INTEGER, " +
                    "SeatID INTEGER, " +
                    "Price REAL NOT NULL, " +
                    "FOREIGN KEY (UserID) REFERENCES Users(UserID), " +
                    "FOREIGN KEY (TripID) REFERENCES Trips(TripID), " +
                    "FOREIGN KEY (SeatID) REFERENCES Seats(SeatID));";

    private static final String CREATE_FOOD_OPTIONS_TABLE =
            "CREATE TABLE IF NOT EXISTS FoodOptions (" +
                    "FoodOptionID INTEGER PRIMARY KEY AUTOINCREMENT, " +
                    "Description TEXT NOT NULL);";

    private static final String CREATE_TICKET_FOOD_OPTIONS_TABLE =
            "CREATE TABLE IF NOT EXISTS TicketFoodOptions (" +
                    "TicketID INTEGER, " +
                    "FoodOptionID INTEGER, " +
                    "Quantity INTEGER NOT NULL, " +
                    "FOREIGN KEY (TicketID) REFERENCES Tickets(TicketID), " +
                    "FOREIGN KEY (FoodOptionID) REFERENCES FoodOptions(FoodOptionID), " +
                    "PRIMARY KEY (TicketID, FoodOptionID));";


    @Override
    public void onCreate(SQLiteDatabase db) {
        db.execSQL(CREATE_STATIONS_TABLE);
        db.execSQL(CREATE_TRAINS_TABLE);
        db.execSQL(CREATE_TRIPS_TABLE);
        db.execSQL(CREATE_USERS_TABLE);
        db.execSQL(CREATE_SEATS_TABLE);
        db.execSQL(CREATE_TICKETS_TABLE);
        db.execSQL(CREATE_FOOD_OPTIONS_TABLE);
        db.execSQL(CREATE_TICKET_FOOD_OPTIONS_TABLE);
    }


    @Override
    public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {//update table

    }

    //////////////////////////////////////////////////////////////////user
    //****************************************
    public void addUser(String FullName,String Email,String Phone,String NationalID,String HashPassword,Integer Age) {
        ContentValues cv=new ContentValues();
        cv.put("Full Name",FullName);
        cv.put("Email",Email);
        cv.put("Phone",Phone);
        cv.put("NationalID",NationalID);
        cv.put("HashPassword",HashPassword);
        cv.put("Age",Age);
        SQLiteDatabase db=getWritableDatabase();
        db.insert("Users",null,cv);
        db.close();
    }
    //****************************************
    public int login(String Email,String HashPassword){
        int result =0;
        SQLiteDatabase db=getReadableDatabase();
        String query = "SELECT * FROM " + "Users" +
                " WHERE " + "Email" + " = ? AND " + "HashPassword" + " = ?";
        String str[]=new String[2];
        str[0]=Email;
        str[1]=HashPassword;
        Cursor c=db.rawQuery(query,str);
        if(c.moveToFirst()){result=1;
        }//there is a recorde
        return result;

    }


}//end of class