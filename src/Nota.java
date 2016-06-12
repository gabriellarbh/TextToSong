/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

/**
 *
 * @author gabriellabarbieri
 */
public class Nota {
    int nota;
    
    public Nota(char nota, int oitava){
        this.nota = charToInt(nota) + 12 * oitava;
    }
    
    private int charToInt(char nota){
        switch(nota){
            case 'c':
                return 0;
            case 'd':
                return 2;
            case 'e':
                return 4;
            case 'f':
                return 5;
            case 'g':
                return 7;
            case 'a':
                return 9;
            case 'b':
                return 11;
            default:
                return 0;
            
        }
    }
    
    public int getNota(){
        return this.nota;
    }
    
}
