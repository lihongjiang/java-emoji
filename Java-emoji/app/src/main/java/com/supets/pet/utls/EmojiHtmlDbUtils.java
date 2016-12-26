package com.supets.pet.utls;

import com.supets.pet.core.EmojiMap;
import com.supets.pet.dao.DBManager;
import com.supets.pet.dao.EmojiHtml;
import com.supets.pet.dao.EmojiHtmlDao;

import java.util.Set;

/**
 * Java-emoji
 *
 * @user lihongjiang
 * @description
 * @date 2016/12/23
 * @updatetime 2016/12/23
 */

public class EmojiHtmlDbUtils {

    private static EmojiHtmlDao dao = DBManager.getInstance().getEmojiHtmlDao();

    public  static  void insertEmojiData(){
        EmojiMap.initData();
        Set<String>  keys=EmojiMap.unified_to_html.keySet();
        for (String key : keys){
            EmojiHtml  emoji=    new EmojiHtml();
            emoji.setUnified(key);
            emoji.setHtml(EmojiMap.unified_to_html.get(key));
            dao.insertOrReplace(emoji);
        }

    }






}
