package start;

import logika.*;
import text.TextoveRozhrani;
import java.io.File;
import grafika.GUI;
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
	public static void main (String[ ] args) {
		GUI grafik = new GUI ();
		grafik.setVisible (true);
		}
}
