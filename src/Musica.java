
import java.util.ArrayList;

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

/**
 *
 * @author gabriellabarbieri
 */
public class Musica {
    private String musica;
    private static final int addVolume = 50;
    private static final int decTempo = 10;
    private int tempo;
    
    public Musica(String input, int instrument){
        //Chamar função de parser
        this.musica = "";
        this.tempo = 120;
        int i;
        input = input.toLowerCase();
        char current;
        int currentOctave = 5;
        int currentVolume = 300;
        
        for(i = 0; i < input.length(); i++){
            current = input.charAt(i);
            if(isNota(current))
                addNota(current, currentOctave);
            else if (isDigit(current))
                currentOctave = Character.getNumericValue(current);
            else {
                switch(current){
                    case '!':
                        currentVolume = currentVolume + addVolume;
                        break;
                    case '?':
                    case '.':
                        currentOctave = 5;
                        break;
                    case '\n':
                    case ';':
                        decTempo();
                        break;  
                    
                }
            }        
        }
        
    }
    
    
    private boolean isNota(char nota){
        return (nota >= 'a' && nota <= 'z');
    }
    
    private boolean isDigit(char digit){
        return (digit >= '0' && digit <= '9');
    }
    
    private void addNota(char nota, int oitava){
        Nota nova = new Nota(nota,oitava);
        musica = musica + " " + Integer.toString(nova.getNota());
    }
    
    private void changeInstrument(){
        
    }
    
    private void decTempo(){
        this.tempo = this.tempo - decTempo;
        this.musica = musica + " " + "T" + this.tempo;
    }

    public String getMusica(){
        return this.musica;
    }
    }
