package com.example.a3zt.madeup.SharedPackage.Class;

import android.content.Context;

/**
 * Created by nirav on 27/03/17.
 */

public class PrefUtils {
    public static void setLanguage(LanguageType currentUser, Context ctx){
        ComplexPreferences complexPreferences = ComplexPreferences.getComplexPreferences(ctx, "user_pref", 0);
        complexPreferences.putObject("user_pref_value", currentUser);
        complexPreferences.commit();
    }



    public static LanguageType getLanguage(Context ctx){
        ComplexPreferences complexPreferences = ComplexPreferences.getComplexPreferences(ctx, "user_pref", 0);
        LanguageType currentUser = complexPreferences.getObject("user_pref_value", LanguageType.class);
        return currentUser;
    }
}
