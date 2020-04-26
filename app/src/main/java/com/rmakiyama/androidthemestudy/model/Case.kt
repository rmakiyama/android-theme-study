package com.rmakiyama.androidthemestudy.model

enum class Case(
    val title: String,
    val description: String
) {
    DIALOG("ダイアログ", "ダイアログのテーマを変えたいとき"),
    PRO("プロモード", "課金ユーザ等のステータスによってテーマカラーを変えたいとき"),
    ATTRIBUTE("テーマ属性", "テーマ属性を定義して、その値を切り替えたいとき");
}
