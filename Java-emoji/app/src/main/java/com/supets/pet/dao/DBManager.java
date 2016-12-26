package com.supets.pet.dao;

import android.database.sqlite.SQLiteDatabase;

import com.supets.pet.core.App;

public class DBManager {
	private static DBManager mInstance;
	private static final String DBName = "emoji_cache.db";
	private static EmojiHtmlDao mBannerDao;

	private DBManager() {
		DaoMaster.DevOpenHelper helper = new DaoMaster.DevOpenHelper(App.INSTANCE, DBName, null);
	    SQLiteDatabase db = helper.getWritableDatabase();
	    DaoMaster daoMaster = new DaoMaster(db);
	    DaoSession daoSession = daoMaster.newSession();
	    mBannerDao = daoSession.getEmojiHtmlDao();
	}
	
	public static DBManager getInstance() {
		if( mInstance == null ) {
			mInstance = new DBManager();
		}
		return mInstance;
	}
	
	public EmojiHtmlDao getEmojiHtmlDao() {
		if( mInstance != null ) {
			return mBannerDao;
		}
		return null;
	}

}
