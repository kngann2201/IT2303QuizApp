/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.dtkn.utils.theme;

import com.dtkn.quizapp.App;
import javafx.scene.Scene;

/**
 *
 * @author admin
 */
public class ThemeManager {
    public static ThemeFactory themeFactory = new DefaultThemeFactory();
    
    public static void setThemeFactory(ThemeFactory tf)
    {
        themeFactory = tf;
    }
    public static void applyTheme(Scene scene)
    {
        scene.getRoot().getStylesheets().clear();
        scene.getRoot().getStylesheets().add(themeFactory.getStyleSheet());

    }
}
