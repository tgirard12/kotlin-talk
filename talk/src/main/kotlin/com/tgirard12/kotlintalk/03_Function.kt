package com.tgirard12.kotlintalk


fun main(args: Array<String>) {

    // fun


    // Extension function


    //
    // Hight order function
    //


    // Better with database in Android to execute a transaction
    /*
    fun SQLiteDatabase.inTx(f: SQLiteDatabase.() -> Unit) {
        this.beginTransaction()
        try {
            f()
            this.setTransactionSuccessful()
        } finally {
            this.endTransaction()
        }
    }

    val db = SQLiteDatabase.openDatabase("", null, 0)
    db.inTx {
        insert("TABLE", null, ContentValues(1))
        update("TABLE", ContentValues(1), "col=?", arrayOf())
    }
    */













    // apply, let, run, with


    // inline
    // no inline


}
