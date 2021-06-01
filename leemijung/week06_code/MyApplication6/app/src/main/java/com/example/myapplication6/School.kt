package com.example.myapplication6

import io.realm.RealmObject //realmObject 을 상속받기

open class School : RealmObject() {

    var name: String?=null
    var location:String?=null
}