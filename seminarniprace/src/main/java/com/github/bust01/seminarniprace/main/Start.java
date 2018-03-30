package com.github.bust01.seminarniprace.main;

import java.io.File;

import com.github.bust01.seminarniprace.logika.Hra;
import com.github.bust01.seminarniprace.logika.IHra;
import com.github.bust01.seminarniprace.ui.TextoveRozhrani;
/*******************************************************************************
 * Třída  Start je hlavní třídou projektu,
 * který představuje jednoduchou textovou adventuru určenou k dalším úpravám a rozšiřování
 *
 * @author    Tomáš Bušek
 * @version   1.0
 */
public class Start
{
    /***************************************************************************
     * Metoda, prostřednictvím níž se spouští celá aplikace.
     *
     * @param args Parametry příkazového řádku
     */
    public static void main(String[] args)
    {
        
        IHra hra = new Hra();
        TextoveRozhrani ui = new TextoveRozhrani(hra);
        ui.hraj();
        
              if(args.length == 0){
        ui.hraj();
    }
    else {
        ui.hrajZeSouboru(new File(args[0]));
    }
}  
private Start(){} // zakázání defaultního kontruktoru
    }

