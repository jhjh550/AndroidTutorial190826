package com.fieldbear.androidtutorial190826.T13_SQLite;

import android.content.Context;

public class TestDBHelper {
    TestSQLiteOpenHelper mOpenHelper;

    public TestDBHelper(Context context) {
        mOpenHelper = new TestSQLiteOpenHelper(context, "people.db",
                null, 1);
    }
}
