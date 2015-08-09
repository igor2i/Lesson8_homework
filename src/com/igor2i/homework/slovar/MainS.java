package com.igor2i.homework.slovar;

import com.igor2i.homework.method.Prevetstvie;
import com.igor2i.homework.method.logs.Logs;
import com.igor2i.homework.scaner.Scanner;

import java.util.Collection;
import java.util.Collections;

/**
 * Created by igor2i on 07.08.2015.
 */
public class MainS {

    public static Collection<String> main() {

        Prevetstvie.getPrevetstvieS();

        Slovar<String> slovar = new Slovar<>();

        Logs<String> logs = new Logs<>();

        try {

            for (String scan = Scanner.getScan(""); !("exit".equals(scan)); scan = Scanner.getScan("")) {

                try {
                    if ("reScan".equals(scan)) {
                        continue;
                    } else if ("help".equals(scan)) {
                        Prevetstvie.getHelpS();
                        continue;
                    } else if ("print".equals(scan)) {
                        slovar.print();
                        continue;
                    }

                    Collections.addAll(slovar, scan.split(" "));

                    slovar.print();

                } catch (Exception ex) {
                    logs.pushLog(ex.getMessage());
                }
            }

            if(logs.lenght()> 0){
                return logs.allPop();
            }else {
                return null;
            }

        } catch (Exception ex){
            if(logs.lenght()> 0){
                return logs.allPop();
            }
            throw ex;
        } finally{
            System.out.println("Выход из Программы Словаря");
        }
    }
}
